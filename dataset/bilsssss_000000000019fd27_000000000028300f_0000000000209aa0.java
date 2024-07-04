import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcase = Integer.parseInt(scanner.nextLine());
        for (int i=0;i<testcase;i++) {
            String inputMatrix = scanner.nextLine();
            String[] inputArray = inputMatrix.split(" ");
            int n = Integer.parseInt(inputArray[0]);
            int k = Integer.parseInt(inputArray[1]);

            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                matrix[j][j] = k / n;
            }
            if (k % n > 0) {
                matrix[n - 1][n - 1] += k % n;
            }

            Random random = new Random();
            List<Integer> listRow = new ArrayList<>();
            List<Integer> listColumn = new ArrayList<>();
            boolean possible = true;

            for (int p = 0; p < n; p++) {
                listRow.add(matrix[p][p]);
                for (int q = 0; q < n; q++) {
                    if (p != q) {
                        int item = random.nextInt(n) + 1;
                        int value = getNumber(listRow, item, n, random);
                        matrix[p][q] = value;
                        listRow.add(value);
                    }
                }
                listRow.clear();
            }

            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    if (listColumn.contains(matrix[q][p])) {
                        possible = false;
                    } else {
                        listColumn.add(matrix[q][p]);
                    }
                }
                listColumn.clear();
            }

            if (possible) {
                System.out.println("case #" + i + ": POSSIBLE");
                for (int p = 0; p < n; p++) {
                    for (int q = 0; q < n; q++) {
                        System.out.println(matrix[p][q] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("case #" + i + ": IMPOSSIBLE");
            }


        }
    }

    private static int getNumber(List<Integer> list, int num, int n, Random random) {
        if (list.contains(num)) {
            return getNumber(list, random.nextInt(n) + 1, n, random);
        } else {
            return num;
        }
    }
}