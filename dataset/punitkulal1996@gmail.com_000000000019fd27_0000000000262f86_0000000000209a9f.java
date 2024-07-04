import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.nextLine());
        for (int i = 0; i < T; i++) {
            String S = s.nextLine();
            char[] chars = S.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            int height = 0;
            for (int j = 0; j < chars.length; j++) {
                int value = Character.getNumericValue(chars[j]);
                    while(!(height == value)) {
                        if (height < value) {
                            stringBuilder.append('(');
                            height++;
                        } else if (height > value) {
                            stringBuilder.append(')');
                            height--;
                        }
                    }
                stringBuilder.append(value);
            }
            while (height != 0){
                stringBuilder.append(')');
                height--;
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
