import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int l = 0; l < t; l++) {
            int n = scanner.nextInt();
            ArrayList<Integer> tasks = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < 2 * n; i++) {
                if (i % 2 == 0) {
                    tasks.add(-scanner.nextInt());
                }
                else {
                    tasks.add(scanner.nextInt());
                    map.put(tasks.get(i), tasks.get(i - 1));
                }
            }

            tasks.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(Math.abs(o1), Math.abs(o2));
                }
            });

            StringBuilder str = new StringBuilder();
            boolean flagJ = true, flagC = true;
            int startJ = -1;
            int startC = -1;
            for (int i = 0; i < 2 * n; i++) {
                if (tasks.get(i) <= 0){
                    if (flagJ) {
                        str.append('J');
                        startJ = tasks.get(i);
                        flagJ = false;
                    }
                    else if (flagC){
                        str.append('C');
                        startC = tasks.get(i);
                        flagC = false;
                    }
                    else {
                        str = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                else{
                    int start = map.get(tasks.get(i));
                    if (start == startC)
                        flagC = true;
                    else if (start == startJ)
                        flagJ = true;
                }
            }

            System.out.printf("Case #%d: %s\n", l + 1, str);
        }
    }
}