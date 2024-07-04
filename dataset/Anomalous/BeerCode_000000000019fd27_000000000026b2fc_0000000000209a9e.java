import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= T; t++) {
            char[] data = new char[B];
            char[] state = new char[B];
            int left = 1;
            int right = B;

            while (left < right) {
                System.out.println(left);
                System.out.flush();
                char leftChar = scanner.nextLine().charAt(0);

                System.out.println(right);
                System.out.flush();
                char rightChar = scanner.nextLine().charAt(0);

                if (leftChar == rightChar) {
                    data[left - 1] = 'S';
                    data[right - 1] = 'S';
                } else {
                    data[left - 1] = 'D';
                    data[right - 1] = 'D';
                }

                state[left - 1] = leftChar;
                state[right - 1] = rightChar;
                left++;
                right--;
            }

            String result = null;
            if (B == 10) {
                result = new String(state);
            } else {
                String[] candidates = { new String(state), "", "", "" };
                for (char c : state) {
                    candidates[1] += (c == '0') ? '1' : '0';
                }
                for (int i = state.length - 1; i >= 0; i--) {
                    candidates[2] += state[i];
                }
                for (int i = state.length - 1; i >= 0; i--) {
                    candidates[3] += (state[i] == '0') ? '1' : '0';
                }

                for (int i = 0; i < B / 20; i++) {
                    int[] scores = new int[4];
                    for (int j = 0; j < 10; j++) {
                        int k = ((i * 10) + j) % B + 1;
                        System.out.println(k);
                        System.out.flush();
                        char response = scanner.nextLine().charAt(0);

                        for (int e = 0; e < 4; e++) {
                            if (candidates[e].charAt(k - 1) == response) {
                                scores[e]++;
                            }
                        }
                    }

                    int fullCount = 0;
                    for (int e = 0; e < 4; e++) {
                        if (scores[e] == 10) {
                            fullCount++;
                        }
                    }

                    if (fullCount == 1) {
                        for (int e = 0; e < 4; e++) {
                            if (scores[e] == 10) {
                                result = candidates[e];
                            }
                        }
                    }

                    if (result != null) {
                        break;
                    }
                }
            }

            System.out.println(result);
            System.out.flush();
            scanner.nextLine(); // Read the check response
        }

        scanner.close();
        System.exit(0);
    }
}