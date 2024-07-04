import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int n = sc.nextInt();
            int [][] taskTime = new int[n][3];
            for(int i = 0; i<n;i++){
                taskTime[i][0] = sc.nextInt();
                taskTime[i][1] = sc.nextInt();
                taskTime[i][2] = i;
            }
            String output = assignTask(taskTime, n);
            System.out.println("Case #" + test + ": " + output);
        }
    }

    private static String assignTask(int[][] taskTime, int n) {
        char []assignedPerson = new char[]{'C','J'};
        char [] ans = new char[n];
        Arrays.sort(taskTime, Comparator.comparingInt(a -> a[0]));
        int[] startTime = new int[2];
        startTime[0] = startTime[1] = Integer.MAX_VALUE;
        for(int i = n-1; i>= 0; i--){
            boolean flag = false;
            int personOne = 0, personTwo = 1;
            if(startTime[personOne] > startTime[personTwo]){
                personOne = 1;
                personTwo = 0;
            }
            if(taskTime[i][1] <= startTime[personOne]){
                flag = true;
                ans[taskTime[i][2]] = assignedPerson[personOne];
                startTime[personOne] = taskTime[i][0];
            }
            if(!flag && taskTime[i][1] <= startTime[personTwo]){
                flag = true;
                ans[taskTime[i][2]] = assignedPerson[personTwo];
                startTime[personTwo] = taskTime[i][0];
            }

            if(!flag){
                return "IMPOSSIBLE";
            }

        }
        return String.valueOf(ans);
    }
}
