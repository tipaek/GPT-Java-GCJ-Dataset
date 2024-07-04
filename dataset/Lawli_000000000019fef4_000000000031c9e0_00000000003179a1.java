import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            List<QueryAndResponse> queryAndResponses = new ArrayList<>(10000);
            for(int j = 0; j < 10000; ++j) {
                int q = in.nextInt();
                String r = in.next();
                queryAndResponses.add(new QueryAndResponse(q, r));
            }

            System.out.println("Case #" + i + ": " + solve(u, queryAndResponses));
        }
    }

    private static String solve(int u, List<QueryAndResponse> queryAndResponses) {
        Set<Character> characters = new HashSet<>();
        Set<Character> charsAtFirstPlace = new HashSet<>();
        Map<Character, Integer> upperBounds = new HashMap<>();
        Character zeroChar = null;

        for(QueryAndResponse qr : queryAndResponses) {
            for(int i = 0; i < qr.response.length(); ++i) {
                char c = qr.response.charAt(i);
                characters.add(c);
                if(i == 0) {
                    charsAtFirstPlace.add(c);

                    if(qr.query != -1 && qr.response.length() == u) {
                        int firstDigit = qr.query;
                        while(firstDigit >= 10) {
                            firstDigit /= 10;
                        }

                        int finalFirstDigit = firstDigit;
                        upperBounds.compute(c, (character, integer) -> {
                            if(integer == null) {
                                return finalFirstDigit;
                            }
                            if (integer < finalFirstDigit) {
                                return integer;
                            }
                            return finalFirstDigit;
                        });
                    }
                }

                if(characters.size() == 10 && charsAtFirstPlace.size() == 9) {
                    if(zeroChar == null) {
                        Set<Character> zeroCharSet = new HashSet<>(characters);
                        zeroCharSet.removeAll(charsAtFirstPlace);
                        zeroChar = zeroCharSet.iterator().next();
                    }

                    upperBounds.remove(zeroChar);
                    if(new HashSet<>(upperBounds.values()).size() == 9) {
                        char[] result = new char[10];

                        result[0] = zeroChar;
                        for(Map.Entry<Character, Integer> entry : upperBounds.entrySet()) {
                            result[entry.getValue()] = entry.getKey();
                        }

                        return new String(result);
                    }
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private static class QueryAndResponse {
        private final int query;
        private final String response;

        public QueryAndResponse(int query, String response) {
            this.query = query;
            this.response = response;
        }
    }
}