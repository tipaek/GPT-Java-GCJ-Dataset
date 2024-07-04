
import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int numberofcase=input.nextInt();
        
        for (int i=1;i<=numberofcase;i++){
            int size=input.nextInt();
            int[][] activities=new int[size][2];
            
            for (int j=0;j<size;j++){
                activities[j][0]=input.nextInt();
                activities[j][1]=input.nextInt();
            }
            
            String output=assignActivity(activities);
            System.out.println("Case #"+i+": "+output);
        }
    }
    
    public static String assignActivity(int[][] activities){
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->activities[a][1]-activities[b][1]);
        char[] schedule=new char[activities.length];
        int timeofC=0,timeofJ=0;
        
        for (int i=0;i<activities.length;i++){
            heap.offer(i);
        }
        while (!heap.isEmpty()){
            int index=heap.poll();
            if (activities[index][0]<timeofC && activities[index][0]<timeofJ){
                return "IMPOSSIBLE";
            }
            if ((timeofC>timeofJ && activities[index][0]>=timeofC) || (timeofC<=timeofJ && activities[index][0]<timeofJ)){
                schedule[index]='C';
                timeofC=activities[index][1];
            }
            else{
                schedule[index]='J';
                timeofJ=activities[index][1];
            }
        }
        return new String(schedule);
    }
    
    
    
}
