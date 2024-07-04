import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(new BufferedReader(new FileReader("c.in")));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = in.nextLine();
        int numCases = Integer.parseInt(line);

        for (int i = 0; i < numCases; i++) {
            line = in.nextLine();
            int N = Integer.parseInt(line);
            String scheduleBusyC = "";
            String scheduleBusyJ = "";
            String result = "";
            for (int j = 0; j < N; j++) {
                line = in.nextLine();
                boolean isBusyC = false;
                if (scheduleBusyC.equals("")) {
                    scheduleBusyC += line;
                    result += "C";
                } else {
                    //Validate schedule C
                    String[] ranges = scheduleBusyC.split(",");
                    for (int k = 0; k < ranges.length && !isBusyC; k++) {
                        String[] newActivity = line.split(" ");
                        String[] currentActivity = ranges[k].split(" ");
                        if ((Integer.parseInt(newActivity[0]) >= Integer.parseInt(currentActivity[0])
                                && Integer.parseInt(newActivity[0]) < Integer.parseInt(currentActivity[1]))
                                || (Integer.parseInt(newActivity[1]) < Integer.parseInt(currentActivity[1])
                                && Integer.parseInt(newActivity[1]) >= Integer.parseInt(currentActivity[0]))
                                || (Integer.parseInt(newActivity[0]) < Integer.parseInt(currentActivity[0])
                                && Integer.parseInt(newActivity[1]) > Integer.parseInt(currentActivity[1]))) {
                            isBusyC = true;
                        }
                    }
                    if (!isBusyC) {
                        result += "C";
                        scheduleBusyC += "," + line;
                    } else {
                        if (scheduleBusyJ.equals("")) {
                            scheduleBusyJ += line;
                            result += "J";
                        } else {
                            boolean isBusyJ = false;
                            //Validate schedule C
                            ranges = scheduleBusyJ.split(",");
                            for (int k = 0; k < ranges.length && !isBusyJ; k++) {
                                String[] newActivity = line.split(" ");
                                String[] currentActivity = ranges[k].split(" ");
                                if ((Integer.parseInt(newActivity[0]) >= Integer.parseInt(currentActivity[0])
                                        && Integer.parseInt(newActivity[0]) < Integer.parseInt(currentActivity[1]))
                                        || (Integer.parseInt(newActivity[1]) < Integer.parseInt(currentActivity[1])
                                        && Integer.parseInt(newActivity[1]) >= Integer.parseInt(currentActivity[0]))
                                        || (Integer.parseInt(newActivity[0]) < Integer.parseInt(currentActivity[0])
                                        && Integer.parseInt(newActivity[1]) > Integer.parseInt(currentActivity[1]))) {
                                    isBusyJ = true;
                                }
                            }
                            if (!isBusyJ) {
                                result += "J";
                                scheduleBusyJ += "," + line;
                            } else {
                                result = "IMPOSSIBLE";
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}
