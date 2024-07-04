import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t=1; t<=T; t++) {
            int N = sc.nextInt();
            String leftGlobal = "";
            String rightGlobal = "";
            boolean valid = true;

            for (int n=0; n<N ; n++) {
                String s = sc.next().trim();
                int i = s.indexOf('*');

                String right = s.substring(i+1);
                String left = s.substring(0, i);

                if (left.length() > leftGlobal.length()) {
                    if (left.startsWith(leftGlobal)) {
                        leftGlobal = left;
                    }else {
                        valid = false;
                    }
                }else {
                    if (!leftGlobal.startsWith(left)) {
                        valid = false;
                    }
                }


                if (right.length() > rightGlobal.length()) {
                    if (right.endsWith(rightGlobal)) {
                        rightGlobal = right;
                    }else {
                        valid = false;
                    }
                }else {
                    if (!rightGlobal.endsWith(right)) {
                        valid = false;
                    }
                }
            }

            if (!valid){
                System.out.println("Case #"+t+": *");
            }else {
                System.out.println("Case #"+t+": " + getAns(leftGlobal, rightGlobal));
            }
        }
    }

    private static String getAns (String left, String right){
        int i = 0;

        while (i<right.length() && i<left.length() && left.charAt(left.length()-i-1)==right.charAt(i)){
            i++;
        }

        return left.substring(0, left.length()-i)+right;
    }
}
