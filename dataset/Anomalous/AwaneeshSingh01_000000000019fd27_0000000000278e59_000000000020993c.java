import java.util.Hashtable;
import java.util.Scanner;

class Main {
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

            int k = computeTrace(mat, size);
            int r = countRowDuplicates(mat, size);
            int c = countColDuplicates(mat, size);

            System.out.println("Case #" + z + ": " + k + " " + r + " " + c);
        }
    }

    public static int computeTrace(int[][] arr, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    public static int countRowDuplicates(int[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Hashtable<Integer, Integer> h = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (h.containsKey(arr[i][j])) {
                    count++;
                    break;
                } else {
                    h.put(arr[i][j], 1);
                }
            }
        }
        return count;
    }

    public static int countColDuplicates(int[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Hashtable<Integer, Integer> h = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (h.containsKey(arr[j][i])) {
                    count++;
                    break;
                } else {
                    h.put(arr[j][i], 1);
                }
            }
        }
        return count;
    }
}