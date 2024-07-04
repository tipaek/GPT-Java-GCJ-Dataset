import java.util.*;
import java.io.*;

/**
 Timo Hromadka
- C will always be assigned to the first task, J second, C third, and so on.
 */
public class Solution3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int count = in.nextInt();
        for (int i = 1; i <= count; ++i) {
            String result = "";
            int numActivities = in.nextInt();

            char[] finalChars = new char[numActivities];
            Arrays.fill(finalChars, 'C');
            ArrayList<Integer> startTimes = new ArrayList<>();
            ArrayList<Integer> endTimes = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) { // populate start and end time arrays accordingly
                String stringTime = in.next();
                stringTime += in.nextLine();
                String[] stringTimeArr = stringTime.split(" ");

                startTimes.add(Integer.parseInt(stringTimeArr[0]));
                endTimes.add(Integer.parseInt(stringTimeArr[1]));
            }

            // handle corner case where numActivites == 2
            if (numActivities == 2) result = "CJ";

            else {
                // run through the first case
                finalChars[getMinIndex(startTimes)] = 'C';
                int cPastTimeInd = getMinIndex(startTimes); // assign the most recent time
                startTimes.set(cPastTimeInd, 1441);

                // run through the second case
                finalChars[getMinIndex(startTimes)] = 'J';
                int jPastTimeInd = getMinIndex(startTimes); // assign the most recent time
                startTimes.set(jPastTimeInd, 1441);

                boolean cameron = false; // cameron is available
                boolean jamie = false; // jamie is available
                int counter = 2;

                while (counter < numActivities) {
                    int minIndex = getMinIndex(startTimes);
                    // check who is available

                    if (endTimes.get(cPastTimeInd) <= startTimes.get(minIndex)) {
                        cameron = true;
                    }
                    if (endTimes.get(jPastTimeInd) <= startTimes.get(minIndex)) {
                        jamie = true;
                    }

                    if (cameron) { // cameron's turn
                        if (startTimes.get(minIndex) >= endTimes.get(cPastTimeInd)) { // success
                            finalChars[minIndex] = 'C';
                            cPastTimeInd = minIndex; // assign the most recent time
                            startTimes.set(cPastTimeInd, 1441);
                            cameron = false;
                        } else {
                            result = "IMPOSSIBLE";
                            break;
                        }
                    } else if (jamie) {
                        if (startTimes.get(minIndex) >= endTimes.get(jPastTimeInd)) { // success
                            finalChars[minIndex] = 'J';
                            jPastTimeInd = minIndex; // assign the most recent time
                            startTimes.set(jPastTimeInd, 1441);
                            jamie = false;
                        } else {
                            result = "IMPOSSIBLE";
                            break;
                        }
                    }
                    else { // neither cameron nor jamie are available
                        result = "IMPOSSIBLE";
                        break;
                    }
                    counter++;
                }
            }


                if (result.equals("IMPOSSIBLE")) System.out.println("Case #" + i + ": IMPOSSIBLE");
                else if (result.equals("CJ")) System.out.println("Case #" + i + ": CJ");
                else {
                    StringBuilder sb = new StringBuilder();
                    for (char c : finalChars) sb.append(c);
                    result += sb.toString();
                    System.out.println("Case #" + i + ": " + result);
                }
            }
        }


    /**
     * @param list, the list to be passed in
     * @return int, the index of the minimum value in the list
     */
    public static int getMinIndex(ArrayList<Integer> list) {
        int index = 0; // assign index to be 0 initially
        for (int i = 1; i<list.size(); i++) index = (list.get(index) <= list.get(i)) ? index : i;
        return index;
    }
}