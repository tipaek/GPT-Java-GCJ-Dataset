import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());
        
        for (int test = 1; test <= testcase; test++) {
            String S = sc.nextLine();
            StringBuilder ans = new StringBuilder();
            int open = 0;

            for (int i = 0; i < S.length(); i++) {
                int number = Character.getNumericValue(S.charAt(i));
                
                if (i == 0) {
                    ans.append("(".repeat(Math.max(0, number)));
                    ans.append(number);
                    open = number;
                } else {
                    int prevNumber = Character.getNumericValue(S.charAt(i - 1));
                    if (number > prevNumber) {
                        ans.append("(".repeat(Math.max(0, number - prevNumber)));
                    } else if (number < prevNumber) {
                        ans.append(")".repeat(Math.max(0, prevNumber - number)));
                    }
                    ans.append(number);
                    open = number;
                }
            }
            
            ans.append(")".repeat(Math.max(0, open)));
            System.out.println("Case #" + test + ": " + ans);
        }
        
        sc.close();
    }
}