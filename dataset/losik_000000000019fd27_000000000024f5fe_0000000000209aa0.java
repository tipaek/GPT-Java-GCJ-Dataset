
import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static int K;
    private static List<List<Integer>> nomove = new ArrayList<>();

    public static void main(String[] args) {
        main(System.in);
    }

    public static void main(InputStream is) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int t = in.nextInt();
        for (int run = 1; run <= t; ++run) {
            N = in.nextInt();
            K = in.nextInt();
            List<List<Integer>> solve = solve(options(1, 1), K, 0);
            if (solve != null) {
                printOK(run, solve);
                continue;
            }
            solve = solve(options(-1, 1), K, 0);
            if (solve != null) {
                printOK(run, solve);
                continue;
            }
            solve = solve(options(-1, -1), K, 0);
            if (solve != null) {
                printOK(run, solve);
                continue;
            }
            solve = solve(options(1, -1), K, 0);
            if (solve != null) {
                printOK(run, solve);
                continue;
            }
            System.out.println("Case #" + run + ": IMPOSSIBLE");
        }
    }

    protected static void printOK(int run, List<List<Integer>> solve) {
        System.out.println("Case #" + run + ": POSSIBLE");
        for (List<Integer> list : solve) {
            List<String> vals = new ArrayList<>();
            for (Integer integer : list) {
                vals.add("" + integer);
            }
            System.out.println(String.join(" ", vals));
        }
    }

    protected static List<List<Integer>> options(int signRow, int signCol) {
        List<List<Integer>> posibleRows = new ArrayList<>();
        for (int row = 0; row < N; row++) {
            List<Integer> posibleRow = new ArrayList<>();
            for (int col = 0; col < N; col++) {
                int val = 2 * N + (col * signCol) + (row * signRow);
                posibleRow.add((1 + (val % N)));
            }
            posibleRows.add(posibleRow);
        }
        return posibleRows;
    }

    private static List<List<Integer>> solve(List<List<Integer>> posibleRows, int sumLeft, int currentRow) {
        if (currentRow == N && sumLeft == 0) {
            return Collections.emptyList();
        }
        if (currentRow >= N || sumLeft < 0) {
            return null;
        }
        //System.err.println("curent row=" + currentRow + " vs N=" + N);
        for (List<Integer> posibleRow : posibleRows) {
            //System.err.println("posibleRow=" + posibleRow+" length ="+posibleRow.size()+" currentRow:"+currentRow);
            Integer val = posibleRow.get(currentRow);
            //System.err.println("Trying val=" + val + " left=" + sumLeft);
            if (sumLeft - val >= 0) {
                List<List<Integer>> newPosibleRows = new ArrayList<>(posibleRows);
                newPosibleRows.remove(posibleRow);
                List<List<Integer>> partRes = solve(newPosibleRows, sumLeft - val, currentRow + 1);
                if (partRes != null) {
                    ArrayList<List<Integer>> arrayList = new ArrayList<>();
                    arrayList.add(posibleRow);
                    arrayList.addAll(partRes);
                    return arrayList;
                }
            }
        }
        return null;

    }

}
