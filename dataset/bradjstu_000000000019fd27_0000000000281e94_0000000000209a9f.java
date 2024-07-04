import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCases; i++)
        {
            runTestCase(i, in);
        }
    }

    private static void runTestCase(int testCaseNumber, Scanner in)
    {
        String str = in.nextLine();

        int nestLevel = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < str.length(); i++)
        {
            char numChar  = str.charAt(i);
            int num = Character.getNumericValue(numChar);

            for(int j = num; j < nestLevel; j++)
            {
                stringBuilder.append(")");
            }
            for(int j = num; j > nestLevel; j--)
            {
                stringBuilder.append("(");
            }
            stringBuilder.append(num);
            nestLevel = num;
        }

        for(int j = nestLevel; j > 0; j--)
        {
            stringBuilder.append(")");
        }

        String testCaseString = stringBuilder.toString();
        outputTestCase(testCaseNumber, testCaseString);
    }



    private static void outputTestCase(int testCaseNumber, String outString)
    {
        System.out.println("Case #" + testCaseNumber + ": " + outString);
    }
}