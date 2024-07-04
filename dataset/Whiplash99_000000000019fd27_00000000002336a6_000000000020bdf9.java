//created by Whiplash99
import java.io.*;
import java.util.*;
public class Solution
{
    static class Time implements Comparable<Time>
    {
        int start, end, id;
        Time(int start, int end, int id)
        {
            this.start=start;
            this.end=end;
            this.id=id;
        }
        public int compareTo(Time b){return Integer.compare(this.start,b.start);}
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N,k=0;

        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();

        while(T-->0)
        {
            N=Integer.parseInt(br.readLine().trim());
            int ans[]=new int[N];

            Time time[]=new Time[N];
            for(i=0;i<N;i++)
            {
                String s[]=br.readLine().trim().split(" ");
                int start=Integer.parseInt(s[0]);
                int end=Integer.parseInt(s[1]);

                time[i]=new Time(start,end,i);
            }

            Arrays.sort(time);

            int prev1=0,prev2=0;
            for(i=0;i<N;i++)
            {
                if(prev1<=time[i].start)
                {
                    prev1=time[i].end;
                    ans[time[i].id]=1;
                }
                else if(prev2<=time[i].start)
                {
                    prev2=time[i].end;
                    ans[time[i].id]=2;
                }
                else break;
            }

            sb.append("Case #").append(++k).append(": ");
            if(i<N) sb.append("IMPOSSIBLE\n");
            else
            {
                for(i=0;i<N;i++) sb.append(ans[i]==1?'C':'J');
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}