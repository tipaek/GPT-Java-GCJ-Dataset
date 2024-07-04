import java.util.*;
 public class Solution{
    public static void main(String arg[])
    {
        Scanner ob=new Scanner(System.in);
        int t = ob.nextInt();
        int count=1;
        while(t!=0)
        {
            int n=ob.nextInt();
            int k=0;
            int r=0;
            int c=0;
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                Set<Integer> al=new HashSet();
             for(int j=0;j<n;j++)
            {
                a[i][j] = ob.nextInt();
                al.add(a[i][j]);
                if(i==j)
                {
                    k+=a[i][j];
                }
            }   
            if(al.size()!=n)
            {
                r++;
            }
           }
           
             for(int i=0;i<n;i++)
            {
                Set<Integer> al=new HashSet();
             for(int j=0;j<n;j++)
            {
                al.add(a[j][i]);
            }   
            if(al.size()!=n)
            {
                c++;
            }
           }
          System.out.println("Case #"+count+":"+k+" "+r+" "+c);
            count++;
            t--;
        }
    }
 }