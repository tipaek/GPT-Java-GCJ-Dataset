import java.util.*;
import java.io.*;
public class Solution
{

    public static void main(String args[])throws IOException
    {
        BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(ob.readLine());
        StringBuilder sb=new StringBuilder();
        int cases=1;
        while(t-->0)
        {
            String s=ob.readLine();
            ArrayList<Character> al=new ArrayList<Character>();
            long val = 0L;
            int n=s.length();
            for(int i=0;i<n;i++)
            {
                int v = s.charAt(i) - '0';
                if(val == v)
                al.add((char)(v + '0'));
                else if(val>v)
                {
                    // add )
                    while(val>v)
                    {
                        al.add(')');
                        val--;
                    }
                    al.add((char)(v + '0'));
                }
                else
                {
                    // add (
                    while(val<v)
                    {
                        al.add('(');
                        val++;
                    }
                    al.add((char)(v + '0'));
                }
            }
            if(val>0)
            {
                for(int i=1;i<=val;i++)
                al.add(')');
            }
            sb.append("Case #"+cases+": ");
            for(char x:al)
            sb.append(x);
            sb.append("\n");
            cases++;
        }
        System.out.println(sb);
    }
}