import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System. in);
        String input = scanner.nextLine();
        int numOfCases = Integer.parseInt(input);
        for(int i=0;i<numOfCases;i++) {
            input = scanner.nextLine();
            TestCase tc = new TestCase(input);
            String result = tc.getResult();
            System.out.println("Case #"+(i+1)+": "+result);
        }

    }

    public static class TestCase {
        private final String data;
        private final int length;
        public TestCase(String data) {
            this.data = data;
            length = data.length();

        }

        private String getResult() {
            StringBuffer sb = new StringBuffer();
            int open = 0;
            for (int i=0;i<length;i++) {
                int val = Character.getNumericValue(data.charAt(i));
              if (val > open) {
                    int diff = val - open;
                    open += diff;
                    for (int j = 0; j < diff; j++) {
                        sb.append("(");
                    }
                } else if (val<open){
                    int diff = open - val;
                    open -= diff;
                    for (int j = 0; j < diff; j++) {
                        sb.append(")");
                    }

                }
                sb.append(val);
            }
            while (open > 0) {
                sb.append(")");
                open--;
            }

            return sb.toString();
        }
    }
}