import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            int currDepth = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < str.length(); j++) {
                if(Character.getNumericValue(str.charAt(j)) >  currDepth) {
                    for (int k = 0; k < Character.getNumericValue(str.charAt(j)) - currDepth; k++) {
                        sb.append('(');
                    }
                    currDepth = Character.getNumericValue(str.charAt(j));
                    sb.append(str.charAt(j));
                } else if (Character.getNumericValue(str.charAt(j)) <  currDepth) {
                    for (int k = 0; k < currDepth - Character.getNumericValue(str.charAt(j)); k++) {
                        sb.append(')');
                    }
                    currDepth = Character.getNumericValue(str.charAt(j));
                    sb.append(str.charAt(j));
                } else {
                    sb.append(str.charAt(j));
                }
            }
            for (int k = 0; k < currDepth; k++) {
                sb.append(')');
            }

            System.out.printf("Case #%d: %s\n", i + 1, sb.toString());
        }
    }
}

