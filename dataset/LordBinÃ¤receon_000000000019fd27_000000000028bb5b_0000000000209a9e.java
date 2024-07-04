import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    enum Modification {
        COMPLEMENT,
        REVERSE,
        REVERSE_AND_COMPLEMENT,
        NOTHING
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int b = input.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.println(solve(b, input));
            String answer = input.next();
            if (answer.equals("N")) {
                break;
            }
        }
    }

    public static String solve(int b, Scanner input) {
        int currentPos = 0;
        int[] knownNumbers = new int[b];
        for (int i = 0; i < b; i++) {
            knownNumbers[i] = 0;
        }
        int numberCount = 0;
        boolean first = true;
        while (numberCount < b) {
            LinkedList<Modification> possibleModifications = new LinkedList<>();
            Collections.addAll(possibleModifications, Modification.values());
            if (first) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(currentPos + 1);
                    knownNumbers[currentPos] = input.nextInt();
                    numberCount++;
                    System.out.println(b - currentPos);
                    knownNumbers[b - currentPos - 1] = input.nextInt();
                    numberCount++;
                    currentPos++;
                }
                first = false;
            } else {
                int counter = 0;
                while (counter < 4) {
                    System.out.println(counter + 1);
                    int currentNum = input.nextInt();
                    if (currentNum != knownNumbers[counter]) {
                        possibleModifications.remove(Modification.NOTHING);
                    } else {
                        possibleModifications.remove(Modification.COMPLEMENT);
                    }
                    if (currentNum != knownNumbers[b - counter - 1]) {
                        possibleModifications.remove(Modification.REVERSE);
                    } else {
                        possibleModifications.remove(Modification.REVERSE_AND_COMPLEMENT);
                    }
                    counter++;
                }
                while (possibleModifications.size() > 1) {
                    if (counter < currentPos) {
                        int number = knownNumbers[counter];
                        int oppositeNumber = knownNumbers[b - counter - 1];
                        if (possibleModifications.contains(Modification.COMPLEMENT) && possibleModifications.contains(Modification.REVERSE)) {
                            if (number == oppositeNumber) {
                                possibleModifications.remove(Modification.REVERSE);
                            }
                        } else if (possibleModifications.contains(Modification.REVERSE) && possibleModifications.contains(Modification.NOTHING)) {
                            if (number != oppositeNumber) {
                                possibleModifications.remove(Modification.REVERSE);
                            }
                        } else if (possibleModifications.contains(Modification.NOTHING) && possibleModifications.contains(Modification.REVERSE_AND_COMPLEMENT)) {
                            if (number == oppositeNumber) {
                                possibleModifications.remove(Modification.REVERSE_AND_COMPLEMENT);
                            }
                        } else if (possibleModifications.contains(Modification.REVERSE_AND_COMPLEMENT) && possibleModifications.contains(Modification.COMPLEMENT)) {
                            if (number != Math.abs(oppositeNumber - 1)) {
                                possibleModifications.remove(Modification.REVERSE_AND_COMPLEMENT);
                            }
                        }
                        counter++;
                    } else {
                        possibleModifications.remove(possibleModifications.getLast());
                    }
                }
                Modification mod = possibleModifications.getFirst();
                switch (mod) {
                    case NOTHING:
                        break;
                    case REVERSE:
                        reverse(knownNumbers);
                        break;
                    case COMPLEMENT:
                        complement(knownNumbers);
                        break;
                    case REVERSE_AND_COMPLEMENT:
                        reverse(knownNumbers);
                        complement(knownNumbers);
                        break;
                }
                int nextPos = currentPos + 3;
                while (currentPos < nextPos && numberCount < b) {
                    System.out.println(currentPos + 1);
                    knownNumbers[currentPos] = input.nextInt();
                    numberCount++;
                    System.out.println(b - currentPos);
                    knownNumbers[b - currentPos - 1] = input.nextInt();
                    numberCount++;
                    currentPos++;
                }
            }
        }
        StringBuilder out = new StringBuilder(b);
        for (int i = 0; i < b; i++) {
            out.append(knownNumbers[i]);
        }
        return out.toString();
    }

    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public static void complement(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.abs(array[i] - 1);
        }
    }
}
