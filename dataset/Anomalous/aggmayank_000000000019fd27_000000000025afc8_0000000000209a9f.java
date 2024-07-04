import java.util.Scanner;

class Solution {
    
    static String repeatChar(char ch, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    static String addOpen(int n) {
        return repeatChar('(', n);
    }

    static String addClose(int n) {
        return repeatChar(')', n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        for (int c = 1; c <= t; c++) {
            String str = in.nextLine();
            int bcount = 0;
            char firstChar = str.charAt(0);
            int firstDigit = firstChar - '0';
            StringBuilder ans = new StringBuilder();

            if (firstDigit != 0) {
                ans.append(addOpen(firstDigit)).append(firstChar);
                bcount = firstDigit;
            } else {
                ans.append("0");
            }

            for (int i = 1; i < str.length(); i++) {
                int currentDigit = str.charAt(i) - '0';
                if (bcount == currentDigit) {
                    ans.append(str.charAt(i));
                } else if (bcount > currentDigit) {
                    int diff = bcount - currentDigit;
                    ans.append(addClose(diff));
                    bcount -= diff;
                    ans.append(str.charAt(i));
                } else {
                    int diff = currentDigit - bcount;
                    bcount += diff;
                    ans.append(addOpen(diff)).append(str.charAt(i));
                }
            }

            if (bcount != 0) {
                ans.append(addClose(bcount));
            }

            System.out.println("Case #" + c + ": " + ans.toString());
        }

        in.close();
    }
}