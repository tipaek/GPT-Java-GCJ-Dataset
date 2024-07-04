import java.util.*;
import java.io.*;

public class Solution {
    private static int T;
    private static List<int[][]> chores;

    public static void main(String[] args) {
        readInput('W');

        for (int i = 0; i < T; i++) {
            int[][] chore = chores.get(i);
            int N = chore.length;
            int[] minutes = new int[1440];
            char[] responsible = new char[N];
            boolean possible = true;

            for (int j = 0; j < N; j++) {
                int start = chore[j][0];
                int end = chore[j][1];
                boolean J = false;
                boolean C = false;

                for (int k = start; k < end; k++) {
                    if (minutes[k] == 'J') {
                        if (C) {
                            possible = false;
                            break;
                        }
                        J = true;
                    } else if (minutes[k] == 'C') {
                        if (J) {
                            possible = false;
                            break;
                        }
                        C = true;
                    } else if (minutes[k] == 'J' + 'C') {
                        possible = false;
                        break;
                    }
                }

                if (!possible) {
                    break;
                }

                if (J && C) {
                    possible = false;
                    break;
                }

                responsible[j] = J ? 'C' : 'J';
                for (int k = start; k < end; k++) {
                    minutes[k] += responsible[j];
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + new String(responsible));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static void readInput(char mode) {
        BufferedReader in = null;
        try {
            if (mode == 'E') {
                in = new BufferedReader(new FileReader("input.txt"));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
            }

            T = Integer.parseInt(in.readLine());
            chores = new ArrayList<>();

            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(in.readLine());
                int[][] chore = new int[N][2];
                for (int j = 0; j < N; j++) {
                    String[] row = in.readLine().split(" ");
                    chore[j][0] = Integer.parseInt(row[0]);
                    chore[j][1] = Integer.parseInt(row[1]);
                }
                chores.add(chore);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}