import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCases = Integer.parseInt(br.readLine());
        for (int idx = 1; idx <= nCases; idx++) {
            solveCase(idx, br);
        }
    }

    public void solveCase(int caseNo, BufferedReader br) throws Exception {
        String s = br.readLine();
        solveCase(caseNo, s);
    }

    public void solveCase(int caseNo, String s) {
        StringBuilder result = new StringBuilder();
        int prCount = 0;
        int currentDigit = 0;

        for (int idx = 0; idx < s.length(); idx++) {
            int digit = Character.getNumericValue(s.charAt(idx));
            Node node = updateBrackets(digit, currentDigit, prCount, result);
            prCount = node.prCount;
            currentDigit = node.currentDigit;

            if (idx == s.length() - 1) {
                addCloseBrackets(prCount, result);
            }
        }
        System.out.println("Case #" + caseNo + ": " + result.toString());
    }

    public Node updateBrackets(int digit, int currentDigit, int prCount, StringBuilder result) {
        if (digit > currentDigit) {
            addOpenBrackets(digit - prCount, result);
            result.append(digit);
            return new Node(digit, digit);
        } else {
            int diff = digit - prCount;
            if (diff <= 0) {
                addCloseBrackets(-diff, result);
            } else {
                addOpenBrackets(diff, result);
            }
            result.append(digit);
            return new Node(prCount + diff, currentDigit);
        }
    }

    public void addOpenBrackets(int count, StringBuilder result) {
        for (int i = 0; i < count; i++) {
            result.append("(");
        }
    }

    public void addCloseBrackets(int count, StringBuilder result) {
        for (int i = 0; i < count; i++) {
            result.append(")");
        }
    }

    class Node {
        int prCount;
        int currentDigit;

        public Node(int prCount, int currentDigit) {
            this.prCount = prCount;
            this.currentDigit = currentDigit;
        }
    }
}