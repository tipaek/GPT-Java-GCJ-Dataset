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
        
        parent c = new parent();
        c.put(a[0][0],a[0][1]);
        ans.add("C");
        
        if(N>1)
        {    
        parent j = new parent();
        j.put(a[1][0],a[1][1]);
        ans.add("J");
        
        for (int n = 2; n < N; n++) 
        {
            if(c.free(a[n][0],a[n][1]) == true)
            {
               if(j.free(a[n][0],a[n][1]) == true)
               {
                  return"IMPOSSIBLE"; 
               }
               else
               {
                 ans.add("J");  
                 
               }
                
            }else
            {
                 ans.add("C");
                              
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
   boolean busy;
    ArrayList< Integer> left ;
    ArrayList< Integer> right ;
    
    
    public parent()
    {
        left = new ArrayList<Integer>();
        right = new ArrayList<Integer>(); 
    }        
    
    
    public void put(int a,int b)
    {
        left.add(a);
        right.add(b);
    }
    
    
  public boolean free(int f, int y)
   { 
      
     busy = false;  
     for(int n = 0; n < left.size(); n++) 
     { 
       if(((f > left.get(n))&&( f < right.get(n)))||((y > left.get(n))&&( y < right.get(n))))
                   {
                      return busy = true;
                   }
     }
     if (busy==false)
     {
         left.add(f);
         right.add(y);
     }
     return busy;
   }
   
   
   
   
 }