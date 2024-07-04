import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    
    public static int[][] sortedTimes;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        final int CAMERON = 1;
        final int JAMIE = 2;
        for(int i = 0; i < testCases; i++)
        {
            int activityCount = Integer.parseInt(scan.nextLine());
            ArrayList<int[]> cTimes = new ArrayList<>();
            ArrayList<int[]> jTimes = new ArrayList<>();
            int[][] activityTimes = new int[activityCount][3];
            sortedTimes = new int[activityCount][/*3*/2];
            boolean solveable = true;
            String out = "";
            for(int j = 0; j < activityCount; j++)
            {
                String line = scan.nextLine();
                String[] split = line.split(" ");
                activityTimes[j][0] = Integer.parseInt(split[0]);
                activityTimes[j][1] = Integer.parseInt(split[1]);
                //activityTimes[j][2] = 0;
            }
            sort(activityTimes, sortedTimes);
            
            for(int j = 0; j < activityCount; j++)
            {
                if(cTimes.isEmpty())
                {
                    //sortedTimes[j][2] = CAMERON;
                    cTimes.add(sortedTimes[j]);
                }
                else if(jTimes.isEmpty())
                {
                    //sortedTimes[j][2] = JAMIE;
                    jTimes.add(sortedTimes[j]);
                }
                else
                {
                    int startTime = sortedTimes[j][0];
                    int endTime = sortedTimes[j][1];
                    if(cTimes.get(cTimes.size() - 1)[1] <= startTime)
                    {
                        //sortedTimes[j][2] = CAMERON;
                        cTimes.add(sortedTimes[j]);
                    }
                    else if(jTimes.get(jTimes.size() - 1)[1] <= startTime)
                    {
                       // sortedTimes[j][2] = JAMIE;
                        jTimes.add(sortedTimes[j]);
                    }
                    else
                    {
                        solveable = false;
                        break;
                    }
                }
            }
            if(!solveable)
            {
                out = "IMPOSSIBLE";
            }
            else
            {
                for(int j = 0; j < activityTimes.length; j++)
                {
                    if(cTimes.contains(activityTimes[j]))
                    {
                        out = out + "C";
                    }
                    else
                    {
                        out = out + "J";
                    }
                }
            }
            System.out.println("CASE #" + (i+1) + ": " + out);
        }
    }
    public static void sort(int[][] inputArray, int[][] outputArray)
    {
        outputArray = Arrays.copyOf(inputArray, inputArray.length);
        
        Arrays.sort(outputArray, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if(entry1[0] > entry2[0])
                    return 1;
                else 
                    return -1;
            }
        });
        
        sortedTimes = outputArray;
        
        
    }
}