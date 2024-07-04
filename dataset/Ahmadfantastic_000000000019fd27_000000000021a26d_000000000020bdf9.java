import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws FileNotFoundException {
        //in = new Scanner(ParentingPartneringReturns.class.getResourceAsStream("file.in"));
        int T = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            in.nextLine();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int S = in.nextInt();
                int E = in.nextInt();
                activities.add(new Activity(i, S, E));
                if (in.hasNextLine()) {
                    in.nextLine();
                }
            }
            activities.sort((o1, o2) -> {
                return o1.s - o2.s;
            });

            char[] answer = new char[N];
            boolean isImpossible = false;
            Activity prevC = null;
            Activity prevJ = null;
            for (Activity activity : activities) {
                if (prevC == null) {
                    prevC = activity;
                } else if (prevJ == null) {
                    prevJ = activity;
                } else {
                    if (prevC.e <= activity.s) {
                        answer[prevC.id] = 'C';
                        prevC = activity;
                    } else if (prevJ.e <= activity.s) {
                        answer[prevJ.id] = 'J';
                        prevJ = activity;
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }
            if (prevC != null) {
                answer[prevC.id] = 'C';
            }
            if (prevJ != null) {
                answer[prevJ.id] = 'J';
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + new String(answer));
            }
        }
    }

    private static class Activity {

        int id;
        int s;
        int e;

        public Activity(int id, int s, int e) {
            this.id = id;
            this.s = s;
            this.e = e;
        }

    }
}
