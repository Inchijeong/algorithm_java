package programmers.kit.greedy.q2_joystick;

public class Joystick {

	public static void main(String[] args) {
//		String name = "JEROEN";
		String name = "JAN";
//		String name = "ABC";
//		String name = "BAABAA";
//		String name = "BAABCAA";
		
		System.out.println(solution(name));
	}
	
	public static int solution(String name) {
		int answer = 0;
		int len = name.length();		
		int pre = 0;
		int post = 0;
		
		for(int i = 1; i <= len/2; i++) {
			if('A' == name.charAt(i)) {
				pre++;
			}else {
				break;
			}
		}
		
		for(int i = len - 1; i > len/2; i--) {
			if('A' == name.charAt(i)) {
				post++;
			}else {
				break;
			}			
		}
		
		if(pre > post) {
			answer += len - 1 - pre;
		}else {
			answer += len - 1 - post;
		}
//		
		System.out.println("pre : " + pre);
		System.out.println("post : " + post);
		
		for(int i = 0; i < len; i++) {
			int cnt = name.charAt(i) - 'A';
			
			if(cnt > 13) {
				cnt = 26 - cnt;
			}
			System.out.println(cnt);
			answer += cnt;
		}
		
		return answer;
	}
}
