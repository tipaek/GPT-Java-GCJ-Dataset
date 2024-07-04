import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OverexcitedFan {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            try {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                String s = input[2];

                int relativeY = y;
                boolean flag = false;
                int time = 0;

                for (int i = 0; i < x; i++) {
                    if (s.charAt(i) == 'S') {
                        relativeY--;
                    } else {
                        relativeY++;
                    }
                }

                boolean direction = relativeY >= 0;

                if (relativeY == 0) {
                    flag = true;
                } else {
                    for (int i = x; i < s.length(); i++) {
                        if (direction) {
                            if (s.charAt(i) == 'N') {
                                time++;
                            } else {
                                relativeY -= 2;
                                time++;
                                if (relativeY <= 0) {
                                    flag = true;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (flag) {
                    bw.write("Case #" + t + ": " + (x + time) + "\n");
                } else {
                    bw.write("Case #" + t + ": IMPOSSIBLE\n");
                }
            } catch (Exception e) {
                bw.write("Case #" + t + ": IMPOSSIBLE\n");
            }
        }
        bw.flush();
    }
}