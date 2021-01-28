package programmers.all;

// 라면 공장
public class RamenFactory {

	public static void main(String[] args) {
		
		int stock = 4;
		int[] dates = {4, 10, 15};
		int[] supplies = {20, 5, 10};
		int k = 30;
		
		System.out.println(solution(stock, dates, supplies, k));		
	}	
	
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int len = dates.length;
        // 공급 받은 마지막 날짜
        int date = 0;
        
        stock -= dates[0];
        date = dates[0];
        
        
         
        for(int i = 0; i < len; i++){
        
            // 당일 날 남은 수량
            stock -= dates[i] - date;
            System.out.println("오늘 새벽에 남은 수량 : " + stock);
            
            int future;
            if(i+1 == len){
                future = k-1;
            }else{
                future = dates[i+1]-1;
            }
            
            System.out.println("미래 : " + future);
            
            System.out.println("미래의 재고 : " + (stock - (future - dates[i])));
            
            if(stock - (future - dates[i]) < 0){
                stock += supplies[i];
                date = dates[i];
                answer++;
            }
            
            System.out.println("채운 후 수량 : " + stock);
            System.out.println("마지막 공급 받은 날짜: " + date);
            System.out.println("==================");
        }
        
        return answer;
    }
}
