package codejam.qualification.parenttingparterner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private int total;
    private List<SimpleEntry<Integer, Integer>> pairs;
    private Map<Integer, Integer> color;
    boolean intersect[][];
    void solve(Scanner sc, PrintWriter pw) {
        total = sc.nextInt();
        pairs = new ArrayList<>();
        color = new HashMap<>();
        intersect = new boolean[total][total];
        for (int i = 0; i < total; i++) {
            pairs.add(new SimpleEntry<>(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (pairs.get(i).getValue() > pairs.get(j).getKey() && pairs.get(i).getKey() < pairs.get(j).getValue()) {
                    intersect[i][j] = true;
                }
            }
        }

        boolean possible = true;
        for (int i = 0; i < total; i++) {
            if (!color.containsKey(i)) {
                if (!couldColor(i, 0)) {
                    possible = false;
                    break;
                }
            }
        }
        String result = "IMPOSSIBLE";
        if (possible) {
            StringBuilder part = new StringBuilder();
            for(int i = 0; i < total; i++) {
                part.append(color.get(i) == 0 ? 'J' : 'C');
            }
            result = part.toString();
        }
        pw.println(result);
    }

    private boolean couldColor(int index, int c) {
        color.put(index, c);
        for (int i = index + 1; i < total; i++) {
            if (intersect[index][i]) {
                if (color.containsKey(i)) {
                    if (color.get(i) == c) {
                        return false;
                    }
                } else {
                    boolean result = couldColor(i, c ^ 1);
                    if (!result) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
//        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
//                + OUTPUT_FILE_NAME));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            pw.print("Case #" + (caseNum + 1) + ": ");
            new Solution().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
