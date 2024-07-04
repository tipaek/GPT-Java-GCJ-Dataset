import java.io.*;
import java.util.*;
class Solution
{
  public static void main(String args[]) throws Exception
  { 
    try{
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        int z =0;
        while(T-- != 0)
        {   
            z++;
            int N = scan.nextInt();
            int time[][] = new int [N][3];
            for(int i=0; i<N; i++)
              {
                time[i][0] = scan.nextInt();
                time[i][1] = scan.nextInt();
                time[i][2] = -1;
              }
            //C=1
            //J=0;
            Boolean flag = false;
            for(int i=0; i<N; i++)
             {
                Boolean A = c_Free(i,time,N);
                Boolean B = j_Free(i,time,N);
                if(A==true && B==false)
                {
                   time[i][2] = 1;
                }
                else if(A==false && B== true)
                {
                    time[i][2] = 0;
                }
                else if(A==true && B==true)
                {
                    time[i][2] = 1;
                }
                else
                {
                    flag = true;
                    break;
                }
                    
              }
                      
            String ans = "";
            if(flag == false)
            {
              for(int i=0; i<N; i++)
              {     
                if(time[i][2]==0)
                 {
                   ans = ans + 'C';
                 }
                 else
                 {
                   ans = ans + 'J';
                 }
              }
               System.out.println("Case #"+z+": "+ ans);
             }
             else
             {
                 System.out.println("Case #"+z+": "+ "IMPOSSIBLE");              
             }
         }
       }
    
    catch(Throwable e)
    {
        return;
    }
}  
    
    
                   static Boolean c_Free(int activity, int time[][], int N)
                   {
                     int last = -1;
                     for(int j=N-1; j>=0; j--)
                       {
                         if(time[j][2] == 1)
                          {
                            last = j;
                            break;
                          }
                       }
                     
                       if(last == -1)
                         {
                         return true;
                         }
                        else 
                         {
                          if(time[activity][0]>=time[last][1])
                          {
                            return true;
                          }
                          else if(time[activity][0]<time[last][1] && time[activity][1]<=time[last][0])
                          {
                              return true;
                          }
                          else
                          {
                              return false;
                          }
                        }    
                    }

                   static Boolean j_Free(int activity, int time[][], int N)
                   {
                      int last = -1;
                     for(int j=N-1; j>=0; j--)
                       {
                         if(time[j][2] == 0)
                          {
                            last = j;
                          }
                       }
                     
                       if(last == -1)
                         {
                         return true;
                         }
                        else 
                         {
                          if(time[last][1]<=time[activity][0])
                          {
                            return true;
                          }
                          else if(time[activity][0]<time[last][1] && time[activity][1]<=time[last][0])
                          {
                              return true;
                          }
                          else
                          {
                              return false;
                          }
                         } 
                    }
}

