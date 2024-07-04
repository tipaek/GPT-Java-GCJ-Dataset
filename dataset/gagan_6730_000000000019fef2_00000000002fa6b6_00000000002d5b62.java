import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution  {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {

        FastReader s=new FastReader();
        StringBuilder ans=new StringBuilder();
        int t=s.nextInt();
        int count=1;
        while(t-->0)
        {
            StringBuilder mid=new StringBuilder("Case #"+(count++)+": ");
            int x=s.nextInt();
            int y=s.nextInt();
            long val=Math.abs(x)^Math.abs(y);
            int x1=Math.abs(x);
            int y1=Math.abs(y);
            String str=Long.toBinaryString(val);
            int  flag=0;
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)=='0')
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                mid.append("IMPOSSIBLE");
                ans.append(mid.toString()).append("\n");
                continue;
            }
            String sx=Integer.toBinaryString(x1);
            String sy=Integer.toBinaryString(y1);
            if(sx.length()!=sy.length())
            {

                StringBuilder m=new StringBuilder();
                for(int i=0;i<Math.abs(sx.length()-sy.length());i++)
                {
                    m.append('0');
                }
                if(sx.length()<sy.length())
                {
                    m.append(sx);
                    sx=m.toString();
                }
                else {
                    m.append(sy);
                    sy=m.toString();
                }
                int f=1;
                for(int i=0;i<sx.length();i++)
                {
                    if(sx.charAt(i)=='0' && sy.charAt(i)=='0')
                    {
                        f=0;
                        break;
                    }
                }
                if(f==0)
                {
                    mid.append("IMPOSSIBLE");
                    ans.append(mid.toString()).append("\n");
                    continue;
                }
                List<Character> list=new ArrayList<>();
                for(int i=sx.length()-1;i>=0;i--)
                {
                    if(sx.charAt(i)=='1')
                    {
                        list.add('E');
                    }
                    else
                    {
                        list.add('N');
                    }
                }

                if(x<0)
                {
                    for(int i=0;i<list.size();i++)
                    {
                        if(list.get(i)=='E')
                        {
                            list.set(i,'W');
                        }
                        else if(list.get(i)=='W')
                        {
                            list.set(i,'E');
                        }

                    }
                }
                if(y<0)
                {
                    for(int i=0;i<list.size();i++)
                    {
                        if(list.get(i)=='N')
                        {
                            list.set(i,'S');
                        }
                        else if(list.get(i)=='S')
                        {
                            list.set(i,'N');
                        }

                    }
                }
                for(char ch:list)
                {
                    mid.append(ch);
                }
                ans.append(mid.toString()).append("\n");
            }
            else {
                int f=1;
                for(int i=0;i<sx.length();i++)
                {
                    if(sx.charAt(i)=='0' && sy.charAt(i)=='0')
                    {
                        f=0;
                        break;
                    }
                }
                if(f==0)
                {
                    mid.append("IMPOSSIBLE");
                    ans.append(mid.toString()).append("\n");
                    continue;
                }
                int v=0;
                int ind=-1;
                for(int i=0;i<sx.length();i++)
                {
                    if(sx.charAt(i)!=sy.charAt(i))
                    {
                        if(sx.charAt(i)==1)
                        {
                            v=0;

                        }
                        else {
                            v=1;
                        }
                        ind=i;
                        break;
                    }
                }
                List<Character> list=new ArrayList<>();
                for(int i=sx.length()-1;i>ind;i--)
                {
                    if(sx.charAt(i)=='1')
                    {
                        list.add('E');
                    }
                    else
                    {
                        list.add('N');
                    }
                }
                if(v==0)
                {
                    list.add('W');
                }
                else
                {
                    list.add('S');
                }
                for(int i=ind-1;i>=0;i--)
                {
                    if(v==0)
                    {
                        list.add('N');
                    }
                    else
                    {
                        list.add('E');
                    }
                }
                if(v==0)
                {
                    list.add('E');
                }
                else
                {
                    list.add('N');
                }
//                System.out.println(count);
//                for(char c:list)
//                {
//                    System.out.print(c);
//                }
//                System.out.println();
                if(x<0)
                {
                    for(int i=0;i<list.size();i++)
                    {
                        if(list.get(i)=='E')
                        {
                            list.set(i,'W');
                        }
                        else if(list.get(i)=='W')
                        {
                            list.set(i,'E');
                        }

                    }
                }
                if(y<0)
                {
                    for(int i=0;i<list.size();i++)
                    {
                        if(list.get(i)=='N')
                        {
                            list.set(i,'S');
                        }
                        else if(list.get(i)=='S'){
                            list.set(i,'N');
                        }

                    }
                }
                for(char ch:list)
                {
                    mid.append(ch);
                }
                ans.append(mid.toString()).append("\n");
            }
//            int currX=0,currY=0;
//            mid.append(1).append(" ").append(1);
//            ans.append(mid.toString()).append("\n");
        }
        System.out.print(ans);
    }
}


