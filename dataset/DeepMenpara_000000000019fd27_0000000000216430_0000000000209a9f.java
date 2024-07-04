import java.io.*;
import java.math.BigInteger;
import java.util.*;


class Solution {
    public static void main(String[] args) throws IOException {

        FastReader sc=new FastReader();
        int n =sc.nextInt();
        int i=0,j=0,k=0;

        for (k=0;k<n;k++)
        {
            String out="";
            int parenthesiscount=0;
            int samecount=0;
            String str=sc.nextLine();
            char inpchar[]=str.toCharArray();
            for (i=0;i<inpchar.length;i++)
            {
                if (i!=inpchar.length-1 && inpchar[i]==inpchar[i+1])
                {
                    samecount++;
                    continue;
                }
                else
                {
                    samecount++;
                    if (parenthesiscount>Integer.parseInt(inpchar[i]+""))
                    {
                        while (parenthesiscount!=Integer.parseInt(inpchar[i]+""))
                        {
                            out+=")";
                            parenthesiscount--;
                        }
                    }
                    else if (parenthesiscount<Integer.parseInt(inpchar[i]+""))
                    {
                        while (parenthesiscount!=Integer.parseInt(inpchar[i]+""))
                        {
                            out+="(";
                            parenthesiscount++;
                        }
                    }

                    while (samecount!=0)
                    {
                        out+=inpchar[i];
                        samecount--;
                    }
                }
            }
            while (parenthesiscount!=0)
            {parenthesiscount--;
            out+=")";
            }
      
            System.out.println("Case #"+(k+1)+": "+out);

        }

        //System.out.println("Case #"+(k+1)+": "+a+" "+b);
    }

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
}