import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.lang.StringBuilder;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt( in .nextLine());
        System.out.println("No of cases  " + cases);

        for (int noOfCases = 0; noOfCases < cases; noOfCases++) {
            int noOfActivities = Integer.parseInt( in .nextLine());
            System.out.println("No of activities  " + noOfActivities);
            int[] start = new int[noOfActivities];
            int[] end = new int[noOfActivities];
            for (int activities = 0; activities < noOfActivities; activities++) {
                String[] startAndEndTime = in .nextLine().split(" ");
                start[activities] = Integer.parseInt(startAndEndTime[0]);
                end[activities] = Integer.parseInt(startAndEndTime[1]);
            }

            for (int activities = 0; activities < noOfActivities; activities++) {
                System.out.println("startAndEndTime" + start[activities] + " " + end[activities]);
            }
            bubbleSort(end, start);

            int cameron = 0, jamie = -1;

            StringBuilder output = new StringBuilder("C");

            for (int assigne = 1; assigne < noOfActivities; assigne++) {

                if (end[cameron] < start[assigne]) {
                    output.append("C");
                    cameron = assigne;
                    continue;
                } else if (jamie == -1) {
                    output.append("J");
                    jamie = assigne;
                    continue;
                } else if (end[jamie] < start[assigne]) {
                        output.append("J");
                        jamie = assigne;
                        continue;
                    } else {
                        output = new StringBuilder("IMPOSSIBLE");
                        break;
                    }

                }

                System.out.println("Case " + noOfCases + 1 + ": " + output.toString());
            }
        }
        
        static void bubbleSort(int[] end, int[] start) {
            int n = end.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (end[j] > end[j + 1]) {
                        // swap arr[j+1] and arr[i] 
                        int temp = end[j];
                        end[j] = end[j + 1];
                        end[j + 1] = temp;
                        int tempStart = start[j];
                        start[j] = start[j + 1];
                        start[j + 1] = tempStart;
                    }
        }

    }
