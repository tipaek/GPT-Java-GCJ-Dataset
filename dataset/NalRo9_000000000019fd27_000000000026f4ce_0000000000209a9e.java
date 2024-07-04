import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int b;
    private static int idx;
    private static int sameIdx;
    private static int sameVal;
    private static int diffIdx;
    private static int diffVal;
    private static List<Integer> left;
    private static List<Integer> right;

    public static void complementList() {
        List<Integer> newLeft = new ArrayList<>();
        for (int val : left) {
            newLeft.add(val ^ 1);
        }
        left = newLeft;

        List<Integer> newRight = new ArrayList<>();
        for (int val : right) {
            newRight.add(val ^ 1);
        }
        right = newRight;
    }

    public static void reverseList() {
        List<Integer> t = left;
        left = right;
        right = t;
    }

    public static void findChange() {
        if (idx == 0)
            return;

        if (sameIdx == -1 || diffIdx == -1) {
            System.out.println(1);
            System.out.flush();
            scanner.nextInt();
            System.out.println(1);
            System.out.flush();
            int result = scanner.nextInt();

            if (left.get(0) != result) {
                complementList();
            }
        } else {
            System.out.println(sameIdx + 1);
            System.out.flush();
            int newSameVal = scanner.nextInt();
            System.out.println(diffIdx + 1);
            System.out.flush();
            int newDiffVal = scanner.nextInt();

            if (sameVal != newSameVal && diffVal != newDiffVal) {
                complementList();
            } else if (sameVal == newSameVal && diffVal != newDiffVal) {
                reverseList();
            } else if (sameVal != newSameVal) {
                complementList();
                reverseList();
            }

            sameVal = newSameVal;
            diffVal = newDiffVal;
        }
    }

    public static void searchLeftRight() {
        if (idx == 0) {
            for (int i = 0; i < 5; i++, idx++) {
                System.out.println(idx + 1);
                System.out.flush();
                left.add(scanner.nextInt());
                System.out.println(b - idx);
                System.out.flush();
                right.add(scanner.nextInt());
            }
        } else {
            for (int i = 0; i < 4; i++, idx++) {
                System.out.println(idx + 1);
                System.out.flush();
                left.add(scanner.nextInt());
                System.out.println(b - idx);
                System.out.flush();
                right.add(scanner.nextInt());
            }
        }
    }


    public static void findSameDiffIdx() {
        for (int i = 0; i < idx; i++) {
            if (sameIdx == -1 && left.get(i).equals(right.get(i))) {
                sameIdx = i;
                sameVal = left.get(i);
            }
            if (diffIdx == -1 && !left.get(i).equals(right.get(i))) {
                diffIdx = i;
                diffVal = left.get(i);
            }
        }
    }

    public static void solve() {
        idx = 0;
        sameIdx = -1;
        diffIdx = -1;
        left.clear();
        right.clear();

        while (idx * 2 < b) {
            if (sameIdx == -1 || diffIdx == -1) {
                sameIdx = -1;
                diffIdx = -1;
            }

            findChange();
            searchLeftRight();

            if (sameIdx == -1 || diffIdx == -1) {
                findSameDiffIdx();
            }
        }

        for (int i = 0; i < b / 2; i++) {
            System.out.print(left.get(i));
        }

        for (int i = 0; i < b / 2; i++) {
            System.out.print(right.get(b / 2 - i - 1));
        }

        System.out.println();
        System.out.flush();

        String answer = scanner.next();
        if (!"Y".equals(answer)) {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        left = new ArrayList<>();
        right = new ArrayList<>();
        int tc = scanner.nextInt();
        b = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            solve();
        }
    }
}
