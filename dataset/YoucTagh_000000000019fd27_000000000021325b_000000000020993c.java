import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {
            int size = sc.nextInt();
            HashMap<Integer, Boolean> tmp;
            int[][] mat = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    mat[j][k] = sc.nextInt();
                }
            }
            int s = 0, r = 0, c = 0;
            for (int j = 0; j < size; j++) {
                s += mat[j][j];
            }

            for (int j = 0; j < size; j++) {
                tmp = new HashMap<>();
                boolean isFound = false;
                for (int k = 0; k < size && !isFound; k++) {
                    if (tmp.get(mat[j][k]) != null) {
                        r++;
                        isFound = true;
                    } else {
                        tmp.put(mat[j][k], true);
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                tmp = new HashMap<>();
                boolean isFound = false;
                for (int k = 0; k < size && !isFound; k++) {
                    if (tmp.get(mat[k][j]) != null) {
                        c++;
                        isFound = true;
                    } else {
                        tmp.put(mat[k][j], true);
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + s + " " + r + " " + c);
        }

    }
}
