import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int max = 1441;
        for (int i = 1; i <= t; i++) {
            int task = in.nextInt();
            StringBuilder sb = new StringBuilder();
            boolean[] one = new boolean[max];
            boolean[] two = new boolean[max];
            int assign = 1;
            while(task-- > 0){
                    int sTemp = in.nextInt();
                    int eTemp = in.nextInt();
                    if ( sTemp < one.length && eTemp < one.length && one[sTemp] == false && one[eTemp] == false) {
                        assign = 1;
                    } else if ( sTemp < two.length && eTemp < two.length && two[sTemp]  == false && two[eTemp]  == false) {
                        assign = 2;
                    } else {
                        sb = new StringBuilder();
                        sb.append("IMPOSSIBLE");
                        task = -1;

                    }
                    if (assign == 1 && task != -1) {
                        for(int k=sTemp; k<=Math.min(eTemp-1,24*60); k++){
                            one[k] = true;
                        }
                        sb.append('J');
                    } else if(assign == 2 && task != -1){
                        for(int k=sTemp; k<=Math.min(eTemp-1,24*60); k++){
                            two[k] = true;
                        }
                        sb.append('C');
                    }
            }

            String ans = sb.toString();
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}