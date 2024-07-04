import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int[] solve(int[] a, int[] z, int[] newA) {
        boolean isEqualA = true, isEqualADash = true, isEqualB = true, isEqualBDash = true;
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] != newA[i]) isEqualA = false;
            if (1 - a[i] != newA[i]) isEqualADash = false;
            if (z[i] != newA[4 - i]) isEqualB = false;
            if (1 - z[i] != newA[4 - i]) isEqualBDash = false;
        }
        
        int[] res = new int[10];
        
        if (isEqualA) {
            System.arraycopy(a, 0, res, 0, a.length);
            System.arraycopy(z, 0, res, 5, z.length);
        } else if (isEqualADash) {
            for (int i = 0; i < a.length; i++) res[i] = 1 - a[i];
            for (int i = 0; i < z.length; i++) res[i + 5] = 1 - z[i];
        } else if (isEqualB) {
            for (int i = 0; i < a.length; i++) res[i] = z[4 - i];
            for (int i = 0; i < z.length; i++) res[i + 5] = a[4 - i];
        } else {
            for (int i = 0; i < a.length; i++) res[i] = 1 - z[4 - i];
            for (int i = 0; i < z.length; i++) res[i + 5] = 1 - a[4 - i];
        }
        
        return res;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int T = reader.nextInt();
        int b = reader.nextInt();

        while (T-- > 0) {
            if (b == 10) {
                int[] arr = new int[10];
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(i + 1);
                    arr[i] = reader.nextInt();
                }
                for (int value : arr) {
                    System.out.print(value);
                }
                System.out.println();
            } else if (b == 20) {
                int[] a = readArray(reader, 5, 1);
                int[] z = readArray(reader, 5, 16);
                int[] c = readArray(reader, 5, 6);
                int[] y = readArray(reader, 5, 11);
                int[] newA = readArray(reader, 5, 1);
                int[] newC = readArray(reader, 5, 6);

                int[] first = solve(a, z, newA);
                int[] second = solve(c, y, newC);

                printArray(first, 0, 5);
                printArray(second, 0, second.length);
                printArray(first, 5, first.length);
                System.out.println();
            }

            String ret = reader.next();
            if (ret.startsWith("N")) return;
        }
    }

    private static int[] readArray(InputReader reader, int length, int startIndex) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println(startIndex + i);
            array[i] = reader.nextInt();
        }
        return array;
    }

    private static void printArray(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(array[i]);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}