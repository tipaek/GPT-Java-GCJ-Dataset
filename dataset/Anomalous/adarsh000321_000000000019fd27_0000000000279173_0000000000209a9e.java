import java.io.*;
import java.util.*;

public class Solution {
    private static int[] array;
    private static int length;
    private static FastReader reader;
    private static int sameIndex = -1, diffIndex = -1;

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
            checkChanges();
            while (count < length / 2) {
                int i = 0;
                for (; i < 4 && count < length / 2; i++) {
                    count++;
                    findPair(count);
                }
                if (i == 4) {
                    checkChanges();
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) {
                result.append(array[i]);
            }
            System.out.println(result);
            System.out.flush();
            if (reader.next().equals("N")) {
                return;
            }
        }
        reader.close();
    }

    private static int query(int index) {
        System.out.println(index + 1);
        System.out.flush();
        return reader.nextInt();
    }

    private static void findPair(int index) {
        array[index] = query(index);
        array[length - index - 1] = query(length - index - 1);
        if (sameIndex == -1 && array[index] == array[length - index - 1]) {
            sameIndex = index;
        }
        if (diffIndex == -1 && array[index] != array[length - index - 1]) {
            diffIndex = index;
        }
    }

    private static void checkChanges() {
        boolean complement = false;
        if (sameIndex != -1 && array[sameIndex] != query(sameIndex)) {
            complement = true;
        }
        boolean reverse = false;
        if (diffIndex != -1 && array[diffIndex] != query(diffIndex)) {
            if (!complement) {
                reverse = true;
            }
        }
        if (complement) {
            for (int i = 0; i < length / 2; i++) {
                array[i] = 1 - array[i];
                array[length - i - 1] = 1 - array[length - i - 1];
            }
        }
        if (reverse) {
            for (int i = 0; i < length / 2; i++) {
                int temp = array[i];
                array[i] = array[length - i - 1];
                array[length - i - 1] = temp;
            }
        }
    }

    private static class FastReader {
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