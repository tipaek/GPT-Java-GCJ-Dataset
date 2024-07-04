import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for(int i = 1; i <= T; i++) {
            String s = null;
            int[] array = new int[B];
            if(B == 10) {
                for(int j = 1; j <= 10; j++) {
                    System.out.println(j);
                    s = input.next();
                    array[j-1] = Integer.parseInt(s);
                }
            }
            else if(B == 20) {
                
            }
            else {

            }
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < B; k++) {
                sb.append(array[k]);
            }
            System.out.println(sb.toString());
            s = input.next();
            if(s.equals("Y")) {
                continue;
            }
            else if(s.equals("N")) {
                break;
            }
        }
    }
}