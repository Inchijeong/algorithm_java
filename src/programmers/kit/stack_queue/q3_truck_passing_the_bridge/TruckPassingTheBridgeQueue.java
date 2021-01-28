package programmers.kit.stack_queue.q3_truck_passing_the_bridge;

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassingTheBridgeQueue {
	
	public static void main(String[] args) {
		
		int bridge_lengt = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		
		System.out.println(solution(bridge_lengt, weight, truck_weights));		
		
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        
        Queue<Integer> waitingTrucks = new LinkedList<>();
        Queue<Integer> corssingTrucks = new LinkedList<>();
        
        for(int waitTruck : truck_weights){
            waitingTrucks.offer(waitTruck);
        }
        
        for(int i = 0; i < bridge_length; i++) {
        	corssingTrucks.offer(0);        	
        }

        // System.out.println("waitingTrucks.isEmpty() "+ waitingTrucks.isEmpty());
        // System.out.println("corssingTrucks.isEmpty() "+ corssingTrucks.isEmpty());
        
        // ���, �ǳʴ� Ʈ���� ������
        while(!(waitingTrucks.isEmpty() && corssingTrucks.isEmpty())){
            int totalWeight = 0;
            
            // �ٸ� ���� �ִ� Ʈ�� �̵�
            // �ٸ� ���̸��� �ǳʴ°� �ƴ϶� �� ���Ұ� ����� �ð����� �ǳ�
            if(!corssingTrucks.isEmpty()){
                corssingTrucks.poll();
                // System.out.println("�ٸ� �ǳ� "+ corssingTrucks.poll());
            }
            
            // �ٸ� ���� Ʈ�� �� ���� ���ϱ�
            if(!corssingTrucks.isEmpty()){
                for(int corssingTruck : corssingTrucks){
                    totalWeight += corssingTruck;
                }                
            }
            
            // System.out.println("totalWeight "+ totalWeight);
            
            // ��� Ʈ�� �ٸ� ���� �̵�
            if(!waitingTrucks.isEmpty()) {
                if(totalWeight + waitingTrucks.peek() <= weight){
                    // System.out.println("�ٸ� ���� "+ waitingTrucks.peek());
                    corssingTrucks.offer(waitingTrucks.poll());
                }else {
                	corssingTrucks.offer(0);
                }
            }
                        
            time++;
            // System.out.println("time "+ time);
            // System.out.println("===========");
        }
        
        // while(!waitingTrucks.isEmpty()){
        //     System.out.println("poll "+waitingTrucks.poll());
        // }
        
        return time;
    }

}
