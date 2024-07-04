import java.io.*;
import java.util.*;

public class Solution {
    static class pair
    {   int st;int et;int a;
        pair(int z,int x,int y)
        {   st=x;
            et=y;
            a=z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int tc=Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++)
        {   int n=Integer.parseInt(br.readLine());
            char c[]=new char[n];
            ArrayList<pair> al=new ArrayList<pair>();
            for(int j=0;j<n;j++)
            {   String s[]=br.readLine().split(" ");
                al.add(new pair(j,Integer.parseInt(s[0]),Integer.parseInt(s[1])));
            }
            Collections.sort(al,new Comparator<pair>()
            {   public int compare(pair p1,pair p2)
                {   if(p1.st<p2.st)
                        return -1;
                    if(p1.st>p2.st)
                        return 1;
                    if(p1.et<p2.et)
                        return -1;
                    return 1;
                }
            }
            );
            int cnt=0;
            int jst=0;int jet=0;int cst=0;int cet=0;
            for(pair p:al)
            {   int pst=p.st;int pet=p.et;
                if(pst>=jet)
                {   c[p.a]='J';
                    jst=pst;
                    jet=pet;
                    cnt++;
                    continue;
                }
                if(pst>=cet)
                {   c[p.a]='C';
                    cst=pst;
                    cet=pet;
                    cnt++;
                    continue;
                }
                break;
            }
        System.out.print("Case #"+i+": ");
        if(cnt==n)
        {   for(int j=0;j<n;j++)
                System.out.print(c[j]);
        }
        else
            System.out.print("IMPOSSIBLE");
        System.out.print("\n");
        }
    }
}