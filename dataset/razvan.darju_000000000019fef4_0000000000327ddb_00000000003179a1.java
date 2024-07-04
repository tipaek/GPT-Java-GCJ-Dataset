import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int cases = scanner.nextInt();

        for (int c = 1; c <= cases; c++) {

            System.out.print("Case #" + c + ": ");
            solve();
            System.out.println();
        }
    }

    private static void solve() {

        int n = 10000;
        int u = scanner.nextInt();

        int found = 0;
        char[] foundArr = new char[10];
        Set<Character> foundSet = new HashSet<>();


        for (int i = 0; i < n; i++) {

            int nr = scanner.nextInt();
            String rep = scanner.next();

            Stack<Integer> st = new Stack<>();
            int c = 0;
            int nrc = nr;
            while (nrc > 0) {
                int a = nrc % 10;
                nrc = nrc / 10;
                c++;
                st.push(a);
            }

            if (c == rep.length()) {
                int cnt = 0;

                boolean canContinue = false;

                while (!st.isEmpty() &&
                        (st.peek() == 0 && canContinue ||
                                st.peek() == found + 1 ||
                                st.peek() < found + 1 && foundArr[st.peek()] == rep.charAt(cnt))) {
                    char ch = rep.charAt(cnt);
                    int a = st.pop();
                    if (a == 0) {
                        foundArr[a] = ch;
                        foundSet.add(ch);
                    } else if (!foundSet.contains(ch)) {
                        foundArr[a] = ch;
                        foundSet.add(ch);
                        canContinue = true;
                        found++;
                    } else if (foundArr[a] == ch) {
                        canContinue = true;
                    }
                    cnt++;
                }
            }
        }

        for (char c : foundArr) {
            System.out.print(c);
        }
    }
}