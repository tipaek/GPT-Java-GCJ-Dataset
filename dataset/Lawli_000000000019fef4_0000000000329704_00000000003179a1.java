import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

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
        Map<Character, Integer> knownChars = new HashMap<>();
        Character zeroChar = null;

        for(QueryAndResponse qr : queryAndResponses) {
            for(int i = 0; i < qr.response.length(); ++i) {
                char c = qr.response.charAt(i);
                characters.add(c);
                if(i == 0) {
                    charsAtFirstPlace.add(c);

                    if(characters.size() == 10 && charsAtFirstPlace.size() == 9 && zeroChar == null) {
                        Set<Character> zeroCharSet = new HashSet<>(characters);
                        zeroCharSet.removeAll(charsAtFirstPlace);
                        zeroChar = zeroCharSet.iterator().next();
                        knownChars.put(zeroChar, 0);
                    }

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

                if(i == qr.response.length() - 1 && qr.query != -1 && qr.response.length() == u) {
                    int number = 0;
                    for(int j = 0; j < i; ++j) {
                        char prev = qr.response.charAt(j);
                        Integer val = knownChars.get(prev);
                        if(val == null) {
                            break;
                        }

                        number += val;
                        number *= 10;
                    }
                    number *= 10;

                    int queryWithoutLastDigit = qr.query / 10;
                    queryWithoutLastDigit *= 10;

                    if(number == queryWithoutLastDigit) {
                        int bound = qr.query % 10;
                        if(bound != 0) {
                            upperBounds.compute(c, (character, integer) -> {
                                if(integer == null) {
                                    return bound;
                                }
                                if (integer < bound) {
                                    return integer;
                                }
                                return bound;
                            });
                        } else if(zeroChar == null) {
                            zeroChar = c;
                            knownChars.put(zeroChar, 0);
                        }
                    }
                }

                if(zeroChar != null) {
                    upperBounds.remove(zeroChar);
                }

                if(upperBounds.size() == 9 && zeroChar != null) {
                    Map<Integer, List<Map.Entry<Character, Integer>>> bounds =
                        upperBounds.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.toList()));

                    for(int j = 1; j < 10; ++j) {
                        List<Map.Entry<Character, Integer>> entry = bounds.get(j);
                        if(entry != null && entry.size() == 1) {
                            knownChars.put(entry.get(0).getKey(), entry.get(0).getValue());
                        } else {
                            break;
                        }
                    }

                    for(int j = 9; j > 0; --j) {
                        List<Map.Entry<Character, Integer>> entry = bounds.get(j);
                        if(entry != null && entry.size() == 1) {
                            knownChars.put(entry.get(0).getKey(), entry.get(0).getValue());
                        } else {
                            break;
                        }
                    }
                }

                if(knownChars.size() == 10) {
                    char[] result = new char[10];

                    for(Map.Entry<Character, Integer> entry : knownChars.entrySet()) {
                        result[entry.getValue()] = entry.getKey();
                    }

                    return new String(result);
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