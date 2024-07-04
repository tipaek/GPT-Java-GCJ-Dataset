import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String testCaseCount;
        testCaseCount = scan.nextLine();
        int testCase = Integer.parseInt(testCaseCount);

        boolean check = false;

        int jamieStartTime = 0;
        int jamieEndTime = 0;
        int cameronStartTime = 0;
        int cameronEndTime = 0;

        for(int i = 0; i < testCase; i++) {
            String testCaseStringCount = scan.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Case #").append(i + 1).append(": ");

            List<String> jamieActivities = new ArrayList<>();
            List<String> cameronActivities = new ArrayList<>();

            for(int j = 0; j < Integer.parseInt(testCaseStringCount); j++) {
                check = false;
                String time = scan.nextLine();
                String[] timeParts = time.split(" ");

                int starTime = Integer.parseInt(timeParts[0]);
                int endTime = Integer.parseInt(timeParts[1]);

                boolean jamieActivity = true;
                boolean cameronActivity = true;

                if(j == 0){
                    jamieActivities.add(time);
                    stringBuilder.append("J");
                }
                else {
                    for (int a = 0; a < jamieActivities.size(); a++) {
                        String[] jamieTimeParts = jamieActivities.get(a).split(" ");
                        jamieStartTime = Integer.parseInt(jamieTimeParts[0]);
                        jamieEndTime = Integer.parseInt(jamieTimeParts[1]);

                        if ((starTime <= jamieStartTime && endTime > jamieStartTime) ||
                            (starTime < jamieEndTime && endTime >= jamieEndTime) ||
                            (starTime >= jamieStartTime && endTime <= jamieEndTime)) {
                            jamieActivity = false;
                            break;
                        }
                    }
                    if(jamieActivity) {
                        stringBuilder.append("J");
                        jamieActivities.add(time);
                    }
                    else {
                        if (cameronActivities.isEmpty()) {
                            cameronActivities.add(time);
                            stringBuilder.append("C");
                        } else {
                            for (int p = 0; p < cameronActivities.size(); p++) {
                                String[] cameronTimeParts = cameronActivities.get(p).split(" ");
                                cameronStartTime = Integer.parseInt(cameronTimeParts[0]);
                                cameronEndTime = Integer.parseInt(cameronTimeParts[1]);

                                if ((starTime <= cameronStartTime && endTime > cameronStartTime) ||
                                    (starTime < cameronEndTime && endTime >= cameronEndTime) ||
                                    (starTime >= cameronStartTime && endTime <= cameronEndTime)) {
                                    cameronActivity = false;
                                    break;
                                }
                            }
                            if(cameronActivity){
                                stringBuilder.append("C");
                                cameronActivities.add(time);
                            }
                            else {
                                check = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(check) stringBuilder = new StringBuilder().append("Case #").append(i + 1).append(": IMPOSSIBLE");
            System.out.println(stringBuilder.toString());
        }
    }
}
