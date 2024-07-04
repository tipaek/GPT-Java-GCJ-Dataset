import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        int numBits = sc.nextInt();
        int x = 1;
        while (x <= numTests) {
            int[] bits = new int[numBits];
            int start = 0;
            int end = numBits -1;
            boolean begin = true;
            boolean opposites = false;
            int[] oppsiteIndex = new int[2];
            boolean same = false;
            int[] sameIndex = new int[2];
            int count = 1;
            int numOfBitsIdentified = 0;
            while (numOfBitsIdentified < numBits) {
                if ((count % 10) == 1 && count != 1) {
                    if (!same) {
                        System.out.println(1);
                        int newBit = sc.nextInt();
                        count++;
                        if (newBit == bits[0]) {
                            // no change detected

                        } else {
                            // flip array
                            flip(bits);
                        }
                        // read to make even
                        System.out.println(1);
                        newBit = sc.nextInt();
                        count++;
                    } else if (!opposites) {
                        System.out.println(1);
                        int newBit = sc.nextInt();
                        count++;
                        if (newBit == bits[0]) {
                            // no change detected

                        } else {
                            // flip array
                            flip(bits);
                        }
                        // read to make even
                        System.out.println(1);
                        newBit = sc.nextInt();
                        count++;
                    } else {
                        System.out.println(sameIndex[0] + 1);
                        int newBit = sc.nextInt();
                        count++;
                        if (newBit == bits[sameIndex[0]]) {
                            System.out.println(oppsiteIndex[0] + 1);
                            int newOppBit = sc.nextInt();
                            count++;
                            if (newOppBit == bits[oppsiteIndex[0]]) {
                                // no change
                            } else {
                                swap(bits);
                            }
                        } else {
                            System.out.println(oppsiteIndex[0] + 1);
                            int newOppBit = sc.nextInt();
                            count++;
                            if (newOppBit == bits[oppsiteIndex[0]]) {
                                flip(bits);
                                swap(bits);
                            } else {
                                flip(bits);
                            }
                        }
                    }
                }
                if (begin) {
                    System.out.println(start + 1);
                    bits[start++] = sc.nextInt();
                    count++;
                    numOfBitsIdentified++;
                    begin = false;
                } else {
                    System.out.println(end + 1);
                    bits[end--] = sc.nextInt();
                    count++;
                    numOfBitsIdentified++;
                    begin = true;
                    if(bits[start - 1] == bits[end + 1]) {
                        same = true;
                        sameIndex[0] = start - 1;
                        sameIndex[1] = end + 1;
                    } else {
                        opposites = true;
                        oppsiteIndex[0] = start - 1;
                        oppsiteIndex[1] = end + 1;
                    }
                }
            }

            printBits(bits);
            String resp = sc.next();
            if (resp.equalsIgnoreCase("N")) {
                return;
            }
            x++;
        }

    }

    private static void swap(int[] bits) {
        for(int i = 0; i < bits.length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - i - 1];
            bits[bits.length - i - 1] = temp;
        }
    }

    private static void flip(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            int curr = bits[i];
            if (curr == 0) {
                bits[i] = 1;
            } else {
                bits[i] = 0;
            }
        }
    }

    public static void printBits(int[] bits) {
        StringBuilder sb = new StringBuilder(bits.length);
        for (int bit : bits) {
            sb.append(bit);
        }
        System.out.println(sb.toString());
    }
}
