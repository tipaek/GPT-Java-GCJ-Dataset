import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

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

    static class Task {
        Integer index;
        Integer start;
        Integer end;
        char name;

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static class Parent {
        int time;
        char name;

        public Parent(char name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        final FastScanner s = new FastScanner();
        int T = s.nextInt();

        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve(s));
        }
    }

    static Parent getMinParent(Parent[] parents) {
        return parents[0].time <= parents[1].time ? parents[0] : parents[1];
    }

    static String solve(FastScanner s) {
        int N = s.nextInt();

        Task[] pairs = new Task[N];

        for (int i = 0; i < N; i++) {
            final Task pair = new Task();
            pair.index = i;
            pair.start = s.nextInt();
            pair.end = s.nextInt();
            pairs[i] = pair;
        }

        Arrays.sort(pairs, (p1, p2) -> p1.start.equals(p2.start)
                ? p1.end.compareTo(p2.end)
                : p1.start.compareTo(p2.start));

        Parent[] parents = {new Parent('J'), new Parent('C')};

//        for (Task pair : pairs) {
//            System.out.println(pair);
//        }

        boolean imp = false;

        for (Task pair : pairs) {

            Parent parent = getMinParent(parents);

            if(parent.time > pair.start) {
                return "IMPOSSIBLE";
            }

            parent.time = pair.end;
            pair.name = parent.name;
        }

        Arrays.sort(pairs, Comparator.comparing(p -> p.index));

        StringBuilder sb = new StringBuilder();

        for (Task pair : pairs) {
            sb.append(pair.name);
        }

        return sb.toString();
    }


}
