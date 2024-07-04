import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {

    private boolean sameFlag = true;
    private boolean diffFlag = true;
    private Integer c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            new Solution().solve(scanner, b);
        }
    }

    private void solve(Scanner scanner, int b) {
        int[] arr = new int[b];
        List<Integer>[] same = new ArrayList[2];
        List<Integer>[] diff = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            same[i] = new ArrayList<>();
            diff[i] = new ArrayList<>();
        }
        int index = 0;
        c = 0;
        while (index < b / 2) {
            c = 0;
            sameFlag = determineFlag(scanner, same);
            diffFlag = determineFlag(scanner, diff);
            while (c + 2 <= 10) {
                System.out.println(index + 1);
                int val1 = scanner.nextInt();
                System.out.println(b - index);
                int val2 = scanner.nextInt();
                if (val1 == val2) {
                    int nval = sameFlag ? val1 : 1 - val2;
                    same[nval].add(index + 1);
                    arr[index] = arr[b - 1 - index] = nval;
                } else {
                    int nval = diffFlag ? val1 : val2;
                    diff[nval].add(index + 1);
                    arr[index] = nval;
                    arr[b - 1 - index] = 1 - nval;
                }
                index = min(index + 1, b / 2);
                c += 2;
            }
            if (c < 10) {
                System.out.println(1);
                scanner.nextInt();
            }
        }
        sameFlag = determineFlag(scanner, same);
        diffFlag = determineFlag(scanner, diff);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b / 2; i++) {
            if (arr[i] == arr[b - 1 - i]) {
                arr[i] = sameFlag ? arr[i] : 1 - arr[i];
                arr[b - 1 - i] = arr[i];
            } else {
                arr[i] = diffFlag ? arr[i] : 1 - arr[i];
                arr[b - 1 - i] = 1 - arr[i];
            }
        }
        for (int i = 0; i < b; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        scanner.next();
    }

    private boolean getFlag(Scanner scanner, int idx, int val) {
        System.out.println(idx);
        int val1 = scanner.nextInt();
        return val1 == val;
    }

    private boolean determineFlag(Scanner scanner, List<Integer>[] list) {
        if (list[0].isEmpty() && list[1].isEmpty()) {
            return true;
        }
        c += 1;
        if (!list[0].isEmpty()) {
            return getFlag(scanner, list[0].get(0), 0);
        }
        return getFlag(scanner, list[1].get(0), 1);
    }
}