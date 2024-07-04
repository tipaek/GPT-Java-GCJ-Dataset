import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            String s = sc.next();
            StringBuilder str = new StringBuilder();
            int cur = 0;
            
            for (int i = 0; i < s.length(); i++) {
                int num = Character.getNumericValue(s.charAt(i));
                
                if (num > cur) {
                    str.append("(".repeat(num - cur));
                } else if (num < cur) {
                    str.append(")".repeat(cur - num));
                }
                
                str.append(s.charAt(i));
                cur = num;
            }
            
            str.append(")".repeat(cur));
            System.out.println("Case #" + t + ": " + str);
        }
    }
}