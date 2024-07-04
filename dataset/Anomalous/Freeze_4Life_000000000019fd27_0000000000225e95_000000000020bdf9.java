import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class InterfaceProg {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] tasks = new int[n][4];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                tasks[i][0] = Integer.parseInt(input[0]);
                tasks[i][1] = Integer.parseInt(input[1]);
                tasks[i][2] = i;
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

            int cameronEnd = 0;
            int jamieEnd = 0;
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int[] task : tasks) {
                int start = task[0];
                int end = task[1];

                if (cameronEnd <= start) {
                    task[3] = 0;
                    cameronEnd = end;
                } else if (jamieEnd <= start) {
                    task[3] = 1;
                    jamieEnd = end;
                } else {
                    writer.write("Case #" + t + ": IMPOSSIBLE\n");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Arrays.sort(tasks, Comparator.comparingInt(task -> task[2]));

                for (int[] task : tasks) {
                    result.append(task[3] == 0 ? 'C' : 'J');
                }

                writer.write("Case #" + t + ": " + result.toString() + "\n");
            }
        }

        writer.flush();
    }
}