
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        nestingDepth();
    }

    private static void nestingDepth() {
        int T = scanner.nextInt();
        scanner.nextLine();
        String s;
        StringBuilder sDash = new StringBuilder();
        int depth;
        int digit;
        for (int t = 1; t <= T; t++){
            depth = 0;
            s = scanner.nextLine();
            for (char c : s.toCharArray()){
                digit = c - '0';
                if(digit > depth){
                    while (digit > depth) {
                        sDash.append('(');
                        depth++;
                    }
                } else if(digit < depth){
                    while (digit < depth) {
                        sDash.append(')');
                        depth--;
                    }
                }
                sDash.append(c);
            }
            while (depth-- > 0) {
                sDash.append(')');
            }

            System.out.println("Case #"+ t +": " + sDash.toString());
            sDash.setLength(0);
        }
    }
}
