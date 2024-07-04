import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            caseNumber++;
            String s = sc.next();
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);

                if (currentChar == '1') {
                    ans.append('(');
                    for (int j = i; j < s.length(); j++) {
                        char nextChar = s.charAt(j);

                        if (nextChar == '1') {
                            ans.append(nextChar);
                            if (j == s.length() - 1) {
                                ans.append(')');
                                i = j;
                                break;
                            }
                        } else {
                            ans.append(')');
                            ans.append(nextChar);
                            i = j;
                            break;
                        }
                    }
                } else {
                    ans.append(currentChar);
                }
            }

            System.out.println(ans.toString());
        }

        sc.close();
    }
}