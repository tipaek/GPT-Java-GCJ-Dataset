import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            inputs.add(line);
        }

        if (inputs.size() == 0) {
            return;
        }

        int caseCnt = Integer.parseInt(inputs.get(0).trim());

        for (int i = 1; i <= caseCnt; i++) {
            String str = inputs.get(i);

            String result = nestingDepth(str);
            System.out.println(String.format("Case #%d: %s", i, result));
        }
    }

    private static String nestingDepth(String str) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch > str.charAt(index)) {
                index = i;
            }
        }

        int max = str.charAt(index) - '0';
        sb.append(max);
        for (int i = 0; i < max; i++) {
            sb.insert(0, '(');
            sb.append(')');
        }

        int ansIndex = max;

        int left = index - 1;
        while (left >= 0) {
            char curr = str.charAt(left);
            char pre = str.charAt(left + 1);
            if (curr < pre) {
                sb.insert(curr - '0', curr);
            } else {
                int diff = curr - pre;
                StringBuilder sbsb = new StringBuilder();
                sbsb.append(curr);
                for (int i = 0; i < diff; i++) {
                    sbsb.insert(0, '(');
                    sbsb.append(')');
                }
                sb.insert(pre - '0', sbsb.toString());
            }
            left--;
        }

        int right = index + 1;
        while (right < str.length()) {
            char curr = str.charAt(right);
            char pre = str.charAt(right - 1);
            if (curr < pre) {
                sb.insert(sb.length() - (curr - '0'), curr);
            } else {
                int diff = curr - pre;
                StringBuilder sbsb = new StringBuilder();
                sbsb.append(curr);
                for (int i = 0; i < diff; i++) {
                    sbsb.insert(0, '(');
                    sbsb.append(')');
                }
                sb.insert(sb.length() - (pre - '0'), sbsb.toString());
            }
            right++;
        }

        return sb.toString();
    }

}


