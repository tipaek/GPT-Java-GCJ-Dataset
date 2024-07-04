
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Arles
 */
public class Solution {

    public static String solve(String expr) {
        Deque<Character> dq = new LinkedList<>();
        int openP = 0;
        for (int i = 0; i < expr.length(); i++) {
            int number = expr.charAt(i) - '0';
            if (openP == 0) {
                while (number > 0) {
                    dq.add('(');
                    openP++;
                    number--;
                }
                dq.add(expr.charAt(i));
            } else {
                if (number == 0) {
                    while (openP > 0) {
                        dq.addLast(')');
                        openP--;
                    }
                    dq.addLast('0');
                } else if (dq.getLast() != '(' && dq.getLast() != ')') {
                    int lastElem = dq.getLast() - '0';
                    if (lastElem > number) {
                        int k = lastElem - number;
                        while (k > 0) {
                            dq.add(')');
                            openP--;
                            k--;
                        }
                        dq.add(expr.charAt(i));
                        while (k < number) {
                            dq.add(')');
                            openP--;
                            k++;
                        }
                    } else if (lastElem == number) {
                        dq.add(expr.charAt(i));
                    } else {
                        while (openP > 0) {
                            dq.addLast(')');
                            openP--;
                        }
                        while (number > 0) {
                            dq.add('(');
                            number--;
                            openP++;
                        }
                        dq.add(expr.charAt(i));
                    }
                } else {
                    while (number > 0) {
                        dq.add('(');
                        number--;
                        openP++;
                    }
                    dq.add(expr.charAt(i));
                }
            }
        }
        while (openP > 0) {
            dq.addLast(')');
            openP--;
        }

        String s = "";

        while (!dq.isEmpty()) {
            s += dq.removeFirst();
        }

        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int cases = 1;

        while (cases <= T) {
            String exp = br.readLine();
            System.out.println("Case #" + cases + ": " + solve(exp));

            cases++;
        }
    }

}
