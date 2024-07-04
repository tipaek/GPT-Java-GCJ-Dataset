import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static String schedule;
    static String cameronTasks;
    static String jamieTasks;
    static int start;
    static int end;
    static int startTime;
    static int endTime;
    static int jamieTaskCount;
    static int cameronTaskCount;
    static String[] timeSlots;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int n = 1; n <= testCases; n++) {
                cameronTasks = "";
                jamieTasks = "";
                jamieTaskCount = 0;
                cameronTaskCount = 0;
                schedule = "";

                int activities = Integer.parseInt(br.readLine());
                for (int i = 0; i < activities; i++) {
                    timeSlots = br.readLine().split(" ");
                    start = Integer.parseInt(timeSlots[0]);
                    end = Integer.parseInt(timeSlots[1]);

                    if (jamieTasks.isEmpty()) {
                        jamieTasks = timeSlots[0] + " " + timeSlots[1] + " ";
                        schedule += "J";
                        jamieTaskCount++;
                    } else if (!canJamieTakeTask()) {
                        if (cameronTasks.isEmpty()) {
                            cameronTasks = timeSlots[0] + " " + timeSlots[1] + " ";
                            schedule += "C";
                            cameronTaskCount++;
                        } else if (!canCameronTakeTask()) {
                            schedule = "IMPOSSIBLE";
                            break;
                        } else {
                            cameronTasks += timeSlots[0] + " " + timeSlots[1] + " ";
                            cameronTaskCount++;
                            schedule += "C";
                        }
                    } else {
                        jamieTasks += timeSlots[0] + " " + timeSlots[1] + " ";
                        jamieTaskCount++;
                        schedule += "J";
                    }
                }
                System.out.println("Case #" + n + ": " + schedule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean canCameronTakeTask() {
        String[] cameronTimeSlots = cameronTasks.split(" ");
        for (int j = 0; j < cameronTaskCount * 2; j += 2) {
            startTime = Integer.parseInt(cameronTimeSlots[j]);
            endTime = Integer.parseInt(cameronTimeSlots[j + 1]);
            if ((start < startTime && end > startTime) || (start >= startTime && start < endTime)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canJamieTakeTask() {
        String[] jamieTimeSlots = jamieTasks.split(" ");
        for (int j = 0; j < jamieTaskCount * 2; j += 2) {
            startTime = Integer.parseInt(jamieTimeSlots[j]);
            endTime = Integer.parseInt(jamieTimeSlots[j + 1]);
            if ((start < startTime && end > startTime) || (start >= startTime && start < endTime)) {
                return false;
            }
        }
        return true;
    }
}