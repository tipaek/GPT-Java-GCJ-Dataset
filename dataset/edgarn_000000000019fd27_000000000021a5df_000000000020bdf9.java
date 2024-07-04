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
     
         // int start = sc.nextInt();
         // int end = sc.nextInt();

         int start = testnums.get(2*i);
         int end = testnums.get((2*i) + 1);

        // System.out.println("trying job " + start + " " + end);


         ArrayList<Integer> currjob = new ArrayList<Integer>();
         currjob.add(start);
         currjob.add(end);
         // System.out.println("trying scheds now ");

         if(valid(cjobs, currjob)){
             cjobs.add(currjob);
             // System.out.println("gave it to C");

             result = result + "C";
         } else 
         if(valid(jjobs, currjob)){
               //            System.out.println("gave it to J");

             jjobs.add(currjob);
             result = result + "J";
         } 
         else{ 

        result = "IMPOSSIBLE";

        break;
     }
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

        // System.out.println("checking vs  " + currstart + " " + currend);

        

        if(currstart == start && currend == end){
           //System.out.println("failed 1");
           return false;
        }
        if(currstart > start && currstart < end){
                   //  System.out.println("failed 1");

           return false;
         }

        if(start > currstart && start < currend){
                  //   System.out.println("failed 2");

           return false;
         }
        if(currend < end && currend > start){
                   //  System.out.println("failed 3");

           return false;
         }
        if(end < currend && end > currend){
                    // System.out.println("failed 4");

          return false;
        }



    }




    return true;
   }




   }
    
     
