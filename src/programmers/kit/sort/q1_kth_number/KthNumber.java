package programmers.kit.sort.q1_kth_number;

import java.util.Arrays;
 
public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int cmdsLen = commands.length;
        int[] answer = new int[cmdsLen];
        
        for(int i = 0; i < cmdsLen; i++){
            int[] cmd = commands[i];
            // System.out.println(cmd[0]);
            int[] arr = Arrays.copyOfRange(array, cmd[0]-1, cmd[1]);
            // System.out.println(Arrays.toString(arr));
            Arrays.sort(arr);
            // System.out.println(Arrays.toString(arr));
            // System.out.println(arr[cmd[2]-1]);
            answer[i] = arr[cmd[2]-1];
        }
        
        return answer;
    }
}
