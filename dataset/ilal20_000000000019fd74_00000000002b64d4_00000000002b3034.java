import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        String[] output = new String[testCases];
        for(int q=0; q<testCases; q++)
        {
            int numPatterns = scan.nextInt();
            String[] patterns = new String[numPatterns];
            for(int i=0; i<numPatterns; i++)
                patterns[i] = scan.next();
            if(patterns[0].substring(0,1).equals("*"))
            {
                int minLength = patterns[0].length();
                int index = 0;
                for(int i=0; i<numPatterns; i++)
                {
                    if(patterns[i].length() < minLength)
                    {
                        minLength = patterns[i].length();
                        index = i;
                    }
                }
                String smallest = patterns[index].substring(1);
                int length = smallest.length();
                ArrayList<String> checker = new ArrayList<String>();
                for(int i=0; i<patterns.length; i++)
                {
                    if(!(patterns[i].substring(patterns[i].length() - length).equals(smallest)))
                    {
                        checker.add("*");
                        output[q] = "*";
                    }
                }

                int maxLength = patterns[0].length();
                int index2 = 0;
                for(int i=0; i<numPatterns; i++)
                {
                    if(patterns[i].length() > maxLength)
                    {
                        maxLength = patterns[i].length();
                        index2 = i;
                    }
                }
                if(checker.size() == 0 && maxLength <=10000)
                    output[q] = patterns[index2].substring(1);
                else
                    output[q] = "*";
            }
            else
            {
                int minLength = patterns[0].length();
                int index = 0;
                for(int i=0; i<numPatterns; i++)
                {
                    if(patterns[i].length() < minLength)
                    {
                        minLength = patterns[i].length();
                        index = i;
                    }
                }
                int indexOfStar = 0;
                String small = patterns[index];
                for(int i=0; i<minLength; i++)
                {
                    if(small.substring(i,i+1).equals("*"))
                    {
                        indexOfStar = i;
                    }
                }
                String first = small.substring(0,indexOfStar);
                String second = small.substring(indexOfStar+1);
                ArrayList<String> checker = new ArrayList<String>();

                for(int i=0; i<patterns.length; i++)
                {
                    if(!(patterns[i].substring(0,indexOfStar).equals(first) &&
                        patterns[i].substring(patterns[i].length()-second.length()).equals(second)))
                    {
                        checker.add("*");
                        output[q] = "*";
                    }
                }

                int maxLength = patterns[0].length();
                int index2 = 0;
                String longest = patterns[0];
                for(int i=0; i<numPatterns; i++)
                {
                    if(patterns[i].length() > maxLength)
                    {
                        maxLength = patterns[i].length();
                        index2 = i;
                        longest = patterns[i];
                    }
                }
                for(int i=0; i<maxLength; i++)
                {
                    if(longest.substring(i,i+1).equals("*"))
                    {
                        indexOfStar = i;
                    }
                }
                if(checker.size() == 0 && maxLength <=10000)
                    output[q] = patterns[index2].substring(0,indexOfStar) + patterns[index2].substring(indexOfStar+1);
                else
                    output[q] = "*";
            }

        }
        for(int i=0; i<output.length; i++)
        {
            System.out.println("Case #" + (i+1) + ": " + output[i]);
        }
    }
}
