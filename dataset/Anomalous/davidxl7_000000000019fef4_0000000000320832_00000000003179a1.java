import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int U = scanner.nextInt();
        Set<Character>[] impossible = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            impossible[i] = new HashSet<>();
        }
        Set<Character> allChars = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            long M = scanner.nextLong();
            if (M == -1) {
                M = (long) Math.pow(10, U) - 1;
            }
            String R = scanner.next();
            long min = (long) Math.pow(10, R.length() - 1);
            long max = Math.min(M, (long) Math.pow(10, R.length()) - 1);

            for (int j = R.length() - 1; j >= 0; j--) {
                for (int k = 0; k < min % 10; k++) {
                    impossible[k].add(R.charAt(j));
                }
                if (max < 10) {
                    for (int k = (int) (max % 10) + 1; k < 10; k++) {
                        impossible[k].add(R.charAt(j));
                    }
                }
                allChars.add(R.charAt(j));
                min /= 10;
                max /= 10;
            }
        }

        Set<Character>[] possible = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            possible[i] = new HashSet<>();
        }

        for (int i = 0; i < 10; i++) {
            Set<Character> temp = new HashSet<>(allChars);
            temp.removeAll(impossible[i]);
            possible[i].addAll(temp);
        }

        int remaining = 10;
        char[] result = new char[10];
        while (remaining > 0) {
            for (int i = 0; i < 10; i++) {
                if (possible[i].size() == 1) {
                    remaining--;
                    char uniqueChar = possible[i].iterator().next();
                    result[i] = uniqueChar;
                    for (int j = 0; j < 10; j++) {
                        possible[j].remove(uniqueChar);
                    }
                }
            }
        }

        for (char c : result) {
            System.out.print(c);
        }
    }
}