import java.io.*;
import java.util.*;

public class Solution {
    static int[] array;
    static int length;
    static FastReader scanner;
    static int sameIndex, diffIndex;

    public static void main(String[] args) throws Exception {
        scanner = new FastReader();
        int testCases = scanner.nextInt();
        length = scanner.nextInt();
        array = new int[length];

        for (int t = 1; t <= testCases; t++) {
            int count = 0;
            sameIndex = -1;
            diffIndex = -1;

            for (; count < 5; count++) {
                processPair(count);
            }

            detectChanges();

            while (count < length / 2) {
                int i = 0;
                for (; i < 4 && count < length / 2; i++) {
                    processPair(count);
                    count++;
                }
                if (i == 4) {
                    detectChanges();
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) {
                result.append(array[i]);
            }
            System.out.println(result);
            System.out.flush();

            String response = scanner.next();
            if (response.equals("N")) {
                return;
            }
        }
        scanner.close();
    }

    static int query(int index) {
        System.out.println(index + 1);
        System.out.flush();
        int response = scanner.nextInt();
        System.out.flush();
        return response;
    }

    static void processPair(int index) {
        array[index] = query(index);
        array[length - index - 1] = query(length - index - 1);

        if (sameIndex == -1 && array[index] == array[length - index - 1]) {
            sameIndex = index;
        }
        if (diffIndex == -1 && array[index] != array[length - index - 1]) {
            diffIndex = index;
        }
    }

    static void detectChanges() {
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
            for (int i = 0; i < length; i++) {
                array[i] = array[i] == 0 ? 1 : 0;
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