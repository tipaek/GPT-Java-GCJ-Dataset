import java.util.ArrayList;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<String>ans=new ArrayList<>();
        int T=in.nextInt();
        for(int t=0;t<T;t++)
        {
            String a="";
            int N=in.nextInt();
            int[][] m=new int[N][2];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<2;j++)
                {
                    m[i][j]=in.nextInt();
                }
            }
            char[] x=new char[N];
            x[0]='J';
            int flag=0,flag1=0;
            for(int i=1;i<N;i++)
            {
                if(m[i-1][1]>m[i][0] && flag==0)
                {
                    flag=1;
                    if(x[i-1]=='J')
                        x[i]='C';
                    else
                        x[i]='J';
                }
                else if(m[i-1][1]<=m[i][0])
                {
                    flag1=1;
                    flag=0;
                    x[i]=x[i-1];
                }
            }
           
           if(flag1==0)
           {
               a="IMPOSSIBLE";
           }
           else
           {
                for(char c : x)
                    a=a+c;
           }
            ans.add(a);
        }
        for(int i=0;i<T;i++)
            System.out.println("Case #"+(i+1)+": "+ans.get(i));
    }
    
}
