import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < testCases; i++) {
            String number = scan.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + nestingDepth(number));
        }
        scan.close();
    }

    public static String nestingDepth(String number) {
        String result = "";
        int prev = 0;
        int t = 0;
        for(int i = 0; i < number.length(); i++) {
            int digit = number.charAt(i) - '0';
            t = 0;
            if((prev - digit) > 0) {
                t = 0;
                while((prev-digit) > t) {
                    result += ")";
                    t++;
                }
                result += number.charAt(i);
            }
            else if((prev - digit) < 0) {
                t = 0;
                while(Math.abs(prev-digit) > t) {
                    result += "(";
                    t++;
                }
                result += number.charAt(i);
            }
            else {
                t = 0;
                result += number.charAt(i);
            }
            prev = digit;
        }
        
        int digit = number.charAt(number.length() - 1) - '0';
        t = 0;
        if(digit > 0) {
            while((digit) > t) {
                result += ")";
                t++;
            }
        }
        return result;
    }

}