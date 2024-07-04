import java.util.Scanner; 
import java.io.*; 
import java.util.Arrays; 
import java.util.*;
import java.util.LinkedList; 
import java.util.Queue; 

 
public class Solution{

 

public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);  
    int tests = sc.nextInt();
    
    for(int test = 1; test <= tests; test++){
        String result = "";
        int n = sc.nextInt();

       int[][] graph = new int[n][n];
       for(int k = 0; k < n; k++)
           Arrays.fill(graph[k], 0);


      ArrayList<Integer> colours = new ArrayList<Integer>();
      for(int ii = 0; ii < n; ii++){
         colours.add(-1);
      }

       ArrayList<Integer> testnums = new ArrayList<Integer>();
       for(int j = 0; j < n; j++){
           int start = sc.nextInt();
           int end = sc.nextInt();
           testnums.add(start);
           testnums.add(end);
       }




      ArrayList<ArrayList<Integer>> jobs = new ArrayList<ArrayList<Integer>>();

      for(int i = 0; i < n; i++){
        ArrayList<Integer> currjob = new ArrayList<Integer>();
        currjob.add(testnums.get(2 * i));
        currjob.add(testnums.get((2*i)+1));
        
        for(int l = 0; l < jobs.size(); l++){
            if(l == i)
                continue;

            if(collision(currjob.get(0), currjob.get(1), jobs.get(l).get(0), jobs.get(l).get(1))){

                graph[i][l] = 1;
                graph[l][i] = 1;
              }  

       }
       jobs.add(currjob);
    }
//     for(int iii = 0; iii < n; iii++){
//       String row = "";
//        for(int iiii = 0; iiii<n;iiii++){
//         row = row + graph[iii][iiii];
//         }
//         System.out.println(row);
// }

    Queue<Integer> q = new LinkedList<>(); 

    HashSet<Integer> red = new HashSet<Integer>();
    HashSet<Integer> blue = new HashSet<Integer>();
    HashSet<Integer> seen = new HashSet<Integer>();

    int broken = 0;
    int added = -1;

    for(int indx = 0; indx < n; indx++){

        if(colours.get(indx) == -1){
            if(broken == 1)
              break;
            //System.out.println("exploring from unvisited node " + indx);

            q.add(indx);
            int colour = 0;
           
           
            while(q.size() != 0){
                int curr = q.remove();
              //  System.out.println("CURR NODE IS " + curr);


                

                if(colours.get(curr) == -1){
                   // System.out.println("Setting " + curr + " colour to " + colour);

                    colours.set(curr, colour);

                     if(colour == 0){
                     // System.out.println("adding " + curr + " to red");
                      colours.set(curr, colour);
                      red.add(curr);
                    }
                    else {
                     // System.out.println("adding " + curr + " to blue");
                                            colours.set(curr, colour);

                      blue.add(curr);
                    }
                    seen.add(curr);

           
                  }

                  
                
                
               
                
               
                   // System.out.println("now trying to add nodes to q");

                  if(colours.get(curr) == 0)
                      colour = 1;
                  else colour = 0;


            


                for(int i2 = 0; i2 < n; i2++){

                    if(i2 == curr)
                      continue;
                 
               if(graph[curr][i2] == 1){
                     // System.out.println("adjacent to " + i2 );
                      if(colours.get(i2) == colours.get(curr)){
                      //   System.out.println("found a break");
                  result = "IMPOSSIBLE";
                  broken = 1;
                  break;
                

                      }
                      if(!seen.contains(i2)){



                      if(colour == 0){
                    //  System.out.println("adding " + i2 + " to red");
                      colours.set(i2, colour);
                      red.add(i2);
                    }
                    else {
                    //  System.out.println("adding " + i2 + " to blue");
                                            colours.set(i2, colour);

                      blue.add(i2);
                    }
                        seen.add(i2);
                        q.add(i2);
                    }

                    }
                  }




            }



        }



    

 


    }
   
    

//     for(int iii = 0; iii < n; iii++){
//       String row = "";
//        for(int iiii = 0; iiii<n;iiii++){
//         row = row + graph[iii][iiii];
//         }
//         System.out.println(row);
// }
    
    if(!result.equals("IMPOSSIBLE"))
        for(int f = 0; f < n; f++){
          if(red.contains(f)){
            result = result + 'J';
          }
          else result = result + 'C';
      


    }
     

     System.out.println("Case #" + test + ": " + result);
   }
}


 
   private static boolean collision(int a1, int b1, int a2, int b2){
    
   
    int start = a1;
    int end = b1;


    int currstart = a2;
    int currend = b2;


        if(currstart == start || currend == end)
          return true;


        if(currstart == end || currend == start){
          return false;
        }

        if(start > currstart && start < currend)
           return true;

        if(currstart > start && currstart < end)
           return true;

        if(end > currstart && end < currend)
           return true;

        if(currend > start && currend < end)
           return true;
            
    




    return false;
   }


  





   }
    
     
