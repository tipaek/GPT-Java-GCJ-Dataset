import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(){
            init();
        }

        public FastScanner(String name) {
            if("naik".equalsIgnoreCase(System.getenv("USER"))){
                init(name);
            } else {
                init();
            }
        }

        public FastScanner(boolean isOnlineJudge){
            if(!isOnlineJudge || System.getProperty("ONLINE_JUDGE") != null){
                init();
            } else {
                init("input.txt");
            }
        }

        private void init(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private void init(String name){
            try {
                br = new BufferedReader(new FileReader(name));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String nextToken(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(nextToken());
        }

        public long nextLong(){
            return Long.parseLong(nextToken());
        }

        public double nextDouble(){
            return Double.parseDouble(nextToken());
        }

    }

    public static void __(Object...objs){
        System.out.println(Arrays.deepToString(objs));
    }

    public static void main(String[] args) {
        final FastScanner s = new FastScanner();

//        final TreeMap<Integer, Integer> rombs = getRombs();

        int T = s.nextInt();

        for (int t = 1; t <= T; t++) {
//            System.out.println("Case #" + t + ": " + solve(s.nextInt(), s.nextInt(), rombs));
            System.out.println("Case #" + t + ": " + solve(s.nextInt(), s.nextInt()));
        }
    }

//    static TreeMap<Integer, Integer> getRombs() {
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//
//        int sum = 0;
//
//        for (int p = 0; p < 31; p++) {
//            int val = 1 << p;
//            sum += val;
//            treeMap.put(sum, val);
////            __(sum, val);
//
//        }
//
//        return treeMap;
//
//    }

    static int getMaxRomb(int value) {
        final int i = Integer.highestOneBit(value);
        return (i << 1) - 1;
    }

//    static String solve(int X, int Y, TreeMap<Integer, Integer> rombs) {
    static String solve(int X, int Y) {

//        __(X, Y);

        int romb = Math.abs(X) + Math.abs(Y);

        final Integer maxRomb = getMaxRomb(romb);

//        __("maxRomb", maxRomb);

        StringBuilder sb = new StringBuilder();

        for (int i = maxRomb; i >= 1 ; i -= Integer.highestOneBit(i)) {
            if(Math.abs(X) > Math.abs(Y)) {
                if(X < 0) {
                    X += Integer.highestOneBit(i);
                    sb.append("W");
                } else {
                    X -= Integer.highestOneBit(i);
                    sb.append("E");
                }
            } else {
                if(Y < 0) {
                    Y += Integer.highestOneBit(i);
                    sb.append("S");
                } else {
                    Y -= Integer.highestOneBit(i);
                    sb.append("N");
                }
            }
        }

        if(X == 0 && Y == 0) {
            return sb.reverse().toString();
        }

        return "IMPOSSIBLE";
    }


}
