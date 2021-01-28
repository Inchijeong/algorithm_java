package programmers.kit.greedy.q1_gym_suit;

public class GymSuit {

	public static void main(String[] args) {
//		int n = 5;
//		int[] lost = {2, 4};
//		int[] reserve = {1, 3, 5};

//		int n = 5;
//		int[] lost = {2, 4};
//		int[] reserve = {3};

//		int n = 3;
//		int[] lost = {3};
//		int[] reserve = {1};

//		int n = 5;
//		int[] lost = {2, 3, 5};
//		int[] reserve = {2, 4};
		
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {3, 5};
		
		System.out.println("answer : " + solution(n, lost, reserve));
	}
	
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];
        
        // 체육복 1으로 초기화
        for(int i = 0; i < n; i++) {
        	students[i] = 1;
        }
        
        // 도난
        for(int i = 0; i < lost.length; i++) {
        	students[lost[i]-1] -= 1;
        }
        
        // 여벌
        for(int i = 0; i < reserve.length; i++) {
        	students[reserve[i]-1] += 1;
        }
        
        // 공유
        for(int i = 0; i < n; i++) {
        	// 여벌이 있을 경우
        	if(students[i] > 1) {

        		if(i > 0 && students[i-1] == 0) { // 앞 번호에 전달
        			students[i] = 1;
        			students[i-1] = 1;        			
        		}else if(i+1 < n && students[i+1] == 0) { // 뒷 번호에 전달
        			students[i] = 1;
        			students[i+1] = 1;
        		} 
        	}
        }

        // 확인
        for(int i = 0; i < n; i++) {
        	System.out.println(students[i]);
        	if(students[i] > 0) {
        		answer++;        		
        	}
        }
        
        return answer;
    }
}
