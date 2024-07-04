import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int cas = 1; cas <= t; ++cas) {
            String s = in.next();
            char[] chars = s.toCharArray();
            LinkedList<Character> q = new LinkedList<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                q.addLast(chars[i]);
            }

            int index = 0;
            while (index < q.size()) {
                Character ch = q.get(index);
                if (Character.isDigit(ch) && ch != '0') {
                    LinkedList<Character> open = new LinkedList<>();
                    LinkedList<Character> close = new LinkedList<>();
                    int numParenth = Character.getNumericValue(ch);
                    for (int j = 0; j < numParenth; j++) {
                        open.addLast('(');
                        close.addLast(')');
                    }
                    q.addAll(index, open);
                    q.addAll(index + 1 + numParenth, close);
                    index += 1 + numParenth;
                } else {
                    index++;
                }
            }

            index = 0;
            while (index < q.size()) {
                Character ch = q.get(index);
                if (ch == '(' && index >= 1 && q.get(index - 1) == ')') {
                    q.remove(index);
                    q.remove(index - 1);
                    index -= 1;
                } else {
                    index++;
                }
            }

            System.out.print("Case #" + cas + ": ");
            for (Character ch : q) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
