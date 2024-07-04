import java.io.*;
import java.util.*;

public class Solution {
    static int[] array;
    static int length;
    static FastReader reader;
    static int sameIndex = -1, diffIndex = -1;

    public static void main(String[] args) throws Exception {
        reader = new FastReader();
        int testCases = reader.nextInt();
        length = reader.nextInt();
        array = new int[length];

        for (int test = 1; test <= testCases; test++) {
            int count = 0;
            for (; count < 5; count++) {
                findPair(count);
            }
            detectChange();
            while (count < length / 2) {
                int iterations = 0;
                for (; iterations < 4 && count < length / 2; iterations++) {
                    count++;
                    findPair(count);
                }
                if (iterations == 4) {
                    detectChange();
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) result.append(array[i]);
            System.out.println(result);
            System.out.flush();
            String response = reader.next();
            if (response.equals("N")) {
                return;
            }
        }
    }

    static int query(int index) {
        System.out.println(index + 1);
        System.out.flush();
        return reader.nextInt();
    }

    static void findPair(int index) {
        array[index] = query(index);
        array[length - index - 1] = query(length - index - 1);
        if (sameIndex == -1 && array[index] == array[length - index - 1]) {
            sameIndex = index;
        }
        if (diffIndex == -1 && array[index] != array[length - index - 1]) {
            diffIndex = index;
        }
    }

    static void detectChange() {
        boolean isComplemented = false;
        if (sameIndex != -1 && array[sameIndex] != query(sameIndex)) {
            isComplemented = true;
        }
        boolean isReversed = false;
        if (diffIndex != -1 && array[diffIndex] != query(diffIndex)) {
            if (!isComplemented) isReversed = true;
        }
        if (isComplemented) {
            for (int i = 0; i < length / 2; i++) {
                array[i] = array[i] == 0 ? 1 : 0;
            }
        }
        if (isReversed) {
            for (int i = 0; i < length / 2; i++) {
                int temp = array[i];
                array[i] = array[length - i - 1];
                array[length - i - 1] = temp;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() throws Exception {
            br.close();
        }

        String next() {
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
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
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