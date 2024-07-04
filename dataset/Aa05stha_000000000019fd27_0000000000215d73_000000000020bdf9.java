import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc=new Scanner(System.in);
        int z=sc.nextInt();
        for(int t=1;t<=z;t++)
        {
           HashSet<Integer> c=new HashSet<>();
           HashSet<Integer> j=new HashSet<>();
           StringBuilder ans=new StringBuilder();
           int f=1;
           int n=sc.nextInt();
           for(int i=0;i<n;i++)
           {
               int a=sc.nextInt();
               int b=sc.nextInt();
               
               if(j.isEmpty() ||  (!j.isEmpty() && !j.contains(a) && !j.contains(b-1)) )
               {
                  ans.append("J");
                   for(int k=a;k<b;k++)
                   j.add(k);
               }
               else if(c.isEmpty() || (!c.isEmpty() && !c.contains(a) && !c.contains(b-1)))
               {
                  ans.append("C");
                  for(int k=a;k<b;k++)
                   c.add(k);
                  
               }
               else
               {
                   f=-1;
                   
               }
           }
           
           if(f==1)
           System.out.println("Case #"+t+": "+ans);
           else
           System.out.println("Case #"+t+": IMPOSSIBLE");
        }
      //  System.out.println("XXXXXXXX");
    }
}
