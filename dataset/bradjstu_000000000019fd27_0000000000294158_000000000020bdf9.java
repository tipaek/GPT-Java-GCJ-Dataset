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
        int testCaseSize = in.nextInt();

        Node[] sorted = new Node[testCaseSize];

        for(int i = 0 ; i < testCaseSize; i++)
        {
            int start = in.nextInt();
            int end = in.nextInt();
            sorted[i] = new Node(start, end, i);
        }

        Arrays.sort(sorted);

        Person j = new Person();
        Person c = new Person();

        boolean impossible = false;

        for(int i = 0; i < sorted.length; i++)
        {
            if (!j.containsOverlap(sorted[i]))
            {
                j.nodeList.add(sorted[i]);
            } else if (!c.containsOverlap(sorted[i]))
            {
                c.nodeList.add(sorted[i]);
            } else
            {
                impossible = true;
            }
        }

        if(impossible)
        {
            outputTestCase(testCaseNumber, "IMPOSSIBLE");
        }
        else
        {
            char[] arr = new char[sorted.length];

            for(int i = 0; i < j.nodeList.size(); i++)
            {
                int originalPosition = j.nodeList.get(i).originalPosition;
                arr[originalPosition] = 'J';
            }

            for(int i = 0; i < c.nodeList.size(); i++)
            {
                int originalPosition = c.nodeList.get(i).originalPosition;
                arr[originalPosition] = 'C';
            }

            String testCaseString = String.valueOf(arr);
            outputTestCase(testCaseNumber, testCaseString);
        }
    }

    private static class Person
    {
        List<Node> nodeList;

        public Person()
        {
            nodeList = new ArrayList<>();
        }


        boolean containsOverlap(Node o)
        {
            for(Node node: nodeList)
            {
                if(node.overlap(o))
                {
                    return true;
                }
            }
            return false;
        }
    }

    private static class Node implements Comparable<Node>
    {
        int start;
        int end;
        int originalPosition;

        Node(int start, int end, int originalPosition)
        {
            this.start = start;
            this.end = end;
            this.originalPosition = originalPosition;
        }

        boolean overlap(Node o)
        {
            return((this.start >= o.start && this.start < o.end) ||
                    (this.end > o.start && this.end <= o.end) ||
                    (o.start >= this.start && o.start < this.end) ||
                    (o.end > this.start && o.end <= this.end));
        }

        @Override
        public int compareTo(Node o)
        {
            return Integer.compare(this.start, o.start);
        }
    }

    private static void outputTestCase(int testCaseNumber, String outString)
    {
        System.out.println("Case #" + testCaseNumber + ": " + outString);
    }
}