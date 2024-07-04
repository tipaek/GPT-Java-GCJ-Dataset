import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        int numOfTests = input.nextInt ();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            int numOfActivities = input.nextInt();
            int[][] activityTimes = new int[numOfActivities][2];
            for (int i = 0; i < numOfActivities; i++) {
                activityTimes[i][0] = input.nextInt();
                activityTimes[i][1] = input.nextInt();
            }
            
            int[] tracker = sortAndTrack (activityTimes);
            
            int CEnd = 0;
            int JEnd = 0;
            boolean impossible = false;
            String[] plan = new String[numOfActivities];
            for (int i = 0; i < numOfActivities; i++) {
                if (CEnd <= activityTimes[i][0]) {
                    plan[tracker[i]] = "C";
                    CEnd = activityTimes[i][1];
                } else if (JEnd <= activityTimes[i][0]) {
                    plan[tracker[i]] = "J";
                    JEnd = activityTimes[i][1];
                } else {
                    impossible = true;
                    break;
                }
            }
            
            String output = "";
            if (impossible) 
                output = "IMPOSSIBLE";
            else {
                for (int i = 0; i < numOfActivities; i++) {
                    output += plan[i];
                }
            }
            
            System.out.println("Case #" + currentTest + ": " + output);
        }
    }
    
    //modified from https://www.geeksforgeeks.org/insertion-sort/
    static int[] sortAndTrack(int[][] arr) 
    {
        int[] tracker = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            tracker[i] = i;
        
        for (int i = 1; i < arr.length; i++) { 
            int key = arr[i][0];
            int other = arr[i][1];
            int trackerKey = tracker[i];
            
            int j = i - 1; 
            while (j >= 0 && arr[j][0] > key) { 
                arr[j + 1][0] = arr[j][0];
                arr[j + 1][1] = arr[j][1];
                tracker[j + 1] = tracker[j];
                
                j = j - 1; 
            } 
            arr[j + 1][0] = key; 
            arr[j + 1][1] = other;
            tracker[j + 1] = trackerKey;
        } 
        return tracker;
    } 
}