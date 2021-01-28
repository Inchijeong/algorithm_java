package programmers.kit.greedy.q4_lifeboat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lifeboat {

	public static void main(String[] args) {
//		int[] people = {70, 50, 80, 50};
//		int limit = 100;

		int[] people = {70, 80, 50};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}
	
	public static int solution(int[] people, int limit) {
		int answer = 0;
		List<Integer> boat = new ArrayList<Integer>();
		
		Arrays.sort(people);
		
		for(int i = people.length -1; i >= 0; i--) {
//			System.out.println(people[i]);
			
			boolean isNeedBoat = true;
			int boatCnt = boat.size();
			
			for(int j = 0; j < boatCnt; j++) {
				
				int weight = boat.get(j) + people[i];
				
				if(weight <= limit) {
					boat.set(j, weight);
					isNeedBoat = false;
					break;
				}
			}
			
			if(isNeedBoat) {
				boat.add(people[i]);
			}
		}
		
		answer = boat.size();
		
		return answer;
	}
}
