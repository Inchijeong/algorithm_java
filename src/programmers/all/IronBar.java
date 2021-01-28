package programmers.all;

// 쇠막대기
public class IronBar {
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		
		System.out.println(solution(arrangement));
	}
	
    public static int solution(String arrangement) {
        int answer = 0;        
        int len = arrangement.length();
        String[] arr = arrangement.split("");
        int openCnt = 1;
        int closeCnt = 0;
        String lastSign = "(";
        
        for(int i = 1; i < len; i++) {
        	String sign = arr[i];
        	System.out.println(sign);
        	
        	if("(".equals(sign)) {
        		openCnt++;
        	}
        	
        	if(")".equals(sign)) {
        		if("(".equals(lastSign)) {
        			
        		}
        		closeCnt++;
        	}
        }
        
        System.out.println(openCnt);
        System.out.println(closeCnt);
        
        return answer;
    }
}
