import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
            ArrayList<int[]> activitiesOrdered = new ArrayList<>();
            char[] assignedActivitie = new char[N];
            ArrayList<Character> assignedActivitieOrdered = new ArrayList<>();
            int[] lastC = {0,0};
            int[] lastJ = {0,0};
            boolean impossible = false;


            for(int j=0; j<N; j++){
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activitiesOrdered.add(activities[j]);
            }

            activitiesOrdered.sort((t1, t2) -> {
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


            lastC = activitiesOrdered.get(0);
            assignedActivitieOrdered.add('C');

            for(int j=1; j<N; j++){
                if(activitiesOrdered.get(j)[0] >= lastC[1]) {
                    assignedActivitieOrdered.add('C');
                    lastC = activitiesOrdered.get(j);
                }
                else if(activitiesOrdered.get(j)[0] >= lastJ[1]) {
                    assignedActivitieOrdered.add('J');
                    lastJ = activitiesOrdered.get(j);
                }
            }

            if(assignedActivitieOrdered.size()<N) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                break;
            }

            int size = N;

            for(int j=0; j<N; j++){
                for(int k=0; k<size; k++){
                    if(Arrays.equals(activities[j], activitiesOrdered.get(k))) {
                        assignedActivitie[j] = assignedActivitieOrdered.get(k);
                        activitiesOrdered.remove(k);
                        assignedActivitieOrdered.remove(k);
                        size--;
                        break;
                    }
                }

            }


            y.append(assignedActivitie);
            System.out.println("Case #" + (i + 1) + ": " + y);

        }
    }


}

