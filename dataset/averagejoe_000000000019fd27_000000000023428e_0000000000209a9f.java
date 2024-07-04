import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static String output = "";

    public static void main(String[] args) {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int cases;
        try {
            cases = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < cases; i++) {

                String[] strDigits = br.readLine().split("");

                int len = strDigits.length;
                int[] d = new int[len + 1];
                d[len] = 0;
                for (int j = 0; j < len; j++) {
                    d[j] = Integer.parseInt(strDigits[j]);
                }

                StringBuilder sb = new StringBuilder();
                int start = 0;
                int heses = 0;
                for (int digit : d) {
                    heses = digit - start;
                    while (heses > 0) {
                        sb.append('(');
                        heses--;
                    }
                    while (heses < 0) {
                        sb.append(')');
                        heses++;
                    }
                    sb.append(String.valueOf(digit));
                    start = digit;
                }

                sb.deleteCharAt(sb.lastIndexOf("0"));
                System.out.println(String.format("Case #%d: %s", i + 1, sb.toString()));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
