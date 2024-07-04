import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        String response = null;
        int testCasesCount = scanner.nextInt();
        int bitCount = scanner.nextInt();

        while(i <= testCasesCount){
            int attempts = 1;
            int bitNum = 1;
            StringBuilder sb = null;

            while(attempts <= 150) {
                solution.print(bitNum);
                response = scanner.next();
                if(attempts % 10 == 1){
                    sb = new StringBuilder();
                }

                sb.append(response);

                bitNum = (bitNum % 10) + 1;
                attempts++;
            }

            solution.print(sb);
            response = scanner.next();

            switch(response) {
                case "Y":
                    break;

                case "N":
                    return;
            }

            i++;
        }
    }

    public StringBuilder reverse(StringBuilder sb){
        StringBuilder newSb = new StringBuilder();
        for(int i = sb.length() - 1; i >= 0 ; i--){
            newSb.append(sb.charAt(i));
        }
        return newSb;
    }

    public StringBuilder reverseAndSlip(StringBuilder sb){
        StringBuilder newSb = new StringBuilder();
        for(int i = sb.length() - 1; i >= 0; i--){
            char c = sb.charAt(i) == '0' ? '1' : '0';
            newSb.append(c);
        }
        return newSb;
    }

    public StringBuilder flip(StringBuilder sb){
        StringBuilder newSb = new StringBuilder();
        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i) == '0' ? '1' : '0';
            newSb.append(c);
        }
        return newSb;
    }

    public void print(Object o){
        System.out.println(o + "");
        System.out.flush();
    }
}
