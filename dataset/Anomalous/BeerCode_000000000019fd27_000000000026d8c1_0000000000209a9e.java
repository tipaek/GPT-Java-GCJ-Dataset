import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            char[] data = new char[bitLength];
            char[] state = new char[bitLength];
            int left = 1;
            int right = bitLength;

            while (left < right) {
                System.out.println(left);
                System.out.flush();
                char leftBit = scanner.nextLine().charAt(0);
                System.out.println(right);
                System.out.flush();
                char rightBit = scanner.nextLine().charAt(0);

                if (leftBit == rightBit) {
                    data[left - 1] = 'S';
                    data[right - 1] = 'S';
                } else {
                    data[left - 1] = 'D';
                    data[right - 1] = 'D';
                }

                state[left - 1] = leftBit;
                state[right - 1] = rightBit;
                left++;
                right--;
            }

            String result = null;

            if (bitLength <= 10) {
                result = new String(state);
            } else {
                String[] candidates = {
                    new String(state), "", "", ""
                };

                for (char c : state) {
                    candidates[1] += (c == '0') ? '1' : '0';
                }

                for (int i = state.length - 1; i >= 0; i--) {
                    candidates[2] += state[i];
                }

                for (int i = state.length - 1; i >= 0; i--) {
                    candidates[3] += (state[i] == '0') ? '1' : '0';
                }

                for (int i = 0; i < 4; i++) {
                    for (int j = i + 1; j < 4; j++) {
                        if (candidates[i].equals(candidates[j])) {
                            candidates[j] = candidates[j].replace('0', 'x').replace('1', 'y');
                        }
                    }
                }

                for (int i = 0; i < bitLength / 20; i++) {
                    int[] scores = new int[4];

                    for (int j = 0; j < 10; j++) {
                        int k = ((i * 10) + j) % bitLength + 1;
                        System.out.println(k);
                        System.out.flush();
                        char response = scanner.nextLine().charAt(0);

                        for (int e = 0; e < 4; e++) {
                            if (candidates[e].charAt(k - 1) == response) {
                                scores[e]++;
                            }
                        }
                    }

                    for (int e = 0; e < 4; e++) {
                        if (scores[e] == 10) {
                            result = candidates[e];
                        }
                    }

                    if (result != null) {
                        break;
                    }
                }
            }

            System.out.println(result);
            System.out.flush();
            String check = scanner.nextLine();
        }

        System.exit(0);
    }
}