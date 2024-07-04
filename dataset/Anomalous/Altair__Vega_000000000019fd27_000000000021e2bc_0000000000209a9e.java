import java.util.Scanner;

public class BitManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int T = Integer.parseInt(firstLine[0]);
        int B = Integer.parseInt(firstLine[1]);
        int halfB = (B % 2 == 0) ? B / 2 : B / 2 + 1;

        for (int testCase = 0; testCase < T; testCase++) {
            int[] bits = new int[B];
            int counter = 1;
            int same = 0;
            int diff = 0;
            boolean sameFound = false;
            boolean diffFound = false;

            while (true) {
                for (int i = 1; i <= halfB + 1; i++) {
                    if (counter == 1) {
                        System.out.println(i);
                        bits[i - 1] = Integer.parseInt(scanner.nextLine());
                        System.out.println(B + 1 - i);
                        bits[B - i] = Integer.parseInt(scanner.nextLine());
                    } else if (counter % 10 == 1) {
                        System.out.println(same);
                        int tempSame = Integer.parseInt(scanner.nextLine());
                        System.out.println(diff);
                        int tempDiff = Integer.parseInt(scanner.nextLine());

                        if (tempSame == bits[same - 1]) {
                            if (tempDiff != bits[diff - 1]) {
                                for (int j = 0; j <= halfB; j++) {
                                    int temp = bits[j];
                                    bits[j] = bits[B - 1 - j];
                                    bits[B - 1 - j] = temp;
                                }
                            }
                        } else if (tempDiff == bits[diff - 1]) {
                            for (int j = 0; j <= halfB; j++) {
                                int temp = bits[j];
                                bits[j] = bits[B - 1 - j];
                                bits[B - 1 - j] = temp;
                            }
                            for (int j = 0; j < i - 1; j++) {
                                bits[j] = 1 - bits[j];
                                bits[B - 1 - j] = 1 - bits[B - 1 - j];
                            }
                        } else {
                            for (int j = 0; j < i - 1; j++) {
                                bits[j] = 1 - bits[j];
                                bits[B - 1 - j] = 1 - bits[B - 1 - j];
                            }
                        }
                        i -= 2;
                    } else {
                        System.out.println(i);
                        bits[i - 1] = Integer.parseInt(scanner.nextLine());
                        System.out.println(B + 1 - i);
                        bits[B - i] = Integer.parseInt(scanner.nextLine());
                    }

                    if (!sameFound && bits[i - 1] == bits[B - i]) {
                        same = i;
                        sameFound = true;
                    }
                    if (!diffFound && bits[i - 1] != bits[B - i]) {
                        diff = i;
                        diffFound = true;
                    }

                    counter += 2;
                }

                StringBuilder outString = new StringBuilder();
                for (int bit : bits) {
                    outString.append(bit);
                }
                System.out.println(outString);
                String hopeItsY = scanner.nextLine();
                if (hopeItsY.equals("Y")) {
                    break;
                }
            }
        }
        scanner.close();
    }
}