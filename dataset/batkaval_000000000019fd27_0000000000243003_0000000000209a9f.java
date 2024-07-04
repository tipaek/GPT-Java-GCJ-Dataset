public class Solution {

    public static void main(String[] args) {
        for (int i = 1; i < args.length; i++) {
            String input = args[i];
            String output = "";

            boolean opened = false;
            for(int j = 0; j< input.length(); j++) {

                int d = Integer.parseInt(String.valueOf(input.charAt(j)));

                if (d == 0) {
                    if (opened) {
                        output += ")";
                        opened = false;
                    }
                }

                if (d == 1) {
                    if (!opened) {
                        opened = true;
                        output += "(";
                    }
                }

                output += d;
            }
            if (opened) {
                output += ")";
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}
