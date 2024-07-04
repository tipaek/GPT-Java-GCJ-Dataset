import java.util.Scanner;
import java.util.Arrays;
class Time
{
    int start;
    int end;
    int ogPos;
    
    public Time(int start, int end, int ogPos)
    {
        this.start = start;
        this.end = end;
        this.ogPos = ogPos;
    }
}
public class Solution
{
    public static String solve(int[] start, int[] end)
    {
        Time[] times = new Time[start.length];
        String[] resultArr = new String[start.length];
        String result = "";
        
        for (int i = 0; i < start.length; i++)
        {
            times[i] = new Time(start[i], end[i], i);
        }
        
        // Bubbles sort
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < times.length-1; i++)
            {
                if (times[i].start > times[i+1].start)
                {
                    int tempStart = times[i].start;
                    int tempEnd = times[i].end;
                    int tempOg = times[i].ogPos;
                    times[i].start = times[i+1].start;
                    times[i].end = times[i+1].end;
                    times[i].ogPos = times[i+1].ogPos;
                    times[i+1].start = tempStart;
                    times[i+1].end = tempEnd;
                    times[i+1].ogPos = tempOg;
                    
                    sorted = false;
                }
            }
        }
        
        boolean depth1Taken = false;
        boolean depth2Taken = false;
        int depth1End = 0;
        int depth2End = 0;
        
        for (int i = 0; i < times.length; i++)
        {
            // Free up "ended" depths
            if (depth1Taken && depth1End <= times[i].start)
            {
                depth1Taken = false;
            }
            if (depth2Taken && depth2End <= times[i].start)
            {
                depth2Taken = false;
            }
            
            // Fill up the depths
            if (!depth1Taken)
            {
                depth1End = times[i].end;
                depth1Taken = true;
                resultArr[times[i].ogPos] = "C";
            }
            else if (!depth2Taken)
            {
                depth2End = times[i].end;
                depth2Taken = true;
                resultArr[times[i].ogPos] = "J";
            }
            else
            {
                return "IMPOSSIBLE";
            }
        }
        
        // Build up the final String
        for (int i = 0; i < resultArr.length; i++)
        {
            result = result + resultArr[i];
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int size = input.nextInt();
            input.nextLine();
            int[] start = new int[size];
            int[] end = new int[size];
            for (int i = 0; i < size; i++)
            {
                String newLine = input.nextLine();
                int spaceLoc = newLine.indexOf(" ");
                String firstEntry = newLine.substring(0, spaceLoc);
                String secondEntry = newLine.substring(spaceLoc + 1);
                int firstNum = 0;
                int secondNum = 0;
                int ele = 0;
                for (int j = firstEntry.length()-1; j >= 0; j--)
                {
                    firstNum += Character.getNumericValue(firstEntry.charAt(j))*Math.pow(10, ele);
                    ele++;
                }
                ele = 0;
                for (int j = secondEntry.length()-1; j >= 0; j--)
                {
                    secondNum += Character.getNumericValue(secondEntry.charAt(j))*Math.pow(10, ele);
                    ele++;
                }
                ele = 0;
                start[i] = firstNum;
                end[i] = secondNum;
            }
            System.out.println("Case #" + ks + ": " + solve(start, end));
        }
    }
}