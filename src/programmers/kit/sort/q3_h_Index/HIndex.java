package programmers.kit.sort.q3_h_Index;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        
        Arrays.sort(citations);
        
        // �ִ�
        int max = citations[len-1];
        
        for(int i = max; i >= 0; i--){
            // h�̻� �� ����
            int mtCnt = 0;
            // h�̸� ������ �ε���
            int lessIdx = 0;
            for(int j = len-1; j >=0; j--){
                if(citations[j] >= i){
                    mtCnt++;
                }else{
                    lessIdx = j;
                    break;
                }
            }
            if(mtCnt >= i){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
