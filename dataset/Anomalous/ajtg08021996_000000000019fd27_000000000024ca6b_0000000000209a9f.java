import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.hasNext() ? sc.nextInt() : 0;
        
        for (int t = 0; t < T; t++) {
            String s = sc.hasNext() ? sc.next().strip() : "";
            
            char maxChar = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (maxChar < s.charAt(i)) {
                    maxChar = s.charAt(i);
                }
            }
            
            int l = maxChar;
            ArrayList<Character> al = new ArrayList<>();
            
            for (int i = 0; i < s.length(); i++) {
                int value = l + s.charAt(i) - maxChar - 48;
                
                if (value > 0 && Character.isDigit(s.charAt(i))) {
                    for (int j = 0; j < value; j++) {
                        al.add('(');
                    }
                    l -= value;
                    al.add(s.charAt(i));
                } else if (value < 0 && Character.isDigit(s.charAt(i))) {
                    value = -value;
                    for (int j = 0; j < value; j++) {
                        al.add(')');
                    }
                    maxChar -= value;
                    al.add(s.charAt(i));
                } else if (value == 0 && Character.isDigit(s.charAt(i))) {
                    al.add(s.charAt(i));
                }
            }
            
            char lastChar = s.charAt(s.length() - 1);
            for (int i = 0; i < lastChar - 48; i++) {
                al.add(')');
            }
            
            StringBuilder sb = new StringBuilder(al.size());
            for (Character c : al) {
                sb.append(c);
            }
            System.out.println("Case #" + (t + 1) + ": " + sb.toString());
        }
        
        sc.close();
    }
}