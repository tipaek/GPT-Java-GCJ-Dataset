import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Solution implements Runnable
{

    public static void main(String[] args)
    {
        new Solution().run();
    }

    int[] bits;

    @Override
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        for (int t = 1; t <= T; t++)
        {
            bits = new int[B];
            int testPolls = 0;
            int isame = -1;
            int idif = -1;
            for (int b = 0; b < B; b++)
            {
//                System.err.println(b + "\t" + Arrays.toString(bits));
                if ((b + testPolls) % 10 == 0)
                {
                    if (isame != -1)
                    {
                        System.out.println(isame + 1);
                        testPolls += 1;
                        if (bits[isame] != sc.nextInt())
                        {
                            complement();
                        }
                    }
                    if (idif != -1)
                    {
                        System.out.println(idif + 1);
                        testPolls += 1;
                        if (bits[idif] != sc.nextInt())
                        {
                            reverse();
                        }
                    }
                    if (testPolls > 0 && testPolls %2== 1)
                    {
                        System.out.println(1);
                        sc.nextInt();
                        testPolls += 1;
                    }
                }
                if (b % 2 == 0)
                {
                    int ask = B / 2 + b / 2;
                    System.out.println(ask + 1);
                    bits[ask] = sc.nextInt();
                } else
                {
                    int ask = B / 2 - (b / 2) - 1;
                    System.out.println(ask + 1);
                    bits[ask] = sc.nextInt();
                    if (bits[ask] == bits[B / 2 + (b - 1) / 2] && isame == -1)
                    {
                        isame = ask;
                    }
                    if (bits[ask] != bits[B / 2 + (b - 1) / 2] && idif == -1)
                    {
                        idif = ask;
                    }
                }

            }

            printBits();
            sc.nextLine();
            String verdict = sc.nextLine();
            if (verdict.equals("N"))
            {
                System.err.println("Fout " + t + " "+ verdict);
                return;
            } else
            {
                System.err.println("goed " + t + " "+ verdict);
            }
        }

    }

    void printBits()
    {
        for (int b : bits)
        {
            System.out.print(b);
        }
        System.out.println("");
    }

    private void reverse()
    {
        for (int i = 0; i < bits.length / 2; i++)
        {
            int t = bits[i];
            bits[i] = bits[bits.length - 1 - i];
            bits[bits.length - 1 - i] = t;
        }
    }

    private void complement()
    {
        for (int i = 0; i < bits.length; i++)
        {
            bits[i] = 1 - bits[i];
        }
    }
}
