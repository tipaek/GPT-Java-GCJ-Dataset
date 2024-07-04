import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int t1 = 0; t1 < t; t1++) {
            int n = scan.nextInt();
            String[] str = new String[n];

            for (int i = 0; i < n; i++) {
                str[i] = scan.next();
            }

            for (int i = 1; i < n; i++) {
                String temp = str[i];
                int j = i - 1;
                while (j >= 0 && temp.length() < str[j].length()) {
                    str[j + 1] = str[j];
                    j--;
                }
                str[j + 1] = temp;
            }

            int flag = 0;
            for (int i = 0; i < str.length; i++) {
                String s = str[i];
                str[i] = s.replace("*", "");
            }

            for (int i = 0; i < str.length; i++) {
                for (int j = i + 1; j < str.length; j++) {
                    if (!str[j].contains(str[i])) {
                        flag=1;
                        break;
                    }
                }
            }

            if(flag==1) System.out.println("Case #" + (t1+1) + ": " + "*");
            else {
                String s = str[str.length-1];
                System.out.println("Case #"+ (t1+1)+": "+s);
            }
        }
    }
}
