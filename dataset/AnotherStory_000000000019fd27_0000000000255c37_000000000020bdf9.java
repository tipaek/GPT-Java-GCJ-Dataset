import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int ts = 0; ts < t; ts++) {
            String answer = "";
            boolean answerPossible = true;
            int n = in.nextInt();

            int arr[][] = new int[n][2];
            int originalArray[][] = new int[n][2];

            for(int i = 0; i < n; i++)
                for(int j = 0; j < 2; j++){
                    arr[i][j] = in.nextInt();
                    originalArray[i][j] = arr[i][j];
                }

            Arrays.sort(arr, new Comparator<int[]>() { 

                @Override
                public int compare(final int[] row1, final int[] row2) {
                    if (row1[0] > row2[0])
                        return 1;
                    else
                        return -1;
                }
            });

            int assignment[] = new int[n];
            assignment[0] = 0;

            for(int i = 1; i < n; i++) {
                // int startIndex = arr[i][0];
                int parentIndex = -1;
                int numberOfParents = 0;

                for(int j = 0; j < i; j++) {
                    if(arr[i][0] >= arr[j][0] && arr[i][0] < arr[j][1]){
                        numberOfParents++;
                        parentIndex = assignment[j];
                        // System.out.println("Parent of " + arr[i][0] + " = " + arr[j][0] + " , " + arr[j][1]);
                    }
                }

                if(numberOfParents == 0){
                    assignment[i] = 0;
                }
                else if(numberOfParents == 1) {
                    assignment[i] = 1 - parentIndex;
                }
                else {
                    answer = "IMPOSSIBLE";
                    answerPossible = false;
                    break;
                }
            }

            if(answerPossible){
                for(int i = 0; i < n; i++) {
                    int startIndex = originalArray[i][0];
                    int endIndex = originalArray[i][1];

                    for(int j = 0; j < n; j++) {
                        if(arr[j][0] == startIndex && arr[j][1] == endIndex){
                            if(assignment[j] == 0){
                                answer += "C";
                            }
                            else
                                answer += "J";
                        }
                    }
                }
            }

            System.out.println("Case #" + (ts+1) + ": " + (answer));
        }
    }
}