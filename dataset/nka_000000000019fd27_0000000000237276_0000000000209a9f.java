import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int x = 1;
        while (T > 0) {
            String input = sc.nextLine();
            String output = "";
            int openBracketCount = 0;
            int len = input.length();
            int digit1 = Integer.parseInt(String.valueOf(input.charAt(0)));

            while (digit1 > 0) {
                output += "(";
                digit1--;
                openBracketCount++;
            }
            output+=input.charAt(0);
            for (int i = 1; i < len; i++) {
                if (input.charAt(i) == '0') {
                    while (openBracketCount > 0) {
                        output += ")";
                        openBracketCount--;
                    }
                    output += input.charAt(i);
                } else if (input.charAt(i - 1) == input.charAt(i)) {
                    output += input.charAt(i);
                } else if(input.charAt(i-1)!='0') {
                    int digit = Integer.parseInt(String.valueOf(input.charAt(i)));

                    output += ")";
                    openBracketCount--;

                    int tempValue = digit - openBracketCount;
                    //System.out.println(tempValue+" "+digit);
                    if (tempValue <= 0) {
                        output += "(";
                        openBracketCount++;
                    }
                    while (tempValue > 0) {
                        output += "(";
                        tempValue--;
                        // System.out.println(tempValue+" "+digit);
                        openBracketCount++;
                    }

                    output += input.charAt(i);
                }
                else{
                    int digit = Integer.parseInt(String.valueOf(input.charAt(i)));
                    while (digit>0){
                        output+="(";
                        digit--;
                        openBracketCount++;
                    }
                    output+=input.charAt(i);
                }
            }
            while (openBracketCount > 0) {
                output += ")";
                openBracketCount--;
            }

            System.out.println("Case #" + x + ": " + output);
            T--;
            x++;
        }
    }
}
