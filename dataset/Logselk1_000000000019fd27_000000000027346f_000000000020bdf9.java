import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nbCases = Integer.parseInt(bufferedReader.readLine());

        for(int iCases = 0; iCases < nbCases; iCases++) {
            boolean cBusy = false, jBusy = false, impossible = false;
            int cEnd = -1, jEnd = -1;
            String solution = "";
            int nbTask = Integer.parseInt(bufferedReader.readLine());
            ArrayList<Pair> pairs = new ArrayList<>();

            for(int iTask = 0; iTask < nbTask; iTask++) {
                String [] readLine = bufferedReader.readLine().split(" ");
                pairs.add(new Pair(Integer.parseInt(readLine[0]), Integer.parseInt(readLine[1]), iTask));
            }

            Collections.sort(pairs);

            int iTime = 0;
            while(iTime < nbTask && !impossible) {
                if(cEnd <= pairs.get(iTime).getStartTime()) {
                    cBusy = false;
                    cEnd = -1;
                }
                if(jEnd <= pairs.get(iTime).getStartTime()) {
                    jBusy = false;
                    jEnd = -1;
                }

                if(cBusy && jBusy) {
                    impossible = true;
                } else {
                    if(cBusy) {
                        solution += "J";
                        jBusy = true;
                        jEnd = pairs.get(iTime).getEndTime();
                    } else {
                        solution += "C";
                        cBusy = true;
                        cEnd = pairs.get(iTime).getEndTime();
                    }
                }
                iTime++;
            }

            if(impossible) {
                solution = "IMPOSSIBLE";
            } else {
                char [] newSolution = new char [nbTask];
                for(int iTask = 0; iTask < nbTask; iTask++) {
                    newSolution [pairs.get(iTask).getOldIndex()] = solution.charAt(iTask);
                }
                solution = new String(newSolution);
            }

            System.out.println("Case #" + (iCases + 1) + ": " + solution);
        }
    }

    static class Pair implements Comparable<Pair>{
        int startTime;
        int endTime;
        int oldIndex;

        public Pair(int startTime, int endTime, int oldIndex) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.oldIndex = oldIndex;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getOldIndex() {
            return oldIndex;
        }

        public void setOldIndex(int oldIndex) {
            this.oldIndex = oldIndex;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.startTime - pair.getStartTime();
        }
    }
}
