import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        for (int t = 0; t < numTests; t++) {
            int n = scanner.nextInt();
            ArrayList<Integer> cBusy = new ArrayList<>();
            ArrayList<Integer> jBusy = new ArrayList<>();
            String res = "";
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (possible) {
                    boolean c = false;
                    boolean j = false;
                    for (int k = 0; k < cBusy.size(); k += 2) {
                        if ((start > cBusy.get(k) && start < cBusy.get(k + 1)) || (end > cBusy.get(k) && end < cBusy.get(k + 1))) {
                            c = true;
                        }
                    }
                    for (int k = 0; k < jBusy.size(); k += 2) {
                        if ((start > jBusy.get(k) && start < jBusy.get(k + 1)) || (end > jBusy.get(k) && end < jBusy.get(k + 1))) {
                            j = true;
                        }
                    }
                    if (!c) {
                        cBusy.add(start);
                        cBusy.add(end);
                        res += "C";
                    } else if (!j) {
                        jBusy.add(start);
                        jBusy.add(end);
                        res += "J";
                    } else {
                        res = "IMPOSSIBLE";
                        possible = false;
                    }
                }
            }
            System.out.println("Case #"+ (t+1) + ": " + res);
        }
    }
}
