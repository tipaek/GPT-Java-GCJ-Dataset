import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t,n;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            String s="";
            String m[]=new String[n];
            for(int j=0;j<n;j++)
            {
                m[j]=sc.next();

                if(j==0)
                    s=m[j];
                else
                {
                    s=chk(s,m[j]);
                }
            }

            if(s.equals("null")) {
                s = "*";
            }
            else
            {
                String s1="";
                for(int k=0;k<s.length();k++)
                    if(s.charAt(k)!='*')
                        s1=s1+s.charAt(k);

                    s=s1;
            }


            System.out.println("Case #"+(i+1)+": "+s);

        }



    }

    static String chk (String s, String p)
    {
        int flag=0;
        if(s.equals("null"))
            return s;

        if(s.charAt(0)!='*'&&p.charAt(0)!='*')
        {
            int i1=0;
            for(int j=0;j<s.length();j++)
                if(s.charAt(j)=='*')
                {
                    i1=j;
                    break;
                }
            for(int j=0;j<p.length();j++)
                if(p.charAt(j)=='*')
                {
                    if(i1>j)
                    i1=j;
                    break;
                }

            for(int j=0;j<i1;j++)
                if(s.charAt(j)!=p.charAt(j))
                    flag=1;

                if(s.charAt(s.length()-1)!='*'&&p.charAt(p.length()-1)!='*')
                {
                    int i2=0;
                    for(int j=s.length()-1;j>=0;j--)
                        if(s.charAt(j)=='*')
                        {
                            i2=s.length()-j-1;
                            break;
                        }
                    for(int j=p.length()-1;j>=0;j--)
                        if(p.charAt(j)=='*')
                        {
                            int x=p.length()-j-1;
                            i2=Math.min(i2,x);
                            break;
                        }

                    for(int j=0;j<i2;j++)
                        if(s.charAt(s.length()-1-j)!=p.charAt(p.length()-1-j))
                            flag=1;

                        if(flag==0)
                        {
                            //String s1;
                            if(s.charAt(i1)!='*')
                            {
                                int a=p.indexOf('*');
                                int b=p.lastIndexOf('*');
                                int c=s.indexOf('*');
                                if(s.charAt(s.length()-1-i2)!='*')
                                    s=s.substring(0,c)+p.substring(a,b)+"*"+s.substring(c+1);
                                else
                                    s=s.substring(0,s.lastIndexOf('*'))+p.substring(a);
                            }
                            else
                            {
                                int a=s.indexOf('*');
                                int b=s.lastIndexOf('*');
                                int c=p.indexOf('*');
                                if(s.charAt(s.length()-1-i2)!='*')
                                    s=p.substring(0,p.lastIndexOf('*'))+s.substring(a);
                                else
                                    s=p.substring(0,c)+s.substring(a,b)+"*"+p.substring(c+1);
                            }

//                            if(s.charAt(s.length()-1-i2)!='*')
////                            {
////                                int a=p.indexOf('*');
////                                int b=p.lastIndexOf('*');
////                                int c=s.lastIndexOf('*');
////                                s=s.substring(0,c)+p.substring(a,b)+"*"+s.substring(c+1);
////                            }
////                            else
////                            {
////                                int a=s.indexOf('*');
////                                int b=s.lastIndexOf('*');
////                                int c=p.lastIndexOf('*');
////                                s=p.substring(0,c)+s.substring(a,b)+"*"+p.substring(c+1);
////                            }
                        }

                }
                else
                {
                    if(flag==0)
                    {
                        if(s.charAt(i1)!='*')
                        {
                            int a=p.indexOf('*');
                            int b=p.lastIndexOf('*');
                            int c=s.indexOf('*');
                            if(b==p.length()-1)
                                s=s.substring(0,c)+p.substring(a,b)+"*"+s.substring(c+1);
                            else
                                s=s+p.substring(a);
                        }
                        else
                        {
                            int a=s.indexOf('*');
                            int b=s.lastIndexOf('*');
                            int c=p.indexOf('*');
                            if(b==s.length()-1)
                                s=p.substring(0,c)+s.substring(a,b)+"*"+p.substring(c+1);
                            else
                                s=p+s.substring(a);
                        }
                    }
                }



        }
        else if(s.charAt(s.length()-1)!='*'&&p.charAt(p.length()-1)!='*') {
            int i2 = 0;
            for (int j = s.length() - 1; j >= 0; j--)
                if (s.charAt(j) == '*') {
                    i2 = s.length() - j - 1;
                    break;
                }
            for (int j = p.length() - 1; j >= 0; j--)
                if (p.charAt(j) == '*') {
                    int x = p.length() - j - 1;
                    i2 = Math.min(i2, x);
                    break;
                }

            for (int j = 0; j < i2; j++)
                if (s.charAt(s.length() - 1 - j) != p.charAt(p.length() - 1 - j))
                    flag = 1;

            if (flag == 0) {
                if (s.charAt(s.length() - 1 - i2) != '*') {
                    int a = p.indexOf('*');
                    int b = p.lastIndexOf('*');
                    int c = s.lastIndexOf('*');
                    if(a==0)
                        s = s.substring(0, c) + p.substring(a, b) + "*" + s.substring(c + 1);
                    else
                        s=p.substring(0,b)+s;
                } else {
                    int a = s.indexOf('*');
                    int b = s.lastIndexOf('*');
                    int c = p.lastIndexOf('*');
                    if(a==0)
                        s = p.substring(0, c) + s.substring(a, b) + "*" + p.substring(c + 1);
                    else
                        s=s.substring(0,b)+p;
                }
            }

        }
        else if(s.charAt(0)!='*'||p.charAt(0)!='*')
        {
            if(s.charAt(0)!='*')
            {
                if(p.charAt(p.length()-1)=='*')
                    s=s.substring(0,s.indexOf('*'))+p+s.substring(s.indexOf('*'));
                else
                    s=s+p.substring(1);
            }
            else
            {
                if(s.charAt(s.length()-1)=='*')
                    s=p.substring(0,p.indexOf('*'))+s+p.substring(p.indexOf('*'));
                else
                    s=p+s.substring(1);
            }

        }
        else if(s.charAt(s.length()-1)!='*'||p.charAt(p.length()-1)!='*')
        {
            if(s.charAt(s.length()-1)!='*')
                s=p+s;
            else
                s=s+p;
        }
        else
        {
            s=s.substring(0,s.indexOf('*'))+p.substring(p.indexOf('*'),p.lastIndexOf('*'))+s.substring(s.indexOf('*'));
        }

        if(flag==1)
            s="null";


        return s;

    }
}