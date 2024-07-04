import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {

            String number = sc.nextLine();
            int numberLenght = number.length() - 1;
            int first = Integer.parseInt(String.valueOf(number.charAt(0)));
            String s = String.join("", Collections.nCopies(first, "("));

            for (int j = 0; j < numberLenght; j++) {
                int a1 = Integer.parseInt(String.valueOf(number.charAt(j)));
                int a2 = Integer.parseInt(String.valueOf(number.charAt(j + 1)));
                s += a1;
                if (a1 == a2) continue;
                String sRepeated = String.join("", Collections.nCopies(Math.abs(a1 - a2), (a1 < a2) ? "(" : ")"));
                s += sRepeated;
            }

            int last = Integer.parseInt(String.valueOf(number.charAt(numberLenght)));
            s += last + String.join("", Collections.nCopies(last, ")"));
            
            System.out.println("Case #" + (i + 1) + ": " + s);
        }

    }
}
