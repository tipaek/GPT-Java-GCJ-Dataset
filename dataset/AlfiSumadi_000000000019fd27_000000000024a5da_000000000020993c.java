import java.util.*;
/**
 * Solution
 */
public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int x = 1; x <= t; x++) {
            solve(x);
        }
    }

    private static void solve(long x) {
        long n = sc.nextLong(), k = 0, c = 0, r = 0;
        
        ArrayList<HashMap<Long,Long>> digitsFoundInColumns = new ArrayList<>();
        for (int i = 0; i < n; i++) digitsFoundInColumns.add(new HashMap<Long, Long>());
        for (int i = 0; i < n; i++) {
            HashMap<Long, Long> digitsFoundInRow = new HashMap<>();
            for (int j = 0; j < n; j++) {
                long currentVal = sc.nextLong();
                if (i == j) k += currentVal;

                if (!digitsFoundInRow.containsKey(currentVal)) digitsFoundInRow.putIfAbsent(currentVal, 1l);
                else digitsFoundInRow.put(currentVal, digitsFoundInRow.get(currentVal) + 1);
                
                if (!digitsFoundInColumns.get(j).containsKey(currentVal)) digitsFoundInColumns.get(j).putIfAbsent(currentVal, 1l);
                else digitsFoundInColumns.get(j).put(currentVal, digitsFoundInRow.get(currentVal) + 1);
            }
            for (Long num : digitsFoundInRow.keySet()) {
                if (digitsFoundInRow.get(num) > 1) {
                    r++;
                    break;
                }
            }
        }

        for (HashMap<Long, Long> digitsFoundInColumn : digitsFoundInColumns) {
            for (Long num : digitsFoundInColumn.keySet()) {
                if (digitsFoundInColumn.get(num) > 1) {
                    c++;
                    break;
                }
            }
        }
        System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
    }
}