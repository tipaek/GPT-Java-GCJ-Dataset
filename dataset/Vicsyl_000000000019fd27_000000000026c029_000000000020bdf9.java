import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Solution {

    public static void solve(int[][] slots, int caze) {

        Arrays.sort(slots, (ints, t1) -> ints[0] - t1[0]);

        char[] solution = new char[slots.length];
        int cIndex = 0;
        int jIndex = 1;
        solution[slots[cIndex][2]] = 'C';
        solution[slots[jIndex][2]] = 'J';

        int next_index = Math.max(jIndex, cIndex) + 1;
        boolean next_j = slots[jIndex][1] < slots[cIndex][1];
        int index_to_check = next_j ? jIndex : cIndex;

        while (next_index != slots.length) {
            if (slots[index_to_check][1] > slots[next_index][0]) {
                System.out.println("Case #" + caze + ": IMPOSSIBLE");
                return;
            }
            solution[slots[next_index][2]] = (next_j ? 'J' : 'C');
            if (next_j) {
                jIndex = next_index;
            } else {
                cIndex = next_index;
            }
            next_index = Math.max(jIndex, cIndex) + 1;
            next_j = slots[jIndex][1] < slots[cIndex][1];
            index_to_check = next_j ? jIndex : cIndex;

        }
        System.out.println("Case #" + caze + ": " + String.valueOf(solution));
    }

    public static void main(String... args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        int cases = Integer.parseInt(line.trim());
        for (int i = 0; i < cases; i++) {
            line = reader.readLine();
            int slots_size = Integer.parseInt(line.trim());
            int[][] slots = new int[slots_size][3];
            for (int s = 0; s < slots_size; s++) {
                String[] strs = reader.readLine().trim().split(" ");
                slots[s][0] = Integer.parseInt(strs[0]);
                slots[s][1] = Integer.parseInt(strs[1]);
                slots[s][2] = s;
            }
            solve(slots, i + 1);
        }

    }
    // comment
}
