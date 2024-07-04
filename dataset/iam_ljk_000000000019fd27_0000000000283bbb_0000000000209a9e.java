import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Solution
{
    public static void main(String[] stp) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t,b;
        t=Integer.parseInt(st.nextToken());b=Integer.parseInt(st.nextToken());
        while(t-- > 0)
        {
            if (b == 10)
            {
                String s = "";
                for (int i = 1; i <= 10; i++) {
                    pw.println(i);
                    pw.flush();
                    st = new StringTokenizer(br.readLine());
                    int n = Integer.parseInt(st.nextToken());
                    s += "" + n;
                }
                pw.println(s);
                pw.flush();
                st = new StringTokenizer(br.readLine());
                String ans;
                ans = st.nextToken();
            }
            else if(b==20)
            {
                String s="";
                for(int i=1;i<=5;i++)
                {
                    pw.println(i); pw.flush();
                    st=new StringTokenizer(br.readLine());
                    int c=Integer.parseInt(st.nextToken());
                    s+=""+c;
                }
                for(int i=16;i <=20;i++)
                {
                    pw.println(i); pw.flush();
                    st=new StringTokenizer(br.readLine());
                    int c=Integer.parseInt(st.nextToken());
                    s+=""+c;
                }
                StringBuilder sb=new StringBuilder(s);
                String list[]=new String[4];
                for(int i=0;i<4;i++)
                {
                    list[i]="";
                    list[i]+=""+s;
                }
                String for1="",for2="";
                for(int i=0;i<list[0].length();i++)
                {
                    if(list[0].charAt(i)=='1') for1+="0";
                    else for1+="1";
                }
                list[0]=for1;
                list[1]=sb.reverse().toString();
                for(int i=0;i<list[2].length();i++)
                {
                    if(list[2].charAt(i)=='1') for2+="0";
                    else for2+="1";
                }
                list[2]=for2;
                StringBuilder sb2=new StringBuilder(list[2]);
                list[2]=sb2.reverse().toString();



                String ss="";
                for(int i=6;i<=15;i++)
                {
                    pw.println(i);pw.flush();
                    st=new StringTokenizer(br.readLine());
                    int c=Integer.parseInt(st.nextToken());
                    ss+=""+c;
                }


                String slist[]=new String[4];
                for(int i=0;i<4;i++) slist[i]=ss;
                for1="";for2="";
                for(int i=0;i<slist[0].length();i++)
                {
                    if(slist[0].charAt(i)=='0') for1+="1";
                    else for1+="0";
                }
                slist[0]=for1;
                StringBuilder stb;
                stb=new StringBuilder(slist[1]);
                slist[1]=stb.reverse().toString();

                for(int i=0;i<slist[2].length();i++)
                {
                    if(slist[2].charAt(i)=='0') for2+="1";
                    else for2+="0";
                }
                slist[2]=for2;
                stb=new StringBuilder(slist[2]);
                slist[2]=stb.reverse().toString();



                ArrayList<Integer> useful1=new ArrayList<>();
                ArrayList<Integer> u1=new ArrayList<>();
                for(int i=0;i<5;i++)
                {
                    if(s.charAt(i)==s.charAt(9-i))
                    {
                        useful1.add(i+1);
                        useful1.add(20-i);
                        u1.add(i+1);
                        u1.add(10-i);
                        break;
                    }
                }
                for(int i=0;i<5;i++)
                {
                    if(s.charAt(i)!=s.charAt(9-i))
                    {
                        useful1.add(i+1);
                        useful1.add(20-i);
                        u1.add(i+1);
                        u1.add(10-i);
                        break;
                    }
                }
                Collections.sort(useful1);
                Collections.sort(u1);





                ArrayList<Integer> useful2=new ArrayList<>();
                ArrayList<Integer> u2=new ArrayList<>();
                for(int i=0;i<5;i++)
                {
                    if(ss.charAt(i)==ss.charAt(9-i))
                    {
                        useful2.add(i+6);
                        useful2.add(15-i);
                        u2.add(i+1);
                        u2.add(10-i);
                        break;
                    }
                }
                for(int i=0;i<5;i++)
                {
                    if(ss.charAt(i)!=ss.charAt(9-i))
                    {
                        useful2.add(i+6);
                        useful2.add(15-i);
                        u2.add(i+1);
                        u2.add(10-i);
                        break;
                    }
                }
                Collections.sort(useful2);
                Collections.sort(u2);








                String s1="",s2="";
                for(int i=0;i<useful1.size();i++)
                {
                    pw.println(useful1.get(i)); pw.flush();
                    st=new StringTokenizer(br.readLine());
                    int n=Integer.parseInt(st.nextToken());
                    s1+=""+n;
                }
                for(int i=0;i<useful2.size();i++)
                {
                    pw.println(useful2.get(i)); pw.flush();
                    st=new StringTokenizer(br.readLine());
                    int n=Integer.parseInt(st.nextToken());
                    s2+=""+n;
                }






                String selected1="";
                String selected2="";
                for(int i=0;i<4;i++)
                {
                    boolean ok=true;
                    for(int j=0;j<useful1.size();j++)
                    {
                        if(list[i].charAt( u1.get(j)-1 ) != s1.charAt(j)) ok=false;
                    }
                    if(ok==true)
                    {
                        selected1=list[i];
                        break;
                    }
                }

                for(int i=0;i<4;i++)
                {
                    boolean ok=true;
                    for(int j=0;j<useful2.size();j++)
                    {
                        if(slist[i].charAt( u2.get(j)-1 ) != s2.charAt(j)) ok=false;
                    }
                    if(ok==true)
                    {
                        selected2=slist[i];
                        break;
                    }
                }








                String ans="";
                for(int i=0;i<5;i++) ans+=selected1.charAt(i);
                ans+=selected2;
                for(int i=5;i<10;i++) ans+=selected1.charAt(i);
                pw.println(ans);
                pw.flush();
                String r="",no="N";
                st=new StringTokenizer(br.readLine());
                r=st.nextToken();
                if(r.equals(no)) System.exit(0);
            }



        }
    }
}