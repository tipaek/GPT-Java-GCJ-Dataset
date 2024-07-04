import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            int[][] arr = new int[26][10];
            for (int[] row : arr) {
                Arrays.fill(row, 0);
            }
            for (int j = 1; j <= 10000; j++) {
                long m = in.nextLong();
                String s = in.next();
                Set<Integer> h = new HashSet<>();
                Set<Character> h1 = new HashSet<>();
                int l = s.length();
                if (l != u) {
                    continue;
                } else {
                    int y = u - 1;
                    long x = m;
                    while (x > 0) {
                        int rem = (int) (x % 10);
                        char c = s.charAt(y);
                        int n = c - 'A';
                        h.add(n);
                        h1.add(c);
                        arr[n][rem]++;
                        x = x / 10;
                        y--;
                    }

                    Iterator<Integer> k = h.iterator();
                    Iterator<Character> k1 = h1.iterator();
                    char[] b = new char[10];
                    while (k.hasNext()) {
                        int f = k.next();
                        int max = 0, index = 0;
                        for (int g = 0; g < 10; g++) {
                            if (arr[f][g] > max) {
                                max = arr[f][g];
                                index = g;
                            }
                        }
                        b[index] = k1.next();
                    }
                    System.out.print("Case #" + i + ": ");
                    for (int q = 0; q < 10; q++) {
                        System.out.print(b[q]);
                    }
                    System.out.println();
                }
            }
        }
    }
}