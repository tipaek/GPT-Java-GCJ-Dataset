import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        final FastScanner s = new FastScanner();
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve(s));
        }
    }

    public static void __(Object...objs){
        System.out.println(Arrays.deepToString(objs));
    }

    static class Pair {
        Long value;
        char[] chars;

        public Pair(Long value, char[] chars) {
            this.value = value;
            this.chars = chars;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "value=" + value +
                    ", chars=" + Arrays.toString(chars) +
                    '}';
        }
    }

    static String solve(FastScanner s) {
        int U = s.nextInt();

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            long val = s.nextLong();
            char[] arr = s.nextToken().toCharArray();
            pairs.add(new Pair(val, arr));
        }

        pairs.sort((p1, p2) -> p1.value.compareTo(p2.value));

        char[] ans = new char[10];
        Arrays.fill(ans,'*');

        boolean[] used = new boolean[255];

        loop:
        for (Pair pair : pairs) {
//            System.out.println(pair);
            if(pair.value < 10) {
                if(ans[pair.value.intValue()] == '*' && !used[pair.chars[0]]) {
                    ans[pair.value.intValue()] = pair.chars[0];
                    used[pair.chars[0]] = true;
                }
            } else {
                if(ans[0] == '*') {
                    for (char ch : pair.chars) {
                        if(!used[ch]) {
                            ans[0] = ch;
                            break loop;
                        }
                    }
                }
            }
        }

        return new String(ans);
    }

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
}
