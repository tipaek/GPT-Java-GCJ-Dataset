import java.util.Scanner;
import java.util.Arrays;
class Start
{
    int time;
    int ogPos;
    
    public Start(int time, int ogPos)
    {
        this.time = time;
        this.ogPos = ogPos;
    }
}
class End
{
    int time;
    int ogPos;
    
    public End(int time, int ogPos)
    {
        this.time = time;
        this.ogPos = ogPos;
    }
}
public class Solution
{
    public static String solve(int[] start, int[] end)
    {
        Start[] startTimes = new Start[start.length];
        End[] endTimes = new End[start.length];
        
        for (int i = 0; i < start.length; i++)
        {
            startTimes[i] = new Start(start[i], i);
            endTimes[i] = new End(end[i], i);
        }
        String result = "";
        
        // Bubble sort
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < startTimes.length-1; i++)
            {
                if (startTimes[i].time > startTimes[i+1].time)
                {
                    int tempTime = startTimes[i].time;
                    int tempOg = startTimes[i].ogPos;
                    startTimes[i].time = startTimes[i+1].time;
                    startTimes[i].ogPos = startTimes[i+1].ogPos;
                    startTimes[i+1].time = tempTime;
                    startTimes[i+1].ogPos = tempOg;
                    
                    sorted = false;
                }
            }
        }
        sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < endTimes.length-1; i++)
            {
                if (endTimes[i].time > endTimes[i+1].time)
                {
                    int tempTime = endTimes[i].time;
                    int tempOg = endTimes[i].ogPos;
                    endTimes[i].time = endTimes[i+1].time;
                    endTimes[i].ogPos = endTimes[i+1].ogPos;
                    endTimes[i+1].time = tempTime;
                    endTimes[i+1].ogPos = tempOg;
                    
                    sorted = false;
                }
            }
        }
        
        /*
        int[] allTimes = new int[start.length*2];
        for (int i = 0; i < start.length; i++)
        {
            allTimes[i] = start[i];
        }
        for (int i = 0; i < end.length; i++)
        {
            allTimes[i+start.length] = end[i];
        }
        
        Arrays.sort(allTimes);
        */
       
        Arrays.sort(start);
        Arrays.sort(end);
        
        int startEle = 0;
        int endEle = 0;
        int depth = 0;
        String currentChar = "J";
        
        while (startEle < start.length)
        {
            if (start[startEle] < end[endEle])
            {
                startEle++;
                depth++;
            
                if (currentChar == "J")
                {
                    currentChar = "C";
                }
                else
                {
                    currentChar = "J";
                }
                
                result = result + currentChar;
            }
            else if (start[startEle] > end[endEle])
            {
            
                if (currentChar == "J")
                {
                    currentChar = "C";
                }
                else
                {
                    currentChar = "J";
                }
                
                endEle++;
                depth--;
            }
            else
            {
                startEle++;
                endEle++;
            
                if (currentChar == "J")
                {
                    currentChar = "C";
                }
                else
                {
                    currentChar = "J";
                }
                
                result = result + currentChar;
            }
            
            if (depth > 2)
            {
                return "IMPOSSIBLE";
            }
        }
        
        String sortedResult = "";
        for (int i = 0; i < result.length(); i++)
        {
            int realPos = startTimes[i].ogPos;
            if (i < realPos)
            {
                if (i+1 < result.length())
                    result = result.substring(0, i) + result.substring(realPos, realPos+1) + result.substring(i+1, realPos) + result.substring(i, i+1) + result.substring(realPos+1);
            }
            else if (i > realPos)
            {
                if (realPos+1 < result.length())
                    result = result.substring(0, realPos) + result.substring(i, i+1) + result.substring(realPos+1, i) + result.substring(realPos, realPos+1) + result.substring(i+1);
            }
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