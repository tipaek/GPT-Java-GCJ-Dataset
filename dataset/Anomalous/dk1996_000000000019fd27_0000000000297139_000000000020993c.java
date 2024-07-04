import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = Integer.parseInt(sc.nextLine());

        for (int temp = 1; temp <= r; temp++) {
            int c = Integer.parseInt(sc.nextLine());
            int[][] mat = new int[c][c];

            for (int i = 0; i < c; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = Integer.parseInt(sc.nextLine());
                }
            }

            int trace = 0;
            for (int i = 0; i < c; i++) {
                trace += mat[i][i];
            }

            int c_count = 0;
            int r_count = 0;

            for (int i = 0; i < c; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < c; j++) {
                    if (!rowSet.add(mat[i][j])) {
                        r_count++;
                        break;
                    }
                }
            }

            for (int j = 0; j < c; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < c; i++) {
                    if (!colSet.add(mat[i][j])) {
                        c_count++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + temp + ": " + trace + " " + r_count + " " + c_count);
        }
    }
}