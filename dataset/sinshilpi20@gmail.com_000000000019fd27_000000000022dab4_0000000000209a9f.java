import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String str = sc.nextLine();
        int ct = 1;
        while (ct <= t) {
            str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int last = 0;
            int bc = 0;
            for (int i = 0; i < str.length(); i++) {
                int curr = Character.getNumericValue(str.charAt(i));
                if (last != curr) {
                    if (last < curr) {
                        addChars(sb, curr-last, '(');
                        bc += curr - last;
                    } else {
                        addChars(sb, last-curr, ')');
                        bc -= last - curr;
                    }
                }
                sb.append(String.valueOf(curr));
                last = curr;
            }
            addChars(sb, bc, ')');
            System.out.println("Case #" + ct + ": " + sb.toString());
            ct++;
        }
    }

    private static void addChars(StringBuilder sb, int f, char ch) {
        for (int i = 0; i < f; i++) {
            sb.append(ch);
        }
    }
}