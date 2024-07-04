import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = Integer.parseInt(in.nextLine()); //  Integer.parseInt(System.console().readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            String currLine = in.nextLine();
            StringBuilder result = new StringBuilder();

            char currDep = '0';

            for (char currChar : currLine.toCharArray()) {
                if (currChar > currDep) {
                    result.append('(');
                    currDep++;
                } else if (currChar < currDep) {
                    result.append(')');
                    currDep--;
                }
                result.append(currChar);
            }

            while (currDep > '0') {
                currDep--;
                result.append(')');
            }
            System.out.println(String.format("Case #%s: %s", testCase +1, result));
        }
    }
}