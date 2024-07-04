import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());

        for (int run = 1; run <= runs; run++) {
            int num = Integer.parseInt(console.nextLine());
            int[] starts = new int[num];
            int[] ends = new int[num];

            if (num != 0) {
                for (int i = 0; i < num; i++) {
                    starts[i] = console.nextInt();
                    ends[i] = console.nextInt();
                }
                console.nextLine();
            }

            ArrayList<String> cTimes = new ArrayList<>();
            ArrayList<String> jTimes = new ArrayList<>();
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < num; i++) {
                boolean useC = true;
                boolean useJ = true;

                for (String time : cTimes) {
                    int testStart = Integer.parseInt(time.split(" ")[0]);
                    int testEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((testStart <= starts[i] && testEnd > starts[i]) || (testStart < ends[i] && testEnd >= ends[i]) ||
                        (testStart < starts[i] && testEnd > ends[i]) || (testStart >= starts[i] && testEnd <= ends[i])) {
                        useC = false;
                        break;
                    }
                }

                for (String time : jTimes) {
                    int testStart = Integer.parseInt(time.split(" ")[0]);
                    int testEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((testStart <= starts[i] && testEnd > starts[i]) || (testStart < ends[i] && testEnd >= ends[i]) ||
                        (testStart < starts[i] && testEnd > ends[i]) || (testStart >= starts[i] && testEnd <= ends[i])) {
                        useJ = false;
                        break;
                    }
                }

                String add = starts[i] + " " + ends[i];
                if (useC && !answer.toString().equals("IMPOSSIBLE")) {
                    cTimes.add(0, add);
                    answer.append("C");
                } else if (useJ && !answer.toString().equals("IMPOSSIBLE")) {
                    jTimes.add(0, add);
                    answer.append("J");
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + run + ": " + answer);
        }

        console.close();
    }
}