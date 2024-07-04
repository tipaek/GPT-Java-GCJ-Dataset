import java.util.*;

public class Solution {

    private static class Query {

        public final long q;
        public final int qLength;
        public final int qFirst;
        public final String r;
        public final char rFirst;

        public Query(long q, String r) {
            if (q == -1) {
                this.q = 99999999999999L;
            } else {
                this.q = q;
            }
            this.qLength = String.valueOf(this.q).length();
            this.qFirst = Integer.valueOf(String.valueOf(this.q).substring(0, 1));
            this.r = r;
            this.rFirst = r.charAt(0);
        }

        public boolean isUnknown() {
            return q == -1;
        }

        public boolean isUseful() {
            return !isUnknown() && r.length() == qLength;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCases = scanner.nextInt();
        for (int caseNo = 1; caseNo <= nCases; ++caseNo) {
            int nDigits = scanner.nextInt();
            Set<Character> possibleChars = new HashSet<>();
            Set<Character> possibleNonZeroChars = new HashSet<>();
            List<Query> queries = new ArrayList<>();
            boolean hasUnknownQueries = false;
            for (int i = 0; i < 10000; ++i) {
                long q = scanner.nextLong();
                String r = scanner.nextLine().trim();
                Query query = new Query(q, r);
                queries.add(query);
                // Pre
                if (q == -1) {
                    hasUnknownQueries = true;
                }
                for (int j = 0; j < r.length(); ++j) {
                    possibleChars.add(r.charAt(j));
                    if (j == 0) {
                        possibleNonZeroChars.add(r.charAt(j));
                    }
                }
            }
            Set<Character> possibleZeroChars = new HashSet<>(possibleChars);
            possibleZeroChars.removeAll(possibleNonZeroChars);
            if (true) {
                Map<Character, Integer> upperBounds = new HashMap<>();
                for (Character c : possibleChars) {
                    upperBounds.put(c, 9);
                }
                for (Query query : queries) {
                    if (query.isUseful()) {
                        if (query.qFirst < upperBounds.get(query.rFirst)) {
                            upperBounds.put(query.rFirst, query.qFirst);
                        }
                    }
                }
                // Construct
                String code = "";
                if (!possibleZeroChars.isEmpty()) {
                    for (Character zero : possibleZeroChars) {
                        boolean isSolution = true;
                        String codeCopy = String.valueOf(zero);
                        Map<Character, Integer> ubCopy = new HashMap<>(upperBounds);
                        ubCopy.remove(zero);
                        while (!ubCopy.isEmpty()) {
                            int upperBound = ubCopy.values().stream().min(Comparator.naturalOrder()).get();
                            Set<Character> toRemove = new HashSet<>();
                            for (Character c : ubCopy.keySet()) {
                                if (ubCopy.get(c) == upperBound) {
                                    toRemove.add(c);
                                    codeCopy += c;
                                }
                            }
                            for (Character c : toRemove) {
                                ubCopy.remove(c);
                            }
                            if (codeCopy.length() > upperBound + 1) {
                                isSolution = false;
                            }
                        }
                        if (isSolution) {
                            code = codeCopy;
                            break;
                        }
                    }
                }
                System.out.println(String.format("Case #%d: %s", caseNo, code));
            }
        }
    }

}
