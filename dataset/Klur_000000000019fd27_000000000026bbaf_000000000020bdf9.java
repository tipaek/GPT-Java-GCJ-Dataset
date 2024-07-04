import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * In
 * 4
 * 3
 * 360 480
 * 420 540
 * 600 660
 * 3
 * 0 1440
 * 1 3
 * 2 4
 * 5
 * 99 150
 * 1 100
 * 100 301
 * 2 5
 * 150 250
 * 2
 * 0 720
 * 720 1440
 * Out
 * Case #1: CJC
 * Case #2: IMPOSSIBLE
 * Case #3: JCCJJ
 * Case #4: CC
 */

public class Solution {

    private void solve(Scanner sc){
        int testCase = sc.nextInt();
        for (int testCount = 1; testCount<=testCase;testCount++) {
            System.out.print("Case #" + testCount + ": ");
            StringBuilder sb = new StringBuilder();
            ArrayList<Activity> cActivities = new ArrayList<>();
            ArrayList<Activity> jActivities = new ArrayList<>();

            int totalActivities = sc.nextInt();
            for (int n = 1; n <= totalActivities; n++) {
                Activity thisActivity = new Activity(sc.nextInt(), sc.nextInt());
//                System.out.println(thisActivity.toString());

                boolean isCAvailable = true;
                for (Activity a : cActivities) {
                    if(isOverlap(thisActivity, a)){
                        isCAvailable = false;
                        break;
                    }
                }
                if(isCAvailable){
                    cActivities.add(thisActivity);
                    sb.append("C");
                } else {
                    boolean isJAvailable = true;
                    for (Activity b : jActivities) {
                        if(isOverlap(thisActivity, b)){
                            isJAvailable = false;
                            break;
                        }
                    }
                    if(isJAvailable){
                        jActivities.add(thisActivity);
                        sb.append("J");
                    } else{
                        sb = new StringBuilder();
                        sb.append("IMPOSSIBLE");
                        
                    }
                }

            }
            System.out.println(sb.toString());
        }
    }

    private static boolean isOverlap(Activity a, Activity b){
        if(a.start<=b.start){
            if(a.end > b.start){
                return true;
            } else {
                return false;
            }
        } else {
            if(b.end > a.start){
                return true;
            } else {
                return false;
            }
        }
    }

    private class Activity{
        public int start;
        public int end;
        Activity(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString(){
            return this.start + " - " + this.end;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner sc = new Scanner(new FileInputStream("D:/03_Temp/google-code-jam/src/codeJam2020/qualification/parentingreturns/test_data.txt"));
        Solution parentingReturns = new Solution();
        parentingReturns.solve(sc);

    }
}
