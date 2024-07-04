import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(scanner.nextLine());
            String[] input = new String[N];
            for (int j = 0; j < N; j++) {
                input[j] = scanner.nextLine();
            }
            int[][] square = new int[N][N];
            for (int j = 0; j < N; j++) {
                String[] inputs = input[j].split(" ");
                for (int k = 0; k < N; k++) {
                    square[j][k] = Integer.valueOf(inputs[k]);
                }
            }
            int k = trace(square);
            int r = row(square);
            int c = col(square);
            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }

    private static int trace(int[][] square) {
        int k = 0;
        for (int i = 0; i < square.length; i++) {
            k += square[i][i];
        }
        return k;
    }

    private static int row(int[][] square) {
        int count = 0;
        ArrayList<Integer> used;
        for (int row = 0; row < square.length; row++) {
            used = new ArrayList<>();
            for (int i = 0; i < square[row].length; i++) {
                if (used.contains(square[row][i])) {
                    count++;
                    break;
                } else {
                    used.add(square[row][i]);
                }
            }
        }
        return count;
    }

    private static int col(int[][] square) {
        int count = 0;
        ArrayList<Integer> used;
        for (int col = 0; col < square.length; col++) {
            used = new ArrayList<>();
            for (int row = 0; row < square.length; row++) {
                if (used.contains(square[row][col])) {
                    count++;
                    break;
                } else {
                    used.add(square[row][col]);
                }
            }
        }
        return count;
    }

}
