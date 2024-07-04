
import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        //Code starts
        FastReader ip = new FastReader();
        OutputStream output = System.out;
        PrintWriter out = new PrintWriter(output);
        int test=ip.nextInt();
        for(int t=1;t<=test;t++){
            int n=ip.nextInt();
            int arr[][]=new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=ip.nextInt();
                    if(i==j){
                        trace+=arr[i][j];
                    }
                }
            }
            int rc=0;
            int cc=0;
            for(int i=0;i<n;i++){
                HashSet<Integer> hs=new HashSet<>();
                for(int j=0;j<n;j++){
                    hs.add(arr[i][j]);
                }
                if(hs.size()!=n){
                    rc++;
                }
            }
            for(int j=0;j<n;j++){
                HashSet<Integer> hs=new HashSet<>();
                for(int i=0;i<n;i++){
                    hs.add(arr[i][j]);
                }
                if(hs.size()!=n){
                    cc++;
                }
            }
            out.println("Case #"+t+": "+trace+" "+rc+" "+cc);

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