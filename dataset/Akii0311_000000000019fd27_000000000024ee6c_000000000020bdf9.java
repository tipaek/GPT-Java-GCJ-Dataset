import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T;
        int flag=0;
        T=sc.nextInt();
        for(int i=1; i<=T; i++)
        {
            int N=sc.nextInt();
            int S[]=new int[N];
            int E[]=new int[N];
            char SE[]=new char[N];
            int temp[]=new int[N];
            for(int j=0; j<N; j++)
            {
                S[j]=sc.nextInt();
                E[j]=sc.nextInt();
                temp[j]=S[j];
            }
            Arrays.sort(temp);
            flag=0;
            int Cs=0, Js=0, Ce=0, Je=0;
            int pos=0;
            for(int j=0; j<N; j++)
            {
                int val=temp[j];
                for(int p=0; p<N; p++)
                {
                    if(val==S[p])
                    {
                        pos=p;
                        break;
                    }
                }
                if(S[pos]>=Je)
                {
                    SE[pos]='J';
                    Js=S[pos];
                    Je=E[pos];
                }
                else if(S[pos]>=Ce)
                {
                    SE[pos]='C';
                    Cs=S[pos];
                    Ce=E[pos];
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            System.out.print("Case #"+i+": ");
            if(flag==0)
            {
                for(int t=0; t<N; t++)
                {
                    System.out.print(SE[t]);
                }
            }
            else
            {
                System.out.print("IMPOSSIBLE");
            }
        }
    }
}



