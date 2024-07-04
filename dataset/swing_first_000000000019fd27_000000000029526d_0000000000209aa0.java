import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader r = new FastReader();
        int t = r.nextInt();

        for(Integer i=1; i<=t; i++){
            int N = r.nextInt();
            int k = r.nextInt();
            boolean not = true;

            int curN;
            int sum;

            if(N%2 == 0){
                sum = (N/2 * (N/2 + 1)) * 2;
                if(sum == k){
                    System.out.println("Case " + i.toString() + ": POSSIBLE");
                    generateIncreasing(N, k, 1);
                    continue;
                }
                if( (sum - N) == k ){
                    System.out.println("Case " + i.toString() + ": POSSIBLE");
                    generateIncreasing(N, k, 0);
                    continue;
                }
            } else{
                sum = N*(N+1) / 2;
                if(sum == k){
                    System.out.println("Case " + i.toString() + ": POSSIBLE");
                    generateIncreasing(N, k, 0);
                    continue;
                }
            }

            curN = 0;
            for(int j=0; j<N; j++){
                curN += N;
                if(k == curN){
                    System.out.println("Case " + i.toString() + ": POSSIBLE");
                    generateDecreasing(N, k, j);
                    not = false;
                    break;
                }
            }



            if(not){
                System.out.println("Case " + i.toString() + ": IMPOSSIBLE");
            }

        }
    }

    public static void generateIncreasing(int n, int k, int d){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print( Integer.toString(  ((d + j + i) % n) + 1) + " "  );
            }
            System.out.println();
        }
    }

    public static void generateDecreasing(int n, int k, int d){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print( Integer.toString(  ((d + n + j - i) % n) + 1) + " "  );
            }
            System.out.println();
        }
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
