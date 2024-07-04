import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int k=0; k<t; k++) {
            int n = sc.nextInt();
            int[][] task = new int[n][2];
            for (int i = 0; i < n; i++) {
                task[i][0] = sc.nextInt();
                task[i][1] = sc.nextInt();
            }
            System.out.println("Case #" + (k+1) + ": " + schedule(task, n));
        }
    }

    private static String schedule(int[][] task, int n) {

        StringBuilder schedule = new StringBuilder();
        int[] jamie = new int[1441];
        int[] cameron = new int[1441];

        for(int i=0; i<n; i++) {
            int start = task[i][0];
            int end = task[i][1];
            if(isJamieAvailable(jamie, start, end)) {
                addTask(jamie, start, end);
                schedule.append("J");
            } else if(isCameronAvailable(cameron, start, end)) {
                addTask(cameron, start, end);
                schedule.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean isCameronAvailable(int[] cameron, int start, int end) {
        int count = 0;
        for(int i=start+1; i<end; i++) {
            if(cameron[i]==1) {
                count++;
            }
            if(count>0) {
                break;
            }
        }
        return count <= 0;
    }

    private static boolean isJamieAvailable(int[] jamie, int start, int end) {
        int count = 0;
        for(int i=start+1; i<end; i++) {
            if(jamie[i]==1) {
                count++;
            }
            if(count>0) {
                break;
            }
        }
        return count <= 0;
    }

    private static void addTask(int[] person, int start, int end) {
        for(int i=start; i<=end; i++){
            person[i] = 1;
        }
    }

}
