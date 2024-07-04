import java.util.Scanner;

class Solution {
    static StringBuilder fin = new StringBuilder();
    static String st = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            st = sc.next();
            int len = st.length();
            int rem = 0;

            // Add leading zeros to the result
            while (rem < len && st.charAt(rem) == '0') {
                fin.append('0');
                rem++;
            }

            if (rem != len) {
                int temp = Character.getNumericValue(st.charAt(rem));
                open(temp);
                fin.append(temp);

                for (int x = rem; x < len - 1; x++) {
                    int temp1 = Character.getNumericValue(st.charAt(x));
                    int temp2 = Character.getNumericValue(st.charAt(x + 1));

                    if (temp2 > temp1) {
                        open(temp2 - temp1);
                        fin.append(temp2);
                    } else if (temp2 < temp1) {
                        close(temp1 - temp2);
                        fin.append(temp2);
                    } else {
                        fin.append(temp2);
                    }
                }

                temp = Character.getNumericValue(st.charAt(len - 1));
                close(temp);
            }

            System.out.println("Case #" + caseNumber + ": " + fin.toString());
            caseNumber++;
            fin.setLength(0);  // Reset the StringBuilder
            st = "";
        }
        sc.close();
    }

    static void open(int n) {
        for (int x = 0; x < n; x++) {
            fin.append('(');
        }
    }

    static void close(int n) {
        for (int x = 0; x < n; x++) {
            fin.append(')');
        }
    }
}