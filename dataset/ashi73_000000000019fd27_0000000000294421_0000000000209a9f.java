import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int count =0;
            String sIn = sc.next();
            String sOut = "";
            for (int j = 0; j < sIn.length(); j++) {
                char ch = sIn.charAt(j);
                int num = Integer.parseInt(ch + "");
                if (num == 0) {
                    sOut = sOut + num;
                } else {
                    if(count<=0){
                        for (int k = 1; k <= num; k++) {
                            sOut = sOut + "(";
                            count++;
                        }
                        sOut = sOut + num;
                    }
                    if(count > 0 && j<sIn.length()-1){
                        int num2 = Integer.parseInt(sIn.charAt(j+1) + "");
                        int diff = num-num2;
                        if(diff>0){
                            for (int k = 1; k <= diff; k++) {
                                sOut = sOut + ")";
                                count--;
                            }
                        }else if(diff<0) {
                            diff = -diff;
                            for (int k = 1; k <= diff; k++) {
                                sOut = sOut + "(";
                                count++;
                            }
                        }
                        sOut = sOut + num2;
                    }
                    if(j==sIn.length()-1){
                        for (int k = 1; k <= num; k++) {
                            sOut = sOut + ")";
                        }

                    }

                }
            }
            System.out.println("Case #" + i + ": " + sOut);
        }
    }
}