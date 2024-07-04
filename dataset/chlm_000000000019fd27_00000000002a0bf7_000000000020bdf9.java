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
            boolean impossible = false;

            for (int j = 0; j < n; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                activities.add(j);
                activities.add((int) 'X');
                activities.add(start);
                activities.add(end);
            }

            for (int j = 0; j < activities.size() / 4; j++) {
                boolean goesToC = true;
                int number = activities.get(4*j);
                int owner = activities.get(4*j + 1);
                int start = activities.get(4*j + 2);
                int end = activities.get(4*j + 3);

                for (int k = 0; k < activitiesC.size() / 4; k++) {
                    int numberC = activitiesC.get(4*k);
                    int ownerC = activitiesC.get(4*k + 1);
                    int startC = activitiesC.get(4*k + 2);
                    int endC = activitiesC.get(4*k + 3);

                    if (!((end <= startC) || (start >= endC))) {
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
                } else {
                    boolean goesToJ = true;
                    for (int m = 0; m < activitiesJ.size() / 4; m++) {
                        int numberJ = activitiesJ.get(4*m);
                        int ownerJ = activitiesJ.get(4*m + 1);
                        int startJ = activitiesJ.get(4*m + 2);
                        int endJ = activitiesJ.get(4*m + 3);

                        if (!((end <= startJ) || (start >= endJ))) {
                            goesToJ = false;
                            break;
                        }
                    }
                    if (goesToJ) {
                        activitiesJ.add(number);
                        activitiesJ.add((int) 'J');
                        activitiesJ.add(start);
                        activitiesJ.add(end);
                        activities.set(4*j + 1, (int) 'J');
                    } else {
                        impossible = true;
                    }
                }


            }



            if (impossible) {
                ans = "IMPOSSIBLE";
            } else {
                for (int j = 0; j < n; j++) {
                 ans += (char) (int) activities.get(4*j + 1);
                }
            }

            System.out.format("Case #%d: %s\n", i, ans);
        }
        scan.close();
    }
}