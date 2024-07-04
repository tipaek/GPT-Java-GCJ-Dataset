import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner std = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder strBu = new StringBuilder();

        int t = std.nextInt();

        int caseN = 0;
        while (caseN++ < t) {
            int n = std.nextInt();
            std.nextLine();
            strBu = new StringBuilder();
            String[] arr = new String[n];
            boolean isPos = true;
            int maxSize = 0;
            int ind = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = std.nextLine();
                if (maxSize < arr[i].length()) {
                    maxSize = arr[i].length();
                    ind = i;
                }
            }

            for (int j = 1; j < arr[ind].length(); j++) {
                char tm = arr[ind].charAt(arr[ind].length() - j);
                for (int i = 0; i < n; i++) {
                    if (arr[i].length() - j >= 1) {
                        if (arr[i].charAt(arr[i].length() - j) != tm) {
                            isPos = false;
                        }
                    }
                }
                if (!isPos) {
                    break;
                } else {
                    strBu.insert(0, tm);
                }
            }

            if (isPos) {
                log.write("Case #" + caseN + ": " + strBu.toString());
                log.write("\n");
            } else {
                log.write("Case #" + caseN + ": *");
                log.write("\n");
            }

        }
        log.flush();

    }
}
