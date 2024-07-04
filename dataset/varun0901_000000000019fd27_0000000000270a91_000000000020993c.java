import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
         HashSet<Integer> h;
        for(int i=1;i<=t;i++)
        {
            int l=0,r=0,c=0;
            int n =sc.nextInt();
            int a[][] =new int[n][n];
            for(int j=0;j<n;j++)
            for(int k=0;k<n;k++)
            a[j][k]=sc.nextInt();
            for(int j=0;j<n;j++)
            l+=a[j][j];
            for(int j=0;j<n;j++)
            {
                h=new HashSet<Integer>();
                for(int k=0;k<n;k++)
                h.add(a[j][k]);
                if(h.size()<n)
                r++;
                
            }
            for(int j=0;j<n;j++)
            {
                h=new HashSet<Integer>();
                for(int k=0;k<n;k++)
                h.add(a[k][j]);
                if(h.size()<n)
                c++;
                
            }
            
         System.out.println("Case #"+i+":"+" "+l+" "+r+" "+c);   
        }
    }
}