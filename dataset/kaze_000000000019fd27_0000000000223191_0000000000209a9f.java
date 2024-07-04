import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int turn = 0; turn < T; turn++) {
            String currline = input.nextLine();
            String result = "";
            boolean afterone = false;
            for (int i = 0; i < currline.length(); i++) {
                if (currline.charAt(i) == '0') {
                    if (afterone) {
                        result+=')';
                    }
                    afterone = false;
                    result+='0';
                } else {
                    if (!afterone) {
                        result+= '(';
                    }
                    afterone = true;
                    result+='1';
                }
            }
            if (afterone) {
                result += ')';
            }
            System.out.println("Case #" + (turn+1) + ": " + result);
        }
    }
}
