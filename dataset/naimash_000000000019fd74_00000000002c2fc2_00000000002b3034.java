import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static String solve(FastScanner s) {
        int N = s.nextInt();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextToken();
        }

//        if(isFirstCase(arr)) {
//            return solveFirstCase(arr);
//        }
//        else if (isSecondCase(arr)) {
//            return solveSecondCase(arr);
//        }

        return solveSecondCase(arr);
    }

    public static boolean isFirstCase(String[] arr) {
        for (String s : arr) {
            if(s.charAt(0) != '*') {
                return false;
            }
        }
        return true;
    }

    public static boolean isSecondCase(String[] arr) {
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

    static class Pattern {
        String value;
        int left;
        int right;

        String getPrefix() {
            return value.substring(0, left);
        }

        String getSuffix() {
            return value.substring(right + 1);
        }

        void add(StringBuilder sb) {
            for (int i = left + 1; i < right; i++) {
                final char ch = value.charAt(i);
                if(ch != ASTERISK.charAt(0)) {
                    sb.append(ch);
                }
            }
        }

        int getSuffixLength() {
            return value.length() - right - 1;
        }

        @Override
        public String toString() {
            return "Pattern{" +
                    "value='" + value + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static String ASTERISK = "*";

    public static String solveSecondCase(String[] arr) {

        List<Pattern> patterns = new ArrayList<>();

        for (String s : arr) {
            final Pattern pattern = new Pattern();
            pattern.value = s;
            patterns.add(pattern);
        }

        for (Pattern pattern : patterns) {

            for (int i = 0; i < pattern.value.length(); i++) {
                if(pattern.value.charAt(i) == '*') {
                    pattern.left = i;
                    break;
                }
            }

            for (int j = pattern.value.length() - 1; j >= 0 ; j--) {
                if(pattern.value.charAt(j) == '*') {
                    pattern.right = j;
                    break;
                }
            }
        }

//        for (Pattern pattern : patterns) {
//            __(pattern);
//        }

        int bestLeft = 0;
        int bestRigth = 0;

        for (int i = 1; i < patterns.size(); i++) {
            if(patterns.get(i).left > patterns.get(bestLeft).left) {
                bestLeft = i;
            }
            if(patterns.get(i).getSuffixLength() > patterns.get(bestRigth).getSuffixLength()) {
                bestRigth = i;
            }
        }

//        __("bestLeft", bestLeft, patterns.get(bestLeft));
//        __("bestRigth", bestRigth, patterns.get(bestRigth));

        if(!validateLeft(patterns, bestLeft)) {
            return ASTERISK;
        }

        if(!validateRight(patterns, bestRigth)) {
            return ASTERISK;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(patterns.get(bestLeft).getPrefix());

        for (Pattern pattern : patterns) {
            pattern.add(sb);
        }

        sb.append(patterns.get(bestRigth).getSuffix());


        return sb.toString();
    }

    static boolean validateLeft(List<Pattern> patterns, int bestLeft) {
        for (Pattern pattern : patterns) {
            for (int i = 0; i < pattern.left; i++) {
                if(pattern.value.charAt(i) != patterns.get(bestLeft).value.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean validateRight(List<Pattern> patterns, int bestRight) {
        for (Pattern pattern : patterns) {
            int last = patterns.get(bestRight).value.length() - 1;
            for (int i = pattern.value.length() - 1; i > pattern.right; i--) {
                if(pattern.value.charAt(i) != patterns.get(bestRight).value.charAt(last--)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void __(Object...objs){
        System.out.println(Arrays.deepToString(objs));
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
