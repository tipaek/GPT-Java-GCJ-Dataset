public class Solution {
    public void nestingDepth(int caseNumber, String s) {
        String[] lines = s.split("\n");
        int index = caseNumber - 1;
        for (String line : lines) {
            System.out.printf("Case #%d: %s%n", caseNumber - index, nestNumber(line));
            index--;
        }
    }

    private String nestNumber(String s) {
        int n = Integer.parseInt(s);
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < n; i++) {
            prefix.append("(");
            s += ")";
        }
        return prefix.toString() + s;
    }
}