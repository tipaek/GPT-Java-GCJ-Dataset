import java.util.Scanner;

public class Solution {
    Scanner scanner = new Scanner(System.in);

    private void assign() {
        int test = scanner.nextInt();
        for (int z = 0; z < test; z++) {
            int n = scanner.nextInt();
            String[] div = new String[n];
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
                div[i] = "";
            }
            boolean[] jamie = new boolean[1441];
            boolean[] cameron = new boolean[1441];
            for (int i = 0; i < jamie.length; i++) {
                jamie[i] = false;
                cameron[i] = false;
            }
            boolean possible = true;
            System.out.println();
            for (int i = 0; i < n; i++) {
                boolean jam = false;
                boolean cam = false;
                if (!jamie[start[i]] && !jamie[end[i] - 1]) {
                    boolean overlap = false;
                    for (int j = start[i]; j < end[i]; j++) {
                        if (jamie[j]) {
                            overlap = true;
                            //System.out.println("Overlap on " + i);
                            break;
                        }
                    }
                    if (!overlap) {
                        jam = true;
                        for (int j = start[i]; j < end[i]; j++) {
                            jamie[j] = true;
                        }
                        div[i] = "J";
                    }
                }
                if (!cameron[start[i]] && !cameron[end[i] - 1] && !jam) {
                    boolean overlap = false;
                    for (int j = start[i]; j < end[i]; j++) {
                        if (cameron[j]) {
                            overlap = true;
                            break;
                        }
                    }
                    if (!overlap) {
                        cam = true;
                        for (int j = start[i]; j < end[i]; j++) {
                            cameron[j] = true;
                        }
                        div[i] = "C";
                    }
                }
                if (!jam && !cam) {
                    int number = z + 1;
                    System.out.print("Case #" + number + ": ");
                    System.out.print("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            if (possible) {
                int number = z + 1;
                System.out.print("Case #" + number + ": ");
                for (int i = 0; i < div.length; i++) {
                    System.out.print(div[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution parent = new Solution();
        parent.assign();
    }
}