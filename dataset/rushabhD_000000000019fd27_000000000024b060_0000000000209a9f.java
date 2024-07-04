import java.util.*;
import java.io.*;

class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
            } catch (Exception e) {
                System.out.println(e);
            }
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



    public static void main(String args[])throws Exception {
        FastReader sc = new FastReader();
        int t=sc.nextInt();
        for(int p=1;p<=t;p++){
            char[] ch=sc.nextLine().toCharArray();
            StringBuffer ans=new StringBuffer();
            char prev='0';
            for(int i=0;i<ch.length;i++){
                int count=prev-ch[i];
                if(count<0){
                    for(int open=0;open<-count;open++){
                        ans.append("(");
                    }
                }else if(count>0){
                    for(int close=0;close<count;close++)
                        ans.append(")");
                }
                ans.append(ch[i]);
                prev=ch[i];
            }
            for(int close=0;close<(prev-'0');close++)
                ans.append(")");

            System.out.println("Case #"+p+": "+ans.toString());
        }
    }


}