import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int[] jamie = new int[1440];
            int[] cameron = new int[1440];
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (isPossible) {
                    boolean canAssignToJamie = true;
                    for (int j = start; j < end; j++) {
                        if (jamie[j] == 1) {
                            canAssignToJamie = false;
                            break;
                        }
                    }

                    if (canAssignToJamie) {
                        for (int j = start; j < end; j++) {
                            jamie[j] = 1;
                        }
                        result.append("J");
                    } else {
                        boolean canAssignToCameron = true;
                        for (int j = start; j < end; j++) {
                            if (cameron[j] == 1) {
                                canAssignToCameron = false;
                                break;
                            }
                        }

                        if (canAssignToCameron) {
                            for (int j = start; j < end; j++) {
                                cameron[j] = 1;
                            }
                            result.append("C");
                        } else {
                            result = new StringBuilder("IMPOSSIBLE");
                            isPossible = false;
                        }
                    }
                }
            }

            System.out.println("Case #" + (l + 1) + ": " + result);
        }
    }
}