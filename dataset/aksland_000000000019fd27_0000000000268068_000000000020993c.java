import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tCases = sc.nextInt();
        for (int i = 0; i < tCases; i++) {
            int nSize = sc.nextInt();
            int trace = 0;
            int nRows = 0;
            Map<Integer, Integer>[] column = new Map[nSize];
            for (int j = 0; j < nSize; j++) {
                Map<Integer, Integer> row = new HashMap<>();

                for (int k = 0; k < nSize; k++) {
                    int val = sc.nextInt();
                    if (j == k) trace += val;

                    if (column[k] == null) column[k] = new HashMap<>();
                    column[k].put(val, column[k].getOrDefault(val, 0) + 1);
                    row.put(val, row.getOrDefault(val, 0) + 1);
                }

                for (int key:row.keySet()) {
                    if (row.get(key)>1) {
                        nRows += 1;
                        break;
                    }
                }
            }
            int nColumns = 0;
            for (int j = 0; j < nSize; j++) {
                for(int key: column[j].keySet()) {
                    if (column[j].get(key) > 1) {
                        nColumns += 1;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i+1) + ": " + trace + " " + nRows + " " + nColumns           );
        }
    }
}