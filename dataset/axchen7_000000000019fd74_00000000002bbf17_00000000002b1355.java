import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int curT = 1; curT <= t; curT++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            C[][] all = new C[r][c];
            long totalInterest = 0;
            long curInterest = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    all[i][j] = new C(scanner.nextInt());
                    curInterest += all[i][j].skill;
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i > 0) all[i][j].prevRow = all[i - 1][j];
                    if (i < r - 1) all[i][j].nextRow = all[i + 1][j];
                    if (j > 0) all[i][j].prevCol = all[i][j - 1];
                    if (j < c - 1) all[i][j].nextCol = all[i][j + 1];
                }
            }

            HashSet<C> toRemove = new HashSet<>();
            HashSet<C> check = new HashSet<>();
            for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) check.add(all[i][j]);


            while (true) {
                totalInterest += curInterest;

                for (C cur : check) {
                    if (cur.needRemove()) toRemove.add(cur);
                }

                if (toRemove.isEmpty()) {
                    break;
                }

                check.clear();
                for (C cur : toRemove) {
                    curInterest -= cur.skill;
                    if (cur.prevRow != null && cur.nextRow != null) {
                        cur.prevRow.nextRow = cur.nextRow;
                        cur.nextRow.prevRow = cur.prevRow;
                    } else if (cur.prevRow != null) {
                        cur.prevRow.nextRow = null;
                    } else if (cur.nextRow != null) {
                        cur.nextRow.prevRow = null;
                    }
                    if (cur.prevCol != null && cur.nextCol != null) {
                        cur.prevCol.nextCol = cur.nextCol;
                        cur.nextCol.prevCol = cur.prevCol;
                    } else if (cur.prevCol != null) {
                        cur.prevCol.nextCol = null;
                    } else if (cur.nextCol != null) {
                        cur.nextCol.prevCol = null;
                    }

                    if (cur.prevRow != null && !toRemove.contains(cur.prevRow))
                        check.add(cur.prevRow);
                    if (cur.nextRow != null && !toRemove.contains(cur.nextRow))
                        check.add(cur.nextRow);
                    if (cur.prevCol != null && !toRemove.contains(cur.prevCol))
                        check.add(cur.prevCol);
                    if (cur.nextCol != null && !toRemove.contains(cur.nextCol))
                        check.add(cur.nextCol);
                }
                toRemove.clear();
            }

            System.out.println("Case #" + curT + ": " + totalInterest);
        }
    }

    static class C {
        int skill;
        C prevRow;
        C nextRow;
        C prevCol;
        C nextCol;

        C(int skill) {
            this.skill = skill;
        }

        boolean needRemove() {
            int total = 0;
            int count = 0;
            if (prevRow != null) {
                total += prevRow.skill;
                count++;
            }
            if (nextRow != null) {
                total += nextRow.skill;
                count++;
            }
            if (prevCol != null) {
                total += prevCol.skill;
                count++;
            }
            if (nextCol != null) {
                total += nextCol.skill;
                count++;
            }
            return count > 0 && skill * count < total;
        }
    }
}
