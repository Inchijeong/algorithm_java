package programmers.kit.brute_force_search.q3_carpet;

public class Carpet {

	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		solution(brown, yellow);
	}
	
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1; i <= yellow; i++) {
        	
        	int yellowVer = i;
        	
        	if(yellow % i == 0) {
        		
        		int yellowHor = yellow / i;
        		int ver = yellowVer + 2;
        		int hor = yellowHor + 2;
        		
//    			System.out.println(yellowVer);
//    			System.out.println(yellowHor);
        		
        		if(ver * hor - yellow == brown) {
        			System.out.println(hor);
        			System.out.println(ver);
        			answer[0] = hor;
        			answer[1] = ver;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}
