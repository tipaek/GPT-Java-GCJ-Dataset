import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            int[][] arr = new int[26][10];
            for (int[] row : arr) {
                Arrays.fill(row, 0);
            }

            for (int j = 1; j <= 10000; j++) {
                long m = in.nextLong();
                String s = in.next();
                Set<Integer> charIndices = new HashSet<>();
                Set<Character> uniqueChars = new HashSet<>();

                if (s.length() != u) {
                    continue;
                }

                int y = u - 1;
                long x = m;
                while (x > 0) {
                    int rem = (int) (x % 10);
                    char c = s.charAt(y);
                    int n = c - 'A';
                    charIndices.add(n);
                    uniqueChars.add(c);
                    arr[n][rem]++;
                    x /= 10;
                    y--;
                }

                Iterator<Integer> charIndexIterator = charIndices.iterator();
                Iterator<Character> uniqueCharIterator = uniqueChars.iterator();
                char[] b = new char[10];

                while (charIndexIterator.hasNext()) {
                    int f = charIndexIterator.next();
                    int max = 0, index = 0;

                    for (int g = 0; g < 10; g++) {
                        if (arr[f][g] > max) {
                            max = arr[f][g];
                            index = g;
                        }
                    }
                    if (uniqueCharIterator.hasNext()) {
                        b[index] = uniqueCharIterator.next();
                    }
                }

                System.out.print("Case #" + i + ": ");
                for (char c : b) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}