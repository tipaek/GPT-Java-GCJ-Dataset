import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public enum States {
        REVERSED, COMPLEMENTED, COMPLEMENTED_REVERSED, SAME
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();

        for (int x = 1; x <= t; x++) {
            Set<States> possibilities = new HashSet<>();
            Queue<Integer> unsolved = new LinkedList<>();
            for (int i = 1; i <= b / 2; i++) {
                unsolved.add(i);
                unsolved.add(b - i + 1);
            }
            List<Integer> arr = new ArrayList<>(Collections.nCopies(b + 1, -1));
            int si = -1, di = -1;
            boolean failed = false;

            for (int q = 1; q <= 150;) {
                if (q <= 10) {
                    int p = unsolved.poll();
                    System.out.println(p);
                    System.out.flush();
                    int v = sc.nextInt();
                    arr.set(p, v);

                    if (si == -1 && arr.get(p).equals(arr.get(b - p + 1))) {
                        si = p;
                    }
                    if (di == -1 && !arr.get(p).equals(arr.get(b - p + 1))) {
                        di = p;
                    }
                    q++;
                } else {
                    if (q % 10 == 1) {
                        possibilities.addAll(Arrays.asList(States.SAME, States.REVERSED, States.COMPLEMENTED, States.COMPLEMENTED_REVERSED));
                    }

                    if (si != -1) {
                        System.out.println(si);
                        System.out.flush();
                        int v = sc.nextInt();
                        if (arr.get(si) == v) {
                            possibilities.remove(States.COMPLEMENTED);
                            possibilities.remove(States.COMPLEMENTED_REVERSED);
                        } else {
                            possibilities.remove(States.SAME);
                            possibilities.remove(States.REVERSED);
                        }
                        q++;
                    }

                    if (di != -1) {
                        System.out.println(di);
                        System.out.flush();
                        int v = sc.nextInt();
                        if (arr.get(di) == v) {
                            possibilities.remove(States.COMPLEMENTED);
                            possibilities.remove(States.REVERSED);
                        } else {
                            possibilities.remove(States.SAME);
                            possibilities.remove(States.COMPLEMENTED_REVERSED);
                        }
                        q++;
                    }

                    if (di == -1 && !possibilities.contains(States.SAME)) {
                        Collections.reverse(arr);
                    }

                    if (si == -1 && possibilities.contains(States.COMPLEMENTED)) {
                        arr = arr.stream().map(v -> v != -1 ? 1 - v : v).collect(Collectors.toList());
                    }

                    if (!unsolved.isEmpty()) {
                        int p = unsolved.poll();
                        System.out.println(p);
                        System.out.flush();
                        int v = sc.nextInt();
                        arr.set(p, v);
                    }
                }

                if (unsolved.isEmpty()) {
                    for (int i = 1; i <= b; i++) {
                        System.out.print(arr.get(i));
                    }
                    System.out.println();
                    System.out.flush();
                    sc.nextLine();
                    if (sc.nextLine().charAt(0) == 'N') {
                        failed = true;
                        break;
                    }
                }
            }

            if (failed) {
                break;
            }
        }

        sc.close();
    }
}