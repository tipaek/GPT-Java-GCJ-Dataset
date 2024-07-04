import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner std = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = std.nextInt();
        std.nextLine();
        int caseN = 0;
        while (caseN++ < t) {
            String s = "0" + std.nextLine() + "0";
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int diff = s.charAt(i+1) - s.charAt(i);
                for (int j = 0; j < Math.abs(diff); j++) {
                    if (diff > 0) {
                        tmp.append("(");
                    } else {
                        tmp.append(")");
                    }
                }
                if (i < s.length() - 2) {
                    tmp.append(s.charAt(i+1));
                }
            }
            log.write("Case #" + caseN + ": " + tmp.toString() + "\n");
        }
        log.flush();
    }
}
