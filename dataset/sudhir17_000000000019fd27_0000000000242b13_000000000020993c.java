import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
class Solution
{   
    public static void main(String[] args)
    { 
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int m=1;m<=T;m++)
        {  
           int n=sc.nextInt();
           Set<Integer>set=new HashSet<>(n);
           int array[][]=new int[n][n];
           for(int i=0;i<n; i++)
           {
                for(int j=0;j<n;j++) 
              {
                  array[i][j] = sc.nextInt();
              }
           }
           int sum=0;
           for(int i=0;i<n;i++)
           {
               sum=sum+array[i][i];
           }
             int r = 0; 
             for (int i = 0; i < n; i++) 
          {   
            for (int j = 0; j < n; j++) 
            { 
                if(!set.add(array[i][j]))
                {
                r++;
                set.clear();
                break;
                }
            }
            set.clear();
          }
          int c = 0; 
          for (int i = 0; i < n; i++) 
          {   
            for (int j = 0; j < n; j++) 
            { 
                if(!set.add(array[j][i]))
                {
                c++;
                set.clear();
                break;
                }
            }
            set.clear();
          }
         

          System.out.println("Case #"+(m+1)+": "+sum+" "+r+" "+c);
        }
    }
}