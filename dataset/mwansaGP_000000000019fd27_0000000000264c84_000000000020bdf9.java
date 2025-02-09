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
           SSort(matrix);
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
        ans.add("c");
        if(N>1)
        {    
        parent j = new parent(a[1][0],a[1][1],true);
        ans.add("j");
        
        for (int n = 2; n < N; n++) 
        {
            if((c.first < a[n][0])&&(c.last > a[n][0] ))
            {
                   if((j.first < a[n][0])&&(j.last > a[n][0] ))
                   {
                          return"IMPOSSIBLE";
                
                   } else
                   {
                         ans.add("j");
                         j.first =a[n][0];
                         j.last= a[n][1]  ;      
                   }      
                
            }else
            {
                        ans.add("c");
                         c.first =a[n][0];
                         c.last= a[n][1];        
            }
           
        }
        }
       String k = ans.toString().replace(",", "").replace("[", "").replace("]", "").trim().replace(" ", "");
       ans.clear();
       return k;
   }
   
   public static void SSort(int[][]list)
   {
     for (int i = 0; i < list.length - 1; i++) {
 // Find the minimum in the list[i..list.length-1]
 int currentMin = list[i][0];
 int currentMinIndex = i;

 for (int j = i + 1; j < list.length; j++)
 {
     if (currentMin > list[j][0]) 
     {
         currentMin = list[j][0];
         currentMinIndex = j;
     } 
 }

 if (currentMinIndex != i) 
 {
      list[currentMinIndex][0] = list[i][0];
      list[currentMinIndex][1] = list[i][1];
      list[i][0] = currentMin;
 }
 }
   }

     
}

class parent
{
   int first;
   int last;
   boolean busy;
   
   public parent(int first, int last, boolean busy)
   {
     first = this.first;
     last = this.last;
     busy = this.busy;
   }    
 }

       