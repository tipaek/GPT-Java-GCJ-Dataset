import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            ArrayList<Integer> activities = new ArrayList<Integer>();
            ArrayList<Integer> activitiesC = new ArrayList<Integer>();
            ArrayList<Integer> activitiesJ = new ArrayList<Integer>();
            String ans = "";
            for (int j = 0; j < n; j++) {
                ans += 'X';
            }

            for (int j = 0; j < n; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                activities.add(j);
                activities.add((int) 'X');
                activities.add(start);
                activities.add(end);
            }

            for (int j = 0; j < n; j++) {
                int number = activities.get(4*j);
                int start = activities.get(4*j + 2);
                int end = activities.get(4*j + 3);
                boolean goesToC = true;

                for (int k = 0; k < activitiesC.size() / 4; k++) {
                    if (!((end <= activitiesC.get(4*k + 2)) ||
                        (start >= activitiesC.get(4*k + 3)))) {
                        goesToC = false;
                        break;
                    }
                }
                if (goesToC) {
                    activitiesC.add(number);
                    activitiesC.add((int) 'C');
                    activitiesC.add(start);
                    activitiesC.add(end);
                    activities.set(4*j + 1, (int) 'C');
                }
            }

            for (int j = 0; j < n; j++) {
                if (activities.get(4*j + 1) != (int) 'C') {
                    int number = activities.get(4*j);
                    int start = activities.get(4*j + 2);
                    int end = activities.get(4*j + 3);
                    boolean goesToJ = true;

                    for (int k = 0; k < activitiesJ.size() / 4; k++) {
                        if (!((end <= activitiesJ.get(4*k + 2)) ||
                            (start >= activitiesJ.get(4*k + 3)))) {
                            goesToJ = false;
                            break;
                        }
                    }
                    if (goesToJ) {
                        activitiesJ.add(number);
                        activitiesJ.add((int) 'C');
                        activitiesJ.add(start);
                        activitiesJ.add(end);
                        activities.set(4*j + 1, (int) 'J');
                    }
                }
            }

            if (activitiesC.size() + activitiesJ.size() != activities.size()) {
                ans = "IMPOSSIBLE";
            } else {

                for (int j = 0; j < n; j++) {
                    if (activities.get(4*j + 1) == (int) 'C') {
                        ans = ans.substring(0, j) + 'C' + ans.substring(j+1);
                    }
                    if (activities.get(4*j + 1) == (int) 'J') {
                        ans = ans.substring(0, j) + 'J' + ans.substring(j+1);
                    }
                }
            }

            System.out.format("Case #%d: %s\n", i, ans);
        }
        scan.close();
    }
}