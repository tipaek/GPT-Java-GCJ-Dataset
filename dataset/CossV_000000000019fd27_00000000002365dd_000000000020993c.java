import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(sc.nextLine());
            int trace = 0;
            int noRows = 0;
            int noCols = 0;
            Map<Integer, Set<Integer>> colsElems = new HashMap<>();
            for (int i = 0; i < n; i++) {
                colsElems.put(i, new HashSet<>());
            }
            for (int i = 0; i < n; i++) {
                String[] stringRowElems = sc.nextLine().split(" ");
                Set<Integer> rowElems = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int elem = Integer.parseInt(stringRowElems[j]);
                    rowElems.add(elem);
                    colsElems.get(j).add(elem);
                    if (i == j) {
                        trace += elem;
                    }

                    if (i == n - 1 && colsElems.get(j).size() < n) {
                        noCols++;
                    }
                }
                if (rowElems.size() < n) {
                    noRows++;
                }
            }

            System.out.println("Case #" + k + ": " + trace + " " + noRows + " " + noCols);
        }
    }
}
