import java.util.*;
import java.io.*;

public class Solution {

    static void print(int caso, boolean poss, int minute) {
        if (poss) {
            System.out.println("Case #" + (caso + 1) + ": " + minute);
        } else {
            System.out.println("Case #" + (caso + 1) + ": IMPOSSIBLE");
        }
    }

    static int[] move(int[] pos, char mossa) {
        int[] risultato = { pos[0], pos[1] };
        switch (mossa) {
            case 'N':
                risultato[1]++;
                break;
            case 'S':
                risultato[1]--;
                break;
            case 'F':
                break;
        }
        return risultato;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 0; i < cases; i++) {
            int X = input.nextInt();
            int Y = input.nextInt();
            String path = input.next();
            int[] target = { X, Y };
            boolean trovato = false;

            int[] me = { 0, 0 };
            int contatore = 0;
            char[] mosse = { 'N', 'S', 'F' };
            Queue<int[]> coda = new LinkedList<>();
            coda.add(me);

            for (int j = 0; j < path.length(); j++) {
                contatore++;
                target = Solution.move(target, path.charAt(j));
                // System.out.println(target[0] + " " + target[1]);
                int r = coda.size();
                // System.out.println("Dimensione coda: " + r);
                for (int k = 0; k < r; k++) {
                    int[] t2 = coda.remove();
                    for (int m = 0; m < mosse.length; m++) {
                        int[] temp = Solution.move(t2, mosse[m]);
                        if (temp[0] == target[0] && temp[1] == target[1]) { // Trovato
                            trovato = true;
                            break;
                        } else {
                            coda.add(temp);
                        }
                    }
                    if (trovato) {
                        break;
                    }
                }
                if (trovato) {
                    break;
                }

            }

            Solution.print(i, trovato, contatore);
        }
    }
}