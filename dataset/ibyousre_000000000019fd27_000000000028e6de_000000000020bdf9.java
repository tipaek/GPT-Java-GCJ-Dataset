
import java.util.Arrays;
import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int ti=0;ti<t;ti++){
            int n = in.nextInt();
            Integer[][] intervals = new Integer[n][3];
            for(int i=0;i<n;i++){
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
                intervals[i][2] = i;
            }
            Arrays.sort(intervals, (a,b)->a[0]-b[0]);
            int cameronFinish = Integer.MIN_VALUE;
            int jamieFinish = Integer.MIN_VALUE;
            char[] taskAssignments = new char[n];
            for(Integer[] interval: intervals){
                if(interval[0]>=cameronFinish){
                    cameronFinish = interval[1];
                    taskAssignments[interval[2]]='C';
                }else if(interval[0]>=jamieFinish){
                    jamieFinish = interval[1];
                    taskAssignments[interval[2]]='J';
                }else{
                    taskAssignments = null;
                    break;
                }
            }
            String solution = "IMPOSSIBLE";
            if(taskAssignments!=null){
                String replace = Arrays.toString(taskAssignments).replace(", ", "");
                solution = replace.substring(1, replace.length()-1);
            }
            System.out.printf("Case #%d: %s%n", ti+1, solution);
        }
    }
}