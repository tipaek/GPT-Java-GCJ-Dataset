import java.io.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= testCaseCount; t++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String s = input[2];

            int relative = y;
            int time = 0;
            boolean possible = false;

            if (s.length() < x) {
                bw.write("Case #" + t + ": IMPOSSIBLE\n");
            } else {
                for (int i = 0; i < x; i++) {
                    relative += (s.charAt(i) == 'S') ? -1 : 1;
                }

                if (relative == 0) {
                    possible = true;
                } else {
                    boolean directionPositive = relative > 0;
                    for (int i = x; i < s.length(); i++) {
                        if (directionPositive) {
                            if (s.charAt(i) == 'N') {
                                time++;
                            } else {
                                relative -= 2;
                                time++;
                                if (relative <= 0) {
                                    possible = true;
                                    break;
                                }
                            }
                        } else {
                            if (s.charAt(i) == 'S') {
                                time++;
                            } else {
                                relative -= 2;
                                time++;
                                if (relative <= 0) {
                                    possible = true;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (possible) {
                    bw.write("Case #" + t + ": " + (x + time) + "\n");
                } else {
                    bw.write("Case #" + t + ": IMPOSSIBLE\n");
                }
            }
        }
        bw.flush();
    }
}