import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            String s = sc.next();
            char[] sArray = s.toCharArray();


            int depth = 0;
            ArrayList<Character> result = new ArrayList<>();
            for(char c : sArray) {

                int valC = c - '0';
                while(valC - depth > 0) {
                    result.add('(');
                    depth ++;
                }

                while(valC - depth < 0) {
                    result.add(')');
                    depth --;
                }

                result.add(c);

            }

            while(depth > 0) {
                result.add(')');
                depth --;
            }
            System.out.print("Case #" + i + ": ");
            for(Character c : result)
                System.out.print(c);

            System.out.println();
        }


       sc.close();

    }
}
