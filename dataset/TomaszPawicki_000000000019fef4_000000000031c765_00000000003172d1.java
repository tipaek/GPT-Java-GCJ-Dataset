import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            List<Long> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(sc.nextLong());
            }
            if (d == 1) {
                System.out.println("Case #" + t + ": 0");
                continue;
            }
            Collections.sort(list);
            if (d == 2) {
                int cuts = 1;
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i).equals(list.get(i - 1))) {
                        cuts = 0;
                        break;
                    }
                }
                System.out.println("Case #" + t + ": " + cuts);
                continue;
            }
            if (d == 3) {
                int cuts = 2;
                for (int i = 2; i < list.size(); i++) {
                    if (list.get(i).equals(list.get(i - 1)) && list.get(i).equals(list.get(i - 2))) {
                        cuts = Math.min(cuts, 0);
                        break;
                    }
                }
                if (cuts > 0) {
                    for (int i = 1; i < list.size(); i++) {
                        if (list.get(i).equals(list.get(i - 1)) && i < n-1) {
                            cuts = Math.min(cuts, 1);
                            break;
                        }
                    }
                    if (cuts == 2) {
                        Set<Long> set = new HashSet<>(n);
                        set.addAll(list);
                        for (int i = 0; i < list.size(); i++) {
                            if(set.contains(2L * list.get(i))) {
                                cuts = Math.min(cuts, 1);
                                break;
                            }
                        }
                    }
                }
                System.out.println("Case #" + t + ": " + cuts);
                continue;
            }
            System.out.println("Case #" + t + ": " + 0);
        }
    }
}
