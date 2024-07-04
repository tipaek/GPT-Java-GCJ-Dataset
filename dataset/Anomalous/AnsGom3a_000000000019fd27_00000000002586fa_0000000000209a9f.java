import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte t = input.nextByte();
        
        for (byte x = 1; x <= t; x++) {
            String s = "0" + input.next();
            StringBuilder nS = new StringBuilder();
            byte len = (byte) s.length();
            byte opened = 0;
            
            for (byte i = 0; i < len - 1; i++) {
                byte temp = (byte) (s.charAt(i + 1) - s.charAt(i));
                
                if (temp > 0) {
                    while (temp-- > 0) {
                        nS.append('(');
                        opened++;
                    }
                } else {
                    while (temp++ < 0) {
                        nS.append(')');
                        opened--;
                    }
                }
                nS.append(s.charAt(i + 1));
            }
            
            while (opened-- > 0) {
                nS.append(')');
            }
            
            System.out.println("case #" + x + ": " + nS.toString());
        }
        
        input.close();
    }
}