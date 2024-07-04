import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        int i;
        int j;
        int tasks;
        int[][] timing;
        StringBuilder result;
        List<Integer> taskStartJ;
        List<Integer> taskEndJ;
        List<Integer> taskStartC;
        List<Integer> taskEndC;
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(i = 1; i<=testCases; i++) {
            tasks = scanner.nextInt();
            timing = new int[tasks][2];
            result = new StringBuilder();
            taskStartJ = new ArrayList<>();
            taskEndJ = new ArrayList<>();
            taskStartC = new ArrayList<>();
            taskEndC = new ArrayList<>();

            for(j=0; j<tasks; j++) {
                timing[j][0] = scanner.nextInt();
                timing[j][1] = scanner.nextInt();
            }
            Boolean flag = true;

            for(j=0; j<tasks; j++) {
                char candidate = getCandidate(timing[j][0], timing[j][1], taskStartJ, taskEndJ, taskStartC, taskEndC);
                if(candidate == 'I'){
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    flag = false;
                    break;
                }
                else {
                    result.append(candidate);
                    if(candidate == 'J') {
                        taskStartJ.add(timing[j][0]);
                        taskEndJ.add(timing[j][1]);
                    }
                    if(candidate == 'C') {
                        taskStartC.add(timing[j][0]);
                        taskEndC.add(timing[j][1]);
                    }
                }
            }

            if(flag) System.out.println("Case #" + i + ": " + result);
        }
    }

    private static char getCandidate(int startTime, int endTime, List<Integer> taskStartJ, List<Integer> taskEndJ, List<Integer> taskStartC, List<Integer> taskEndC) {
        Boolean flag = true;
        for(Integer startJ: taskStartJ) {
            if(startTime >= startJ && startTime < taskEndJ.get(taskStartJ.indexOf(startJ))) flag = false;
            else if(endTime > startJ && endTime <= taskEndJ.get(taskStartJ.indexOf(startJ))) flag = false;
            else if(startTime <= startJ && endTime >= taskEndJ.get(taskStartJ.indexOf(startJ))) flag = false;
        }
        if(flag) return 'J';
        else {
            flag = true;
            for(Integer startC: taskStartC) {
                if(startTime >= startC && startTime < taskEndC.get(taskStartC.indexOf(startC))) flag = false;
                else if(endTime > startC && endTime <= taskEndC.get(taskStartC.indexOf(startC))) flag = false;
                else if(startTime <= startC && endTime >= taskEndC.get(taskStartC.indexOf(startC))) flag = false;
            }
            if(flag) return 'C';
        }
        return 'I';
    }
}
