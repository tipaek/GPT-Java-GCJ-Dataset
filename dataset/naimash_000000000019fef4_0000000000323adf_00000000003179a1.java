import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

        int[] counter = new int[255];

        for (Pair pair : pairs) {
            for (char ch : pair.chars) {
                counter[ch]++;
            }
        }


        List<Letter> letters = new ArrayList<>();

        for (int i = 0; i < 255; i++) {
            if(counter[i] > 0) {
                letters.add(new Letter((char) i, counter[i]));
            }
        }

        letters.sort(Comparator.comparing(l -> l.count));

//        for (Letter letter : letters) {
//            __(letter);
//        }

        int[] horm = new int[] {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        char[] ans = new char[10];

        for (int i = 0; i < 10; i++) {
            ans[horm[i]] = letters.get(i).ch;
        }


        return new String(ans);
    }

    static class Letter {
        char ch;
        Integer count;

        public Letter(char ch, Integer count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Letter{" +
                    "ch=" + ch +
                    ", count=" + count +
                    '}';
        }
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
