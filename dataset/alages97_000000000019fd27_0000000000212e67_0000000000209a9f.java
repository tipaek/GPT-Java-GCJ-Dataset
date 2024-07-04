import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int j = 0; j < N; j++) {
            String input = sc.next();
            StringBuffer string = new StringBuffer(input);
            StringBuffer modifiedString = new StringBuffer(input);

            int oneIndex = 0;
            int oneEndIndex = 0;
            boolean start = false;
            int paranInsertCount = 0;

            int i = 0;

            while (i < string.length()) {
                if (string.charAt(i) == '1' && !start) {
                    start = true;
                    oneIndex = i;
                }
                if (string.charAt(i) == '0' && start) {
                    start = false;
                    oneEndIndex = i;
                    paranInsertCount++;
                    modifiedString.insert(oneEndIndex*paranInsertCount, ')');
                    modifiedString.insert(oneIndex*paranInsertCount, '(');
                }
                i++;
            }


            if (start) {
                oneEndIndex = string.length();
                paranInsertCount++;
                modifiedString.append(')');
                modifiedString.insert(oneIndex*paranInsertCount, '(');
            }
            System.out.println("Case #" + (j+1) + ": " + modifiedString.toString());
        }
    }
}
