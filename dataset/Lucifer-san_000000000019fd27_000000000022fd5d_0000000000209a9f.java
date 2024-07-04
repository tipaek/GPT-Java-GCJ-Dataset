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

        int t;
        t=sc.nextInt();
        String s;
        for(int i=0;i<t;i++)
        {
            s=sc.next();
            String s1;
            s1=s;
            int max=0;
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)!='('&&s.charAt(j)!=')')
                {
                    int a=(int)s.charAt(j)-48;
                    if(max<a)
                        max=a;
                }
            }

            for(int z=0;z<max;z++) {
                int x = 0;
                for (int j = 0; j < s1.length(); j++) {
                    if (s1.charAt(j) == '(')
                        ++x;
                    else if (s1.charAt(j) == ')')
                        --x;
                    else if ((int) s1.charAt(j) - 48 > x) {
                        if (j > 0)
                            s1 = s1.substring(0, j) + "(" + s1.substring(j);
                        else if (j == 0)
                            s1 = "(" + s1;

                        j = j + 1;
                        ++x;
                        if (j == s1.length())
                            s1 = s1 + ")";
                        else
                            while ((int) s1.charAt(j) - 48 >= x) {
                                ++j;
                                if (j == s1.length()) {
                                    s1 = s1 + ")";
                                    break;
                                }
                                if ((int) s1.charAt(j) - 48 < x) {
                                    s1 = s1.substring(0, j) + ")" + s1.substring(j);
                                    --x;
                                    break;
                                }
                            }
                    }
                }
            }

            System.out.println("Case #"+(i+1)+": "+s1);
        }



    }
}