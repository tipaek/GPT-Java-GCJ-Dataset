import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String s = input[2];

            int relative = y;
            int time = 0;
            boolean flag = false;

            if (s.length() < x) {
                bw.write("Case #" + t + ": IMPOSSIBLE\n");
                continue;
            }

            for (int i = 0; i < x; i++) {
                relative += (s.charAt(i) == 'S') ? -1 : 1;
            }

            if (relative == 0) {
                flag = true;
            } else {
                boolean direction = relative > 0;
                relative = Math.abs(relative);

                for (int i = x; i < s.length(); i++) {
                    if ((direction && s.charAt(i) == 'N') || (!direction && s.charAt(i) == 'S')) {
                        time++;
                    } else {
                        relative -= 2;
                        time++;
                        if (relative <= 0) {
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if (flag) {
                bw.write("Case #" + t + ": " + (x + time) + "\n");
            } else {
                bw.write("Case #" + t + ": IMPOSSIBLE\n");
            }
        }

        bw.flush();
    }
}