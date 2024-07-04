import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; ++testCase) {
            ArrayList<Integer> bitArray = new ArrayList<>();
            for (int i = 0; i < bitLength; ++i) {
                bitArray.add(0);
            }

            System.out.println(1);
            bitArray.set(0, scanner.nextInt());

            int knownBits = 1;
            int queryCount = 1;

            while (knownBits < bitLength) {
                if (queryCount % 10 != 0) {
                    int index = knownBits % 2 == 0 ? (knownBits / 2) + 1 : bitLength - (knownBits / 2);
                    System.out.println(index);
                    bitArray.set(index - 1, scanner.nextInt());
                    ++queryCount;
                    ++knownBits;
                } else {
                    ArrayList<ArrayList<Integer>> possibleArrays = generateCandidates(bitArray);
                    int possibleMasks = 0b1111;
                    
                    int index = 0;
                    while (possibleMasks != 0b1000 && possibleMasks != 0b0100 && possibleMasks != 0b0010 && possibleMasks != 0b0001) {
                        ++queryCount;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possibleMasks = updatePossibleMasks(possibleArrays, index, bit, possibleMasks);
                        ++index;
                    }
                    
                    switch (possibleMasks) {
                        case 0b1000:
                            bitArray = possibleArrays.get(3);
                            break;
                        case 0b0100:
                            bitArray = possibleArrays.get(2);
                            break;
                        case 0b0010:
                            bitArray = possibleArrays.get(1);
                            break;
                        default:
                            bitArray = possibleArrays.get(0);
                    }
                }
            }
            
            for (int bit : bitArray) {
                System.out.print(bit);
            }
            
            System.out.println();
        }
    }
    
    public static int updatePossibleMasks(ArrayList<ArrayList<Integer>> candidates, int index, int bit, int possibleMasks) {
        for (int i = 0; i < candidates.size(); ++i) {
            if (((possibleMasks >> i) & 1) == 1 && candidates.get(i).get(index) != bit) {
                possibleMasks -= 1 << i;
            }
        }
        
        return possibleMasks;
    }

    public static ArrayList<ArrayList<Integer>> generateCandidates(ArrayList<Integer> array) {
        int length = array.size();

        ArrayList<ArrayList<Integer>> candidates = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            candidates.add(new ArrayList<>());
        }
        
        for (int i = 0; i < length; ++i) {
            candidates.get(0).add(1 - array.get(i)); // complement
            candidates.get(1).add(array.get(length - i - 1)); // reverse
            candidates.get(2).add(1 - candidates.get(1).get(i)); // reverse complement
            candidates.get(3).add(array.get(i)); // original
        }

        return candidates;
    }
}