import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
        public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        String[] strings = new String[t];
        for (int l = 0; l < t; l++) {
            int low = 0;
            String result = "";
            strings[l] = scanner.next();
            for (int i = 0; i < strings[l].length(); i++) {
                if (i == strings[l].length() - 1 || strings[l].charAt(i) != strings[l].charAt(i + 1)) {
                    if (strings[l].charAt(i) == '1') result += "(" + strings[l].substring(low, i + 1) + ")";
                    else result += strings[l].substring(low, i + 1);
                    low = i + 1;
                }
            }
            System.out.println("Case #" + (l + 1) + ": " + result);
        }
    }
}