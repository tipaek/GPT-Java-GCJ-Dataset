import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input

        for (int i = 0; i < t; i++) {
            String a = sc.nextLine();
            char[] chArray = a.toCharArray();
            ArrayList<Character> charList = new ArrayList<>();

            for (char ch : chArray) {
                int num = Character.getNumericValue(ch);
                for (int j = 0; j < num; j++) {
                    charList.add('(');
                }
                charList.add(ch);
                for (int j = 0; j < num; j++) {
                    charList.add(')');
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char character : charList) {
                sb.append(character);
            }

            while (sb.indexOf(")(") != -1) {
                int index = sb.indexOf(")(");
                sb.delete(index, index + 2);
            }

            System.out.println("Case #" + (i + 1) + ": " + sb);
        }
        sc.close();
    }
}