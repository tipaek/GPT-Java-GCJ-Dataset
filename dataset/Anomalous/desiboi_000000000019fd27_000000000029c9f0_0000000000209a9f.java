import java.util.Scanner;

class IntPar {
    static int str2int(String s) {
        return Integer.parseInt(s);
    }

    public static String addBrackets(String s) {
        StringBuilder result = new StringBuilder();
        int[] digits = s.chars().map(Character::getNumericValue).toArray();
        int previousDigit = 0;

        for (int digit : digits) {
            while (previousDigit < digit) {
                result.append('(');
                previousDigit++;
            }
            while (previousDigit > digit) {
                result.append(')');
                previousDigit--;
            }
            result.append(digit);
        }

        while (previousDigit > 0) {
            result.append(')');
            previousDigit--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Enter the number: ");
            String n = sc.next();
            System.out.println(addBrackets(n));
            System.out.println();
        }
        
        sc.close();
    }
}