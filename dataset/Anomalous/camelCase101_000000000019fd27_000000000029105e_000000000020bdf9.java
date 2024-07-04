import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            int[] cameron = new int[activityCount * 2];
            int cameronLength = 0;
            int[] jamie = new int[activityCount * 2];
            int jamieLength = 0;
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start > end) {
                    int temp = end;
                    end = start;
                    start = temp;
                }

                boolean fitsCameron = true;
                for (int j = 0; j < cameronLength; j += 2) {
                    if (start < cameron[j + 1] && end > cameron[j]) {
                        fitsCameron = false;
                        break;
                    }
                }

                if (fitsCameron) {
                    cameron[cameronLength] = start;
                    cameron[cameronLength + 1] = end;
                    cameronLength += 2;
                    schedule.append("C");
                } else {
                    boolean fitsJamie = true;
                    for (int j = 0; j < jamieLength; j += 2) {
                        if (start < jamie[j + 1] && end > jamie[j]) {
                            fitsJamie = false;
                            break;
                        }
                    }

                    if (fitsJamie) {
                        jamie[jamieLength] = start;
                        jamie[jamieLength + 1] = end;
                        jamieLength += 2;
                        schedule.append("J");
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + schedule.toString());
            }
        }
    }
}