import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> answer = new ArrayList<>();
        while (n > 0) {
            String m = sc.nextLine();
            answer.add(calculate(m));
            n--;
        }
        for (int i = 0 ; i < answer.size(); i++) {
            int j = i+1;
            System.out.println("Case #" + j + ": " + answer.get(i));
        }
    }
   public static String calculate(String str) {
//        System.out.println(str.length());
        StringBuilder stringBuilder = new StringBuilder();
        int openCount = 0 ;
        int closeCount = 0 ;
        int prev = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = Character.getNumericValue(str.charAt(i));
//            System.out.println(val + " " + openCount + " " + closeCount + " " + prev);
            openCount = val;
            if (val > prev) {
                while (openCount > prev) {
                    stringBuilder.append('(');
                    openCount--;
                    closeCount++;
                }
                stringBuilder.append(val);
            }
            if (val < prev) {
                while (closeCount > val) {
                    stringBuilder.append(')');
                    closeCount--;
                }
                stringBuilder.append(val);
            }
            if (val == prev) stringBuilder.append(val);
            prev = val;
        }
        if (closeCount > 0) {
            while(closeCount > 0) {
                stringBuilder.append(')');
                closeCount--;
            }
        }
        String result  = stringBuilder.toString();
        return  result;
    }
}
