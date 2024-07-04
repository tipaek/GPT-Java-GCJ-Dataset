import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

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


    static class Activity implements Comparable<Activity>{
        int start;
        int end;
        int index;
        char ch;
        Activity(int start,int end,int index){
            this.start=start;
            this.end=end;
            this.index=index;
        }


        @Override
        public int compareTo(Activity o) {
            return start-o.start;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCases=fr.nextInt();
        for(int l=0;l<testCases;l++) {
            String str=fr.next();
            int cur=0;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                int digit=ch-'0';
                if(digit==cur){
                    sb.append(digit);
                }
                else if(digit>cur){
                    sb.append("(");
                    cur++;
                    i--;
                }
                else{
                    sb.append(")");
                    cur--;
                    i--;
                }

            }
            while(cur-->0){
                sb.append(")");

            }
            System.out.println("Case #"+(l+1)+": "+sb.toString());

        }
    }
}
