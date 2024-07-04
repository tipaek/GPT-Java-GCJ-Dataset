import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int max = 1441;
        boolean check = true;
        for (int i = 1; i <= t; i++) {
            int task = in.nextInt();

            StringBuilder sb = new StringBuilder();
            boolean[] one = new boolean[max];
            boolean[] two = new boolean[max];
            int assign = 1;
            while(task-- > 0){
                int sTemp = in.nextInt();
                int eTemp = in.nextInt();
                if ( one[sTemp] == false && one[eTemp] == false) {
                    assign = 1;
                } else if (two[sTemp]  == false && two[eTemp]  == false) {
                    assign = 2;
                } else {
                    sb = new StringBuilder("IMPOSSIBLE");
                    check = false;
                }
                if (assign == 1 && check) {
                    for(int k=sTemp; k<eTemp; k++){
                        one[k] = true;
                    }
                    sb.append('J');
                } else if(assign == 2 && check){
                    for(int k=sTemp; k<eTemp; k++){
                        two[k] = true;
                    }
                    sb.append('C');
                }
            }
            String ans = sb.toString();
            System.out.println("Case #" + i + ": " + ans);
            check = true;
        }
    }
}