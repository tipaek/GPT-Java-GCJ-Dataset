
import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) throws IOException {
        //Code starts
        FastReader ip = new FastReader();
        OutputStream output = System.out;
        PrintWriter out = new PrintWriter(output);
        int test=ip.nextInt();
        for(int t=1;t<=test;t++){
            String s=ip.nextLine();
            StringBuilder str=new StringBuilder();
            int open=0;
            int i=0;
            while(i<s.length()){
                if(i!=0 && s.charAt(i)==s.charAt(i-1)){
                    str.append(s.charAt(i));
                }else {
                    int v = s.charAt(i)-'0';
                    if (open < v) {
                        while (open != v) {
                            str.append('(');
                            open++;
                        }
                        str.append(v);
                    } else  {
                        while (open != v) {
                            str.append(')');
                            open--;
                        }
                        str.append(v);
                    }
                }
                i++;
            }
            while (open!=0){
                str.append(')');
                open--;
            }
            out.println("Case #"+t+": "+str);
        }

        out.close();
        //Code ends
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreElements()) {
            try { st = new StringTokenizer(br.readLine()); }
            catch (IOException e) { e.printStackTrace(); } }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }

}