

import java.util.*;
import java.io.*;
public class Solution {
    
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); 
    for (int t = 0; t < T; t++) {
        String result = "";
        
       int N = in.nextInt();
       char[] resultarr = new char[N];
       int[] start = new int[N];
       int[] end = new int[N];
       for(int i=0;i<N;i++)
       {
           start[i] = in.nextInt();
           end[i] = in.nextInt();
           
       }
      // System.out.println(Arrays.toString(start));
       //System.out.println(Arrays.toString(end));
       int count = 0;
       int Cin = -1;
       int Jin = -1;
       for(int i=0;i<=1440;i++)
        {
           
            for(int j=0;j<N;j++)
            {
                
                
                if(end[j]==i)
                {
                   if(Cin==j)
                   {
                      Cin = -1;
                     // System.out.print(j+"forC ");
                      count--;
                   }  
                    else if(Jin==j)
                    {
                       Jin = -1;
                      // System.out.print(j+"forJ ");
                       count--;
                    }
               }    
               if(start[j]==i)
               {
                  if(count<2)
                  {
                    
                    if(Jin==-1)
                    {
                       Jin = j;
                      // System.out.print(j+"forJ ");
                       count++;
                       resultarr[j]='J';
                       //result = result + "J";
                    }  
                    else if(Cin==-1)
                    {
                       Cin = j;
                      // System.out.print(j+"forC ");
                       count++;
                       resultarr[j] = 'C'; 
                       //result = result + "C";
                    }
                    
                  }    
                    else
                    {
                        result = "IMPOSSIBLE";
                        break;
                    }    
                }
              
            }
            if(result=="IMPOSSIBLE")
             {    break; }
             
                  
                   
               
           
        }
        if(result!="IMPOSSIBLE")
          {
               for(int g=0;g<N;g++)
                       result = result + resultarr[g] ;
          }
        System.out.println("Case #"+(t+1)+": "+result);
      
    }
  }
}
