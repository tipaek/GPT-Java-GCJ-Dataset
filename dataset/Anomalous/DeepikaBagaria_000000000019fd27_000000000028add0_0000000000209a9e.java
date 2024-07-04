import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int n = input.nextInt();

        for (int tt = 0; tt < t; tt++) {
            int[] b = new int[n];
            if (n == 10) {
                handleTenCase(input, b);
            } else if (n == 20) {
                handleTwentyCase(input, b);
            }
            StringBuilder sb = new StringBuilder();
            for (int i : b) {
                sb.append(i);
            }
            System.out.println(sb.toString());
            if (input.next().equals("N")) {
                break;
            }
        }
        input.close();
    }

    private static void handleTenCase(Scanner input, int[] b) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            b[i] = input.nextInt();
        }
    }

    private static void handleTwentyCase(Scanner input, int[] b) {
        int samePos = -1, diffPos = -1;
        int[] same = new int[2], diff = new int[2];

        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1);
            b[i] = input.nextInt();
        }
        for (int i = 15; i < 20; i++) {
            System.out.println(i + 1);
            b[i] = input.nextInt();
            if (samePos == -1 && b[i] == b[19 - i]) {
                samePos = i;
                same[0] = b[i];
            }
            if (diffPos == -1 && b[i] != b[19 - i]) {
                diffPos = i;
                diff[0] = b[i];
            }
        }

        if (samePos != -1 && diffPos != -1) {
            processRemainingBits(input, b, samePos, diffPos, same, diff);
        } else {
            handleRemainingBits(input, b, same, diff);
        }
    }

    private static void processRemainingBits(Scanner input, int[] b, int samePos, int diffPos, int[] same, int[] diff) {
        int[] newsame = new int[2], newdiff = new int[2];
        compute(input, newsame, newdiff, b, samePos, diffPos, same, diff);

        for (int i = 5; i < 13; i++) {
            System.out.println(i + 1);
            b[i] = input.nextInt();
        }
        compute(input, newsame, newdiff, b, samePos, diffPos, same, diff);
        for (int i = 13; i < 17; i++) {
            System.out.println(i + 1);
            b[i] = input.nextInt();
        }
    }

    private static void handleRemainingBits(Scanner input, int[] b, int[] same, int[] diff) {
        int samePos = -1, diffPos = -1;
        
        for (int i = 5; i < 10; i++) {
            System.out.println(i + 1);
            b[i] = input.nextInt();
        }
        for (int i = 10; i < 15; i++) {
            System.out.println(i + 1);
            b[i] = input.nextInt();
            if (samePos == -1 && b[i] == b[19 - i]) {
                samePos = i;
                same[0] = b[i];
            }
            if (diffPos == -1 && b[i] != b[19 - i]) {
                diffPos = i;
                diff[0] = b[i];
            }
        }

        if (samePos != -1 && diffPos != -1) {
            processRemainingBits(input, b, samePos, diffPos, same, diff);
        }
    }

    private static void compute(Scanner input, int[] newsame, int[] newdiff, int[] b, int samePos, int diffPos, int[] same, int[] diff) {
        System.out.println(samePos + 1);
        newsame[0] = input.nextInt();
        System.out.println(diffPos + 1);
        newdiff[0] = input.nextInt();

        if (compare(newsame, same) != compare(newdiff, diff)) {
            if (compare(newsame, same) == 1) {
                b = reverse(b);
            }
            b = compliment(b);
        } else if (compare(newsame, same) == 1) {
            b = reverse(b);
        }

        b[samePos] = newsame[0];
        b[diffPos] = newdiff[0];
        same[0] = newsame[0];
        diff[0] = newdiff[0];
    }

    private static int compare(int[] newsame, int[] same) {
        return newsame[0] == same[0] ? 0 : 1;
    }

    public static int[] reverse(int[] a) {
        Collections.reverse(Arrays.asList(a));
        return a;
    }

    public static int[] compliment(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 1 - a[i];
        }
        return a;
    }
}