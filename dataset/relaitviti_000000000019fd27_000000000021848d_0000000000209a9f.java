import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
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
        for (int i = 0; i <str.length();i++) {
            int val = Character.getNumericValue(str.charAt(i));
            for (int j=0; j < val; j++) {
                stringBuilder.append('(');
            }
            stringBuilder.append(val);
            for (int j=0; j < val; j++) {
                stringBuilder.append(')');
            }
//            System.out.println(val);
        }
        System.out.println(stringBuilder);
        StringBuilder stringBuilder1 = new StringBuilder();
        String temp = "";
        for(int i=0; i < stringBuilder.length() - 1; i++) {
             if (stringBuilder.charAt(i+1) == '(' && stringBuilder.charAt(i) == ')' ) {
                 i++;
                 continue;
             } else {
                 stringBuilder1.append(stringBuilder.charAt(i));
                 temp=String.valueOf(stringBuilder.charAt(i));
             }
        }
        stringBuilder1.append(stringBuilder.charAt(stringBuilder.length()-1));
        String result  = stringBuilder1.toString();
        return  result;
    }
}
