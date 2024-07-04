import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = Integer.parseInt(scanner.nextLine());

        String[] outputs = new String[numberOfCases];
        String output = "";
        for (int i = 0; i < numberOfCases; i++) {
            outputs[i] = "Case #" + (i + 1) + ": " + makeSchedule(scanner);
        }

        for (int i = 0; i < numberOfCases; i++) {
            System.out.println(outputs[i]);
        }
    }
    public static String makeSchedule(Scanner scanner) {
        String [] activities = new String[Integer.parseInt(scanner.nextLine())];
        List<int[]> cameronsJobs = new ArrayList<>();
        List<int[]> jamiesJobs = new ArrayList<>();
        String output = "";

        for (int i = 0; i < activities.length; i++) {
            activities[i] = scanner.nextLine(); //save all inputs
        }
        //let cameron take all jobs she can, and let jamie take all jobs cameron can't take
        for (int i = 0; i < activities.length ; i++) {
            String activity = activities[i];
            int startingTime = Integer.parseInt(activity.substring(0 ,activity.indexOf(" ")));
            int endingTime = Integer.parseInt(activity.substring(activity.indexOf(" ") + 1));
            boolean cameronBusy = false;
            boolean jamieBusy = false;
            for (int[] cameronJob : cameronsJobs) {
                //either start or end time overapse with one job
                if (startingTime >= cameronJob[0] && startingTime < cameronJob[1]
                        || endingTime > cameronJob[0] && endingTime <= cameronJob[1]) {
                    cameronBusy = true;
                }
            }
                //cameron busy, lets askk jamie if he can do
            if (cameronBusy) {
                for (int[] jamiejob : jamiesJobs) {
                    //either start or end time overapse with one job
                    if (startingTime >= jamiejob[0] && startingTime < jamiejob[1]
                            || endingTime > jamiejob[0] && endingTime <= jamiejob[1]) {
                        jamieBusy = true;
                    }
                }
                if (jamieBusy) {
                    //jamie is busy too, scheduling is impossible
                    output = "IMPOSSIBLE";
                    break;
                } else {
                    //jamie is not busy, he can take the job
                    jamiesJobs.add(new int[]{startingTime, endingTime});
                    output += "J";
                }
            } else {
                //cameron not busy, she takes the job
                cameronsJobs.add(new int[]{startingTime, endingTime});
                output += "C";
            }
            //another job scheduled, turn flag off
            jamieBusy = false;
            cameronBusy = false;
        }
        return output;
    }
}
