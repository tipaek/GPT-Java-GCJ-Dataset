import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        final FastScanner s = new FastScanner();

        int T = s.nextInt();

        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve(s));
        }

    }

    public static String solve(FastScanner s) {
        int N = s.nextInt();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextToken();
        }

        if(isFirstCase(arr)) {
            return solveFirstCase(arr);
        }

        return solveFirstCase(arr);
    }

    public static boolean isFirstCase(String[] arr) {
        for (String s : arr) {
            int ast = 0;
            for (char ch : s.toCharArray()) {
                if(ch == '*') {
                    ast++;
                }
            }
            if(ast != 1) {
                return false;
            }
        }
        return true;
    }

    public static String solveFirstCase(String[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        String answer = arr[arr.length - 1].substring(1);

        for (int i = 0; i < arr.length - 1; i++) {
            if(!answer.endsWith(arr[i].substring(1))){
                return "*";
            }
        }
        return answer;
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
