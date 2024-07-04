import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner fr=new Scanner(System.in);
        int t=fr.nextInt();
        for(int i =1;i<=t;i++)
        {
            int[] a= new int[1441];
            for(int x=0;x<1441;x++)
            {
                a[x]=-1;
            }
            int n=fr.nextInt();
            int[] pos=new int[n];
            for(int j=0;j<n;j++)
            {
                int start=fr.nextInt();
                pos[j]=start;
                int end=fr.nextInt();
                a[start]=end;
            }
            char[] ans=new char[1441];
            boolean C=false;
            boolean J=false;
            int last_seen_C=-1;
            int last_seen_J=-1;
            boolean final_ans=false;
            for(int x=0;x<1441;x++)
            {
                //System.out.println("i m in");

                if(x==last_seen_C) {
                    //System.out.println("in");
                    last_seen_C = -1;
                    C=false;
                }
                if(x==last_seen_J) {
                    //System.out.println("in");
                    last_seen_J = -1;
                    J=false;
                }
                if (a[x]==-1)
                    continue;
                if(!C)
                {
                    C=true;
                    last_seen_C=a[x];
                    ans[x]='C';
                }
                else if(!J)
                {
                    J=true;
                    last_seen_J=a[x];
                    ans[x]='J';
                }
                else if(last_seen_C!=-1&&last_seen_J!=-1)
                {
                    //System.out.println(last_seen_C+"   "+last_seen_J);
                    final_ans=true;
                    break;
                }
            }
            StringBuilder answer=new StringBuilder();
            for(int v:pos)
            {
                answer.append(ans[v]);
            }
            //System.out.println(ans);
            System.out.print("Case #"+i+": ");
            if(!final_ans)
                System.out.println(answer);
            else System.out.println("IMPOSSIBLE");
        }
    }
}
