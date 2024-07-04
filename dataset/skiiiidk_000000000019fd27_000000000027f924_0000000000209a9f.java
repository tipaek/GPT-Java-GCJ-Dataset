import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = scan.nextInt();
        scan.nextLine();
        int count = 1;
        while (t-- > 0) {
            String ans = "";
            String input = scan.nextLine();
            //System.out.println(input);
            char[] inputs = input.toCharArray();

            for (int i = 0; i < inputs.length; i++) {
                if (i == 0) {
                    int diff1 = inputs[i] - '0';
                    for (int o = 0; o < diff1; o++) {
                        ans += "(";
                    }
                }
                ans += inputs[i];
                if (i == inputs.length - 1) {
                    int diff = inputs[i] - '0';

                    for (int o = 0; o < diff; o++) {
                        ans += ")";
                    }
                } else {
                    int diff = inputs[i] - inputs[i + 1];
                    if (diff > 0) {

                        for (int o = 0; o < diff; o++) {
                            ans += ")";
                        }
                    }
                    if (diff < 0) {
                        diff = -diff;

                        for (int o = 0; o < diff; o++) {
                            ans += "(";
                        }
                    }
                }
            }
            //System.out.println(count);
            //System.out.println(ans);
            log.write("Case #" + (count) + ": " + ans + "\n");
            //System.out.println(colRep);
            count++;
        }
        log.flush();

    }
}
