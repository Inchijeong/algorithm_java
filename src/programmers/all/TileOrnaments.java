package programmers.all;

public class TileOrnaments {

	public static void main(String[] args) {
		int N = 5;
		
		System.out.println(solution(N));
	}
	
	public static long solution(int N) {
		long answer = 0;
		
		long first = 1;
		long second = 1;
		long third;
		
		if(N == 1) {
			answer = 4;
		}else if(N == 2){
			answer = 6;
		}else {
			
			int i = 3;
			
			while(i <= N) {
				third = first + second;
//				System.out.println(third);
				answer = third * 2 + (second + third) * 2;
//				System.out.println(answer);
				first = second;
				second = third;
				i++;
			}			
		}
		
		return answer;
	}

}
