import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static interface Solver {
        public String solve();
    }

    ////////// TODO: solver /////////////////
    private static class LongArrSolver implements Solver {

        long[] slices;
        int numDiners;

        public LongArrSolver(Scanner scanner) {
            numDiners = Integer.parseInt(scanner.nextLine().split(" ")[1]);
            String[] tokens = scanner.nextLine().trim().split(" ");
            slices = new long[tokens.length];
            for (int j=0; j<tokens.length; ++j) {
                slices[j] = Long.parseLong(tokens[j]);
            }
        }

        public String solve2() {
            Arrays.sort(slices);
            Set<Long> candidates = new HashSet<>();
            for (int i=0; i<slices.length; ++i) {
                for (int j=i+1; j<slices.length; ++j) {
                    candidates.add(slices[i]);
                    candidates.add(slices[j]);
                    if (slices[i] > slices[j])
                        candidates.add(findGCD(slices[i], slices[j]));
                    else
                        candidates.add(findGCD(slices[j], slices[i]));
                }
            }

//            for (int i=0; i<5; ++i) {
//                List<Long> cs = new ArrayList<>(candidates);
//                for (int j=0; j<cs.size(); ++j) {
//                    for (int k=j+1; k<cs.size(); ++k) {
//
//                    }
//                }
//
//            }

            List<Long> sortedCandidates = candidates.stream().sorted().collect(Collectors.toList());

            int minCount = numDiners - 1;

            for (int i=0; i<sortedCandidates.size(); ++i) {
                int ndr = numDiners;
                int numSlicesMade = 0;

                long currCand = sortedCandidates.get(i);

                for (long l : slices) {
                    if (l < currCand) continue;
                    if (l > ndr * currCand) {
                        numSlicesMade += ndr;
                        ndr = 0;
                        minCount = Math.min(minCount, numSlicesMade);
                        break;
                    }

                    if (l % currCand == 0) {
                        numSlicesMade += (l / currCand) - 1;
                        ndr -= (l / currCand);
                        if (ndr == 0) {
                            minCount = Math.min(minCount, numSlicesMade);
                            break;
                        }
                    }
                }

                for (long l : slices) {
                    if (l < currCand) continue;
                    if (ndr == 0) break;

                    if (l % currCand != 0) {
                        long num = l / currCand;
                        if (num > ndr) num = ndr;
                        numSlicesMade += num;
                        ndr -= num;
                    }

                }

                if (ndr == 0)
                    minCount = Math.min(minCount, numSlicesMade);
            }
            return "" + minCount;
        }

        public long findGCD(long i, long j) {
            if (j == 0) {
                return i;
            }
            return findGCD(j, i % j);
        }

        @Override
        public String solve() {
            Map<Long, Integer> numToCount = new HashMap<>();
            for (long l : slices) {
                if (!numToCount.containsKey(l))
                    numToCount.put(l, 1);
                else
                    numToCount.put(l, numToCount.get(l) + 1);
            }


            List<Map.Entry<Long, Integer>> sortedSlices = numToCount.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

            int maxNum = sortedSlices.get(sortedSlices.size() - 1).getValue();
            if (maxNum >= numDiners) return "0";


            List<Long> sortedSliceValues = new ArrayList<Long>();
            for (long l : slices) {
                sortedSliceValues.add(l);
            }
            Collections.sort(sortedSliceValues);

            int ndr = numDiners;
            int minCount = Integer.MAX_VALUE;

            for (int i=0; i<sortedSliceValues.size(); ++i) {
                int numSlicesMade = 0;
                long currSlice = sortedSliceValues.get(i);
                ndr -= numToCount.get(currSlice);
                for (int j=i+1; j<sortedSliceValues.size(); ++j) {
                    long s = sortedSliceValues.get(j);
                    if (ndr == 0) {
                        minCount = Math.min(minCount, numSlicesMade);
                        break;
                    }
                    else if (s % currSlice == 0) {
                        numSlicesMade += (s % currSlice) - 1;
                        ndr -= (s % currSlice);

                        if (ndr < 0) {
                            numSlicesMade += ndr;
                            numSlicesMade += 1;
                            minCount = Math.min(minCount, numSlicesMade);
                            break;
                        }
                    }
                    else if (s / currSlice >= ndr) {
                        numSlicesMade += ndr;
                        minCount = Math.min(minCount, numSlicesMade);
                        break;
                    }
                }
            }

            return "2";
        }
    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            LongArrSolver s = new LongArrSolver(inputReader); // TODO
            String output = s.solve2();
            System.out.println(String.format("Case #%d: %s", (i + 1), output));
        }
    }

    public static void main(String[] args) {
        handleInput((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
//         testCases();
    }

    public static void testCases() {
        String input = "4\n" +
                "1 3\n" +
                "5 3 3\n" +
                "5 2\n" +
                "10 5 359999999999 123456789 10\n" +
                "2 3\n" +
                "8 4\n" +
                "3 2\n" +
                "1 2 3";
        handleInput(new Scanner(input));
    }
}
