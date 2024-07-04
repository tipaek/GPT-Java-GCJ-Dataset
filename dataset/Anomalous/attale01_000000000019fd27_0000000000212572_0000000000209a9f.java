public class NestingDepth {

    public static void main(String[] args) {
        System.out.println(calculateNestingDepth("4\n0000\n101\n111000\n1"));
    }

    public static String calculateNestingDepth(String input) {
        String[] cases = input.split("\n");
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < cases.length; i++) {
            StringBuilder sb = new StringBuilder();
            int prevDepth = 0;
            System.out.print("Case #" + i + ": ");

            for (int j = 0; j < cases[i].length(); j++) {
                int currentDepth = Character.getNumericValue(cases[i].charAt(j));

                while (prevDepth < currentDepth) {
                    sb.append("(");
                    prevDepth++;
                }

                while (prevDepth > currentDepth) {
                    sb.append(")");
                    prevDepth--;
                }

                sb.append(cases[i].charAt(j));
            }

            while (prevDepth > 0) {
                sb.append(")");
                prevDepth--;
            }

            result.append("Case #").append(i).append(": ").append(sb).append("\n");
        }

        return result.toString();
    }
}