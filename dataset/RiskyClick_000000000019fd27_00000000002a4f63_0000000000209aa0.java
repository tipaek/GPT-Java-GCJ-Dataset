import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int counter = 1;
        int reps = 1;
        String outcome;
        boolean show;

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();

        while (reps != tests + 1) {
            int leftR = 0;
            int rightL = 0;
            int size = in.nextInt();
            int target = in.nextInt();
            int[][] arr2d = new int[size][size];

            for (int i = 0; i < arr2d.length; i++) {
                counter = i + 1;
                for (int j = 0; j < arr2d.length; j++) {
                    arr2d[i][j] = counter;
                    if (counter == size) {
                        counter = 0;
                    }
                    if(i == j){
                        leftR += arr2d[i][j];
                        rightL += arr2d[i][size - i - 1];
                    }
                    counter++;
                }
            }
            if(leftR == target || rightL == target){
                outcome = "POSSIBLE";
                show = true;
            } else {
                outcome = "IMPOSSIBLE";
                show = false;
            }

            System.out.println("Case #" + reps + ": " + outcome);
            if(show) {
                for (int i = 0; i < arr2d.length; i++) {
                    for (int j = 0; j < arr2d.length; j++) {
                        System.out.print(arr2d[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }
            reps++;
        }
    }
}