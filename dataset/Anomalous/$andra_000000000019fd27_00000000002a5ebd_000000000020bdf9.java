import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static String schedule;
    static String cameron;
    static String jamie;
    static int s = 0;
    static int e = 0;
    static int start = 0;
    static int end = 0;
    static int jamieCount;
    static int cameronCount;
    static String[] minutes;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int limit = Integer.parseInt(br.readLine());

            for (int n = 1; n <= limit; n++) {
                cameron = "f";
                jamie = "f";
                jamieCount = 0;
                cameronCount = 0;
                schedule = "";
                int activities = Integer.parseInt(br.readLine());

                for (int i = 0; i < activities; i++) {
                    minutes = br.readLine().split(" ");
                    s = Integer.parseInt(minutes[0]);
                    e = Integer.parseInt(minutes[1]);

                    if (jamie.equals("f")) {
                        jamie = minutes[0] + " " + minutes[1] + " ";
                        schedule += "J";
                        jamieCount++;
                    } else if (!evaluateJamie()) {
                        if (cameron.equals("f")) {
                            cameron = minutes[0] + " " + minutes[1] + " ";
                            schedule += "C";
                            cameronCount++;
                        } else if (!evaluateCameron()) {
                            schedule = "IMPOSSIBLE";
                        } else {
                            cameron += minutes[0] + " " + minutes[1] + " ";
                            cameronCount++;
                            schedule += "C";
                        }
                    } else {
                        jamie += minutes[0] + " " + minutes[1] + " ";
                        jamieCount++;
                        schedule += "J";
                    }
                }

                System.out.println("Case #" + n + ": " + schedule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean evaluateCameron() {
        String[] cameronTimes = cameron.split(" ");
        for (int j = 0; j < cameronCount * 2; j += 2) {
            start = Integer.parseInt(cameronTimes[j]);
            end = Integer.parseInt(cameronTimes[j + 1]);
            if ((s < start && e > start) || (s > start && s < end)) {
                return false;
            }
        }
        return true;
    }

    public static boolean evaluateJamie() {
        String[] jamieTimes = jamie.split(" ");
        for (int j = 0; j < jamieCount * 2; j += 2) {
            start = Integer.parseInt(jamieTimes[j]);
            end = Integer.parseInt(jamieTimes[j + 1]);
            if ((s < start && e > start) || (s > start && s < end)) {
                return false;
            }
        }
        return true;
    }
}