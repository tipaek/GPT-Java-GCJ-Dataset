import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String args[])
    {
        int T,i,j,k;
        FastReader sc=new FastReader();
        String s[];
        boolean isMatched = false;

        do {
            T=sc.nextInt();
        }while (T<1 || T>100);

        s=new String[T];


        for (i=0;i<T;i++)
        {
            do {
                s[i]=sc.nextLine();
                isMatched = s[i].matches("[0-1]+");
            }while (s[i].length()<1 || s[i].length()>100 || !isMatched);

            for (j=0;j<s[i].length();j++)
            {
                if (s[i].charAt(j)!='0')
                {
                    s[i]=addChar(s[i],'(',j);
                    for (k=j+1;k<s[i].length();k++)
                    {
                        if (s[i].charAt(k)!='1')
                        {
                            s[i]=addChar(s[i],')',k);

                            j=k+1;
                            break;
                        }
                        if(k==(s[i].length()-1))
                        {
                            if(s[i].charAt(k)=='1')
                            {
                                s[i]=addChar(s[i],')',k+1);
                                j=k+1;
                                break;
                            }
                        }
                    }
                }

            }
        }

        for (i=0;i<T;i++)
        {
            System.out.println("Case #"+(i+1)+": "+s[i]);
        }
        System.exit(0);
    }
    public static String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }
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

}
