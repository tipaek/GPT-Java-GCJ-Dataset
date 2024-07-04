import java.util.Scanner; 
import java.io.*; 
import java.util.Arrays; 
import java.util.*;

 
public class Solution{

 

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);  
    
    int tests = sc.nextInt();
    

     
    for(int test = 1; test <= tests; test++){

      ArrayList<ArrayList<Integer>> cjobs = new ArrayList<ArrayList<Integer>>();
      ArrayList<ArrayList<Integer>> jjobs = new ArrayList<ArrayList<Integer>>();

       int n = sc.nextInt();
       
       String result = "";


       ArrayList<Integer> testnums = new ArrayList<Integer>();

       for(int j = 0; j < n; j++){
       int start = sc.nextInt();
       int end = sc.nextInt();
       testnums.add(start);
       testnums.add(end);


       }


       for(int i = 0; i < n; i++){
     
        

         int start = testnums.get(2*i);
         int end = testnums.get((2*i) + 1);



         ArrayList<Integer> currjob = new ArrayList<Integer>();
         currjob.add(start);
         currjob.add(end);
         
         if(valid(cjobs, currjob)){
             cjobs.add(currjob);
             

             result = result + "C";
             continue;
         } 

         if(valid(jjobs, currjob)){
               

             jjobs.add(currjob);
             result = result + "J";
             continue;
         } 
         

        result = "IMPOSSIBLE";

        break;
     }
     

     System.out.println("Case #" + test + ": " + result);
   }
}


 
   private static boolean valid(ArrayList<ArrayList<Integer>> sched, ArrayList<Integer> job){
    
    
   
    int start = job.get(0);
    int end = job.get(1);

    for(int k = 0; k < sched.size(); k++){
        ArrayList<Integer> curr = sched.get(k);
       

        
        int currstart = curr.get(0);
        int currend = curr.get(1);


        

        if(currstart == start && currend == end){
           return false;
        }


        if(currstart >= start && currstart < end){

           return false;
         }

        if(start >= currstart && start < currend){

           return false;
         }


        // if(currend < end && currend > start){

        //    return false;
        //  }
        // if(end < currend && end > currstart){

        //   return false;
        // }



    }




    return true;
   }





   }
    
     
