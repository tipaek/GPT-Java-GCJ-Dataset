
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
            int n=ip.nextInt();
            int arr[][]=new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0]=ip.nextInt();
                arr[i][1]=ip.nextInt();
            }
            Arrays.sort(arr,Comparator.comparing(o->o[0]));

            StringBuilder ans=new StringBuilder();
            boolean possible=true;
            int c=0;
            int j=0;
            for(int i=0;i<n;i++){
                if(arr[i][0]>=c){
                    c=arr[i][1];
                    ans.append('C');
                }else if(arr[i][0]>=j){
                    j=arr[i][1];
                    ans.append('J');
                }else{
                    possible=false;
                    break;
                }
            }
            if(possible){
                out.println("Case #"+t+": "+ans);
            }else{
                out.println("Case #"+t+": "+"Impossible");
            }
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