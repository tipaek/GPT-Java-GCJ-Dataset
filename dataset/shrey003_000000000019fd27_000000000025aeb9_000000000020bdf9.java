import java.util.*;
class Solution
{static int no=1;
    public static void main(String args[])
    {
        
        Scanner sc=new Scanner(System.in);
        if(sc.hasNext())
        {
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int n1=sc.nextInt();
            int[][] ar=new int[n1][2];
            for(int j=0;j<n1;j++)
            {
                for(int k=0;k<2;k++)
                {
                    ar[j][k]=sc.nextInt();
                }
            }
            check(ar);
        }
        }
    }
    public static void check(int[][] ar)
    {
        int n=0;
        int ch=0;
        String[] s=new String[ar.length];
        s[0]="C";
        for(int i=1;i<ar.length;i++)
        {

            HashSet<String> set=new HashSet<String>();
            for(int j=0;j<i;j++)
            {
                if((ar[i][0]>ar[j][0] && ar[i][0]<ar[j][1])  || (ar[i][1]>ar[j][0] && ar[i][1]<ar[j][1]))
                {//System.out.println(s[j]);
                    set.add(s[j]);
                }
            }
            if(set.size()==2)
            {
                ch=1;
                break;
            }
            if(set.size()==0) {
                n++;
                s[n] = "C";


            }
            else
            {
                n++;
                Object[] arr=set.toArray();

                if(arr[0].equals("C"))
                    s[n]="J";
                else
                    s[n]="C";

            }
        }
        System.out.print("Case #"+no+": ");
        no++;
        if(ch==1)
            System.out.println("IMPOSSIBLE");
        else
        {
            for(int i=0;i<=n;i++)
                System.out.print(s[i]);
            System.out.println();
        }
    }
}