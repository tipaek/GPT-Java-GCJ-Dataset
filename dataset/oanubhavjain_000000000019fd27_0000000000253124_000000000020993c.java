import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                String[][] inputs = new String[N][N];
                for (int j = 0; j < N; j++) {
                    String inp = br.readLine();
                    inputs[j] = inp.split(" ");
                }
                printOutput(i + 1, N, inputs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printOutput(int T, int N, String inputs[][]) {
        int x = 0, r = 0, c = 0;
        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            HashMap<String, Integer> mc = new HashMap<>();
            list.add(mc);
        }
        for (int i = 0; i < N; i++) {
            HashMap<String, Integer> mr = new HashMap<>();
            for (int j = 0; j < N; j++) {
                list.get(j).put(inputs[i][j], list.get(j).getOrDefault(inputs[i][j], 0) + 1);
                if (i == j) {
                    x += Integer.parseInt(inputs[i][j]);
                }
                mr.put(inputs[i][j], mr.getOrDefault(inputs[i][j], 0) + 1);
            }
            for (Integer v : mr.values()) {
                r = Math.max(r, v);
            }
            r = (r == 1) ? 0 : r;
        }
        for (int i = 0; i < N; i++) {
            for (Integer v : list.get(i).values()) {
                c = Math.max(c, v);
            }
            c = (c == 1) ? 0 : c;
        }
        System.out.println("Case #" + T + ": " + x + " " + r + " " + c);
    }
}
