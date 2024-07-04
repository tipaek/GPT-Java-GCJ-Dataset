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
            int timings = scan.nextInt();
            ArrayList<Integer> startTimes = new ArrayList<Integer>();
        ArrayList<Integer> endTimes = new ArrayList<Integer>();
            for(int i=0; i<timings; i++)
            {
                startTimes.add(scan.nextInt());
                endTimes.add(scan.nextInt());
            }
            int[] index = new int[startTimes.size()];
            for(int i=1; i<=index.length; i++)
                index[i-1] = i;
            String[] schedule = new String[index.length];

            //sort stuff.

            int min = startTimes.get(0);
            int minInd = 0;
            int temp = 0;
            int temp2 = 0;
            int temp3 = 0;
            for(int j=0; j<startTimes.size(); j++)
            {
                min = startTimes.get(j);
                minInd = j;
                for(int i=0; i<startTimes.size(); i++)
                {
                    if(startTimes.get(i) > min)
                    {
                        temp = startTimes.get(i);
                        startTimes.set(i, min);
                        startTimes.set(minInd, temp);
                        min = startTimes.get(minInd);

                        temp2 = endTimes.get(i);
                        endTimes.set(i, endTimes.get(minInd));
                        endTimes.set(minInd, temp2);

                        temp3 = index[i];
                        index[i] = index[minInd];
                        index[minInd] = temp3;
                    }
                }

            }


            
            int jStart = startTimes.get(0);
            int jEnd = endTimes.get(0);
            schedule[0] = "J";
            int cStart = 0;
            int cEnd = 0;
            
            for(int i=1; i<startTimes.size(); i++)
            {
                if(startTimes.get(i) >= jEnd)
                {
                    jEnd = endTimes.get(i);
                    schedule[i] = "J";
                }
                else if(startTimes.get(i) >= cEnd)
                {
                    cEnd = endTimes.get(i);
                    schedule[i] = "C";
                }
                else
                {
                    schedule[i] = "X";
                }

            }
            String[] str = new String[timings];
            for(int i=0; i<timings; i++)
            {
                str[i] = "A";
            }
            
            for(int i=0; i<index.length; i++)
            {
                str[index[i]-1] = schedule[i];
            }
            
            String s = "";
            for(int i=0; i<str.length; i++)
                s += str[i];
            
            if(s.contains("X"))
                output[q] = "IMPOSSIBLE";
            else
                output[q] = s;

        }
        for(int i=0; i<output.length; i++)
        {
            System.out.println("Case #" + (i+1) + ": " + output[i]);
        }
    }
}

