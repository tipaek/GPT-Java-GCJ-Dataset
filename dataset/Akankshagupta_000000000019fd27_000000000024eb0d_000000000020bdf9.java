
import java.util.Scanner;
import java.lang.StringBuilder;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());

         if(cases <= 0)
         return;

        for (int noOfCases = 0; noOfCases < cases; noOfCases++) {
            int noOfActivities = Integer.parseInt( in .nextLine());
             if(noOfActivities <=0)
            continue;
            int[] start= new int[noOfActivities];
            int[] end = new int[noOfActivities];
            int[] index = new int[noOfActivities];
            for (int activities = 0; activities < noOfActivities; activities++) {
                String[] startAndEndTime = in .nextLine().split(" ");
                start[activities] = Integer.parseInt(startAndEndTime[0]);
                end[activities] = Integer.parseInt(startAndEndTime[1]);
                index[activities] = activities;
            }

            bubbleSort(end, start, index);

            int cameron = -1, jamie = -1;

            StringBuilder output = new StringBuilder();

            char[] outputChar = new char[noOfActivities];
    
            for (int assigne = 0; assigne < noOfActivities; assigne++) {

                if (cameron == -1 || start[assigne] >= end[cameron] ) {
                    outputChar[index[assigne]] = 'C';
            
                    cameron = assigne;
                  
                    continue;
                } else if (jamie == -1 || start[assigne]>= end[jamie]) {
                    outputChar[index[assigne]] = 'J';
                    jamie = assigne;
                
                    continue;
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }

            }

            if (output.toString().equals("IMPOSSIBLE")) {
                System.out.println("Case #" + (noOfCases + 1) + ": " + output.toString());
            } else {
                    
                System.out.println("Case #" + (noOfCases + 1) + ": " + String.valueOf(outputChar));

                }

                
    
        }


    }

    static void bubbleSort(int[] end, int[] start, int[] index) {
        int n = end.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (start[j] > start[j + 1]) {
                    // swap arr[j+1] and arr[i] 
                    int temp = end[j];
                    end[j] = end[j + 1];
                    end[j + 1] = temp;
                    int tempStart = start[j];
                    start[j] = start[j + 1];
                    start[j + 1] = tempStart;

                    int tempIndex = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = tempIndex;
                }
            }
        }    
    }

}