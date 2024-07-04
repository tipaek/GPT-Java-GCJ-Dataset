import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
        public static void main(String[] args){
        FastReader input = new FastReader();
        int z=1;
        int t = input.nextInt();
        while (t-->0){
            int n = input.nextInt();
            TreeMap<Integer,Integer> treemap = new TreeMap<>();
            String ans = "";
            while (n-->0){
                int start = input.nextInt();
                int end = input.nextInt();
                treemap.put(start,end);
            }
            int jamiePrevious=-1;
            int cameronPrevious=-1;
            boolean flag = false;
            for (Map.Entry it : treemap.entrySet()){
                int key = (int) it.getKey();
                int val = (int) it.getValue();

                if (key < cameronPrevious && key < jamiePrevious){
                    flag = true;
                   break;
                }

                if (key >= cameronPrevious){
                    ans+="C";
                    cameronPrevious = val;
                }else {
                    ans+='J';
                    jamiePrevious = val;
                }
            }
            System.out.println("Case #"+z+": "+((flag)?"IMPOSSIBLE":ans));
            z++;
        }

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
    }
}