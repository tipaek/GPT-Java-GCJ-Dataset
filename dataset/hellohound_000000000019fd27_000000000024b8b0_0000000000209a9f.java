import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc= 1; tc<= t; tc++) {
            String str = sc.next();
            int prev = 0;
            int close = 0;
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < str.length(); i++) {
                int temp = Character.getNumericValue(str.charAt(i));
                if(temp > prev) {
                    int open = temp-prev;
                    for(int j = 0; j < open; j++) sb.append('(');
                    close += open;
                    
                    sb.append(str.charAt(i));
                } else if (temp < prev) {
                    int cl = prev-temp;
                    for(int j = 0; j < cl; j++) sb.append(')');
                    close -= cl;
                    sb.append(str.charAt(i));
                } else {
                    sb.append(str.charAt(i));
                }
                prev = temp;
            }
            
            for(int i = 0; i < close; i++) sb.append(')');
            
            String ans = sb.toString();
            System.out.println("Case #" + tc + ": " + ans);
        }
    }
}