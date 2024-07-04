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
            int[][] taskList = new int[n][3];
            for(int j=0; j<n; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                taskList[j][0] = start;
                taskList[j][1] = end;
                taskList[j][2] = j;

            }

            Arrays.sort(taskList, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });

            char[] order = new char[n];

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
                    order[taskList[j][2]] = 'C';
                   // output.append('C');
                } else if(!jWorking){
                    jWorking = true;
                    jStart = taskList[j][0];
                    jEnd = taskList[j][1];
                    order[taskList[j][2]] = 'J';
                    //output.append('J');
                } else {
                    possible = false;
                }
            }

            if(possible)
                System.out.println("Case #"+ (i+1) + ": " + new String(order) );
            else
                System.out.println("Case #"+ (i+1) + ": " + "IMPOSSIBLE" );
        }
    }


}


