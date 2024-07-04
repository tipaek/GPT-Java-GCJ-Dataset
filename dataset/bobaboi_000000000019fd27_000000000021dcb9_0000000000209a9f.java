// import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
// import java.util.Set;

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
            if (strChar[i] == '1') {
                list.add('(');
                list.add('1');
                while (i < strChar.length) {
                    if (strChar[i] == '0') {
                        i--;
                        list.remove(list.size() - 1);
                        list.add(')');
                        break;
                    } else {
                        list.add('1');
                        i++;
                    }
                }
            } else {
                list.add('0');
            }
        }
        if (list.get(list.size() - 1) == '1') {
            list.remove(list.size() - 1);
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
