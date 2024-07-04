import java.util.Scanner;

public class Solution {
    public static boolean getPos(Scanner input, int pos) {
        System.out.println("" + pos);
        String s = input.next();
        return s.charAt(0) == '1';
    }
    public static void solve(Scanner input, int b) {
        int pairs = 0;
        boolean left = true;
        int count = 1;
        boolean[] cur = new boolean[b];
        boolean res;
        int pair1 = -1;
        int pair2 = -1;
        boolean odd = (b % 2) == 1;
        while (true) {
            if (count % 10 == 1 && count != 1) {
                boolean pair1Ch = false;
                boolean pair2Ch = false;
                if (pair1 != -1) {
                    res = getPos(input, pair1 + 1);
                    ++count;
                    if (res != cur[pair1])
                        pair1Ch = true;
                }
                if (pair2 != -1) {
                    res = getPos(input, pair2 + 1);
                    ++count;
                    if (res != cur[pair2]) {
                        pair2Ch = true;
                    }
                }
                for (int i = 0; i < pairs; ++i) {
                    if (cur[i] == cur[b - i - 1] && pair1Ch) {
                        cur[i] = !cur[i];
                        cur[b - i - 1] = cur[i];
                    }
                    if (cur[i] != cur[b - i - 1] && pair2Ch) {
                        cur[i] = !cur[i];
                        cur[b - i - 1] = !cur[i];
                    }
                }
            } else {
                if (left) {
                    cur[pairs] = getPos(input, pairs + 1);
                    if (odd && pairs == b / 2) {
                        break;
                    }
                } else {
                    cur[b - pairs - 1] = getPos(input, b - pairs);
                    if (pair1 == -1) {
                        if (cur[pairs] == cur[b - pairs - 1])
                            pair1 = pairs;
                    }
                    if (pair2 == -1) {
                        if (cur[pairs] != cur[b - pairs - 1])
                            pair2 = pairs;
                    }
                    ++pairs;
                    if (!odd && pairs == b / 2)
                        break;
                }
                left = !left;
                ++count;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; ++i)
            sb.append(cur[i] ? '1' : '0');
        System.out.println(sb.toString());
        String s = input.next();
        if (s.charAt(0) != 'Y') {
            throw new Error("Wrong guess!");
        }

    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int b = input.nextInt();
        input.nextLine();
        for (int ks = 1; ks <= t; ks++) {
            solve(input, b);
        }
    }
}