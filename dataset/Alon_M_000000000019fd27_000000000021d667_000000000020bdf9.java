import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        class Activity {
            public int x;
            public int y;
            public int number;
            public String spot;

            // Constructor
            public Activity(int x, int y,int number)
            {
                this.x = x;
                this.y = y;
                this.number = number;
                this.spot = "";
            }

        }




        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++){

            int n = scanner.nextInt();
            Activity[] matrix = new Activity[n];
            for (int k = 0; k < n; k++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                matrix[k] =new Activity(x,y,k);
            } //filled all activities

            Arrays.sort(matrix, (Activity a1, Activity a2) -> a1.x - a2.x);
            String[] sol = new String[n];
            int cTime = 0;
            int jTime = 0;
            boolean found = false;
            String output = "";

            for (int k = 0; k < n && !found; k ++) {
                if (matrix[k].x >= cTime) {
                    matrix[k].spot = "C";
                    cTime = matrix[k].y;
                } else if (matrix[k].x >= jTime) {
                    matrix[k].spot = "J";
                    jTime = matrix[k].y;
                } else {
                    output = "IMPOSSIBLE";
                    found = true;
                }
            }
            Arrays.sort(matrix, (Activity a1, Activity a2) -> a1.number - a2.number);


            if ( !found ){
                for (Activity act : matrix ){
                    output = output.concat(act.spot);
                }
            }
            int caseNum = i+1;
            System.out.println("Case #" + (caseNum) + ": " + output);






        }
    }

}
