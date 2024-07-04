import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int cs=1; cs<=T; cs++) {
            String raw = input.next();
            String newS = "";
            boolean is1Found = false;
            for(char c : raw.toCharArray()) {
                if(c == '1') {
                    if(!is1Found) {
                        is1Found = true;
                        newS += "(";
                    }
                } else {
                    if(is1Found) {
                        is1Found = false;
                        newS += ")";
                    }
                }
                newS += c;
            }
            if(is1Found) {
                newS += ")";
            }
            System.out.println("Case #" + cs + ": " + newS);
        }
    }
}