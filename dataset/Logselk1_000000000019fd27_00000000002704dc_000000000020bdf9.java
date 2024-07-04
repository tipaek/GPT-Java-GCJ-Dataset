import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nbCases = Integer.parseInt(bufferedReader.readLine());

        for(int iCases = 0; iCases < nbCases; iCases++) {
            boolean cBusy = false, jBusy = false, impossible = false;
            int cEnd = -1, jEnd = -1;
            String solution = "";
            int nbTask = Integer.parseInt(bufferedReader.readLine());
            ArrayList<Integer> startTimeUnordered = new ArrayList<>();
            ArrayList<Integer> endTimeUnordered = new ArrayList<>();
            ArrayList<Integer> startTimeOrdered = new ArrayList<>();
            ArrayList<Integer> endTimeOrdered = new ArrayList<>();

            for(int iTask = 0; iTask < nbTask; iTask++) {
                String [] readLine = bufferedReader.readLine().split(" ");
                startTimeUnordered.add(Integer.parseInt(readLine[0]));
                endTimeUnordered.add(Integer.parseInt(readLine[1]));
            }
            
            startTimeOrdered.addAll(startTimeUnordered);
            endTimeOrdered.addAll(endTimeUnordered);

            int tempStart, tempEnd;
            for(int iTask = 0; iTask < nbTask - 1; iTask++) {
                for(int jTask = iTask + 1; jTask < nbTask; jTask++) {
                    if(startTimeOrdered.get(iTask) > startTimeOrdered.get(jTask)) {
                        tempStart = startTimeOrdered.get(iTask);
                        tempEnd = endTimeOrdered.get(iTask);
                        startTimeOrdered.set(iTask, startTimeOrdered.get(jTask));
                        startTimeOrdered.set(jTask, tempStart);
                        endTimeOrdered.set(iTask, endTimeOrdered.get(jTask));
                        endTimeOrdered.set(jTask, tempEnd);
                    }
                }
            }

            int iTime = 0;
            while(iTime < nbTask && !impossible) {
                if(cEnd <= startTimeOrdered.get(iTime)) {
                    cBusy = false;
                    cEnd = -1;
                }
                if(jEnd <= startTimeOrdered.get(iTime)) {
                    jBusy = false;
                    jEnd = -1;
                }

                if(cBusy && jBusy) {
                    impossible = true;
                } else {
                    if(cBusy) {
                        solution += "J";
                        jBusy = true;
                        jEnd = endTimeOrdered.get(iTime);
                    } else {
                        solution += "C";
                        cBusy = true;
                        cEnd = endTimeOrdered.get(iTime);
                    }
                }
                iTime++;
            }

            if(impossible) {
                System.out.println("Case #" + (iCases + 1) + ": " + "IMPOSSIBLE");
            } else {
                String newSolution = "";
                for(int iTask = 0; iTask < nbTask; iTask++) {
                    int index = startTimeOrdered.indexOf(startTimeUnordered.get(iTask));
                    if(index == iTask || endTimeOrdered.get(index).equals(endTimeUnordered.get(iTask))) {
                        newSolution += solution.charAt(index);
                    }
                }
                System.out.println("Case #" + (iCases + 1) + ": " + newSolution);
            }
        }
    }
}
