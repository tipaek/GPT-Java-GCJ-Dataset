
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = Integer.parseInt(sc.nextToken());
        for (int i = 0; i < numberOfTest; i++) {
            // Input
            int numberOfSlide = sc.nextInt();
            int numberOfDish = sc.nextInt();
            long[] degrees = new long[numberOfSlide];
            for (int j = 0 ; j < numberOfSlide; j++) {
                degrees[j] = sc.nextLong();
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(numberOfSlide, numberOfDish, degrees));
        }
    }

    public static String solve(int N, int D, long[] degrees) {
        Map<Long, Integer> sequenceOfDegree = new HashMap<>();
        for (long degree : degrees) {
            int sequence = 1;
            if (sequenceOfDegree.containsKey(degree)) {
                sequence = sequenceOfDegree.get(degree) + 1;
            }
            sequenceOfDegree.remove(degree);
            sequenceOfDegree.put(degree, sequence);
            if (sequence >= D) {
                return "0";
            }
        }

        int minCut = Integer.MAX_VALUE;
        for (long targetDegree : sequenceOfDegree.keySet()) {
            int numberOfSlide = 0;
            for (long degree : degrees) {
                if (degree != targetDegree) {
                    numberOfSlide += degree % targetDegree == 0 ? degree / targetDegree - 1 : degree / targetDegree;
                }
                if (numberOfSlide >= D - sequenceOfDegree.get(targetDegree)) {
                    break;
                }
            }
            if (numberOfSlide != 0) {
                minCut = Math.min(minCut, numberOfSlide);
            }
        }
        
        return (minCut == Integer.MAX_VALUE ? D - 1 : minCut) + "";
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
