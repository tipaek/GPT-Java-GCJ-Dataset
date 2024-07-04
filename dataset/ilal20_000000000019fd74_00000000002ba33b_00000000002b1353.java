import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        int[] tests = new int[testCases];
        for(int i=0; i<testCases; i++)
            tests[i] = scan.nextInt();
        for(int i=0; i<testCases; i++)
        {
            if(tests[i] == 501)
            {
                System.out.println("Case #" + (i+1) + ":");
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 2");
                System.out.println("3 1");
                for(int j=4; j<=501; j++)
                    System.out.println(j + " 1");
            }
            else
            {
                System.out.println("Case #" + (i+1) + ":");
                for(int j=1; j<=tests[i]; j++)
                {
                    System.out.println(j + " 1");
                }
            }
        }
    }
}
