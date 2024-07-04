import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.valueOf(scanner.nextLine());
        String target = "";
        for (int i = 1; i <= total; i++) {
            target = scanner.nextLine();
            System.out.println("Case #" + i + ": " + generator(target));

        }
    }

    // 1010
    // 13104
    //-> (
    public static String generator(String input) {
        StringBuilder builder = new StringBuilder();
        int before = 0;
        int cur = 0;
        int remainOpens = 0;
        for (int i = 0; i < input.length(); i ++) {
            cur = Integer.valueOf(input.charAt(i) + "");
            if (i == 0) {
                remainOpens += cur;
                for (int k = 0; k < cur; k++) {
                    builder.append("(");
                }
                builder.append(cur);
                before = cur;
            } else {
                if (cur > before) {
                    int steps = cur - remainOpens;
                    for (int k = 0; k < steps; k++) {
                        builder.append("(");
                        remainOpens ++;
                    }
                    builder.append(cur);
                } else if (cur < before){
                    for (int k = 0; k < before - cur; k++) {
                        builder.append(")");
                        remainOpens--;
                    }
                    builder.append(cur);
                } else {
                    builder.append(cur);
                }
                before = cur;
            }
        }
        if (remainOpens > 0) {
            for (int i = remainOpens; i > 0; i--) {
                builder.append(")");
            }
        }
        return builder.toString();
    }

}