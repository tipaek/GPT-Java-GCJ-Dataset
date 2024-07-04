import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        int testCasesCount = scanner.nextInt();
        while(i <= testCasesCount){
            String numberString = scanner.next();

            String output = solution.generateParenthesis(numberString);
            System.out.print("Case #" + i + ": " + output);
            System.out.println();
            i++;
        }
    }

    public String generateParenthesis(String numString){
        StringBuilder sb = new StringBuilder();
        char[] numArray = numString.toCharArray();

        int currentLevel = 0;
        for(int i = 0; i < numArray.length; i++){
            char c = numArray[i];
            int digit = Character.getNumericValue(c);

            if(currentLevel == digit){
                sb.append(c);
            } else if(currentLevel < digit){
                append(sb, '(', digit - currentLevel); //(((3))1(2((4))2))
                sb.append(c);
                currentLevel = digit;
            } else if(currentLevel > digit){
                append(sb, ')', currentLevel - digit);
                sb.append(c);
                currentLevel = digit;
            }
        }
        if(currentLevel > 0){
            append(sb, ')', currentLevel);
        }
        return new String(sb);
    }

    public void append(StringBuilder sb, char c, int count){
        while(count > 0){
            sb.append(c);
            count--;
        }
    }
}
