import java.lang.*;
import java.util.*;

public class Solution {

    
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        int times = Integer.parseInt(in.nextLine());
        
        String impos = "IMPOSSIBLE";
        String[] turn = {"C", "J"};
        String [] tempEventTimes;
        int actualTurn;
        
        for(int i = 1; i<= times; i++ ){
            
            StringBuffer result = new StringBuffer();
            
            int events = Integer.parseInt(in.nextLine());
            int[][] eventTimes= new int[events][2];
            
            for(int j = 0; j < events; j++){
                
                tempEventTimes = in.nextLine().split("\\s+");
                eventTimes[j][0] = Integer.parseInt(tempEventTimes[0]);
                eventTimes[j][1] = Integer.parseInt(tempEventTimes[1]);
                
            }
            
            Arrays.sort(eventTimes, Comparator.comparingDouble(o -> o[0]));
            
            actualTurn = 0;
            result.append(turn[actualTurn]);
            
            for(int k = 1; k < events ; k++){
                
                if(eventTimes[k-1][1] > eventTimes[k][0]){
                    if(k>1 && eventTimes[k][0] < eventTimes[k-2][1]){
                        result = new StringBuffer();
                        result.append(impos);
                        break;
                    }
                    if(actualTurn == 0)
                        actualTurn = 1;
                    else
                        actualTurn = 0;
                        
                    result.append(turn[actualTurn]);
                    
                }else{
                    result.append(turn[actualTurn]);
                }
                
            }
            
            
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
    }
    
}