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
//            letters['A' - 'A'].find(1);
//            letters['B' - 'A'].find(1);

            Arrays.sort(letters);
            System.out.print("Case #" + t + ": ");
            System.out.print(letters[9]);
            for (int i = 0; i < 9; i++)
            {
                System.out.print(letters[i]);
            }
            System.out.println("");
        }
    }

    class found implements Comparable<found>
    {

        long foundAsFirst = 0;
        long foundTotal = 0;
        char c;

        public found(char c)
        {
            this.c = c;
        }

        @Override
        public String toString()
        {
            return "" + c;//+ " " + foundTotal + " " + foundAsFirst + "\n\r";
        }

        @Override
        public int compareTo(found o)
        {

            return -Long.compare(foundTotal, o.foundTotal);
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
