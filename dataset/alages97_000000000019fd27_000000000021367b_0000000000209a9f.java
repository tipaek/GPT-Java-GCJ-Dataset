import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int j = 0; j < N; j++) {
            String input = sc.next();
            StringBuffer string = new StringBuffer(input);
            StringBuffer modifiedString = new StringBuffer();

            int oneIndex = 0;
            int oneEndIndex = 0;
            boolean start = false;
            int paranInsertCount = 0;

            int i = 0;

            while (i < string.length()) {
                if (string.charAt(i) == '1' && !start) {
                    start = true;
                    modifiedString.append('(');
                    modifiedString.append('1');
                }
                else if (string.charAt(i) == '0' && start) {
                    start = false;
                    modifiedString.append(')');
                    modifiedString.append('0');
                } else {
                    modifiedString.append(string.charAt(i));
                }
                i++;
            }


            if (start) {
                modifiedString.append(')');
            }
            System.out.println("Case #" + (j+1) + ": " + modifiedString.toString());
        }
    }
}
