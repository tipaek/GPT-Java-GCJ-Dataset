import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scheduler {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] start = new int[n];
            int[] end = new int[n];
            int[] id = new int[n];
            char[] assignments = new char[n];
            boolean impossible = false;

            for (int job = 0; job < n; job++) {
                String[] times = br.readLine().split(" ");
                start[job] = Integer.parseInt(times[0]);
                end[job] = Integer.parseInt(times[1]);
                id[job] = job;
            }

            // Sort by end times
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (end[i] > end[j]) {
                        swap(start, i, j);
                        swap(end, i, j);
                        swap(id, i, j);
                    }
                }
            }

            int camEnd = 0, jamEnd = 0;
            for (int i = 0; i < n; i++) {
                if (camEnd <= start[i]) {
                    assignments[id[i]] = 'C';
                    camEnd = end[i];
                } else if (jamEnd <= start[i]) {
                    assignments[id[i]] = 'J';
                    jamEnd = end[i];
                } else {
                    impossible = true;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (char c : assignments) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}