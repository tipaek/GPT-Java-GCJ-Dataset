public class Solution {

    public static void main(String[] args) {
        for (int i = 1; i < args.length; i++) {
            String input = args[i];
            StringBuilder output = new StringBuilder();

            boolean isOpened = false;
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                if (digit == 0 && isOpened) {
                    output.append(")");
                    isOpened = false;
                } else if (digit == 1 && !isOpened) {
                    output.append("(");
                    isOpened = true;
                }

                output.append(digit);
            }
            if (isOpened) {
                output.append(")");
            }

            System.out.println("Case #" + i + ": " + output.toString());
        }
    }
}