import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = in.nextInt();
        int b = in.nextInt();
        
        for (int tc = 1; tc <= t; tc++) {
            int[] arr = new int[b];
            int found = 0;
            int done = 0;
            
            while (found < b) {
                if (done % 10 == 0 && done != 0) {
                    handleSpecialCases(in, arr, b, found);
                    done += 2;
                }
                
                arr[found / 2] = query(in, found / 2 + 1);
                arr[b - 1 - found / 2] = query(in, b - found / 2);
                
                found += 2;
                done += 2;
            }
            
            StringBuilder result = new StringBuilder();
            for (int bit : arr) {
                result.append(bit);
            }
            
            System.out.println(result);
            System.out.flush();
            
            if (in.next().equals("N")) {
                return;
            }
        }
    }
    
    private static void handleSpecialCases(FastReader in, int[] arr, int b, int found) throws IOException {
        int eqIndex = findEqualIndex(arr, b, found);
        if (eqIndex != -1) {
            if (query(in, eqIndex + 1) != arr[eqIndex]) {
                invertArray(arr, found);
            }
        } else {
            query(in, 1); // just to maintain parity
        }
        
        int diffIndex = findDifferentIndex(arr, b, found);
        if (diffIndex != -1) {
            if (query(in, diffIndex + 1) != arr[diffIndex]) {
                reverseArray(arr, b, found);
            }
        } else {
            query(in, 1); // just to maintain parity
        }
    }
    
    private static int query(FastReader in, int index) throws IOException {
        System.out.println(index);
        System.out.flush();
        return in.nextInt();
    }
    
    private static int findEqualIndex(int[] arr, int b, int found) {
        for (int i = 0; i < found / 2; i++) {
            if (arr[i] == arr[b - 1 - i]) {
                return i;
            }
        }
        return -1;
    }
    
    private static int findDifferentIndex(int[] arr, int b, int found) {
        for (int i = 0; i < found / 2; i++) {
            if (arr[i] != arr[b - 1 - i]) {
                return i;
            }
        }
        return -1;
    }
    
    private static void invertArray(int[] arr, int found) {
        for (int i = 0; i < found / 2; i++) {
            arr[i] ^= 1;
            arr[arr.length - 1 - i] ^= 1;
        }
    }
    
    private static void reverseArray(int[] arr, int b, int found) {
        for (int i = 0; i < found / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[b - 1 - i];
            arr[b - 1 - i] = temp;
        }
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
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