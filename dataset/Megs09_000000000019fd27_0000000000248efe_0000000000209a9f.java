import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int tc=Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++)
        {   String s=br.readLine();
            int ucl=0;
            StringBuilder ans=new StringBuilder();
            int p=Integer.parseInt(s.substring(0,1));
            for(int j=0;j<p;j++)
                ans.append("(");
            ans.append(p);
            ucl+=p;
            int n=s.length();
            for(int j=1;j<n;j++)
            {   int d=Integer.parseInt(Character.toString(s.charAt(j)));
                if(d<p)
                {   for(int k=0;k<(p-d);k++)
                        ans.append(")");
                    ans.append(d);
                    ucl-=(p-d);
                    p=d;
                }
                else if(p==d)
                {   ans.append(d);
                    //System.out.println("2");
                }
                else
                {   for(int k=0;k<(d-p);k++)
                        ans.append("(");
                    ucl+=(d-p);
                    ans.append(d);
                    p=d;
                }
            }
            for(int j=0;j<ucl;j++)
                ans.append(")");
            System.out.println("Case #"+i+": "+ans);
        }
    }
}