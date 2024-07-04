
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        System.out.println(testCases);
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String stringResult = "";
            LinkedList<Character> digits = new LinkedList<>();
            String testCaseDigits = scanner.next();
            for (Character digitChar : testCaseDigits.toCharArray()) {
                short digit = Short.parseShort(digitChar.toString());
                for (int i = 0; i < digit; i++)
                    digits.add('(');
                digits.add(digitChar);
                for (int i = 0; i < digit; i++)
                    digits.add(')');
            }
            digits = simplify(digits);

            System.out.println(String.format("Case #%s: %s", caseIndex, digits.stream().map(String::valueOf).collect(Collectors.joining())));
        }
    }

    public static LinkedList<Character> simplify(LinkedList<Character> digits){
        for (int i=0; i< digits.size()-1; i++){
            if(digits.get(i)==')' &&digits.get(i+1)=='('){
                digits.remove(i);
                digits.remove(i);
                return simplify(digits);
            }
        }
        return digits;
    }
}