import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        int cases = myInput.nextInt();

        for (int i = 0; i<cases; i++) {
            System.out.println("Case #"+(i+1)+": " + converter(myInput.next()));
        }

    }

    private static String converter(String s) {
        StringBuilder sb = new StringBuilder();
        int currentLevel = 0;

        for (int i = 0; i<s.length(); i++) {
            int x = s.charAt(i) - 48;
            if (currentLevel < x)
                goLevelUp(sb, x - currentLevel);
            else
                goLevelDown(sb, currentLevel-x);
            sb.append(s.charAt(i));
            currentLevel = x;
        }
        goLevelDown(sb, currentLevel);
        return sb.toString();
    }

    private static void goLevelUp(StringBuilder sb, int shift) {
        for (int i=0; i<shift; i++) {
            sb.append("(");
        }
        return;
    }

    private static void goLevelDown(StringBuilder sb, int shift) {
        for (int i=0; i<shift; i++) {
            sb.append(")");
        }
        return;
    }
}
