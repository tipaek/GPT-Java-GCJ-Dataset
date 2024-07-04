import java.lang.reflect.Array;
import java.util.*;

class Solution {

    static class Node {
        int start, finish, index;
        char perform;

        public char getPerform() {
            return perform;
        }

        public void setPerform(char perform) {
            this.perform = perform;
        }

        public Node(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            ArrayList<Node> activtiy = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] times = scanner.nextLine().split(" ");
                Node node = new Node(Integer.parseInt(times[0]), Integer.parseInt(times[1]), i);
                activtiy.add(node);
            }

            activtiy.sort((o1, o2) -> {
                if (o1.finish != o2.finish) {
                    return Integer.compare(o1.finish, o2.finish);
                }
                return Integer.compare(o1.start, o2.start);
            });

            int C_max = 0, J_max = 0;
            int flag = 0;
            for (int i = 0; i < activtiy.size(); i++) {
                if (i == 0) {
                    activtiy.get(i).setPerform('C');
                    C_max = activtiy.get(i).finish;
                } else if (activtiy.get(i).start >= C_max) {
                    activtiy.get(i).setPerform('C');
                    C_max = activtiy.get(i).finish;
                } else if (J_max == 0 || activtiy.get(i).start >= J_max) {
                    activtiy.get(i).setPerform('J');
                    J_max = activtiy.get(i).finish;
                } else {
                    flag = 1;
                    break;
                }
            }

            activtiy.sort(Comparator.comparingInt(o -> o.index));

            if (flag == 1) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder s = new StringBuilder();
                for (Node n : activtiy) {
                    s.append(n.getPerform());
                }
                System.out.println("Case #" + (t + 1) + ": " + s.toString());
            }
        }
    }
}


