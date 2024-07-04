import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Vestigium {
    public static void main(String[] args) {
//        final FastScanner s = new FastScanner("input.txt");
        final FastScanner s = new FastScanner();

        int T = s.nextInt();

        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve(s));
        }
    }

    static String solve(FastScanner s) {
        int N = s.nextInt();

        int k = 0;

        int arr[][] = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                arr[r][c] = s.nextInt();
                if(r == c) {
                    k += arr[r][c];
                }
            }
        }

        int answerR = 0;

        for (int r = 0; r < N; r++) {
            boolean[] used = new boolean[N + 1];
            for (int c = 0; c < N; c++) {
                final int val = arr[r][c];
                if(used[val]) {
                    answerR++;
                    break;
                }
                used[val] = true;
            }
        }

        int answerC = 0;

        for (int c = 0; c < N; c++) {
            boolean[] used = new boolean[N + 1];
            for (int r = 0; r < N; r++) {
                final int val = arr[r][c];
                if(used[val]) {
                    answerC++;
                    break;
                }
                used[val] = true;
            }
        }


        return k + " " + answerR + " " + answerC;
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
