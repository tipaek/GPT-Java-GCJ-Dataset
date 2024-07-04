import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int countTasks = in.nextInt();
            
            int[][] tasks = new int[countTasks][2];
            
            for (int j = 0; j < countTasks; j++) {
                int timeStart = in.nextInt();
                int timeFinish = in.nextInt();
                
                tasks[j][0] = timeStart;
                tasks[j][1] = timeFinish;
            }
            
            System.out.println("Case #" + index + ": " + "IMPOSSIBLE");
            //System.out.println(run(tasks, i));
        }
    }
    
    public static String run(int[][] tasks, int index)
    {
        int minTimeFinish = -1, n = tasks.length, minTimeStart, minIndex;

        char[] result = new char[n];

        while (true) {
            minIndex = -1;
            minTimeStart = 1440;

            for (int i = 0; i < n; i++) {
                if (result[i] == 'C') continue;

                if (minIndex == -1 && tasks[i][0] >= minTimeFinish) {
                    minTimeStart = tasks[i][0];
                    minIndex = i;
                }

                if (tasks[i][0] <= minTimeStart && tasks[i][0] >= minTimeFinish) {
                    minTimeStart = tasks[i][0];

                    if (tasks[i][1] < tasks[minIndex][1]) {
                        minIndex = i;
                    }
                }
            }

            if (minIndex == -1) break;

            minTimeFinish = tasks[minIndex][1];

            result[minIndex] = 'C';
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == 'C') continue;

            for (int j = 0; j < n; j++) {
                if (j == i || result[j] == 'C') continue;

                if (tasks[i][0] == tasks[j][0] || tasks[i][1] == tasks[j][1]) {
                    return "Case #" + index + ": " + "IMPOSSIBLE";
                }

                if (tasks[i][0] > tasks[j][0]) {
                    if (tasks[j][1] > tasks[i][0]) {
                        return "Case #" + index + ": " + "IMPOSSIBLE";
                    }
                }

                if (tasks[j][0] > tasks[i][0]) {
                    if (tasks[i][1] > tasks[j][0]) {
                        return "Case #" + index + ": " + "IMPOSSIBLE";
                    }
                }
            }

            result[i] = 'J';
        }

        return "Case #" + index + ": " + (new String(result));
    }
    
    public static void printMatrix(int[][] result)
    {
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            printArray(result[i]);
        }
    }

    public static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}