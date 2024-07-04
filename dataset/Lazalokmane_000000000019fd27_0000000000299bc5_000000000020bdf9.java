import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sr = new Scanner(System.in);
    public static String solve(Integer[][] tasks) {
        Boolean[] cMinutes = new Boolean[1440];
        Arrays.fill(cMinutes, false);
        Boolean[] jMinutes = new Boolean[1440];
        Arrays.fill(jMinutes, false);
        String result = "";
        for(Integer[] task : tasks) {
            String doer = "C";
            for (int i = task[0]; i < task[1]; i++) {
                if(cMinutes[i] && jMinutes[i]) return "IMPOSSIBLE";
                else if (doer==("C") && cMinutes[i]) doer = "J";
            }
            for (int i = task[0]; i < task[1]; i++) {
                if (doer.equals("C")) cMinutes[i] = true;
                else jMinutes[i] = true;
            }
            result += doer;
        }
        return result;
    }


    public static void main (String[]args){
        int test = sr.nextInt();
        System.out.println();
        int i = 0;
        while (i < test) {
            int n = sr.nextInt();
            Integer[][] tasks = new Integer[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    tasks[j][k] = sr.nextInt();
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(tasks));
            i++;
        }
    }
}
