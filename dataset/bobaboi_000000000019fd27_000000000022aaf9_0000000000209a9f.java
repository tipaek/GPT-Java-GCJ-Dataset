import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int caseCount = 1;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < count; i++) {
            solve(scan);
        }
    }
    public static void solve(Scanner scan) {
        String str = scan.nextLine();
        List<Character> list = new LinkedList<>();
        char[] strChar = str.toCharArray();

        char last = '0';
        for (int i = 0; i < strChar.length; i++) {
            char curr = strChar[i];
            if (curr > last) {
                for (int j = 0; j < curr - last; j++) {
                    list.add('(');
                }
            } else {
                for (int j = 0; j < last - curr; j++) {
                    list.add(')');
                }
            }
            last = curr;
            list.add(curr);
            // fast forwarding to last occurrence of this number
            i++;
            while (i < strChar.length && strChar[i] == curr) {
                list.add(curr);
                i++;
            }
            i--;
        }
        int end = list.get(list.size() - 1) - '0';
        for (int i = 0; i < end; i++) {
            list.add(')');
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        System.out.println("Case #" + caseCount + ": " + sb.toString());
        caseCount++;
    }
}
