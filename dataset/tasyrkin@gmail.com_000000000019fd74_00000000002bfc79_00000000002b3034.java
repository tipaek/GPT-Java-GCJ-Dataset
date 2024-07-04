import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {
            final int N = scanner.nextInt();

            String[] patterns = new String[N];
            for (int i = 0; i < N; i++) {
                patterns[i] = scanner.next();
            }

            StringBuilder sb = new StringBuilder();

            MergeResult result = new MergeResult(true, patterns[0]);
            for (int i = 1; i < N; i++) {
                result = merge(result, patterns[i]);
                if (!result.merged) {
                    break;
                }
            }
            if (!result.merged) {
                sb = new StringBuilder("*");
            } else {
                sb = new StringBuilder(result.merge.replace("*", ""));
            }

            System.out.println(
                    String.format(
                            "Case #%d: %s", caseNumber, sb.toString()
                    )
            );
        }
    }

    private static MergeResult merge(MergeResult previousResult, String pattern) {
        StringBuilder prefix = new StringBuilder();
        MergeResult result = getPrefixMergeResult(previousResult, pattern, prefix);
        if (result != null) {
            return result;
        }

        StringBuilder postfix = new StringBuilder();
        result = getPostfixMergeResult(previousResult, pattern, postfix);
        if (result != null) {
            return result;
        }

        return new MergeResult(true, prefix.toString() + "*" + postfix.toString());
    }

    private static MergeResult getPostfixMergeResult(MergeResult previousResult, String pattern, StringBuilder postfix) {
        String merge = previousResult.merge;
        int pattIdx = pattern.length() - 1;
        int mergeIdx = merge.length() - 1;
        while (pattIdx >= 0 && mergeIdx >= 0) {
            if (pattern.charAt(pattIdx) == '*' && merge.charAt(mergeIdx) == '*') break;
            if (pattern.charAt(pattIdx) == '*') {
                postfix.insert(0, merge.charAt(mergeIdx));
                --mergeIdx;
            } else if (merge.charAt(mergeIdx) == '*') {
                postfix.insert(0, pattern.charAt(pattIdx));
                --pattIdx;
            } else {
                if (pattern.charAt(pattIdx) == merge.charAt(mergeIdx)) {
                    postfix.insert(0, pattern.charAt(pattIdx));
                } else {
                    return new MergeResult(false, "");
                }
                --mergeIdx;
                --pattIdx;
            }
        }
        return null;
    }

    private static MergeResult getPrefixMergeResult(MergeResult previousResult, String pattern, StringBuilder prefix) {
        String merge = previousResult.merge;
        int pattIdx = 0;
        int mergeIdx = 0;
        while (pattIdx < pattern.length() && mergeIdx < merge.length()) {
            if (pattern.charAt(pattIdx) == '*' && merge.charAt(mergeIdx) == '*') break;
            if (pattern.charAt(pattIdx) == '*') {
                prefix.append(merge.charAt(mergeIdx));
                ++mergeIdx;
            } else if (merge.charAt(mergeIdx) == '*') {
                prefix.append(pattern.charAt(pattIdx));
                ++pattIdx;
            } else {
                if (pattern.charAt(pattIdx) == merge.charAt(mergeIdx)) {
                    prefix.append(pattern.charAt(pattIdx));
                } else {
                    return new MergeResult(false, "");
                }
                ++mergeIdx;
                ++pattIdx;
            }
        }
        return null;
    }

    private static class MergeResult {
        boolean merged;
        String merge;

        public MergeResult(boolean merged, String merge) {
            this.merged = merged;
            this.merge = merge;
        }
    }
}
