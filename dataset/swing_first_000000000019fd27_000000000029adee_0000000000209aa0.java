import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

            if(N%2 == 0 && k % 2 == 0){
                sum = ((N/2 * (N/2 + 1)));

                if( (sum <= k) && (k <= (sum + N * N / 2)) ){
                    ArrayList<Integer> vals = generateVal(N, k);

                    System.out.println("Case " + i.toString() + ": POSSIBLE");
                    generateIncreasing(N, k, vals);
                    continue;

                }

            } else{
                sum = N*(N+1) / 2;
                if(sum == k){
                    System.out.println("Case " + i.toString() + ": POSSIBLE");
                    generateIncreasing(N, k);
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

    public static ArrayList<Integer> generateVal(int n, int k){
        int halfN = n / 2;
        int val;
        k /= 2;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=halfN; i++){
            list.add(i);
            k -= i;
        }

        for(int i=halfN-1; i>=0; i--){
            val = list.get(i);
            if(k <= halfN){
                list.set(i, val + k);
                k = 0;
                break;
            } else{
                list.set(i, val + halfN);
                k -= halfN;
            }
        }

        int index = 1;
        for(int i=1; i<=n; i++){
            if(list.contains(i)) continue;
            list.add(index, i);
            index += 2;
        }
        return list;
    }

    public static void generateIncreasing(int n, int k){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print( Integer.toString(  ((j + i) % n) + 1) + " "  );
            }
            System.out.println();
        }
    }

    public static void generateIncreasing(int n, int k, ArrayList<Integer> vals){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print( Integer.toString(  (vals.get((n + j + i) % n))) + " ");
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
