import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Solution {


    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        int numberOfCases = sc.nextInt();

        for (int caze = 1; caze <= numberOfCases; caze++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            List<Long> slices = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                slices.add(sc.nextLong());
            }
//            System.out.println(slices);
            int res = getRes(N, D, slices);


            System.out.println("Case #" + caze + ": " + res);
        }
    }

    private static int getRes(int n, int d, List<Long> slices) {
        if (n == 1) {
            return d - 1;
        }
        Long dAsLong = (long) d;

        Map<Long, Long> count = countByStreamGroupBy(slices);
        List<Long> oneSlice = new ArrayList<>();
        for (Map.Entry<Long, Long> entry : count.entrySet()) {
            if (entry.getValue().equals(dAsLong)) {
                return 0;
            }
            if (entry.getValue().equals(dAsLong - 1)) {
                oneSlice.add(entry.getKey());
            }
        }
        for (Long single : oneSlice) {
            for (Long slice : slices) {
                if (slice > single) return 1;
            }
        }

//        Collections.sort(slices);
        for (Long l : slices) {
            if (slices.contains(2 * l)) {
                return 1;
            }
        }

        return 2;
    }

    public static Map<Long, Long> countByStreamGroupBy(List<Long> input) {
        return input.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
    }

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
