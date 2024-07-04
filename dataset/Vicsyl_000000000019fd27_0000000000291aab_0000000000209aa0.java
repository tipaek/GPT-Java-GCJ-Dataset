import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

    public static void print(int size, int[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j != 0) {
                    System.out.print(" " + matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void solve(int size, int trace_goal, int caze) {
        int[][] matrix = new int[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                matrix[i][j] = -1;
//            }
//        }
        int next_x_index = 0;
        int next_y_index = 0;
        boolean[][] takenByRow = new boolean[size][size + 1];
        boolean[][] takenByColumn = new boolean[size][size + 1];

        boolean done = false;
        while (!done) {

            int cur_number = matrix[next_x_index][next_y_index];
            if (cur_number != 0) {
                takenByRow[next_x_index][cur_number] = false;
                takenByColumn[next_y_index][cur_number] = false;
            }

            boolean backtracked = false;
            do {
                cur_number++;
                if (cur_number == size + 1) {
                    cur_number = 0;
                    // backtrack
                    if (next_x_index == 0) {
                        if (next_y_index == 0) {
                            System.out.println("Case #" + caze + ": IMPOSSIBLE");
                            return;
                        } else {
                            next_y_index--;
                            next_x_index = size - 1;
                        }
                    } else {
                        next_x_index--;
                    }
                    backtracked = true;
                    break;
                }
            } while (takenByRow[next_x_index][cur_number] || takenByColumn[next_y_index][cur_number]);

            if (!backtracked) {
                matrix[next_x_index][next_y_index] = cur_number;
                takenByColumn[next_y_index][cur_number] = true;
                takenByRow[next_x_index][cur_number] = true;
                next_x_index++;
                if (next_x_index == size) {
                    if (next_y_index == size - 1) {
                        int trace = 0;
                        for (int i = 0; i < size; i++) {
                            trace += matrix[i][i];
                        }
                        if (trace == trace_goal) {

                            System.out.println("Case #" + caze + ": POSSIBLE");
                            print(size, matrix);
                            return;
                        } else {
                            next_x_index = size - 1;
                        }
                    } else {
                        next_x_index = 0;
                        next_y_index++;
                    }
                }

            }
        }
    }

    public static void main(String... args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        int cases = Integer.parseInt(line.trim());
        for (int i = 0; i < cases; i++) {
            String[] n_str = reader.readLine().trim().split(" ");
            int size = Integer.parseInt(n_str[0].trim());
            int trace = Integer.parseInt(n_str[1].trim());
            solve(size, trace, i + 1);
        }

    }
}
