import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] s = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    s[j][k] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + foo(r, c, s));
        }
    }

    private static int foo(int r, int c, final int[][] s) {
        int inter = 0;
        int totalSum = 0;
        ArrayList<ArrayList<LinkedList<Integer>>> up = new ArrayList<>(r);
        ArrayList<ArrayList<LinkedList<Integer>>> down = new ArrayList<>(r);
        ArrayList<ArrayList<LinkedList<Integer>>> right = new ArrayList<>(r);
        ArrayList<ArrayList<LinkedList<Integer>>> left = new ArrayList<>(r);
        boolean[][] in = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            up.add(new ArrayList<>(c));
            down.add(new ArrayList<>(c));
            right.add(new ArrayList<>(c));
            left.add(new ArrayList<>(c));
            for (int j = 0; j < c; j++) {
                up.get(i).add(new LinkedList<>());
                down.get(i).add(new LinkedList<>());
                right.get(i).add(new LinkedList<>());
                left.get(i).add(new LinkedList<>());
                for (int k = i - 1; k >= 0; k--) {
                    up.get(i).get(j).add(k);
                }
                for (int k = i + 1; k < r; k++) {
                    down.get(i).get(j).add(k);
                }
                for (int k = j - 1; k >= 0; k--) {
                    left.get(i).get(j).add(k);
                }
                for (int k = j + 1; k < c; k++) {
                    right.get(i).get(j).add(k);
                }
                totalSum += s[i][j];
                in[i][j] = true;
            }
        }
        boolean elim = true;
        while (elim) {
            elim = false;
            inter += totalSum;
            boolean[][] out = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (in[i][j]) {
                        int s0 = s[i][j];
                        int count = 0;
                        int sum = 0;
                        if (!up.get(i).get(j).isEmpty()) {
                            int upE = up.get(i).get(j).getFirst();
                            count++;
                            sum += s[upE][j];
                        }
                        if (!down.get(i).get(j).isEmpty()) {
                            int downE = down.get(i).get(j).getFirst();
                            count++;
                            sum += s[downE][j];
                        }
                        if (!right.get(i).get(j).isEmpty()) {
                            int rightE = right.get(i).get(j).getFirst();
                            count++;
                            sum += s[i][rightE];
                        }
                        if (!left.get(i).get(j).isEmpty()) {
                            int leftE = left.get(i).get(j).getFirst();
                            count++;
                            sum += s[i][leftE];
                        }
                        if (sum > s0 * count) {
                            elim = true;
                            in[i][j] = false;
                            out[i][j] = true;
                        }
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (out[i][j]) {
                        totalSum -= s[i][j];
                        for (int k = i - 1; k >= 0; k--) {
                            down.get(k).get(j).removeFirstOccurrence(i);
                        }
                        for (int k = i + 1; k < r; k++) {
                            up.get(k).get(j).removeFirstOccurrence(i);
                        }
                        for (int k = j - 1; k >= 0; k--) {
                            right.get(i).get(k).removeFirstOccurrence(j);
                        }
                        for (int k = j + 1; k < c; k++) {
                            left.get(i).get(k).removeFirstOccurrence(j);
                        }
                    }
                }
            }
        }
        return inter;
    }

}
