import java.util.*;
import java.io.*;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;

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
        int u = in.nextInt();

        QRPair[] pairs = new QRPair[10000];

        for(int i = 0; i < 10000; i++)
        {
            long q = in.nextLong();
            String r = in.next();
            pairs[i] = new QRPair(q, r);
        }

        //String d = maxValuesApproach(pairs);

        String d = statsApproach(pairs, u);

        outputTestCase(testCaseNumber, d);
    }

    private static String maxValuesApproach(QRPair pairs)
    {
        return "";
    }

    private static String statsApproach(QRPair[] pairs, int u)
    {
        int[] nums = new int[200];
        int[] others = new int[200];

        for(int i = 0; i < 10000; i++)
        {
            long q = pairs[i].query;
            String r =  pairs[i].result;

            if(r.length() == u)
            {
                char firstLetter = r.charAt(0);
                int index = (int) firstLetter;

                char secondLetter = r.charAt(1);
                int index2 = (int) secondLetter;

                others[index2]++;
                nums[index]++;
            }
        }

        List<Rank> ranks = new ArrayList<>();
        List<Rank> ranks2 = new ArrayList<>();

        for(int i = 0; i < 200; i++)
        {
            if(nums[i] > 0)
            {
                ranks.add(new Rank(nums[i], i));
            }

            if(others[i] > 0 )
            {
                ranks2.add(new Rank(others[i], i));
            }
        }

        ranks.sort(
                Comparator.comparingInt(Rank::getTally).reversed());

        String x = "";


        for(Rank rank2: ranks2)
        {
            boolean isPresent = false;
            for(Rank rank: ranks)
            {
                if(rank2.value == rank.value)
                {
                    isPresent = true;
                }
            }

            if(!isPresent)
            {
                x += (char)(rank2.value);
            }
        }


        for(Rank rank: ranks)
        {
//            System.out.println(rank.tally + " " + rank.value);
//
//            System.out.println(String.valueOf(Character.toChars(rank.value)));
            x += (char)rank.value;
        }

        return x;
    }


    public static class Rank
    {
        int tally;
        int value;

        Rank(int tally, int value)
        {
            this.tally = tally;
            this.value = value;

        }

        public int getTally()
        {
            return tally;
        }

    }

    public static class QRPair
    {
        public long query;
        public String result;

        QRPair(long query, String result)
        {
            this.query = query;
            this.result = result;
        }
    }

    private static void outputTestCase(int testCaseNumber, String outString)
    {
        System.out.println("Case #" + testCaseNumber + ": " + outString);
    }
}