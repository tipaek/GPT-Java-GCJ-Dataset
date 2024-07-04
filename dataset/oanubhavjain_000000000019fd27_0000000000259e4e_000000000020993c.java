import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        try {

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = in.nextInt();

            for (int i = 0; i < T; i++) {
                int N = in.nextInt();
                int[][] inputs = new int[N][N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        inputs[j][k] = in.nextInt();
                    }
                }
                printOutput(i + 1, N, inputs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printOutput(int T, int N, int inputs[][]) {
        int x = 0, r = 0, c = 0;
        ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            HashMap<Integer, Integer> mc = new HashMap<>();
            list.add(mc);
        }
        for (int i = 0; i < N; i++) {
            HashMap<Integer, Integer> mr = new HashMap<>();
            for (int j = 0; j < N; j++) {
                list.get(j).put(inputs[i][j], list.get(j).getOrDefault(inputs[i][j], 0) + 1);
                if (i == j) {
                    x += inputs[i][j];
                }
                mr.put(inputs[i][j], mr.getOrDefault(inputs[i][j], 0) + 1);
            }
            for (Integer v : mr.values()) {
                if(v>1) {
                    r++;
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (Integer v : list.get(i).values()) {
                if(v>1) {
                    c++;
                    break;
                }
            }
        }
        System.out.println("Case #" + T + ": " + x + " " + r + " " + c);
    }
}
