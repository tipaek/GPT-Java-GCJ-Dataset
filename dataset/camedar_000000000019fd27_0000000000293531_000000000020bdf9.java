import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String... args){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int[] cameron = new int[2];
        int[] jaimie = new int[2];
        int startingTime, endingTime;
        String resultingString;
        String strRange;
        String[] rangeInMinutes;
        int n;
        in.nextLine();
        for(int i=1;i<=t;i++){
            cameron[0] = cameron[1]=0;
            jaime[0] = jaimie[1] = 0;
            startingTime = endingTime = 0;
            resultingString = "";
            n = in.nextInt();
            in.nextLine();
            for (int j = 0; j < n; j++) {
                strRange = in.nextLine();
                rangeInMinutes = strRange.split(" ");
                startingTime = Integer.parseInt(rangeInMinutes[0]);
                endingTime = Integer.parseInt(rangeInMinutes[1]);

                if(((cameron[0] + cameron[1]) == 0) || cameron[0] >= endingTime || cameron[1] <= startingTime ){//is Cameron available
                    cameron[1] = endingTime;
                    cameron[0] = startingTime;
                    resultingString += "C";
                } else if(((jaimie[0] + jaimie[1]) == 0) || jaimie[1] <= startingTime || jaimie[0] >= endingTime) {//is Jaimie available
                    jaimie[1] = endingTime;
                    jaimie[0] = startingTime;
                    resultingString += "J";
                } else {
                    resultingString = "IMPOSSIBLE";
                    break;
                }
            }
            // Output response for each test case
            System.out.println("Case #" + i + ": " + resultingString);
        }

    }
}