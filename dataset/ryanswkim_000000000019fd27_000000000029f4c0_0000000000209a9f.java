import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            char[] cur = in.next().toCharArray();
            int[] num = new int[cur.length];
            for (int j = 0; j < cur.length; j++) {
                num[j] = cur[j] - '0';
            }
            String ret = "";
            boolean started = false;
            for (int j = 0; j < num.length; j++) {
                if(num[j] == 1){
                    if (!started){
                        started = true;
                        ret = ret + "(1";
                    } else{
                        ret = ret + "1";
                    }
                }
                if(num[j] == 0){
                    if (started){
                        started = false;
                        ret = ret + ")0";
                    } else{
                        ret = ret + "0";
                    }
                }
                if (j == num.length - 1 && started){
                    ret = ret + ")";
                }
            }
            System.out.println("Case #" + i + ": "+ ret);
        }
    }
}
