
import java.util.*;
import java.io.*;
public class Solution {
  
     
	public static void main(String[] args) {
	
	
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcase = in.nextInt();  
       
        List<int[]> C = new ArrayList();
        List<int[]> J = new ArrayList();
        
        for(int i = 0 ; i< testcase ; i++){
            int numActivities = in.nextInt();
         boolean impossible = false; 
         StringBuilder schedule = new StringBuilder();
         for(int k = 0 ; k<numActivities; k++){
            int []  activities = new int[2];
            activities[0] = in.nextInt();
            activities[1] = in.nextInt();
            
            int result =whoisfree(activities,C,J);
            if(result ==1){
                schedule.append("C");
            }else if(result ==2){
                schedule.append("J");
            }else{
                impossible = true ;
            }
             
         }
         if(impossible){
            System.out.println("Case #"+ (i+1) + ": " + "IMPOSSIBLE" );
             
         }else{
         System.out.println("Case #"+ (i+1) + ": " + schedule);
         }
         
         C.clear();
         J.clear();
        }
        
    
	}
	
public static int whoisfree(int [] task, List<int[]> C ,List<int[]> J){
    
    if (C.size()==0){
         C.add(new int[]{task[0],task[1]});
          return 1;
    }
    
    int booked =0;
     for (int[] myActivity: C) {
         //myActivity[0] start time myActivity[0] = endtime
        if(task[0] < myActivity[0] && task[1] <= myActivity[0]){
            
        }else if(task[0] >= myActivity[1] && task[1] > myActivity[1]){
            
        }else {
            break;
        }
        booked++;
     }
   
      if (C.size()==booked){
          
          C.add(new int[]{task[0],task[1]});
          return 1;
          
         
      }else{
          
        booked = 0;
         for (int[] myActivity: J) {
             //myActivity[0] start time myActivity[0] = endtime
            if(task[0] < myActivity[0] && task[1] <= myActivity[0]){
                
            }else if(task[0] >= myActivity[1] && task[1] > myActivity[1]){
                
            }else {
                break;
            }
            booked++;
         }
         
         if(J.size()==booked){
             J.add(new int[]{task[0],task[1]});
             return 2;
            
         }else{
             return 0;
         }  
      }
    
    
}	

}
