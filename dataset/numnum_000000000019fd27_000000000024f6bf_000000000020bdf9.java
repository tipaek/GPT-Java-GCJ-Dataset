import java.util.Scanner;
import java.util.ArrayList;

public class Solution
{
    public static String solve(int[] start, int[] end)
    {
        String result = "";
        
        int[] starts = new int[1441];
        int[] ends = new int[1441];
        ArrayList<Integer>[] id = new ArrayList[1441];
        String[] resultArr = new String[start.length];
        for (int i = 0; i < id.length; i++)
        {
            id[i] = new ArrayList<Integer>();
        }
        int depth = 0;
        String current = "J";
        
        for (int i = 0; i < start.length; i++)
        {
            starts[start[i]]++;
            ends[end[i]]++;
            id[start[i]].add(i);
        }
        
        for (int i = 0; i < starts.length; i++)
        {
            depth += starts[i]-ends[i];
            
            
            if (ends[i] >= 1 && starts[i] == 0)
            {
                if (ends[i] % 2 == 1)
                {
                    if (current == "J")
                        current = "C";
                    else
                        current = "J";
                }
            }
            
            while (starts[i] >= 1)
            {
                resultArr[id[i].get(0)] = current;
                id[i].remove(0);
                for (int j = 0; j < id[i].size()-1; i++)
                {
                    id[i].set(j, id[i].get(j+1));
                }
                
                    if (current == "J")
                        current = "C";
                    else
                        current = "J";
                starts[i]--;
            }
            
            
            if (depth > 2)
            {
                return "IMPOSSIBLE";
            }
        }
        
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