

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {
            StringBuilder builder = new StringBuilder();
            String candidate = br.readLine();
            int first = candidate.charAt(0) - '0';
            int end = first;
            for (int idx = 0; idx < first; idx++) {
                builder.append("(");
            }
            builder.append(first);
            for (int index = 1; index < candidate.length(); index++) {
                int value = candidate.charAt(index) - '0';
                if (value == first) {
                    builder.append(value);
                } else if (value < first) {
                    int diff = first - value;
                    for (int idx = 0; idx < diff; idx++) {
                        builder.append(")");
                    }
                    builder.append(value);
                    end = end - diff;
                } else if(value > first) {
                    int diff = value - end;
                    end = value;
                    for (int idx = 0; idx < diff; idx++) {
                        builder.append("(");
                    }
                    builder.append(value);
                }
                first = value;
            }
            for (int idx = 0; idx < end; idx++) {
                builder.append(")");
            }
            System.out.println(builder.toString());
        }
    }


}
