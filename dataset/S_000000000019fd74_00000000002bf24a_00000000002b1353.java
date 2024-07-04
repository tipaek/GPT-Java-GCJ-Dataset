
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class Solution {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = Integer.parseInt(scan.nextLine());

        int[][] p = new int[21][21];
        for (int i = 0; i <= 20; i++) {
            p[i][0] = 1;
        }
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j <= i; j++) {
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
            }
        }

        for (int i = 1; i <= cases; i++) {
            solve(i, scan, p);
        }
    }

    public static void solve(int caseNum, Scanner scan, int[][] p) {
        System.out.println("Case #" + caseNum + ":");
        helper(scan.nextInt(), p);

    }

    static void helper(int w, int[][] p) {
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 1;
        int r = 1;
        int k = 1;
        list.addLast(r * 100 + k);
        while (sum < w / 2) {
            int left = p[r - 1 + 1][k - 1];
            int right = p[r - 1 + 1][k - 1 + 1];
            if (left <= right) {
                k++;
            }
            sum += p[r - 1 + 1][k - 1];
            r++;

            list.addLast(r * 100 + k);
        }

        while (sum < w && p[r - 1][k - 1 + 1] != 0) {
            int right = p[r - 1][k - 1 + 1];
            int up = p[r - 2][k - 1];

            if (sum + right <= w) {
                    sum += right;
                    k++;
            } else if (sum + up <= w) {
                    sum += up;
                    r--;
            }
            list.addLast(r * 100 + k);
        }

        while (sum != w) {
            sum++;
            r++;
            k++;
            list.addLast(r * 100 + k);
        }


        while (!list.isEmpty()) {
            int i = list.removeFirst();
            System.out.println((i / 100) + " " + (i % 100));
        }
    }
}