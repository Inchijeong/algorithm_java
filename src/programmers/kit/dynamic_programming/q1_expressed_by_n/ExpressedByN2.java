package programmers.kit.dynamic_programming.q1_expressed_by_n;

//DFS
public class ExpressedByN2 {
	
	static int answer = -1;

	public static void main(String[] args) {
		
		int n = 5;
		int number = 12;
		
		solution(n, number);
		System.out.println(answer);
	}
	
	public static void solution(int n, int number) {
		calc(n, number, 0, 0);
	}
	
	public static void calc(int n, int number, int count, int accum) {
		int nn = n;
		
		if(count > 8) {
			answer = -1;
			return;
		}
		
		if(accum == number) {
			if(answer == -1 || answer > count) {
				answer = count;
			}
			return;
		}
		
		for(int i = 1; i < 9 - count; i++) {
			
			calc(n, number, count + i, accum + nn);
			calc(n, number, count + i, accum - nn);
			calc(n, number, count + i, accum * nn);
			calc(n, number, count + i, accum / nn);
			
			nn = n * 10 + n;
		}		
	}
}
