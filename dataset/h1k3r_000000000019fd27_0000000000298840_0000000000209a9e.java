import java.util.Scanner;

public class Solution
{

    private static class WrongGuess extends Exception {};

    private static void solve(Scanner input, int B) throws WrongGuess
    {
        int requests = 0;
        int nextPos = 0;
        char[] bits = new char[B];

        while (requests < 150) {

            System.out.println(nextPos+1);
            char bit = input.next().charAt(0);
            bits[nextPos] = bit;


            if (nextPos >= B - 1) {
                System.out.println(format(bits));

                String s = input.next();
                if (s.equals("N")) {
                    throw new WrongGuess();
                }
                return;
            }

            nextPos++;
        }
    }

    private static String format(char[] b)
    {

        return new String(b);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        try {
            for (int ks = 1; ks <= T; ks++) {
                solve(input, B);
            }
        } catch (WrongGuess e) {
            return;
        }
    }
}
