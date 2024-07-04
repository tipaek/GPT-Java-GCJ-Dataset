import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner file = new Scanner(System.in);
        int testCases = file.nextInt();
        for (int i = 0; i < testCases; i++)
        {
            String s = file.next();
            int[] a = new int[s.length()];
            for (int j = 0; j < a.length; j++)
            {
                a[j] = s.charAt(j) - 48;
            }
            int[][] parentheses = new int[a.length + 1][2];
            while (!done(a))
            {
                int maxBegin = 0, maxEnd = 0, currBegin = 0;
                for (int j = 0; j < a.length; j++)
                {
                    if (a[j] != 0)
                    {
                        currBegin = j;
                        break;
                    }
                }
                for (int j = currBegin; j < a.length; j++)
                {
                    if (j != 0 && a[j] != 0 && a[j - 1] == 0)
                    {
                        currBegin = j;
                    }
                    if (a[j] == 0 && a[j - 1] != 0)
                    {
                        if (j - currBegin > maxEnd - maxBegin)
                        {
                            maxBegin = currBegin;
                            maxEnd = j;
                        }
                    }
                }
                if (a[a.length - 1] != 0)
                {
                    if (a.length - currBegin > maxEnd - maxBegin)
                    {
                        maxBegin = currBegin;
                        maxEnd = a.length;
                    }
                }
                parentheses[maxBegin][0]++;
                parentheses[maxEnd][1]++;
                for (int j = maxBegin; j < maxEnd; j++)
                {
                    a[j]--;
                }
            }
            System.out.printf("Case #%d: ", i + 1);
            for (int j = 0; j < a.length; j++)
            {
                for (int k = 0; k < parentheses[j][1]; k++)
                {
                    System.out.print(')');
                }
                for (int k = 0; k < parentheses[j][0]; k++)
                {
                    System.out.print('(');
                }
                System.out.print(s.charAt(j));
            }
            for (int j = 0; j < parentheses[parentheses.length - 1][1]; j++)
            {
                System.out.print(')');
            }
            System.out.println();
        }
    }
    
    static boolean done(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != 0)
            {
                return false;
            }
        }
        return true;
    }
}
