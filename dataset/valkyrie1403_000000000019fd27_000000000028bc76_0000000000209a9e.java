import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main (String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();

        for (int i = 0; i < t; i++)
        {
           solve(b, in);
        }
    }

    private static void solve(int numBits, Scanner in)
    {
        boolean [] bits = new boolean [numBits];
        int sameStart = -1, diffStart = -1;

        // do first 10 queries
        for (int i = 0; i < 5; i++)
        {
            System.out.println((i+1));
            bits[i] = (in.nextInt() == 1);

            System.out.println((numBits - i));
            bits[numBits - i - 1] = (in.nextInt() == 1);

            if ((diffStart == -1) && (bits[i] != bits[numBits - i - 1]))
                diffStart = i;

            if ((sameStart == -1) && (bits[i] == bits[numBits - i - 1]))
                sameStart = i;
        }


        int numQueries = 10, currStart = 5, currEnd = numBits - currStart - 1;

        while (currStart < currEnd)
        {
            if (numQueries % 10 == 0)
            {
                // run test queries
                boolean sameChanged = false, diffChanged = false;

                if (sameStart != -1)
                {
                    System.out.println((sameStart + 1));
                    boolean sameBitNew = (in.nextInt() == 1);
                    sameChanged = (sameBitNew != bits[sameStart]);
                }
                else
                    System.out.println(1);

                if (diffStart != -1)
                {
                    System.out.println((diffStart + 1));
                    boolean diffBitNew = (in.nextInt() == 1);
                    diffChanged = (diffBitNew != bits[diffStart]);
                }
                else
                    System.out.println(1);


                if (sameChanged && diffChanged)
                    flip(bits);
                else if (diffChanged)
                    reverse(bits);
                else if (sameChanged)
                {
                    flip(bits);
                    reverse(bits);
                }
            }
            else
            {
                System.out.println((currStart + 1));
                bits[currStart] = (in.nextInt() == 1);

                System.out.println((currEnd + 1));
                bits[currEnd] = (in.nextInt() == 1);

                if ((diffStart == -1) && (bits[currStart] != bits[currEnd]))
                    diffStart = currStart;

                if ((sameStart == -1) && (bits[currStart] == bits[currEnd]))
                    sameStart = currStart;
                currStart++;
                currEnd--;
            }
            numQueries += 2;
        }

        StringBuilder output = new StringBuilder();
        for (boolean b : bits)
            output.append(b ? 1 : 0);

        System.out.println(output.toString());
        in.nextLine();
        in.nextLine();
    }

    private static void flip(boolean [] bits)
    {
        for (int i = 0; i < bits.length; i++)
            bits[i] = !bits[i];
    }

    private static void reverse(boolean [] bits)
    {
        for (int i = 0; i < bits.length / 2; i++)
        {
            boolean temp = bits[i];
            bits[i] = bits[bits.length - i - 1];
            bits[bits.length - i - 1] = temp;
        }
    }
}