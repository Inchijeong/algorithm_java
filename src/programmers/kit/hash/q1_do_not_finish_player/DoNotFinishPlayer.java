package programmers.kit.hash.q1_do_not_finish_player;

import java.util.HashMap;

public class DoNotFinishPlayer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> partiMap = new HashMap<String, Integer>();
        
        for(String val : participant){
            int cnt = 1;
            if(partiMap.containsKey(val)){
                cnt += partiMap.get(val);
            }
            partiMap.put(val, cnt);
        }
        
        // Set set = partiMap.entrySet();
        
        // System.out.println(set);
        
        for(String comp : completion){
            if(partiMap.containsKey(comp)){
                if(partiMap.get(comp) == 1){
                    partiMap.remove(comp);
                }else{
                    partiMap.put(comp, partiMap.get(comp)-1);
                }
            }
        }
        // Set set2 = partiMap.entrySet();
        
        // System.out.println(set2);
        
        for(String ans : partiMap.keySet()){
            answer = ans;            
        }
        
        return answer;
    }
}
