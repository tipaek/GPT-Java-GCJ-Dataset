import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {


        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            int[][] taskList = new int[n][2];
            for(int j=0; j<n; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                taskList[j][0] = start;
                taskList[j][1] = end;

            }

            Arrays.sort(taskList, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });

            boolean cWorking = false;
            int cStart = 0;
            int cEnd = 0;

            boolean jWorking = false;
            int jStart = 0;
            int jEnd = 0;

            StringBuilder output = new StringBuilder("");
            boolean possible = true;

            for(int j = 0; j<n; j++){
                if(cWorking && cEnd <= taskList[j][0]){
                    cWorking = false;
                }
                if(jWorking && jEnd <= taskList[j][0]){
                    jWorking = false;
                }

                if(!cWorking){
                    cWorking = true;
                    cStart = taskList[j][0];
                    cEnd = taskList[j][1];
                    output.append('C');
                } else if(!jWorking){
                    jWorking = true;
                    jStart = taskList[j][0];
                    jEnd = taskList[j][1];
                    output.append('J');
                } else {
                    possible = false;
                }
            }

            if(possible)
                System.out.println("Case #"+ (i+1) + ": " + output.toString() );
            else
                System.out.println("Case #"+ (i+1) + ": " + "IMPOSSIBLE" );
        }
    }


}


