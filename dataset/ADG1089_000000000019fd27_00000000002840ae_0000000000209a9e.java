import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public enum States {
        r,//reversed
        c,//complemented
        cr,//complemented and reversed
        s // same
    }

    private static int si = -1;
    private static int di = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();
        for (int x = 1; x <= t; x++) {
            Set<States> possibilities = new HashSet<>();
            Queue<Integer> unsolved = new LinkedList<>();
            for (int i = 1; i < b - i + 1; i++) {
                unsolved.add(i);
                unsolved.add(b - i + 1);
            }
            List<Integer> arr = new ArrayList<>(b + 1);
            for (int i = 0; i <= b; i++) {
                arr.add(-1);
            }
            si = -1;
            di = -1;
            boolean failed = false;
            for (int q = 1; q <= 150; ) {
                if (q <= 10) {
                    assert unsolved.size() > 0;
                    q = queryDigit(sc, b, unsolved, arr, q);
                } else {
                    if (q % 10 == 1) {
                        possibilities.add(States.s);
                        possibilities.add(States.r);
                        possibilities.add(States.c);
                        possibilities.add(States.cr);
                    }
                    if (si != -1) {
                        System.out.println(si);
                        System.out.flush();
                        int v = sc.nextInt();
                        if (arr.get(si) == v) { // s or r
                            possibilities.remove(States.c);
                            possibilities.remove(States.cr);
                        } else {//c or cr
                            possibilities.remove(States.s);
                            possibilities.remove(States.r);
                        }
                        q++;
                    }//2 possibility remains
                    if (di != -1) {
                        System.out.println(di);
                        System.out.flush();
                        int v = sc.nextInt();
                        if (arr.get(si) == v) {//cr or s
                            possibilities.remove(States.c);
                            possibilities.remove(States.r);
                        } else {// c or r
                            possibilities.remove(States.cr);
                            possibilities.remove(States.s);
                        }
                        q++;
                    } // 2 possibility remains
                    if (di == -1) {//all same
                        if (!possibilities.contains(States.s)) {
                            Collections.reverse(arr);
                        }  // else do nothing

                    }
                    if (si == -1) { // all diff
                        if (possibilities.contains(States.c)) {
                            arr = arr.stream().map(v -> {
                                if (v != -1) {
                                    return 1 - v;
                                } else return v;
                            }).collect(Collectors.toList());
                        } // else do nothing
                    }
                    if (unsolved.size() > 0) {
                        q = queryDigit(sc, b, unsolved, arr, q);
                    }
                }
                if (unsolved.size() == 0) {
                    for (int i = 1; i <= b; i++) {
                        System.out.print(arr.get(i));
                    }
                    System.out.println();
                    System.out.flush();
                    sc.nextLine();
                    char c = sc.nextLine().charAt(0);
                    if (c == 'N') {
                        failed = true;
                    }
                    break;
                }
            }
            if (failed) {
                break;
            }
        }
    }

    private static int queryDigit(Scanner sc, int b, Queue<Integer> unsolved, List<Integer> arr, int q) {
        int p = unsolved.poll();
        System.out.println(p);
        System.out.flush();
        int v = sc.nextInt();
        arr.set(p, v);
        if (si == -1 && arr.get(p).equals(arr.get(b - p + 1))) {
            si = b - p + 1;
        }
        if (di == -1 && arr.get(p) == 1 - arr.get(b - p + 1)) {
            di = b - p + 1;
        }
        q++;
        return q;
    }


}