package codility.lessons;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String BASE_PACKAGE = "codility.lessons";
    // 프로젝트의 소스 루트를 기준으로 한 상대 경로. 환경에 맞게 조정 필요.
    private static final String BASE_SOURCE_PATH = "algorithm_java/src/codility/lessons";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            List<String> topics = findTopics();
            if (topics.isEmpty()) {
                System.out.println("No topics found in " + BASE_SOURCE_PATH);
                System.out.println("Please ensure topics (like 'lesson0', 'arrays') exist as directories directly under this path.");
                break;
            }

            System.out.println("\n=== Codility Lessons Solution Runner ===");
            System.out.println("Available Topics:");
            for (int i = 0; i < topics.size(); i++) {
                // Main 클래스가 있는 디렉토리는 제외 (필요시)
                if (topics.get(i).equalsIgnoreCase("Main")) continue; 
                System.out.printf("  %d. %s\n", i + 1, topics.get(i));
            }
            System.out.println("  0. Exit");
            System.out.print("Choose topic: ");

            int topicChoice = readIntInput(scanner);

            if (topicChoice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            // Adjust index for potential skipped 'Main' dir or handle topic selection more robustly
            // This simple approach assumes contiguous numbering shown to user.
            if (topicChoice < 1 || topicChoice > topics.size()) {
                System.out.println("Invalid topic number.");
                continue;
            }

            String selectedTopic = topics.get(topicChoice - 1); // Adjust if skipping entries
            runTopicSolutions(scanner, selectedTopic);
        }
        scanner.close();
    }

    // 토픽 찾기 (BASE_SOURCE_PATH 아래의 디렉토리)
    private static List<String> findTopics() {
        List<String> topics = new ArrayList<>();
        File baseDir = new File(BASE_SOURCE_PATH);
        File[] topicDirs = baseDir.listFiles(file ->
            file.isDirectory() &&
            !file.getName().equals("Main") && // Main 디렉토리 제외
            !file.getName().equals("lesson_temp") // lesson_temp 디렉토리 명시적 제외
        );

        if (topicDirs != null) {
            for (File topicDir : topicDirs) {
                topics.add(topicDir.getName());
            }
            Collections.sort(topics); // Sort topics alphabetically
        }
        return topics;
    }

    // 특정 토픽 하위의 문제들 실행
    private static void runTopicSolutions(Scanner scanner, String topic) {
        while (true) {
            List<ProblemInfo> problems = findProblems(topic);
            if (problems.isEmpty()) {
                System.out.println("No problems found for topic: " + topic);
                System.out.println("Expected structure: " + BASE_SOURCE_PATH + "/" + topic + "/problemX/Solution.java");
                break; // Go back to topic selection
            }

            System.out.printf("\n=== %s Problems ===\n", topic.substring(0, 1).toUpperCase() + topic.substring(1));
            for (int i = 0; i < problems.size(); i++) {
                 ProblemInfo p = problems.get(i);
                System.out.printf("  %d. Problem %d\n", i + 1, p.problem);
            }
            System.out.println("  0. Back to topic selection");
            System.out.print("Choose problem number: ");

            int problemChoice = readIntInput(scanner);

            if (problemChoice == 0) {
                break; // Exit problem loop, go back to topic selection
            }

            if (problemChoice < 1 || problemChoice > problems.size()) {
                System.out.println("Invalid problem number.");
                continue;
            }

            ProblemInfo selectedProblem = problems.get(problemChoice - 1);
            runSingleSolution(scanner, selectedProblem);
        }
    }

    // 특정 토픽 하위의 문제 목록 찾기 (lesson 구조 제거됨)
    private static List<ProblemInfo> findProblems(String topic) {
        List<ProblemInfo> problems = new ArrayList<>();
        File topicDir = new File(BASE_SOURCE_PATH, topic);
        File[] problemDirs = topicDir.listFiles(File::isDirectory); // Find problemX directories directly

        Pattern problemPattern = Pattern.compile("problem(\\d+)");

        if (problemDirs != null) {
            for (File problemDir : problemDirs) {
                 Matcher problemMatcher = problemPattern.matcher(problemDir.getName());
                 if (problemMatcher.matches()) {
                     int problemNum = Integer.parseInt(problemMatcher.group(1));
                     // ClassName 생성 시 lesson 제거
                     String className = String.format("%s.%s.problem%d.Solution",
                             BASE_PACKAGE, topic, problemNum);
                     File solutionFile = new File(problemDir, "Solution.java");
                     if (solutionFile.exists()) {
                          // ProblemInfo 생성 시 lesson 제거
                          problems.add(new ProblemInfo(topic, problemNum, className));
                     } else {
                         System.err.println("Warning: Solution.java not found in " + problemDir.getPath());
                     }
                 }
            }
            // Problem 번호 순으로 정렬
            problems.sort(Comparator.comparingInt(p -> p.problem));
        }
        return problems;
    }

    // 단일 솔루션 실행 (변경 없음)
    private static void runSingleSolution(Scanner scanner, ProblemInfo problemInfo) {
         try {
             System.out.println("\n--- Running: " + problemInfo.className + " ---");
             Class<?> solutionClass = Class.forName(problemInfo.className);
             Object solution = solutionClass.getDeclaredConstructor().newInstance();

             Method solutionMethod = findSolutionMethod(solutionClass);
             if (solutionMethod == null) {
                 System.err.println("No 'solution' method found in class " + problemInfo.className);
                 return;
             }

             Object[] parameters = getParameters(solutionMethod, scanner);

             long startTime = System.nanoTime();
             Object result = solutionMethod.invoke(solution, parameters);
             long endTime = System.nanoTime();

             System.out.println("\nResult: " + formatResult(result));
             System.out.printf("Execution time: %.3f ms\n", (endTime - startTime) / 1_000_000.0);

         } catch (ClassNotFoundException e) {
             System.err.println("Error: Class not found ("+ problemInfo.className +"). Ensure it exists and is compiled.");
             System.err.println("Check package declaration inside Solution.java matches the directory structure.");
         } catch (NoSuchMethodException e) {
             System.err.println("Error: Default constructor not found for " + problemInfo.className);
         } catch (Exception e) {
             System.err.println("Error running solution: " + e.getMessage());
             if (e instanceof java.lang.reflect.InvocationTargetException && e.getCause() != null) {
                 System.err.println("Caused by: ");
                 e.getCause().printStackTrace();
             } else {
                 e.printStackTrace();
             }
         }
    }

    // Helper method to read integer input safely (변경 없음)
    private static int readIntInput(Scanner scanner) {
        while (true) {
            try {
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            } catch (Exception e) {
                System.err.println("Input reading error: " + e.getMessage());
                System.out.print("Please try entering the number again: ");
            }
        }
    }

    // findSolutionMethod, getParameters, formatResult 메소드 (변경 없음 - 이전 코드 유지)
    private static Method findSolutionMethod(Class<?> solutionClass) {
        for (Method method : solutionClass.getMethods()) {
            if (method.getName().equals("solution") && (method.getModifiers() & java.lang.reflect.Modifier.PUBLIC) != 0) {
                return method;
            }
        }
        return null;
    }

    private static Object[] getParameters(Method solutionMethod, Scanner scanner) {
        Class<?>[] parameterTypes = solutionMethod.getParameterTypes();
        Object[] parameters = new Object[parameterTypes.length];
        System.out.println("\nEnter parameters for the solution method:");

        for (int i = 0; i < parameterTypes.length; i++) {
            System.out.printf("Enter parameter %d (%s): ", i + 1, parameterTypes[i].getSimpleName());
            while (true) {
                try {
                    String line = scanner.nextLine();
                    if (parameterTypes[i] == int.class || parameterTypes[i] == Integer.class) {
                        parameters[i] = Integer.parseInt(line.trim());
                    } else if (parameterTypes[i] == long.class || parameterTypes[i] == Long.class) {
                         parameters[i] = Long.parseLong(line.trim());
                    } else if (parameterTypes[i] == double.class || parameterTypes[i] == Double.class) {
                         parameters[i] = Double.parseDouble(line.trim());
                    } else if (parameterTypes[i] == String.class) {
                        parameters[i] = line;
                    } else if (parameterTypes[i] == int[].class) {
                        String[] parts = line.trim().split("\\s+");
                        if (parts.length == 1 && parts[0].isEmpty()) {
                            parameters[i] = new int[0];
                        } else {
                            int[] arr = new int[parts.length];
                            for (int j = 0; j < parts.length; j++) {
                                arr[j] = Integer.parseInt(parts[j]);
                            }
                            parameters[i] = arr;
                        }
                    } else {
                         System.out.println("Unsupported parameter type: " + parameterTypes[i].getName() + ". Input treated as String.");
                         parameters[i] = line;
                    }
                    break;
                } catch (NumberFormatException e) {
                     System.out.print("Invalid number format. Please enter again: ");
                } catch (Exception e) {
                     System.err.println("Input error: " + e.getMessage());
                     System.out.print("Please try entering the parameter again: ");
                }
            }
        }
        return parameters;
    }

    private static String formatResult(Object result) {
        if (result == null) {
            return "null";
        }
        if (result.getClass().isArray()) {
            if (result instanceof int[]) return Arrays.toString((int[]) result);
            if (result instanceof long[]) return Arrays.toString((long[]) result);
            if (result instanceof double[]) return Arrays.toString((double[]) result);
            if (result instanceof boolean[]) return Arrays.toString((boolean[]) result);
            if (result instanceof char[]) return Arrays.toString((char[]) result);
            if (result instanceof byte[]) return Arrays.toString((byte[]) result);
            if (result instanceof float[]) return Arrays.toString((float[]) result);
            if (result instanceof short[]) return Arrays.toString((short[]) result);
            try {
                 return Arrays.deepToString((Object[]) result);
            } catch (ClassCastException e) {
                 return result.getClass().getSimpleName() + " (non-standard array)";
            }
        }
        return result.toString();
    }

    // 문제 정보를 저장하기 위한 내부 클래스 (lesson 필드 제거)
    private static class ProblemInfo {
        final String topic;
        final int problem;
        final String className;

        ProblemInfo(String topic, int problem, String className) {
            this.topic = topic;
            this.problem = problem;
            this.className = className;
        }
    }
} 