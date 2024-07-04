import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    static int N = 0;
    static String[][] matrix = new String[1][1];
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<String> input = new ArrayList<>();
        while(in.hasNext()) {
            input.add(in.nextLine());
        }
        args = new String[input.size()];
        for (int i = 0; i < input.size(); i++) {
            args[i] = input.get(i);
        }
        helper(args);
    }
    
    public static void helper(String[] args) {
        int test = Integer.parseInt(args[0]);
        int index = 1;
        for (int i = 0; i < test; i++) {
            N = Integer.parseInt(args[index++]);
            matrix = new String[N][N];

            int columnMatch = 0;
            int rowMatch = 0;

            Map<Integer, Set<String>> columnToSet = new HashMap<>();
            boolean[] columnHasDup = new boolean[N];
            int diagonalSum = 0;
            for (int j = 0; j < N; j++) {
                String[] temp = args[index++].split(" ");
                HashSet<String> currentRow = new HashSet<>();
                boolean rowHas = false;
                for (int k = 0; k < N; k++) {
                    String current = temp[k];
                    if (j == k) diagonalSum += Integer.parseInt(current);
                    if (currentRow.contains(current)) {
                        rowHas = true;
                    } else {
                        currentRow.add(current);
                    }
                    if (columnToSet.containsKey(k)) {
                        Set<String> tempSet = columnToSet.get(k);
                        if (tempSet.contains(current)) columnHasDup[k] = true;
                        else {
                            tempSet.add(current);
                        }
                    } else {
                        Set<String> tempSet = new HashSet<>();
                        tempSet.add(current);
                        columnToSet.put(k, tempSet);
                    }
                }
                if (rowHas) rowMatch++;

            }
            for(int l = 0; l < columnHasDup.length; l++) {
                if (columnHasDup[l]) columnMatch++;
            }
            System.out.println(solve(i, diagonalSum, rowMatch, columnMatch));
        }
    }

    public static String solve(int caseNum, int diagonalSum, int columnMatch, int rowMatch) {
        return "Case #" + (caseNum + 1) + ": " + diagonalSum + " " + columnMatch + " " + rowMatch;
    }
}