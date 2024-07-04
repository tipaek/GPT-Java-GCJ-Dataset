import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public enum States {
        REVERSED, // reversed
        COMPLEMENTED, // complemented
        COMPLEMENTED_REVERSED, // complemented and reversed
        SAME // same
    }

    private static int sameIndex = -1, diffIndex = -1, bitLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        bitLength = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            Set<States> possibilities = new HashSet<>();
            Queue<Integer> unsolvedIndices = new LinkedList<>();
            
            for (int i = 1; i <= bitLength / 2; i++) {
                unsolvedIndices.add(i);
                unsolvedIndices.add(bitLength - i + 1);
            }
            
            List<Integer> bitArray = new ArrayList<>(Collections.nCopies(bitLength + 1, -1));
            sameIndex = -1;
            diffIndex = -1;
            boolean hasFailed = false;
            
            for (int queryCount = 1; queryCount <= 150; ) {
                if (queryCount <= 10) {
                    queryCount = queryBit(scanner, unsolvedIndices, bitArray, queryCount);
                } else {
                    if (queryCount % 10 == 1) {
                        possibilities.addAll(Arrays.asList(States.SAME, States.REVERSED, States.COMPLEMENTED, States.COMPLEMENTED_REVERSED));
                        
                        if (sameIndex != -1) {
                            queryCount = processIndex(scanner, bitArray, possibilities, sameIndex, queryCount);
                        }
                        
                        if (diffIndex != -1) {
                            queryCount = processIndex(scanner, bitArray, possibilities, diffIndex, queryCount);
                        }
                        
                        if (diffIndex == -1 && (possibilities.contains(States.COMPLEMENTED) || possibilities.contains(States.COMPLEMENTED_REVERSED))) {
                            bitArray = complement(bitArray);
                        }
                        
                        if (sameIndex == -1 && (possibilities.contains(States.COMPLEMENTED) || possibilities.contains(States.REVERSED))) {
                            bitArray = complement(bitArray);
                        }
                        
                        if (possibilities.size() == 1) {
                            switch (possibilities.iterator().next()) {
                                case COMPLEMENTED:
                                    bitArray = complement(bitArray);
                                    break;
                                case REVERSED:
                                    unsolvedIndices = reverse(bitArray, unsolvedIndices);
                                    break;
                                case COMPLEMENTED_REVERSED:
                                    bitArray = complement(bitArray);
                                    unsolvedIndices = reverse(bitArray, unsolvedIndices);
                                    break;
                                case SAME:
                                    break;
                            }
                        }
                    } else {
                        queryCount = queryBit(scanner, unsolvedIndices, bitArray, queryCount);
                    }
                }
                
                if (unsolvedIndices.isEmpty()) {
                    for (int i = 1; i <= bitLength; i++) {
                        System.out.print(bitArray.get(i));
                    }
                    System.out.println();
                    System.out.flush();
                    
                    if (scanner.nextLine().charAt(0) == 'N') {
                        hasFailed = true;
                    }
                    break;
                }
            }
            
            if (hasFailed) {
                break;
            }
        }
    }

    private static List<Integer> complement(List<Integer> bitArray) {
        return bitArray.stream()
                .map(value -> value != -1 ? 1 - value : value)
                .collect(Collectors.toList());
    }

    private static void swap(List<Integer> bitArray, int index1, int index2) {
        int temp = bitArray.get(index1);
        bitArray.set(index1, bitArray.get(index2));
        bitArray.set(index2, temp);
    }

    private static Queue<Integer> reverse(List<Integer> bitArray, Queue<Integer> unsolvedIndices) {
        reverseArray(bitArray);
        Queue<Integer> reversedUnsolved = new LinkedList<>();
        
        while (!unsolvedIndices.isEmpty()) {
            reversedUnsolved.add(bitLength - unsolvedIndices.poll() + 1);
        }
        
        return reversedUnsolved;
    }

    private static void reverseArray(List<Integer> bitArray) {
        for (int i = 1; i <= bitLength / 2; i++) {
            swap(bitArray, i, bitLength - i + 1);
        }
    }

    private static int queryBit(Scanner scanner, Queue<Integer> unsolvedIndices, List<Integer> bitArray, int queryCount) {
        int index = unsolvedIndices.poll();
        System.out.println(index);
        System.out.flush();
        
        int value = scanner.nextInt();
        bitArray.set(index, value);
        
        if (sameIndex == -1 && bitArray.get(index).equals(bitArray.get(bitLength - index + 1))) {
            sameIndex = index;
        }
        
        if (diffIndex == -1 && bitArray.get(index) == 1 - bitArray.get(bitLength - index + 1)) {
            diffIndex = index;
        }
        
        return queryCount + 1;
    }

    private static int processIndex(Scanner scanner, List<Integer> bitArray, Set<States> possibilities, int index, int queryCount) {
        System.out.println(index);
        System.out.flush();
        
        int value = scanner.nextInt();
        if (bitArray.get(index) == value) {
            possibilities.removeAll(Arrays.asList(States.COMPLEMENTED, States.COMPLEMENTED_REVERSED));
        } else {
            possibilities.removeAll(Arrays.asList(States.SAME, States.REVERSED));
        }
        
        return queryCount + 1;
    }
}