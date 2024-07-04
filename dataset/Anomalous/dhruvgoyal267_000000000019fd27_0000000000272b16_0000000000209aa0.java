import java.util.*;

public class Solution {
    static HashMap<Integer, ArrayList<Integer>> map;
    static int n, trace;
    static int[] temp2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int originalT = t;
        boolean isFirstCase = true;

        while (t-- > 0) {
            if (!isFirstCase) {
                System.out.println();
            }
            isFirstCase = false;

            map = new HashMap<>();
            n = scanner.nextInt();
            trace = scanner.nextInt();

            initializeMap();

            temp2 = new int[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = i;
            }

            int resultIndex = checkSum(0);

            if (resultIndex == -1) {
                System.out.println("Case #" + (originalT - t) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (originalT - t) + ": POSSIBLE");
                printResult();
            }
        }
    }

    static void initializeMap() {
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add((i + j) % n);
            }
            map.put(i, row);
        }
    }

    static int checkSum(int k) {
        if (k == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += map.get(temp2[i]).get(i) + 1;
            }
            return sum == trace ? 1 : -1;
        }

        for (int i = k; i < n; i++) {
            swap(temp2, k, i);

            if (checkSum(k + 1) == 1) {
                return 1;
            }

            swap(temp2, k, i);
        }

        return -1;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void printResult() {
        for (int j = 0; j < n; j++) {
            ArrayList<Integer> row = map.get(temp2[j]);
            for (int i = 0; i < row.size(); i++) {
                System.out.print(row.get(i) + 1 + " ");
            }
            System.out.println();
        }
    }
}