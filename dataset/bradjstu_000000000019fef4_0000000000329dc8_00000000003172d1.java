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
        String line1 =  in.nextLine();
        String[] intStrs1 = line1.split("\\s+");

        int n = Integer.parseInt(intStrs1[0]);
        int d = Integer.parseInt(intStrs1[1]);

        String line =  in.nextLine();
        String[] intStrs = line.split("\\s+");
        List<Long> ints = new ArrayList<>();

        for(int i = 0; i < intStrs.length; i++)
        {
            if(!intStrs[i].equals(""))
            {
                ints.add(Long.parseLong(intStrs[i]));
            }
        }

//        for(int i = 0; i < ints.size(); i++)
//        {
//            System.out.println(ints.get(i));
//        }

        boolean twos = false;
        boolean threes = false;

        Set<Long> x = new HashSet<>();
        Set<Long> duplicates = new HashSet<>();

        for(int i = 0; i < ints.size(); i++)
        {
            if(!x.add(ints.get(i)))
            {
                twos = true;
                if(!duplicates.add(ints.get(i)))
                {
                    threes = true;
                }
            }
        }

        int output = 0;

        if(threes)
        {
            output = 0;
        }
        else if(twos && d > 2)
        {
            output = 1;
        }
        else if(d > 2)
        {
            output = 2;
        }
        else if(twos)
        {
            output = 0;
        }
        else
        {
            output = 1;
        }
        String testCaseString = String.valueOf(output);
        outputTestCase(testCaseNumber, testCaseString);
    }



    private static void outputTestCase(int testCaseNumber, String outString)
    {
        System.out.println("Case #" + testCaseNumber + ": " + outString);
    }
}