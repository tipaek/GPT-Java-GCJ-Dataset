import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static long x;
    static long y;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());

            String solution = findSolution(x, y);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String findSolution(long x, long y) {
        StringBuilder solution = new StringBuilder();
        int pow = 1;

        while (true) {
            if (x == 0 && y == 0) {
                return solution.toString();
            }

            if (x % Math.pow(2, pow) == 0) {
                if (y % Math.pow(2, pow) == 0) {
                    return "IMPOSSIBLE";
                } else {
                    if (x == 0 && Math.abs(y) == Math.pow(2, pow - 1)) {
                        if (y > 0) {
                            y -= Math.pow(2, pow - 1);
                            solution.append('N');
                        } else {
                            y += Math.pow(2, pow - 1);
                            solution.append('S');
                        }
                    } else if (x % Math.pow(2, pow + 1) == 0) {
                        if ((y + Math.pow(2, pow - 1)) % Math.pow(2, pow + 1) != 0) {
                            y += Math.pow(2, pow - 1);
                            solution.append('S');
                        } else {
                            y -= Math.pow(2, pow - 1);
                            solution.append('N');
                        }
                    } else {
                        if ((y + Math.pow(2, pow - 1)) % Math.pow(2, pow + 1) == 0) {
                            y += Math.pow(2, pow - 1);
                            solution.append('S');
                        } else {
                            y -= Math.pow(2, pow - 1);
                            solution.append('N');
                        }
                    }
                }
            } else {
                if (y % Math.pow(2, pow) != 0) {
                    return "IMPOSSIBLE";
                } else {
                    if (y == 0 && Math.abs(x) == Math.pow(2, pow - 1)) {
                        if (x > 0) {
                            x -= Math.pow(2, pow - 1);
                            solution.append('E');
                        } else {
                            x += Math.pow(2, pow - 1);
                            solution.append('W');
                        }
                    } else if (y % Math.pow(2, pow + 1) == 0) {
                        if ((x + Math.pow(2, pow - 1)) % Math.pow(2, pow + 1) != 0) {
                            x += Math.pow(2, pow - 1);
                            solution.append('W');
                        } else {
                            x -= Math.pow(2, pow - 1);
                            solution.append('E');
                        }
                    } else {
                        if ((x + Math.pow(2, pow - 1)) % Math.pow(2, pow + 1) == 0) {
                            x += Math.pow(2, pow - 1);
                            solution.append('W');
                        } else {
                            x -= Math.pow(2, pow - 1);
                            solution.append('E');
                        }
                    }
                }
            }
            pow++;
        }
    }
}