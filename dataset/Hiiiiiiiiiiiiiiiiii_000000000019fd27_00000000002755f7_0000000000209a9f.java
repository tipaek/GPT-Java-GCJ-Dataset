import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int i=1; i <= tc; i++) {
            String input = sc.next();
            String result = "";

            for(int j=0; j < input.length(); j++) {
                if(j == 0) {
                    int len = (int)(input.charAt(j) - '0');
                    
                    for (int k = 0; k < len; k++) {
                        result += "(";
                    }

                    result += input.charAt(j);
                } else {
                    int prev = (int)(input.charAt(j-1) - '0');
                    int now = (int)(input.charAt(j) - '0');
                    int diff =  prev - now;

                    if(diff >= 0) {
                        for(int k=0; k < diff; k++) {
                            result += ")";
                        }

                        result += input.charAt(j);
                    } else {
                        for(int k=0; k < Math.abs(diff); k++) {
                            result += "(";
                        }

                        result += input.charAt(j);
                    }
                }
            }

            int lastLen = input.charAt(input.length()-1) - '0';
            for(int j=0; j < lastLen; j++) {
                result += ")";
            }


            System.out.println("Case #" + i + ": " + result);
        }
    }


}
