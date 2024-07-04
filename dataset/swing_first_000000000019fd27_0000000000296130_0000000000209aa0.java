import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader r = new FastReader();
        int t = r.nextInt();

        for(Integer i=1; i<=t; i++){
            Long N = r.nextLong();
            Long k = r.nextLong();
            boolean not = true;

            Long curN;
            Long sum;


            if(N%2L == 0L){
                sum = (N/2L * (N/2L + 1L)) * 2L;
                if(sum.equals(k)){
                    System.out.println("Case #" + i.toString() + ": POSSIBLE");
                    generateIncreasing(N, k, 1L);
                    continue;
                }
                if( sum.equals(N + k) ){
                    System.out.println("Case #" + i.toString() + ": POSSIBLE");
                    generateIncreasing(N, k, 0L);
                    continue;
                }
            } else{
                sum = N*(N+1L) / 2L;
                if(sum.equals(k)){
                    System.out.println("Case #" + i.toString() + ": POSSIBLE");
                    generateIncreasing(N, k, 0L);
                    continue;
                }
            }

            curN = 0L;
            for(long j=0L; j<N; j++){
                curN += N;
                if(k.equals(curN)){
                    System.out.println("Case #" + i.toString() + ": POSSIBLE");
                    generateDecreasing(N, k, j);
                    not = false;
                    break;
                }
            }



            if(not){
                System.out.println("Case #" + i.toString() + ": IMPOSSIBLE");
            }

        }
    }

    public static void generateIncreasing(long n, long k, long d){
        String outString = "";
        for(long i=0; i<n; i++){
            for(long j=0; j<n; j++){
                outString += Long.toString(  ((d + j + i) % n) + 1L) + " ";
            }
           outString += "\n";
        }
        System.out.print(outString);
    }

    public static void generateDecreasing(long n, long k, long d){
        String outString = "";
        for(long i=0; i<n; i++){
            for(long j=0; j<n; j++){
                outString += Long.toString(  ((d + n + j - i) % n) + 1L) + " ";
            }
            outString += "\n";
        }
        System.out.print(outString);
    }


    public static class FastReader{
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

        Boolean hasNext(){
            try{
                return br.ready();
            } catch(Exception e){
                return false;
            }
        }
    }
}
