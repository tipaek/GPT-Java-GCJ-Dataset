import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int id = 1;
        while (t != 0) {
            String s;
            s = sc.next();
            StringBuilder sb = new StringBuilder();
            int i = 0;

            int curDeep = 0;
            while (i < s.length()) {
                int deep = s.charAt(i) - '0';
                while (curDeep < deep) {
                    sb.append('(');
                    curDeep++;
                }
                while (curDeep > deep) {
                    sb.append(')');
                    curDeep--;
                }
                sb.append(s.charAt(i));
                i++;
            }
            while (curDeep > 0) {
                sb.append(')');
                curDeep--;
            }
            t--;
            System.out.println("Case #" + id + ": " + sb.toString());
            id++;
        }
    }
}
