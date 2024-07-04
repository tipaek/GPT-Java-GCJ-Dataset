
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
        int i = Math.min(left.length(), right.length())-1;
        while (true) {
            String s = left.substring(left.length() - 1 - i);
            if (right.startsWith(s)) {
                break;
            }
            i--;
        }

        System.out.println("i = "+i);
        return left.substring(0, left.length()-i)+right;
    }
    
//    private static int getPivotIndex(String left, String right, int left_index, int right_index) {
//        int mid = (left_index+right_index)/2;
//        
//        if (right.startsWith(left.substring(left.length()-1-mid))){
//            if (mid==left_index){
//                return getPivotIndex(left, right, mid, right_index);
//            }
//        }
//        return getPivotIndex(left, right, left_index, mid);
//    }
}
