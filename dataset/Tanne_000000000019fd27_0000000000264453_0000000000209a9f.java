import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = scan.next();
            String y = "";
            boolean open = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    if (!open) {
                        y += "(1";
                        open = true;
                    } else {
                        y+= "1";
                    }
                } else {
                    if (!open){
                        y+="0";
                    } else {
                        y+=")0";
                        open = false;
                    }
                }
            }
            if (s.charAt(s.length()-1)== '1')y+=")";
            System.out.println("Case #" + i + ": " + y);
        }
    }
}
