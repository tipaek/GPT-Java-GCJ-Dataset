
import java.util.*;


/**
 * 231
 * ((2)((3))1)
 *
 * 6421
 *
 * ((((((6))4))2)1)
 *
 * 246
 * ((2)(((4)(6)))
 *
 * 36
 *
 * (((3)((((6
 *
 *
 * 12345
 * (1)((2)((3)(((4
 */


class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Solution s = new Solution();
        final int cas = scanner.nextInt();
        for (int ca=1; ca<=cas; ca++){
            final String str = scanner.next().replaceAll("[()]", "");
            int stackNumber= 0;
            final char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<chars.length;i++){
                if (i==0){
                    if (chars[i]=='0'){
                        sb.append('0');
                    }else{
                        stackNumber = Character.getNumericValue(chars[i]);
                        sb.append(nParanthes(stackNumber, '('));
                        sb.append(chars[i]);
                    }
                    if (i==chars.length-1){
                        sb.append(nParanthes(stackNumber, ')'));
                    }
                }else{
                    int current = Character.getNumericValue(chars[i]);
                    int previous = Character.getNumericValue(chars[i-1]);
                    if (current==previous) sb.append(chars[i]);
                    else if (current==0){
                        sb.append(nParanthes(stackNumber, ')'));
                        sb.append('0');
                        stackNumber=0;
                    } else if (current < previous){
                        int delta = previous - current;
                        stackNumber = stackNumber - delta;
                        sb.append(nParanthes(delta, ')'));
                        sb.append(chars[i]);
                    }else { //current > previous
                        if (previous==0){
                            sb.append(nParanthes(current, '('));
                            sb.append(chars[i]);
                            stackNumber=current;
                        } else{
                            //sb.append(')');
                            int delta = current-previous;
                            sb.append(nParanthes(delta, '('));
                            sb.append(chars[i]);
                            stackNumber = current;
                        }
                    }

                    if (i==chars.length-1){
                        sb.append(nParanthes(current, ')'));
                    }
                }
            }
            System.out.println( String.format("Case #%d: %s", ca, sb.toString()));
        }
    }

    private static String nParanthes(int delta, char c) {
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<delta; j++){
            sb.append(c);
        }
        return sb.toString();
    }
}
