import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            byte[] array = new byte[bits];
            for (int i = 0; i < bits; i++) {
                array[i] = -1;
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(i + 1);
                array[i] = getBitValue(scanner.next().charAt(0));
                System.out.println(bits - i);
                array[bits - i - 1] = getBitValue(scanner.next().charAt(0));
            }

            int frontIndex = 5;
            AtomicInteger queryCount = new AtomicInteger(11);

            while (queryCount.get() <= 150) {
                if (frontIndex >= bits / 2) {
                    System.out.println(new String(array));
                    break;
                }

                if (queryCount.get() % 10 == 1) {
                    int effectNumber = determineEffectNumber(array, frontIndex, scanner, queryCount);
                    applyEffect(array, frontIndex, effectNumber);
                }

                byte frontBit = -2, backBit = -2;
                for (int i = 0; i < 2; i++) {
                    if (queryCount.get() % 10 != 1 && i == 0) {
                        System.out.println(frontIndex + 1);
                        frontBit = getBitValue(scanner.next().charAt(0));
                        queryCount.incrementAndGet();
                    }
                    if (queryCount.get() % 10 != 1 && i == 1) {
                        System.out.println(bits - frontIndex);
                        backBit = getBitValue(scanner.next().charAt(0));
                        queryCount.incrementAndGet();
                    }
                }

                if (frontBit != -2 && backBit != -2) {
                    array[frontIndex] = frontBit;
                    array[bits - frontIndex - 1] = backBit;
                    frontIndex++;
                }
            }

            if (scanner.next().charAt(0) == 'N') {
                break;
            }
        }
    }

    private static void applyEffect(byte[] array, int index, int effectNumber) {
        switch (effectNumber) {
            case 1:
                for (int i = 0; i < index; i++) {
                    array[i] = (byte) (array[i] == 1 ? 0 : 1);
                }
                break;
            case 2:
                for (int i = 0; i < index; i++) {
                    byte temp = array[i];
                    array[i] = array[array.length - i - 1];
                    array[array.length - i - 1] = temp;
                }
                break;
            case 3:
                for (int i = 0; i < index; i++) {
                    byte temp = array[i];
                    array[i] = array[array.length - i - 1];
                    array[array.length - i - 1] = temp;
                    array[i] = (byte) (array[i] == 1 ? 0 : 1);
                }
                break;
        }
    }

    private static byte getBitValue(char ch) {
        return (byte) (ch == '1' ? 1 : 0);
    }

    private static int determineEffectNumber(byte[] array, int index, Scanner scanner, AtomicInteger count) {
        int index1 = -1, index2 = -1;

        for (int i = 0; i < index; i++) {
            if (array[i] == array[array.length - i - 1]) {
                index1 = i;
            }
            if ((array[i] > array[array.length - i - 1] && array[i] - 1 == array[array.length - i - 1]) ||
                (array[i] < array[array.length - i - 1] && array[i] + 1 == array[array.length - i - 1])) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                break;
            }
        }

        Set<Integer> possibleEffects = new HashSet<>();
        Set<Integer> possibleEffectsByIndex2 = new HashSet<>();

        if (index1 >= 0) {
            System.out.println(index1 + 1);
            byte bit = getBitValue(scanner.next().charAt(0));
            count.incrementAndGet();
            if (array[index1] == 1 && bit == 0) {
                possibleEffects.add(1);
                possibleEffects.add(3);
            } else {
                possibleEffects.add(2);
                possibleEffects.add(4);
            }
        }

        if (index2 >= 0) {
            System.out.println(index2 + 1);
            byte bit = getBitValue(scanner.next().charAt(0));
            count.incrementAndGet();
            if (array[index2] == 0 && bit == 0) {
                possibleEffectsByIndex2.add(3);
                possibleEffectsByIndex2.add(4);
            } else {
                possibleEffectsByIndex2.add(1);
                possibleEffectsByIndex2.add(2);
            }
        }

        if (possibleEffects.isEmpty()) {
            return possibleEffectsByIndex2.iterator().next();
        } else if (possibleEffectsByIndex2.isEmpty()) {
            return possibleEffects.iterator().next();
        } else {
            for (int effect : possibleEffects) {
                if (possibleEffectsByIndex2.contains(effect)) {
                    return effect;
                }
            }
            return 1; // Default value if no common effect is found
        }
    }
}