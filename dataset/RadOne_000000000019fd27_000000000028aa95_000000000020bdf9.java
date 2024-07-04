import java.util.*;
public class Solution
{
    public static void sort(int a[][])
    {
        int n=a.length;
        //int temp=0;
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<(n-i);j++)
            {
                if(a[j-1][0]>a[j][0])
                {
                    int temp=a[j-1][0];
                    int ctem=a[j-1][1];
                    a[j-1][0]=a[j][0];
                    a[j-1][1]=a[j][1];
                    a[j][0]=temp;
                    a[j][1]=ctem;
                }
            }
        }
        /*for(int i=0;i<n;i++)
        {
            System.out.println(a[i][0]+" "+a[i][1]);
        }*/
    }
    public static int hash(int start,int a[][])
    {
        int ans=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i][0]==start && a[i][1]==0)
            {ans=i;break;}
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            char sb[]=new char[n];
            //BidiMap hash = new DualHashBidiMap();
            int a[][]=new int[n][2];
            int b[][]=new int[n][2];
            int cst=Integer.MIN_VALUE;
            int ced=Integer.MIN_VALUE;
            int jst=Integer.MIN_VALUE;
            int jed=Integer.MIN_VALUE;
            boolean chck=true;
            for(int j=0;j<n;j++)
            {
                a[j][0]=sc.nextInt();
                a[j][1]=sc.nextInt();
                b[j][0]=a[j][0];
                b[j][1]=0;
                //hash.put(j,a[j][0]);
            }
            sort(a);
            for(int j=0;j<n;j++)
            {
                int start=a[j][0];
                int end=a[j][1];
                if(start>=ced)
                {
                    cst=start;
                    ced=end;
                    int pl=hash(cst,b);
                    sb[pl]='C';
                    b[pl][1]=1;
                    //pl++;
                }
                else if(start>=jed)
                {
                    jst=start;
                    jed=end;
                    int pl=hash(jst,b);
                    sb[pl]='J';
                    b[pl][1]=1;
                }
                else
                    {chck=false;break;}
            }
            //System.out.println(sb);
            String ss=new String(sb);
            if(chck)
              System.out.println("Case #"+(i+1)+": "+ss);
            else
              System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
        }
    }   
}