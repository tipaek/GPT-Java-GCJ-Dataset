import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class Solution {
    
    public static int[][] readInputActivities(Scanner in){
        int numberOfActivities = in.nextInt();
        int[][] activitiesTable = new int[numberOfActivities][4];
        for (int i = 0; i < numberOfActivities; i++) {
            activitiesTable[i][0] = i;
            activitiesTable[i][3] = 0;
        }

        for (int i = 0; i < numberOfActivities; i++) {
            activitiesTable[i][1] = in.nextInt();
            activitiesTable[i][2] = in.nextInt();
        }
        return activitiesTable;
    }

    public static int[][] assignActivitiesForOneTestCase(int[][] activitiesTable, int numberOfActivities){
        int endingOfRecentActivityForJamie = 0;
        int endingOfRecentActivityForCameron = activitiesTable[0][2];

        for (int i = 1; i < numberOfActivities; i++) {

            if (endingOfRecentActivityForCameron <= activitiesTable[i][1]){
                endingOfRecentActivityForCameron = activitiesTable[i][2];
            }
            else if(endingOfRecentActivityForJamie <= activitiesTable[i][1]){
                activitiesTable[i][3] = 1;
                endingOfRecentActivityForJamie = activitiesTable[i][2];
            }
            else{
                return null;
            }
        }
        return activitiesTable;
    }

    public static int[][] sortTableByStartingCertainColumn(int[][] unsortedInputTable, int columnForSorting){
        int[][] sortedTable = unsortedInputTable;
        Arrays.sort(sortedTable, new Comparator<int[]>() {

            @Override
            public int compare(final int[] x,
                               final int[] y) {
                
                if (x[columnForSorting] > y[columnForSorting])
                    return 1;
                else
                    return -1;
            }
        });

        return sortedTable;
    }

    public static String convertDigitsIntoString(int[][] activitiesTable, int numberOfActivities){
        String outputString = "";

        for (int i = 0; i < numberOfActivities; i++) {
            if(activitiesTable[i][3] == 0){
                outputString += "C";
            }
            else{
                outputString += "J";
            }
        }
        return outputString;
    }

    public static ArrayList<int[][]> createArrayListOfAllTestCases(Scanner in){
        ArrayList<int[][]> arrayListOfAllTestCases = new ArrayList<>();
        int numberOfTestCases = in.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            arrayListOfAllTestCases.add(readInputActivities(in));
        }
        return  arrayListOfAllTestCases;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<int[][]> arrayListOfAllTestCases = createArrayListOfAllTestCases(in);
        String output;
        int caseCounter = 1;

        for (int[][] activitiesTable: arrayListOfAllTestCases) {
            output = "Case #" + caseCounter + ": ";
            activitiesTable = sortTableByStartingCertainColumn(activitiesTable,1);
            activitiesTable = assignActivitiesForOneTestCase(activitiesTable,activitiesTable.length);
            if(activitiesTable == null){
                output += "IMPOSSIBLE";
            }else{
                activitiesTable = sortTableByStartingCertainColumn(activitiesTable,0);
                output += convertDigitsIntoString(activitiesTable, activitiesTable.length);
            }
            System.out.println(output);
            caseCounter++;
        }
    }
}
