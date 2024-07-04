import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int z = 1; z <= T; z++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int k = trace(mat, size);
            int r = rowDuplicate(mat, size);
            int c = colDuplicate(mat, size);

            System.out.println("Case #" + z + ": " + k + " " + r + " " + c);
        }
    }

    public static int trace(int[][] arr, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    public static int rowDuplicate(int[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashMap<Integer, Boolean> h = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (h.containsKey(arr[i][j])) {
                    count++;
                    break;
                } else {
                    h.put(arr[i][j], true);
                }
            }
        }
        return count;
    }

    public static int colDuplicate(int[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashMap<Integer, Boolean> h = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (h.containsKey(arr[j][i])) {
                    count++;
                    break;
                } else {
                    h.put(arr[j][i], true);
                }
            }
        }
        return count;
    }
}