import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {

    boolean sameFlag = true, diffFlag = true;
    Integer c;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 0; i < t; ++i) {
            new Solution().solve(in, b);
        }
    }

    private void solve(Scanner in, int b) {
        int arr[] = new int[b];
        List<Integer> same[] = new ArrayList[2], diff[] = new ArrayList[2];
        for (int i = 0; i < 2; ++i) {
            same[i] = new ArrayList<>();
            diff[i] = new ArrayList<>();
        }
        int ind = 0;
        c = 0;
        while (ind < b / 2) {
            c = 0;
            sameFlag = determineFlag(in, same);
            diffFlag = determineFlag(in, diff);
            while (c + 2 <= 10) {
                System.out.println(ind + 1);
                int val1 = in.nextInt();
                System.out.println(b - ind);
                int val2 = in.nextInt();
                if (val1 == val2) {
                    int nval = sameFlag ? val1 : 1 - val2;
                    same[nval].add(ind + 1);
                    arr[ind] = arr[b - 1 - ind] = nval;
                } else {
                    int nval = diffFlag ? val1 : val2;
                    diff[nval].add(ind + 1);
                    arr[ind] = nval;
                    arr[b - 1 - ind] = 1 - nval;
                }
                ind = min(ind + 1, b/2);
                c += 2;
            }
            if (c < 10) {
                System.out.println(1);
                in.nextInt();
            }
        }
        sameFlag = determineFlag(in, same);
        diffFlag = determineFlag(in, diff);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < b / 2; ++i) {
            if (arr[i] == arr[b - 1 - i]) {
                arr[i] = sameFlag ? arr[i] : 1 - arr[i];
                arr[b - 1 - i] = arr[i];
            } else {
                arr[i] = diffFlag ? arr[i] : 1 - arr[i];
                arr[b - 1 - i] = 1 - arr[i];
            }
        }
        for (int i = 0; i < b; ++i) {
            System.out.print(arr[i]);
        }
        System.out.println();
        in.next();
    }

    private boolean getFlag(Scanner in, int idx, int val) {
        System.out.println(idx);
        int val1 = in.nextInt();
        return val1 == val;
    }

    private boolean determineFlag(Scanner in, List<Integer>[] l) {
        if (l[0].isEmpty() && l[1].isEmpty()) {
            return true;
        }
        c += 1;
        if (!l[0].isEmpty()) {
            return getFlag(in, l[0].get(0), 0);
        }
        return getFlag(in, l[1].get(0), 1);
    }

}
