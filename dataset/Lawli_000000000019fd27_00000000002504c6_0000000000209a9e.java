import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private final Scanner in;
    private final boolean[] array;
    private final int b;
    private final boolean even;
    private int reads = 0;
    private int indicesCovered = -1;
    private Integer matchingMarkerIndex;
    private Integer oppositeMarkerIndex;

    public Solution(Scanner in, int b) {
        this.in = in;
        this.b = b;
        even = (b % 2) == 0;
        array = new boolean[b];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            Solution solution = new Solution(in, b);
            System.out.println(solution.solve(in, b));
            in.next();
        }
    }

    private String solve(Scanner in, int b) {
        if(!even) {
            matchingMarkerIndex = b / 2;
            array[b/2] = read(b/2);
        }

        for(int i = 0; i < b/2; ++i) {
            int remainder = reads % 10;

            if(remainder == 9) {
                read(0);
                handleFluctuation();
            } else if(remainder == 0 && indicesCovered >= 0) {
                handleFluctuation();
            }

            boolean nextBit = read(i);

            boolean pairBit = read(oppositeIndex(i));

            array[i] = nextBit;
            array[oppositeIndex(i)] = pairBit;

            if(oppositeMarkerIndex == null && nextBit != pairBit) {
                oppositeMarkerIndex = i;
            } else if(matchingMarkerIndex == null && nextBit == pairBit) {
                matchingMarkerIndex = i;
            }

            indicesCovered = i;
        }

        char[] result = new char[b];
        for(int i = 0; i < b; ++i) {
            result[i] = array[i] ? '1' : '0';
        }
        return new String(result);
    }

    private void handleFluctuation() {
        Set<Fluctuation> possibleFluctuation = new HashSet<>(Arrays.asList(Fluctuation.values()));

        if(matchingMarkerIndex != null) {
            boolean prevMatchingValue = array[matchingMarkerIndex];
            boolean newMatchingValue = read(matchingMarkerIndex);

            if(prevMatchingValue == newMatchingValue) {
                possibleFluctuation.remove(Fluctuation.NEGATION);
                possibleFluctuation.remove(Fluctuation.COMBINED);
            } else {
                possibleFluctuation.remove(Fluctuation.NOTHING);
                possibleFluctuation.remove(Fluctuation.SHUFFLE);
            }
        }

        if(oppositeMarkerIndex != null) {
            boolean prevOppositeValue = array[oppositeMarkerIndex];
            boolean newOppositeValue = read(oppositeMarkerIndex);

            if(prevOppositeValue == newOppositeValue) {
                possibleFluctuation.remove(Fluctuation.NEGATION);
                possibleFluctuation.remove(Fluctuation.SHUFFLE);
            } else {
                possibleFluctuation.remove(Fluctuation.NOTHING);
                possibleFluctuation.remove(Fluctuation.COMBINED);
            }
        }

        if(possibleFluctuation.contains(Fluctuation.NOTHING)) {
            return;
        }

        if(possibleFluctuation.size() == 1) {
            executeChange(possibleFluctuation.iterator().next());
        } else {
            if(matchingMarkerIndex != null && oppositeMarkerIndex == null) {
                executeChange(Fluctuation.NEGATION);
            } else {
                executeChange(Fluctuation.SHUFFLE);
            }
        }
    }

    private void executeChange(Fluctuation change) {
        if(change == Fluctuation.NOTHING) {
            return;
        }

        for(int i = 0; i <= indicesCovered; ++i) {
            int j = oppositeIndex(i);

            switch(change) {
                case NEGATION: {
                    array[i] = !array[i];
                    array[j] = !array[j];
                    break;
                }
                case SHUFFLE: {
                    boolean temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    break;
                }
                case COMBINED: {
                    boolean temp = array[j];
                    array[j] = !array[i];
                    array[i] = !temp;
                }
                default: {
                    break;
                }
            }
        }

        if(!even) {
            switch(change) {
                case NEGATION:
                case COMBINED: {
                    array[matchingMarkerIndex] = !array[matchingMarkerIndex];
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private boolean read(int index) {
        ++reads;
        System.out.println(index + 1);
        return in.nextInt() == 1;
    }

    private int oppositeIndex(int i) {
        return b - i - 1;
    }

    private enum Fluctuation {
        NOTHING,
        NEGATION,
        SHUFFLE,
        COMBINED
    }
}
