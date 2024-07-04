import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.zip.ZipEntry;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int p = in.nextInt();
            in.nextLine();
            String maxLengthString = "";
            String[] strings = new String[p];
            for (int j = 0; j < p; j++) {
                strings[j] = in.nextLine().replace("*", "[A-Z]*");
                if (maxLengthString.length() < strings[j].length()) {
                    maxLengthString = strings[j];
                }
            }
            maxLengthString = maxLengthString.substring(6);
            boolean matches = true;
            for (String string : strings) {
                if (!maxLengthString.matches(string)) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                System.out.println("Case #" + i + ": " + maxLengthString);
            } else {
                System.out.println("Case #" + i + ": *");
            }
        }
    }
}
