import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner sc) throws Exception {
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            doCase(sc, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) throws Exception {
        String[] inParm = sc.nextLine().split(" ");
        int N = Integer.parseInt(inParm[0]);
        int D = Integer.parseInt(inParm[1]);
        String[] chunks = sc.nextLine().split(" ");
        List<String> chunkStringList = Arrays.asList(chunks);

        List<BigInteger> chunkList = chunkStringList.stream()
                .map(s -> new BigInteger(s))
                .collect(Collectors.toList());

        Set<BigInteger> chunkSet = new HashSet<>(chunkList);
        boolean dupSlices = chunkSet.size() < chunkList.size();

        if (D == 2) {
            if (dupSlices) { // 2 slices of same size
                printRes(caseNumber, 0);
                return;
            } else {
                printRes(caseNumber, 1);
                return;
            }
        } else { // D = 3

            boolean containsADoubleOne = false;
            Set<BigInteger> doubleChunk = chunkSet.stream()
                    .map(c -> c.multiply(new BigInteger("2")))
                    .collect(Collectors.toSet());

            for (BigInteger b: chunkSet) {
                if (doubleChunk.contains(b)) {
                    containsADoubleOne = true;
                }
            }

            if (!dupSlices) { // no identical slices find one that is 2x another one

                if (containsADoubleOne) {
                    printRes(caseNumber, 1);
                    return;
                }

                // no slice is twice the size of another slice
                printRes(caseNumber, 2);
                return;
            } else { // Duplicates!

                // 3 slices -> 0
                // 2 slices -> one bigger is enough
                // find one which is (double) bigger than the duplicate -> 1 cut, 2 cut.

                HashMap<BigInteger, Integer> chunkCount = new HashMap<>();
                chunkList.forEach(bigInteger -> {
                    if (!chunkCount.containsKey(bigInteger)) {
                        chunkCount.put(bigInteger, 0);
                    }

                    chunkCount.put(bigInteger, chunkCount.get(bigInteger) + 1);
                });

                LinkedList<BigInteger> sortedChunks = chunkList.stream()
                        .sorted()
                        .collect(Collectors.toCollection(LinkedList::new));
                boolean couldDoIn1 = false;
                for (BigInteger chunk: sortedChunks) {
                    int nbDuplicates = chunkCount.get(chunk);
                    if (nbDuplicates >= 3) {
                        printRes(caseNumber, 0);
                        return;
                    } else if (nbDuplicates >= 2) {
                        // check not last :)
                        if (chunk.compareTo(sortedChunks.getLast()) == -1 ) {
                            couldDoIn1 = true;
                        }
                    }
                }

                if (containsADoubleOne || couldDoIn1) {
                    printRes(caseNumber, 1);
                    return;
                }


                printRes(caseNumber, 2);
                return;

            }
        }

    }

    private static void printRes(int caseNumber, int res) {
        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + Integer.toString(res));
    }
}
