
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
//            System.out.println(sx.length()+" "+sy.length());
            StringBuilder m1=new StringBuilder();
            for(int i=0;i<Math.abs(sx.length()-sy.length());i++)
            {
                m1.append('0');
            }
            if(sx.length()<sy.length())
            {
                m1.append(sx);
                sx=m1.toString();
            }
            else {
                m1.append(sy);
                sy=m1.toString();
            }

            int f1=1;
            for(int i=0;i<sx.length();i++)
            {
                if(sx.charAt(i)=='0' && sy.charAt(i)=='0')
                {
                    f1=0;
                    break;
                }
            }
            if(f1==0)
            {
                mid.append("IMPOSSIBLE");
                ans.append(mid.toString()).append("\n");
                continue;
            }

            if((x1%2==0 && y1%2==0)||(x1%2==1 && y1%2==1))
            {
                mid.append("IMPOSSIBLE");
                ans.append(mid.toString()).append("\n");
                continue;
            }
            flag=0;
            for(int i=0;i<sx.length();i++)
            {
                if(sx.charAt(i)==sy.charAt(i))
                {
                    flag=1;
                    break;
                }

            }
            if(flag==1) {
                String a = sy;
                String b = sx;
                int odd = x1;
                int v = 0;
                if (y1 % 2 == 1) {
                    odd = y1;
                    b = sy;
                    a = sx;
                    v = 1;
                }
                int pow=0;
                List<Character> list=new ArrayList<>();
                int ind=-1;
                for (int i = sx.length() - 1; i >= 0; i--) {
                    if(sx.charAt(i)==sy.charAt(i))
                    {
                        ind=i;
                        break;
                    }
                    else if(sx.charAt(i)=='1')
                    {
                        list.add('E');
                    }
                    else if(sy.charAt(i)=='1')
                    {
                        list.add('N');
                    }
                }
                if(ind!=-1)
                {
                    if(list.get(list.size()-1)=='N')
                    {
                        list.remove(list.size()-1);
                        list.add('S');
                        for(int i=ind;i>=0;i--)
                        {
                            list.add('E');

                        }
                        list.add('N');
                    }
                    else
                    {
                        list.remove(list.size()-1);
                        list.add('W');
                        for(int i=ind;i>=0;i--)
                        {
                            list.add('N');

                        }
                        list.add('E');
                    }
                }
                for(int i=0;i<list.size();i++)
                {
                    if(x<0)
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
                    if(y<0)
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
                for(char c:list)
                {
                    mid.append(c);
                }
                ans.append(mid.toString()).append("\n");
//                ans1.setCharAt(ans1.length()-1);
            }
            else
            {
                List<Character> list=new ArrayList<>();
                for(int i=sx.length()-1;i>=0;i--)
                {
                    if(sx.charAt(i)=='1')
                    {
                        list.add('E');
                    }
                    else {
                        list.add('N');
                    }
                }
                for(int i=0;i<list.size();i++)
                {
                    if(x<0)
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
                    if(y<0)
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
                for(char c:list)
                {
                    mid.append(c);
                }
                ans.append(mid.toString()).append("\n");
            }




        }
        System.out.print(ans);
    }
}


