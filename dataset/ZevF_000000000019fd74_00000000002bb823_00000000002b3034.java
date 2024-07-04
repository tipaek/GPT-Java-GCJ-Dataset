import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=scan.nextInt();
        for(int tcount=1;tcount<=t;tcount++)
        {
            int n=scan.nextInt();
            String []p=new String[n];
            for(int i=0;i<n;i++)
                p[i]=scan.next();
            String beginning="";
            String end="";
            boolean []reached=new boolean[n];
            for(int i=0;i<n;i++)
                reached[i]=false;
            boolean impossible=false;
            for(int i=0;i<=100;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(reached[j])
                        continue;
                    if(i>=p[j].length() || p[j].charAt(i)=='*')
                        reached[j]=true;
                    else if(beginning.length()==i)
                        beginning=beginning+p[j].charAt(i);
                    else if(beginning.charAt(i)!=p[j].charAt(i))
                    {
                        impossible=true;
                        break;
                    }
                }
                boolean done=true;
                for(int j=0;j<n;j++)
                    if(!reached[j])
                    {
                        done=false;
                        break;
                    }
                if(impossible || done)
                    break;
            }
            if(impossible)
            {
                System.out.println("Case #"+tcount+": *");
                continue;
            }
            for(int i=0;i<n;i++)
                reached[i]=false;
            for(int i=0;i<=100;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(reached[j])
                        continue;
                    if(i>=p[j].length() || p[j].charAt(p[j].length()-1-i)=='*')
                        reached[j]=true;
                    else if(end.length()==i)
                        end=""+p[j].charAt(p[j].length()-1-i)+end;
                    else if(end.charAt(0)!=p[j].charAt(p[j].length()-1-i))
                    {
                        impossible=true;
                        break;
                    }
                }
                boolean done=true;
                for(int j=0;j<n;j++)
                    if(!reached[j])
                    {
                        done=false;
                        break;
                    }
                if(impossible || done)
                    break;
            }
            if(impossible)
            {
                System.out.println("Case #"+tcount+": *");
                continue;
            }
            String []middle=new String[n];
            for(int i=0;i<n;i++)
                middle[i]=p[i].substring(p[i].indexOf('*'),p[i].lastIndexOf('*')).replaceAll("\\*","");
            String result=beginning;
            for(int i=0;i<n;i++)
                result=result+middle[i];
            result=result+end;
            System.out.println("Case #"+tcount+": "+result);
        }
    }
}

