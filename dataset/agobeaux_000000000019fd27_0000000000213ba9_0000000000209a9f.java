import java.util.*;
public class Solution {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String line = sc.nextLine(); // newline char
        for (int i = 1; i <= T; i++) {
            line = sc.nextLine();
            String str = "";
            int currLPar = 0;
            for (char c : line.toCharArray()) {
                int val = Character.getNumericValue(c);  
                while (val - currLPar > 0) {
                    str += "(";
                    currLPar++;
                }
                while (currLPar - val > 0) {
                    str += ")";
                    currLPar--;
                }
                str += c;
            }
            while (currLPar > 0) {
                str += ")";
                currLPar--;
            }
            System.out.println(String.format("Case #%d: %s", i, str));
        }
    }
}
