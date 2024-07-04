import java.lang.*;
import java.util.*;

public class Solution {

    
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        int times = Integer.parseInt(in.nextLine());
        
        String impos = "IMPOSSIBLE";
        String[] turn = {"C", "J"};
        int[] busyUntil = new int[2];
        String [] tempEventTimes;
        int actualTurn, temp;
        
        for(int i = 1; i<= times; i++ ){
            
            StringBuffer result = new StringBuffer();
            
            int events = Integer.parseInt(in.nextLine());
            int[][] eventTimes = new int[events][2];
            
            for(int j = 0; j < events; j++){
                
                tempEventTimes = in.nextLine().split("\\s+");
                eventTimes[j][0] = Integer.parseInt(tempEventTimes[0]);
                eventTimes[j][1] = Integer.parseInt(tempEventTimes[1]);
                
            }
            
            Arrays.sort(eventTimes, Comparator.comparingDouble(o -> o[0]));
            System.out.println(eventTimes);
            
            actualTurn = 0;
            result.append(turn[actualTurn]);
            busyUntil[actualTurn] = eventTimes[0][1];
            busyUntil[actualTurn] = 0;
            
            for(int k = 1; k < events ; k++){
                
                if(eventTimes[k][0] < busyUntil[actualTurn]){
                    if(actualTurn == 0)
                        temp = 1;
                    else
                        temp = 0;
                        
                    if(eventTimes[k][0] < busyUntil[temp]){
                        result = new StringBuffer();
                        result.append(impos);
                        break;
                    }else{
                        actualTurn = temp;
                        result.append(turn[actualTurn]);
                        busyUntil[actualTurn] = eventTimes[k][1];
                    }
                }else{
                    result.append(turn[actualTurn]);
                    busyUntil[actualTurn] = eventTimes[k][1];
                }
                
                
            }
            
            
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
    }
    
}