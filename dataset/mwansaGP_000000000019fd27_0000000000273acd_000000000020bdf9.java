import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mwansa Gee Phiri
 */
class Solution
{
   public static void main(String args[])
   {
     Scanner input = new Scanner(System.in);
      int casenum = input.nextInt();
        String[][] answer;
        answer = new String[casenum][2];
      
      for (int n = 0; n < casenum; n++) 
      {
           int N = input.nextInt();
           int [][] matrix;
           matrix = new int[N][2];
           
           for (int i = 0; i < N; i++)
           {
               matrix [i][0] = input.nextInt();
               matrix [i][1] = input.nextInt();
                       
           }
           
           String jobs = alo(matrix, N); 
        
             
             int test = n+1; 
             
            answer[n][0]= Integer.toString(test);
            answer[n][1]= jobs; 
           
            
      }
          
          
      
       
         for (int n = 0; n < casenum; n++) 
         {
            
            
            System.out.println("Case #" + (Integer.parseInt(answer[n][0])) + ": " + answer[n][1]);
         }    
       }
   
   
   public static String alo(int[][]a, int N)
   {
        ArrayList<String> ans = new ArrayList<>();
        parent c = new parent(a[0][0],a[0][1],true);
        ans.add("C");
        if(N>1)
        {    
        parent j = new parent(a[1][0],a[1][1],true);
        ans.add("J");
        
        for (int n = 2; n < N; n++) 
        {
            if((c.first < a[n][0])&&(c.last > a[n][0] )||(c.first < a[n][1])&&(c.last > a[n][1] ))
            {
                   if((j.first < a[n][0])&&(j.last > a[n][0]||(c.first < a[n][1])&&(c.last > a[n][1] ) ))
                   {
                          return"IMPOSSIBLE";
                
                   } else
                   {
                         ans.add("J");
                         j.first =a[n][0];
                         j.last= a[n][1]  ;      
                   }      
                
            }else
            {
                        ans.add("C");
                         c.first =a[n][0];
                         c.last= a[n][1];        
            }
           
        }
        }
       String k = ans.toString().replace(",", "").replace("[", "").replace("]", "").trim().replace(" ", "");
       ans.clear();
       return k;
   }
   
  
   

     
}

class parent
{
   int first;
   int last;
   boolean busy;
   
   public parent(int first, int last, boolean busy)
   {
     this.first = first;
     this.last = last;
     this.busy = busy;
   }    
 }

       