import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] array;
    private static int arraySize;
    private static FastReader sc;
    private static int samePairIndex, diffPairIndex;

    public static void main(String[] args) throws Exception {
        sc = new FastReader();
        int testCases = sc.nextInt();
        arraySize = sc.nextInt();
        array = new int[arraySize];

        for (int t = 1; t <= testCases; t++) {
            samePairIndex = -1;
            diffPairIndex = -1;
            int pairsProcessed = 0;

            for (; pairsProcessed < 5; pairsProcessed++) {
                processPair(pairsProcessed);
            }

            checkChanges();
            while (pairsProcessed < arraySize / 2) {
                int iterations = 0;
                for (; iterations < 4 && pairsProcessed < arraySize / 2; iterations++) {
                    processPair(pairsProcessed);
                    pairsProcessed++;
                }
                if (iterations == 4) {
                    checkChanges();
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i : array) {
                result.append(i);
            }
            System.out.println(result);
            if (sc.next().equals("N")) {
                return;
            }
        }
        sc.close();
    }

    private static int query(int index) {
        System.out.println(index + 1);
        return sc.nextInt();
    }

    private static void processPair(int index) {
        array[index] = query(index);
        array[arraySize - index - 1] = query(arraySize - index - 1);

        if (samePairIndex == -1 && array[index] == array[arraySize - index - 1]) {
            samePairIndex = index;
        }
        if (diffPairIndex == -1 && array[index] != array[arraySize - index - 1]) {
            diffPairIndex = index;
        }
    }

    private static void checkChanges() {
        boolean complement = false;
        if (samePairIndex != -1 && array[samePairIndex] != query(samePairIndex)) {
            complement = true;
        }

        boolean reverse = false;
        if (diffPairIndex != -1 && array[diffPairIndex] != query(diffPairIndex)) {
            if (!complement) {
                reverse = true;
            }
        }

        if (complement) {
            for (int i = 0; i < arraySize; i++) {
                array[i] = array[i] == 0 ? 1 : 0;
            }
        }

        if (reverse) {
            for (int i = 0; i < arraySize / 2; i++) {
                int temp = array[i];
                array[i] = array[arraySize - i - 1];
                array[arraySize - i - 1] = temp;
            }
        }
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() throws Exception {
            br.close();
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}