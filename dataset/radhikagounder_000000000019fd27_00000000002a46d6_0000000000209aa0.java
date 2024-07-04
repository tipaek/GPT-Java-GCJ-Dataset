import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner s =new Scanner(System.in);
        int T=s.nextInt();
        for(int t=0;t<T;t++)
        {
            int n=s.nextInt();
            int k=s.nextInt();
            int sum=(int)((n*(n+1))/2);
            int pivot=0;
            for(int i=1;i<=n;i++)
            {
                if(k==i*n)
                 pivot=i;
            }
            //System.out.println(sum+" "+pivot+" "+k+" "+n);
            /*if(sum==k)
            {
                      System.out.println("Case #"+(t+1)+":"+" "+"POSSIBLE");
                        int p = 1; 
     
                    for (int i = 1; i <= n; i++) 
                        { 
  
                            int temp = p; 
  
                        while (temp <= n) 
                        { 
                            System.out.print(temp + " "); 
                            temp++; 
                        } 
      
        
                        for (int j = 1; j < p; j++) 
                            System.out.print(j + " "); 
      
                        p++; 
                        System.out.println(); 
        } 

            }
            */
             if(pivot !=0)
            {
                int b[]=new int[n];
                int q=0;
                for(int j=pivot;j<=n;j++)
                 b[q++]=j;
                 for(int j=1;j<pivot;j++)
                 b[q++]=j;
                  System.out.println("Case #"+(t+1)+":"+" "+"POSSIBLE");
                        int p = n+1; 
     
                    for (int i = 1; i <= n; i++) 
                        { 
  
                            int temp = p; 
  
                        while (temp <= n) 
                        { 
                            System.out.print(b[temp-1] + " "); 
                            temp++; 
                        } 
      
        
                        for (int j = 1; j < p; j++) 
                            System.out.print(b[j-1] + " "); 
      
                        p--; 
                        System.out.println();
                        }
            }
            else
            {
                System.out.println("Case #"+(t+1)+":"+" "+"IMPOSSIBLE");
            }
            
        }
    }
}