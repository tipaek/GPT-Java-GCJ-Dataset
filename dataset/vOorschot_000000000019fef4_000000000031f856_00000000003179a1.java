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

    public void run()
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++)
        {
            int U = sc.nextInt();
            found[] letters = new found[26];
            for (int i = 0; i < 26; i++)
            {
                letters[i] = new found((char) ('A' + i));
            }

            for (int i = 0; i < 10000; i++)
            {
                int M = sc.nextInt();
                char[] l = sc.next().toCharArray();
                for (int c = 0; c < l.length; c++)
                {
                    letters[l[c] - 'A'].find(c);
                }

            }

            Arrays.sort(letters);
            System.out.print("Case #" + t + ": ");
            for (int i = 0; i < 10; i++)
            {
                System.out.print(letters[i]);
            }
            System.out.println("");
        }
    }

    class found implements Comparable<found>
    {

        int foundAsFirst = 0;
        int foundTotal = 0;
        char c;

        public found(char c)
        {
            this.c = c;
        }

        @Override
        public String toString()
        {
            return "" + c;// + " " + foundTotal + " " + foundAsFirst + "\n\r";
        }

        @Override
        public int compareTo(found o)
        {
            if (foundTotal != 0 && foundAsFirst == 0)
            {
                return -1;
            } else if (o.foundTotal != 0 && o.foundAsFirst == 0)
            {
                return 1;
            }
            if (foundTotal - o.foundTotal == 0)
            {
                return 0;
            } else if (foundTotal - o.foundTotal > 0)
            {
                return -1;
            } else
            {
                return 1;
            }
        }

        private void find(int i)
        {
            foundTotal++;
            if (i == 0)
            {
                foundAsFirst++;
            }
        }

    }
}
