import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            String S = scan.next();

            StringBuilder sb = new StringBuilder();

            int open = 0;
            char[] nums = S.toCharArray();
            for(int i=0; i<nums.length; i++){
                int curr = nums[i] - '0';

                if(open < curr){
                    if(open > 0 && sb.length() > 0){
                        sb.append(")");
                        open--;
                    }
                    while(true){
                        sb.append("(");
                        open++;
                        if(open == curr){
                            break;
                        }
                    }
                }else if(open > curr){
                    while(true){
                        sb.append(")");
                        open--;
                        if(open == curr){
                            break;
                        }
                    }
                }
                sb.append(curr);
            }

            while(open > 0){
                sb.append(")");
                open--;
            }

            System.out.println("Case #" + t + ": " + sb.toString());
        }

        scan.close();


    }
}