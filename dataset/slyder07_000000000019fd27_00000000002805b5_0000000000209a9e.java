import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    FastReader in = new FastReader();

    public static void main(String[] args) throws IOException{
        new Solution().solveTests();
    }

    public void solveTests() throws IOException {
        int T = in.nextInt();
        int B = in.nextInt();
        for(int i = 0; i < T; i++){
            solveTest(B);
        }
    }

    class BitSet{
        Boolean[] set;

        public BitSet(int size){
            set = new Boolean[size];
        }

        public void complement(){
            for(int i = 0; i < set.length; i++){
                if(set[i] == null){
                    continue;
                }
                set[i] = !set[i];
            }
        }

        public void reverse(){
            for(int i = 0; i < set.length / 2; i++){
                Boolean sw = set[i];
                set[i] = set[set.length - 1 - i];
                set[set.length - 1 - i] = sw;
            }
        }

        public void complementAndReverse(){
            complement();
            reverse();
        }
    }

    public void solveTest(int B){
        BitSet bitSet = new BitSet(B);
        for(int i = 0; i < B; i++){
            System.out.println(i + 1);
            bitSet.set[i] = in.nextInt() == 1;
        }

        StringBuilder builder = new StringBuilder();

        for(Boolean b : bitSet.set){
            if(b){
                builder.append("1");
            } else {
                builder.append("0");
            }
        }

        System.out.println(builder.toString());


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
