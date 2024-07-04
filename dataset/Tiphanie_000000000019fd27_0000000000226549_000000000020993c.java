import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            int dia = 0;
            ArrayList<HashSet<Integer>> rows = initSets(n);
            ArrayList<HashSet<Integer>> cols = initSets(n);
            ArrayList<Boolean> rowDup = initBooleans(n);
            ArrayList<Boolean> colDup = initBooleans(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int cur = in.nextInt();
                    if (rows.get(i).contains(cur)) {
                        rowDup.set(i, true);
                    } else {
                        rows.get(i).add(cur);
                    }
                    if (cols.get(j).contains(cur)) {
                        colDup.set(j, true);
                    } else {
                        cols.get(j).add(cur);
                    }
                    if (i == j) {
                        dia += cur;
                    }
                }
            }
            int rowSum = calDups(rowDup);
            int colSum = calDups(colDup);
            System.out.println("Case #" + k + ":" + dia + " " + rowSum + " " + colSum);
        }
    }

    private static ArrayList<HashSet<Integer>> initSets(int n) {
        ArrayList<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>(n);
        for (int i = 0; i < n; ++i) {
            sets.add(new HashSet<>());
        }
        return sets;
    }

    private static ArrayList<Boolean> initBooleans(int n) {
        ArrayList<Boolean> booleans = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            booleans.add(false);
        }
        return booleans;
    }

    private static int calDups(ArrayList<Boolean> Dups) {
        int sum = 0;
        for (boolean b : Dups) {
            if (b) {
                ++sum;
            }
        }
        return sum;
    }
}
