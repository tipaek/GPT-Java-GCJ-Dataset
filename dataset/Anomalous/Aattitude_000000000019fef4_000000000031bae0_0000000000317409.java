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
            try {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                String directions = input[2];

                boolean reached = false;
                int relativePosition = y;
                int time = 0;

                for (int i = 0; i < x; i++) {
                    relativePosition += (directions.charAt(i) == 'S') ? -1 : 1;
                }

                if (relativePosition == 0) {
                    reached = true;
                } else {
                    boolean movingNorth = relativePosition > 0;

                    for (int i = x; i < directions.length(); i++) {
                        if (movingNorth) {
                            if (directions.charAt(i) == 'N') {
                                time++;
                            } else {
                                relativePosition -= 2;
                                time++;
                                if (relativePosition <= 0) {
                                    reached = true;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (reached) {
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