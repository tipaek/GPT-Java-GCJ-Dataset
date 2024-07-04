import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static int L = 17;

    public static void main(String[] args) {
        String[] left = new String[1000000];
        solve(1, left, new StringBuilder(), 1);
        for (int i = 100; i < 100000; i++)
            if (left[i] == null)
                throw new RuntimeException(i + "");

        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {

            int target = input.nextInt();
            System.out.printf("Case #%d:\n", caseNum);

            if (target < 100) {
                for (int i = 0; i < target; i++)
                    System.out.printf("%d %d\n", i + 1, 1);
                continue;
            }

            found = null;
            solve2(L, left, new StringBuilder(), 0, target);

//            System.out.println(found);
            boolean l = true;
            System.out.printf("%d %d\n", 1, 1);
//            int check = 1;
            for (int i = 0; i < found.length(); i++) {
                int index = i + 1;
                char c = found.charAt(i);
                if (c == '1') {
                    if (l) {
                        System.out.printf("%d %d\n", index + 1, 1);
//                        check += nCr(index, 0);
                    } else {
                        System.out.printf("%d %d\n", index + 1, index + 1);
//                        check += nCr(index, index);
                    }
                } else if (c == '2') {
                    if (l) {
                        System.out.printf("%d %d\n", index + 1, 2);
                        System.out.printf("%d %d\n", index + 1, 1);
//                        check += nCr(index, 1);
//                        check += nCr(index, 0);
                    } else {
                        System.out.printf("%d %d\n", index + 1, index);
                        System.out.printf("%d %d\n", index + 1, index + 1);
//                        check += nCr(index, index - 1);
//                        check += nCr(index, index);
                    }
                } else if (c == '3') {
                    if (l) {
                        for (int j = 0; j <= index; j++) {
                            System.out.printf("%d %d\n", index + 1, j + 1);
//                            check += nCr(index, j);
                        }
                    } else {
                        for (int j = index; j >= 0; j--) {
                            System.out.printf("%d %d\n", index + 1, j + 1);
//                            check += nCr(index, j);
                        }
                    }
                    l = !l;
                }
            }
//            System.out.println(check); // MFD
        }
    }

    static String found;

    static void solve2(int index, String[] left, StringBuilder current, int sum, int target) {
        if (found != null)
            return;
        if (sum > target)
            return;
        if (target - sum < left.length && left[target - sum] != null) {
            found = left[target - sum] + current.toString();
            return;
        }
        if (index == 30)
            return;
        current.append('1');
        solve2(index + 1, left, current, sum + 1, target);
        current.deleteCharAt(current.length() - 1);
        current.append('2');
        solve2(index + 1, left, current, sum + index + 1, target);
        current.deleteCharAt(current.length() - 1);
        current.append('3');
        solve2(index + 1, left, current, sum + (1 << index), target);
        current.deleteCharAt(current.length() - 1);
    }

    static void solve(int index, String[] left, StringBuilder current, int sum) {
        if (index == L) {
            if (left[sum] == null) {
                left[sum] = current.toString();
            }
            return;
        }
        current.append('1');
        solve(index + 1, left, current, sum + 1);
        current.deleteCharAt(current.length() - 1);
        current.append('2');
        solve(index + 1, left, current, sum + index + 1);
        current.deleteCharAt(current.length() - 1);
        current.append('3');
        solve(index + 1, left, current, sum + (1 << index));
        current.deleteCharAt(current.length() - 1);
    }

    public static long nCr(long a, int b) {
        if (b < 0 || a < b)
            return 0;
        long nCr = 1;
        for (int i = 0; i < b; i++) {
            nCr *= a - i;
            nCr /= i + 1;
        }
        return nCr;
    }
}
