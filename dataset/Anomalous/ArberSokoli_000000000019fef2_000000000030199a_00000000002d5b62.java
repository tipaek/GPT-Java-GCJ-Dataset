import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int[] current = new int[32];
            int[] max = new int[32];
            int[] min = new int[32];
            int t = Integer.parseInt(sc.nextLine());

            for (int t0 = 0; t0 < t; t0++) {
                String[] s = sc.nextLine().split(" ");
                long x = Long.parseLong(s[0]);
                long y = Long.parseLong(s[1]);

                initializeArrays(current, max, min);

                boolean process = true;
                boolean impossible = false;
                long impossibleX = Math.abs(x) * 4;
                long impossibleY = Math.abs(y) * 4;

                while (process) {
                    long step = 1;
                    long fx = 0;
                    long fy = 0;

                    if (fx == x && fy == y) {
                        break;
                    }

                    for (int i = 31; i >= 0; i--) {
                        if (current[i] == 0) {
                            break;
                        }
                        fx = updateFx(current[i], fx, step);
                        fy = updateFy(current[i], fy, step);
                        step *= 2;
                    }

                    if (fx == x && fy == y) {
                        break;
                    }

                    if (impossibleX < step && impossibleY < step) {
                        impossible = true;
                        break;
                    }

                    nextCombo(current, max, min);
                }

                String answer = buildAnswer(current);
                if (impossible) {
                    answer = "IMPOSSIBLE";
                }

                System.out.println("Case #" + (t0 + 1) + ": " + answer);
            }
        }
    }

    private static void initializeArrays(int[] current, int[] max, int[] min) {
        for (int i = 0; i < 32; i++) {
            max[i] = 4;
            min[i] = 1;
            current[i] = 0;
        }
    }

    private static long updateFx(int currentValue, long fx, long step) {
        if (currentValue == 1) {
            fx -= step;
        } else if (currentValue == 3) {
            fx += step;
        }
        return fx;
    }

    private static long updateFy(int currentValue, long fy, long step) {
        if (currentValue == 2) {
            fy -= step;
        } else if (currentValue == 4) {
            fy += step;
        }
        return fy;
    }

    private static int[] nextCombo(int[] current, int[] max, int[] min) {
        for (int i = current.length - 1; i >= 0; i--) {
            if (current[i] < max[i]) {
                current[i]++;
                break;
            } else {
                current[i] = min[i];
            }
        }
        return current;
    }

    private static String buildAnswer(int[] current) {
        StringBuilder answer = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            if (current[i] != 0) {
                switch (current[i]) {
                    case 1:
                        answer.append("W");
                        break;
                    case 2:
                        answer.append("S");
                        break;
                    case 3:
                        answer.append("E");
                        break;
                    case 4:
                        answer.append("N");
                        break;
                }
            }
        }
        return answer.toString();
    }
}