import java.util.Scanner;
public class Solution
{
    public static void main(String s[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();int n;int ar[][];int ct,jt;int fl;int cj[];String res;int tm;
        for(int t1=0;t1<t;t1++)
        {
            n=sc.nextInt();ar=new int[n][3];
            for(int i=0;i<n;i++) {ar[i][0]=sc.nextInt();ar[i][1]=sc.nextInt();ar[i][2]=i;}
            cj=new int[n];res="";fl=0;
            for(int i=0;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(ar[i][0]>ar[j][0])
                    {
                        tm=ar[i][0];ar[i][0]=ar[j][0];ar[j][0]=tm;
                        tm=ar[i][1];ar[i][1]=ar[j][1];ar[j][1]=tm;
                        tm=ar[i][2];ar[i][2]=ar[j][2];ar[j][2]=tm;
                    }
                }
            }
            for(int i=0;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(ar[i][0]==ar[j][0]&&ar[i][1]>ar[j][1])
                    {
                        tm=ar[i][1];ar[i][1]=ar[j][1];ar[j][1]=tm;
                        tm=ar[i][2];ar[i][2]=ar[j][2];ar[j][2]=tm;
                    }
                }
            }
            //for(int i=0;i<n;i++) {System.out.println(ar[i][0]+" "+ar[i][1]+" "+ar[i][2]);}
            
            ct=ar[0][1];jt=0;cj[0]=0;
            for(int i=1;i<n;i++)
            {
                if(ar[i][0]>=ct) {cj[i]=0;ct=ar[i][1];}
                else if(ar[i][0]>=jt) {cj[i]=1;jt=ar[i][1];}
                else {fl=1;break;}
            }
            if(fl==1) {System.out.println("Case #"+(t1+1)+": IMPOSSIBLE");continue;}
            for(int i=0;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(ar[i][2]>ar[j][2])
                    {
                        tm=ar[i][2];ar[i][2]=ar[j][2];ar[j][2]=tm;
                        tm=cj[i];cj[i]=cj[j];cj[j]=tm;
                    }
                }
            }
            for(int i=0;i<n;i++) {if(cj[i]==0) res+='C';else res+='J';}
            System.out.println("Case #"+(t1+1)+": "+res);
            
        }
    }
}