import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for(int i=0; i<T; i++){

            StringBuilder y = new StringBuilder();

            int N = in.nextInt();

            int[][] activities = new int[N][2];
            int[][] activitiesOrdered = new int[N][2];
            char[] assignedActivitie = new char[N];
            char[] assignedActivitieOrdered = new char[N];
            int[] lastC = {0,0};
            int[] lastJ = {0,0};
            boolean impossible = false;


            for(int j=0; j<N; j++){
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activitiesOrdered[j][0] = activities[j][0];
                activitiesOrdered[j][1] = activities[j][1];
            }

            Arrays.sort(activitiesOrdered, (t1, t2) -> {
                if(t1[0] > t2[0])
                    return 1;
                else if(t1[0] == t2[0]){
                    if(t1[1] > t2[1])
                        return 1;
                    else if(t1[0] == t2[1])
                        return 0;
                }
                return -1;
            });


            lastC = activitiesOrdered[0];
            assignedActivitieOrdered[0] = 'C';

            for(int j=1; j<N; j++){
                if(activitiesOrdered[j][0] >= lastC[1]) {
                    assignedActivitieOrdered[j] = 'C';
                    lastC = activitiesOrdered[j];
                }
                else if(activitiesOrdered[j][0] >= lastJ[1]) {
                    assignedActivitieOrdered[j] = 'J';
                    lastJ = activitiesOrdered[j];
                }
            }

            for(char character: assignedActivitieOrdered){
                if (character != 'C' && character != 'J') {
                    impossible = true;
                    break;
                }
            }

            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(Arrays.equals(activities[j], activitiesOrdered[k])){
                        assignedActivitie[j] = assignedActivitieOrdered[k];
                        break;
                    }
                }

            }

            if(impossible)
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            else {
                y.append(assignedActivitie);
                System.out.println("Case #" + (i + 1) + ": " + y);
            }
        }
    }


}

