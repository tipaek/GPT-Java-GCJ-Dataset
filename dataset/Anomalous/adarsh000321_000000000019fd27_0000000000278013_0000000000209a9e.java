import java.io.*;
import java.util.*;

public class Solution {
    static int[] array;
    static int size;
    static FastReader reader;
    static int sameIndex = -1, diffIndex = -1;

    public static void main(String[] args) throws Exception {
        reader = new FastReader();
        int testCases = reader.nextInt();
        size = reader.nextInt();
        array = new int[size];

        for (int test = 1; test <= testCases; test++) {
            int count = 0;
            for (; count < 5; count++) {
                findPair(count);
            }
            detectChanges();
            
            while (count < size / 2) {
                int i = 0;
                for (; i < 4 && count < size / 2; i++) {
                    count++;
                    findPair(count);
                }
                if (i == 4) {
                    detectChanges();
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < size; i++) {
                result.append(array[i]);
            }
            System.out.println(result);
            System.out.flush();

            String response = reader.next();
            if (response.equals("N")) {
                return;
            }
            reader.close();
        }
    }

    static int query(int index) {
        System.out.println(index + 1);
        System.out.flush();
        return reader.nextInt();
    }

    static void findPair(int index) {
        array[index] = query(index);
        array[size - index - 1] = query(size - index - 1);

        if (sameIndex == -1 && array[index] == array[size - index - 1]) {
            sameIndex = index;
        }
        if (diffIndex == -1 && array[index] != array[size - index - 1]) {
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
            for (int i = 0; i < size / 2; i++) {
                array[i] = array[i] == 0 ? 1 : 0;
            }
        }

        if (reverse) {
            for (int i = 0; i < size / 2; i++) {
                int temp = array[i];
                array[i] = array[size - i - 1];
                array[size - i - 1] = temp;
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