import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.valueOf(scanner.nextLine());
        for(int i = 0; i < caseCount; i++) {
            int N = Integer.valueOf(scanner.nextLine());
            int[][] matrix = new int[N][N];
            for(int j = 0; j < N; j++) {
                String[] line = scanner.nextLine().split(" ");
                for(int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.valueOf(line[k]);
                }
            }
            String result = slove(matrix, i + 1);
            System.out.println(result);
        }
    }

    public static String slove(int[][] matrix, int index) {
        int row = 0;
        int column = 0;
        int sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        for(int i = 0; i < matrix.length; i++) {
            HashSet<Integer> set = new HashSet();
            for(int j = 0; j < matrix.length; j++) {
                if(set.contains(matrix[i][j])) {
                    row++;
                    break;
                } else {
                    set.add(matrix[i][j]);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            HashSet<Integer> set = new HashSet();
            for(int j = 0; j < matrix.length; j++) {
                if(set.contains(matrix[j][i])) {
                    column++;
                    break;
                } else {
                    set.add(matrix[j][i]);
                }
            }
        }

        return String.format("Case #%d: %d %d %d", index, sum, row, column);
    }
}