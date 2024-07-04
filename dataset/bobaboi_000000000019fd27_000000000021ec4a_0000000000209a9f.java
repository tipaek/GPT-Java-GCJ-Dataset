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

        for (int i = 0; i < strChar.length; i++) {
            char curr = strChar[i];
            for (int j = 0; j < curr - '0'; j++) {
                list.add('(');
            }
            list.add(curr);
            i++;
            while (i < strChar.length && strChar[i] == curr) {
                list.add(curr);
                i++;
            }
            i--;
            for (int j = 0; j < strChar[i] - '0'; j++) {
                list.add(')');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        System.out.println("Case #" + caseCount + ": " + sb.toString());
        caseCount++;
    }
}
