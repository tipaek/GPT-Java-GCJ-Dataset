import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int inputCount = Integer.parseInt(scanner.nextLine());

        List<String> str = new ArrayList<>();

        for (int c = 0; c < inputCount; c++) {

            System.out.print("Case #" + (c + 1) + ":");
            String line = scanner.nextLine();
            str.add(line);
            int preVal = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            for (int i = 0; i <= line.length(); i++) {
                int val = 0;
                if (i != line.length()) {
                    val = Integer.parseInt(line.charAt(i) + "");
                }

                if (preVal < val) {
                    for (int x = 0; x < (val - preVal); x++) {
                        sb.append("(");
                    }
                } else if (preVal > val) {
                    for (int x = 0; x < (preVal - val); x++) {
                        sb.append(")");
                    }
                }
                if (i != line.length()) {
                    sb.append(val);
                }

                preVal = val;
            }
            System.out.println(sb.toString());
        }


    }
}
