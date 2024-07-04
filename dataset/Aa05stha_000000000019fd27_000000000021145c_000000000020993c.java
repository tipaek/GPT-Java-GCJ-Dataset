import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc=new Scanner(System.in);
        int z=sc.nextInt();
        for(int t=1;t<=z;t++)
        {
           int n=sc.nextInt();
           int a[][]=new int[n][n];
           int ans=0;
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   a[i][j]=sc.nextInt();
                   if(i==j) ans+=a[i][j];
               }
           }
           
           HashSet<Integer> h;
           int row=0,col=0;
           for(int i=0;i<n;i++)
           {
               h=new HashSet<>();
               for(int j=0;j<n;j++)
               {
                   if(!h.contains(a[i][j])) 
                   h.add(a[i][j]);
                   else
                   {
                       row++;
                       break;
                   }
               }
           }
           
           for(int i=0;i<n;i++)
           {
                h=new HashSet<>();
               for(int j=0;j<n;j++)
               {
                  // System.out.print(a[j][i]+" ");
                   if(!h.contains(a[j][i]))
                   h.add(a[j][i]);
                   else
                   {
                       col++;break;
                   }
               }
           }
           
           System.out.println("Case #"+t+": "+ans+" "+row+" "+col); 
        }
      //  System.out.println("XXXXXXXX");
    }
}
