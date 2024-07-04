import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            if(!solve(in, b)) {
                return;
            }
        }
    }

    private static boolean solve(Scanner sc, int B) {
        boolean[] state = new boolean[B];
        for (int i = 0; i < 5; ++i) {
            state[i] = query(i, sc);
            state[B - i - 1] = query(B - i - 1, sc);
        }
        int reverseWitness = -1;
        int complementWitness = -1;
        int determined = 10;
        while (determined < B) {
            if(complementWitness == -1) {
                for(int i = 0; i < determined / 2; ++i) {
                    if(state[i] == state[B-i-1]) {
                        complementWitness = i;
                        break;
                    }
                }
            }

            if(reverseWitness == -1) {
                for(int i = 0; i < determined / 2; ++i) {
                    if(state[i] != state[B-i-1]) {
                        reverseWitness = i;
                        break;
                    }
                }
            }

            // no complement witness means all determined bits i are opposite to bits B-i-1
            // This means that a reverse and a complement have the same effect on the determined bits
            if(complementWitness != -1) {
                boolean res = query(complementWitness, sc);
                if(res != state[complementWitness]) {

                    // complement was taken. update state
                    for(int i = 0; i < B; ++i) {
                        state[i] = ! state[i];
                    }
                }
            } else {
                query(1, sc);
            }

            // no reverseWitness means all determined bits i are equal to bits B-i-1
            // Swapping is an identify operation over the determined bits
            if(reverseWitness != -1) {
                boolean res = query(reverseWitness, sc);
                if(res != state[reverseWitness]) {
                    // state reversed. update state
                    for(int i = 0; i < B/2; ++i) {
                        boolean temp = state[i];
                        state[i] = state[B-i-1];
                        state[B-i-1] = temp;
                    }
                }
            } else {
                query(1, sc);
            }

            for(int i = 0; i < 4; ++i) {
                int index = determined/2+i;
                state[index] = query(index, sc);
                state[B-index-1] = query(B-index-1, sc);
            }

            determined += 8;
        }

        return report(state, sc);


    }

    private static boolean report(boolean[] state, Scanner sc) {
        StringBuilder sb = new StringBuilder();
        for (boolean bit : state) {
            sb.append(bit?'1':'0');
        }
        System.out.println(sb.toString());
        System.out.flush();

        boolean success = sc.next().trim().equals("Y");
sc.nextLine();
        return success;
    }

    private static boolean query(int i, Scanner sc) {
        System.out.println(i + 1);
        System.out.flush();
        boolean bit = sc.nextInt() == 1;
        sc.nextLine();
        return bit;
    }
}
  