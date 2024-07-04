import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            String s = sc.next();
            StringBuffer newS = new StringBuffer();
            int c1 = s.charAt(0) - 48;
            for(int i = 0 ; i < c1 ; i++){
                newS.append("(");
            }
            newS.append(c1);
            for(int i = 1 ; i < s.length();i++){
                int c2 = s.charAt(i) - 48;
                if(c2 > c1){
                    for(int j = 0 ; j < c2-c1 ; j++){
                        newS.append("(");
                    }
                }else {
                    for (int j = 0; j < c1 - c2; j++) {
                        newS.append(")");
                    }

                }
                newS.append(c2);
                c1 = c2;
            }
            for(int i = 0 ; i < c1 ; i++){
                newS.append(")");
            }
            System.out.printf("\nCase #%d: %s",(x),newS);
        }
    }
}
