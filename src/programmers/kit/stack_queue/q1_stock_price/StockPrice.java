package programmers.kit.stack_queue.q1_stock_price;

public class StockPrice {
	
	public static void main(String[] args) {
		
		int[] prices = {1, 2, 3, 2, 3};
		
		int[] answer = solution(prices);
		
		for(int as : answer) {
			System.out.println(as);
		}
		
	}
	
	public static int[] solution(int[] prices) {
		int len = prices.length;
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < len-1; i++) {
        	boolean fallFlag = false;
        	for(int j = i+1; j < len; j++) {
        		if(prices[j] < prices[i]) {
        			answer[i] = j - i;
        			fallFlag = true;
        			break;
        		}
        	}
        	if(!fallFlag) {
        		answer[i] = len-i-1;        		
        	}
        }
        
        answer[len-1] = 0;
        
        return answer;
    }

}
