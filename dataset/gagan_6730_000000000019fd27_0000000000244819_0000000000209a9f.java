import javax.swing.*;
import java.io.*;
import java.util.*;
import java.math.*;

import static java.util.Comparator.*;

class Solution {
    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int t=s.nextInt();

        for(int c=1;c<=t;c++)
        {
            String str=s.next();

            List<Character> list=new ArrayList<>();

            int max=Integer.MIN_VALUE;
            for(int i=0;i<str.length();i++)
            {
                list.add(str.charAt(i));
                max=Math.max(max,Character.getNumericValue(str.charAt(i)));
            }

            for(int i=0;i<max;i++)
            {
                List<Character> mid=new ArrayList<>();
                boolean closed=true;
                for(int j=0;j<list.size();j++)
                {
                    if(Character.isDigit(list.get(j)))
                    {
                        int val=Character.getNumericValue(list.get(j));
                        if(closed)
                        {
                            if(val>i)
                            {
                                mid.add('(');
                                mid.add(list.get(j));
                                closed=false;
                            }
                            else {
                                mid.add(list.get(j));
                            }
                        }
                        else {
                            if(val<=i)
                            {
                                mid.add(')');
                                mid.add(list.get(j));
                                closed=true;
                            }
                            else
                            {
                                mid.add(list.get(j));
                            }
                        }
                    }
                    else
                    {
                        mid.add(list.get(j));
                    }
                }
                if(!closed)
                    mid.add(')');
                list=new ArrayList<>(mid);
//                StringBuilder b=new StringBuilder();
//                for(char ch:list)
//                {
//                    b.append(ch);
//                }
//                System.out.println(b);
            }
            StringBuilder ans=new StringBuilder();
            for(char i:list)
            {
                ans.append(i);
            }

            System.out.println("Case #"+c+": "+ans.toString());
        }

    }

}


class FastReader
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
            catch (IOException  e)
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