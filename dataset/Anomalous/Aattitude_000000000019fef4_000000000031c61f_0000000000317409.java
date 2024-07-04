import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OverexcitedFan {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCount; t++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String s = input[2];

            int relativePosition = y;
            boolean possible = false;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'S') {
                    relativePosition--;
                } else {
                    relativePosition++;
                }

                if (relativePosition == 0) {
                    bw.write("Case #" + t + ": " + (i + 1) + "\n");
                    possible = true;
                    break;
                }
            }

            if (!possible) {
                bw.write("Case #" + t + ": IMPOSSIBLE\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}