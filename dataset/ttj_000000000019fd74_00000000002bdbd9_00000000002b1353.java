import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class Pair {
        public Integer key;
        public Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int goal = scanner.nextInt();
            List<Pair> result = getResult(goal);
            System.out.print("Case #" + (i + 1) + ":");
            for (Pair pair : result) {
                System.out.println();
                System.out.print(pair.key + " " + pair.value);
            }
            if (i != n - 1)
                System.out.println();
        }
    }

    private static List<Pair> getResult(int goal) {
        List<Pair> pairList = new ArrayList<>();
        int rowCount = (int)(Math.log(goal + 1) / Math.log(2));
        for (int i = 1; i <= rowCount; i++) {
            if (i % 2 == rowCount % 2) {
                for (int j = 1; j <= i; j++) {
                    pairList.add(new Pair(i, j));
                }
            } else {
                for (int k = i; k >= 1; k--) {
                    pairList.add(new Pair(i, k));
                }
            }
        }
        int remainder = goal - (int)Math.pow(2, rowCount) + 1;
        rowCount++;
        if (remainder >= rowCount - 1) {
            while (remainder >= rowCount - 1) {
                pairList.add(new Pair(rowCount, rowCount - 1));
                remainder -= (rowCount - 1);
                rowCount++;
            }
            rowCount--;
        }
        while (remainder > 0) {
            pairList.add(new Pair(rowCount, rowCount));
            remainder--;
            rowCount++;
        }

        return pairList;
    }
}
