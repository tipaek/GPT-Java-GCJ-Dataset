import java.util.Scanner;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int query = in.nextInt();
        
        for (int i = 0; i < query; i++) {
            String s = in.next();
            StringBuilder newS = new StringBuilder();
            int prevNum = -1, bracCount = 0;

            for (char ch : s.toCharArray()) {
                int num = Character.getNumericValue(ch);
                
                if (num > prevNum) {
                    newS.append("(".repeat(num - bracCount));
                    bracCount = num;
                } else if (num < prevNum) {
                    newS.append(")".repeat(bracCount - num));
                    bracCount = num;
                }
                
                newS.append(num);
                prevNum = num;
            }
            
            if (bracCount > 0) {
                newS.append(")".repeat(bracCount));
            }
            
            answer.append("Case #").append(i + 1).append(": ").append(newS).append("\n");
        }
        
        System.out.print(answer);
        in.close();
    }
}