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
        myTree C = new myTree();
        myTree J = new myTree();

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
                System.out.println("Case #" + caseNr+ ": " + "IMPOSSIBLE");
                return;
            }

        }

        System.out.println("Case #" + caseNr+ ": " + jobs.toString());

    }
}
class MyNode
{
    int value;
    int item;
    MyNode left;
    MyNode right;

    MyNode(int value, int item)
    {
        this.item = item;
        this.value = value;
        left = null;
        right = null;
    }
}

class myTree
{
    MyNode root;

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

    private MyNode appendRecursive(MyNode current, int start, int end) throws Exception {
        if(current == null)
        {
            return new MyNode(start, end);
        }
        else if( current.value >= start )
        {
            if( current.value > end)
                current.left = appendRecursive(current.left, start, end);
            else
                throw new Exception("failed");
        }
        else
        {
            if (current.item <= start)
                current.right =  appendRecursive(current.right, start, end);
            else
                throw new Exception("failed");
        }

        return current;
    }
}