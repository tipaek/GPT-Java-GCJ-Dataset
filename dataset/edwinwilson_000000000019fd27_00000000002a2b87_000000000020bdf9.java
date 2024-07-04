import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numCases = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    String solution = "";

    for(int currentCase = 1; currentCase <= numCases; currentCase++) {
        solution += "Case #" + currentCase + ": ";

        Integer nbTasks = Integer.parseInt(in.nextLine());
        ArrayList<List<Integer>> listC = new ArrayList<>();
        ArrayList<List<Integer>> listJ = new ArrayList<>();
        String currentSolution = "";

        for(int i = 0; i < nbTasks; i++) {
            String[] line = in.nextLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            if(listC.size() == 0) {
                listC.add(Arrays.asList(start, end));
                currentSolution += "C";
                continue;
            }

            if(listJ.size() == 0) {
                listJ.add(Arrays.asList(start, end));
                currentSolution += "J";
                continue;
            }

            Boolean taskAssigned = false;

            for(int j = 0; j < listC.size(); j++) {
                if(start < listC.get(j).get(1) && start > listC.get(j).get(0) || end > listC.get(j).get(0) && end < listC.get(j).get(1) || start < listC.get(j).get(1) && end > listC.get(j).get(1) || start < listC.get(j).get(0) && end > listC.get(j).get(0)) {
                    continue;
                }

                if(j == listC.size() - 1) {
                    listC.add(Arrays.asList(start, end));
                    taskAssigned = true;
                    currentSolution += "C";
                    break;
                }
            }

            if(!taskAssigned) {
                for(int j = 0; j < listJ.size(); j++) {
                    if(start < listJ.get(j).get(1) && start > listJ.get(j).get(0) || end > listJ.get(j).get(0) && end < listJ.get(j).get(1) || start < listJ.get(j).get(1) && end > listJ.get(j).get(1) || start < listJ.get(j).get(0) && end > listJ.get(j).get(0)) {
                        continue;
                    }
    
                    if(j == listJ.size() - 1) {
                        listJ.add(Arrays.asList(start, end));
                        taskAssigned = true;
                        currentSolution += "J";
                        break;
                    }
                }
            }

            if(!taskAssigned) {
                currentSolution = "IMPOSSIBLE";
                break;
            }
        }

        solution += currentSolution + "\n";
    }

    System.out.print(solution);
  }
}
