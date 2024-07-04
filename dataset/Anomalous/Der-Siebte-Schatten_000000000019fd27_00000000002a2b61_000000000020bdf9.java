import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String[] answer = new String[n];
            Arrays.fill(answer, "nobody");

            int[] start = new int[n];
            int[] end = new int[n];
            for (int j = 0; j < n; j++) {
                start[j] = scanner.nextInt();
                end[j] = scanner.nextInt() - 1;
            }

            boolean busy = false;
            for (int j = 0; j <= 1440; j++) {
                boolean cameron = false;
                boolean jamie = false;

                for (int k = 0; k < n; k++) {
                    if (!answer[k].equals("nobody") && j >= start[k] && j <= end[k]) {
                        if (answer[k].equals("C")) {
                            if (cameron) {
                                busy = true;
                            } else {
                                cameron = true;
                            }
                        } else if (answer[k].equals("J")) {
                            if (jamie) {
                                busy = true;
                            } else {
                                jamie = true;
                            }
                        }
                    }
                }

                for (int k = 0; k < n; k++) {
                    if (answer[k].equals("nobody") && j >= start[k] && j <= end[k]) {
                        if (cameron && jamie) {
                            busy = true;
                        } else if (cameron) {
                            jamie = true;
                            answer[k] = "J";
                        } else {
                            cameron = true;
                            answer[k] = "C";
                        }
                    }
                }
            }

            if (busy) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String ans : answer) {
                    System.out.print(ans);
                }
                System.out.println();
            }
        }
    }
}