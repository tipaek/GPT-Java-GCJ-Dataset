import java.util.*;
import java.io.*;


class CODEJ {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int w = 1; w <= t; w++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean possible = false;
            int index = 0;
            for (int i = 1; i <= n; i++) {
                if (k % i == 0 && k / i == n) {
                    possible = true;
                    index = i;
                    break;
                }
            }
            if (!possible) {
                if (k % ((n * (n + 1)) / 2) == 0) {
                    possible = true;
                    index = n + 1;
                }
            }
            System.out.print("Case #" + w + ": ");
            if (!possible && n == 2 && k == 3) {
                System.out.println("IMPOSSIBLE");
            } else {
                int a[] = new int[n];
                for (int i = 1; i <= n; i++) {
                    a[i - 1] = i;
                }
                System.out.println("POSSIBLE");
                if (index == n + 1) {
                    System.out.println("index = "+index);
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(a[(i+j)%n]+" ");
                        }
                        System.out.println();
                    }
                } else {
                    
                    System.out.println("index = "+index);
                    
                    int count = 0;
                    while (count < n) {
                        for (int i = 0; i < n; i++) {
                            int rem = (i + index) % n;
                            if (rem != 0)
                                System.out.print(a[rem-1]+" ");
                            else
                                System.out.print(a[n-1]+" ");
                            if (i == n - 1) {
                                index = a[(i + index) % n]-1;
                            }
                        }
                        System.out.println();
                        count++;
                    }

                }
            }
        }
    }
}