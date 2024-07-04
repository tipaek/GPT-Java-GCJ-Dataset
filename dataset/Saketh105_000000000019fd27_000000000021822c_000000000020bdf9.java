import java.io.*;
import java.util.*;
import java.util.Map.Entry;

 class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            TreeMap<Integer, Integer> h = new TreeMap<>();
            for (int k = 0; k < n; k++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                h.put(start, end);
            }
            String sol = solve(h);
            System.out.println("Case #" + (i + 1) + ": " + sol);
        }
    }

    public static String solve(TreeMap<Integer, Integer> t) {
        String sol = "";
        boolean isJoccupied = false;
        boolean isCoccupied = false;
        String next = "J";
        int startJ = 0;
        int endJ = 0;
        int startC = 0;
        int endC = 0;
        while (!t.isEmpty()) {
            Entry<Integer, Integer> e = t.pollFirstEntry();
            if (endC <= e.getKey() && endC <= e.getValue()) {
                isCoccupied = false;
            }
            if (endJ <= e.getKey() && endJ <= e.getValue()) {
                isJoccupied = false;
            }
            if (isJoccupied && isCoccupied) {
                sol = "IMPOSSIBLE";
                break;
            } else {
                if (!isJoccupied) {
                    startJ = e.getKey();
                    endJ = e.getValue();
                    isJoccupied = true;
                    sol += "J";
                } else if (!isCoccupied) {
                    startC = e.getKey();
                    endC = e.getValue();
                    isCoccupied = true;
                    sol += "C";
                }
            }
        }
        return sol;
    }
}