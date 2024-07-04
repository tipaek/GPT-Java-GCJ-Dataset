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
            int et[]=new int[100000];
            int et1[]=new int[100000];
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
            Collections.sort(l);
            StringBuffer ans=new StringBuffer("");
            int last=0;
            int endc=0,endj=0;
            char c[]=new char[100000];
            char c1[]=new char[100000];
            if(ok)
            {
                for(int i=0;i<n;i++)
                {
                    if(i==0)
                    {    c[l.get(i)]='C';ans.append('C');endc=et[l.get(0)];}
                    else if(i==1)
                    {
                        if(l.get(i)!=l.get(i-1))
                        {
                            if(et[l.get(i-1)]<=l.get(i))
                            {    c[l.get(i)]='C';ans.append('C');endc=et[l.get(i)];}
                            else
                            {
                                c[l.get(i)]='J';ans.append('J');endj=et[l.get(i)];
                                last=1;
                            }
                        }
                        else
                        {    c1[l.get(i)]='C';ans.append('J');endj=et1[l.get(i)];}
        
                    }
                    else
                    {
                        if(l.get(i)!=l.get(i-1))
                        {
                            if(et[l.get(i-1)]<=l.get(i) && last==0)
                            {   c[l.get(i)]='C';ans.append('C');endc=et[l.get(i)];}
                            else if(et[l.get(i-1)]<=l.get(i) && last==1)
                            {    c[l.get(i)]='J';ans.append('J');endj=et[l.get(i)];}
                            else
                            {
                                if(last==1 && endc<=l.get(i))
                                {   c[l.get(i)]='C';ans.append('C');last=0;endc=et[l.get(i)];}
                                else if(last==0 && endj<=l.get(i))
                                {   c[l.get(i)]='J';ans.append('J');last=1;endj=et[l.get(i)];}
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
                                c1[l.get(i)]='J';ans.append('J');endj=et1[l.get(i)];last=1;
                            }
                            else if(last==1 && endc<=l.get(i))
                            {
                                c1[l.get(i)]='C';ans.append('C');endc=et1[l.get(i)];last=0;
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
            {
                pw.print("Case #"+tc+": ");
                // pw.println("Case #"+tc+": "+ans);
                for(int i=0;i<n;i++)
                {
                    //pw.println(st[i]);
                    if(c[st[i]]!='N' && et1[st[i]]==-999)
                    {
                        pw.print(c[st[i]]);
                        c[st[i]]='N';
                    }
                    else
                        pw.print(c1[st[i]]);
                }
                pw.print("\n");
            }
        }
        pw.flush();
    }
}

