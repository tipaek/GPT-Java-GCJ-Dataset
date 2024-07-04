import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import java.util.Stack;
import java.util.Arrays;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out); 
        int t = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++)
        {
            int n=Integer.parseInt(br.readLine());
            int st[]=new int[n];
            int et[]=new int[24*60+2];
            int et1[]=new int[24*60+2];
            Arrays.fill(et,-999);
            Arrays.fill(et1,-999);
            boolean ok=true;
            ArrayList <Integer> l= new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String s1[]=(br.readLine()).split(" ");
                st[i]=Integer.parseInt(s1[0]);
                l.add(st[i]);
                if(et[st[i]]==-999)
                    et[st[i]]=Integer.parseInt(s1[1]);
                else if(et1[st[i]]==-999)
                    et1[st[i]]=Integer.parseInt(s1[1]);
                else
                {    pw.println("Case #"+tc+": IMPOSSIBLE");ok=false;}
            }
            //Collections.sort(l);
            StringBuffer ans=new StringBuffer("");
            int last=0;
            boolean state[]=new boolean[n+1];
            state[0]=true;state[1]=true;
            int endc=0,endj=0;
            if(ok)
            {
                for(int i=0;i<n;i++)
                {
                    if(i==0)
                    {    ans.append('C');endc=et[l.get(0)];}
                    else if(i==1)
                    {
                        if(l.get(i)!=l.get(i-1))
                        {
                            if(et[l.get(i-1)]<=l.get(i))
                            {    ans.append('C');endc=et[l.get(i)];}
                            else
                            {
                                ans.append('J');endj=et[l.get(i)];
                                last=1;
                            }
                        }
                        else
                        {    ans.append('J');endj=et1[l.get(i)];}
        
                    }
                    else
                    {
                        if(l.get(i)!=l.get(i-1))
                        {
                            if(et[l.get(i-1)]<=l.get(i) && last==0)
                            {   ans.append('C');endc=et[l.get(i)];}
                            else if(et[l.get(i-1)]<=l.get(i) && last==1)
                            {    ans.append('J');endj=et[l.get(i)];}
                            else
                            {
                                if(last==1 && endc<=l.get(i))
                                {   ans.append('C');last=0;endc=et[l.get(i)];}
                                else if(last==0 && endj<=l.get(i))
                                {   ans.append('J');last=1;endj=et[l.get(i)];}
                                else
                                {
                                    ok=false;
                                    pw.println("Case #"+tc+": IMPOSSIBLE");
                                    break;
                                }
                            }
                        }
                        else
                        {
                            //pw.println(last+" "+endj+" "+l.get(i));
                            if(last==0 && endj<=l.get(i))
                            {
                                ans.append('J');endj=et1[l.get(i)];last=1;
                            }
                            else if(last==1 && endc<=l.get(i))
                            {
                                ans.append('C');endc=et1[l.get(i)];last=0;
                            }
                            else
                            {
                                ok=false;
                                pw.println("Case #"+tc+": IMPOSSIBLE");
                                break;
                            }
                        }
                    }
                    //pw.println(ans);
                }
            }
            if(ok)
                pw.println("Case #"+tc+": "+ans);
        }
        pw.flush();
    }
}

