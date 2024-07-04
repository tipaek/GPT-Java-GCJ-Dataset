import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int testCases = Integer.parseInt(s);
        int caseNr = 1;
        while(testCases > 0)
        {
            s = br.readLine();
            int N = Integer.parseInt(s);
            schedule(N, br, caseNr);

            caseNr++;
            testCases--;
        }
    }

    private static void schedule(int N , BufferedReader br, int caseNr ) throws IOException
    {
        StringBuilder jobs = new StringBuilder();
        BinaryTree C = new BinaryTree();
        BinaryTree J = new BinaryTree();

        for (int i = 0; i < N; i++)
        {
            String s = br.readLine();
            String[] times = s.split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            if(C.append(start, end))
                jobs.append("C");
            else if( J.append(start, end))
                jobs.append("J");
            else
            {
                jobs = new StringBuilder();
                jobs.append("IMPOSSIBLE");
                break;
            }

        }

        System.out.println("Case #" + caseNr+ ": " + jobs.toString());

    }
}
class Node
{
    int value;
    int item;
    Node left;
    Node right;
}

class BinaryTree
{
    Node root;

    boolean append(int start, int end)
    {
        try {

            root = appendRecursive(root, start, end);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    private Node appendRecursive(Node current, int start, int end) throws Exception {
        if(current == null)
        {
            Node node = new Node();
            node.value = start;
            node.item = end;

            return node;
        }
        else if( current.value >= start )
        {
            if( current.value > end)
                return appendRecursive(current.left, start, end);
            else
                throw new Exception("failed");
        }
        else
        {
            if (current.item <= start)
                return appendRecursive(current.right, start, end);
            else
                throw new Exception("failed");
        }
    }
}
