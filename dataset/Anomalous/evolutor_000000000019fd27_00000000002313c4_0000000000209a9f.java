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
                char c = s.charAt(i);
                if (c == '1') {
                    ans.append('(');
                    for (int j = i; j < s.length(); j++) {
                        char k = s.charAt(j);

                        if (k == '1') {
                            ans.append(k);
                            if (j == s.length() - 1) {
                                ans.append(')');
                                i = j;
                                break;
                            }
                        } else {
                            ans.append(')').append(k);
                            i = j;
                            break;
                        }
                    }
                } else {
                    ans.append(c);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + ans.toString());
        }

        sc.close();
    }
}