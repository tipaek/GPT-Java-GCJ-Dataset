import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;
    public int B;

    public void doCase(int caseNumber) throws Exception {
        int[] arr = new int[B];
        Arrays.fill(arr, -1);
        for (int guessCount = 0; guessCount < 150; guessCount++) {
//            System.err.println("Before " + guessCount + " " + Arrays.toString(arr));
            if (guessCount % 10 == 0 && guessCount > 0) {
                Set<List<Integer>> set = makeSet(arr);
//                System.err.println(set);
                System.out.println(1);
                int val = readInput();
                set = fixSet(set, 0, val);
                if (set.size() > 1) {
                    guessCount++;
                    int where = findWhere(set);
                    System.out.println(where + 1);
                    val = readInput();
                    set = fixSet(set, where, val);
                    if (set.size() > 1) {
                        System.err.println("Two guesses didn't work!");
                        System.exit(1);
                    }
                }
                arr = setToArray(set);
                continue;
            }
            int where;
            if (guessCount % 2 == 0) where = indexOfFirstUnknown(arr);
            else where = indexOfLastUnknown(arr);
            if (where >= 0) {
                System.out.println(where + 1);
                int val = readInput();
//                System.err.println((where+1) + " -> " + val);
                arr[where] = val;
            } else {
                System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining()));
                String input = in.readLine();
//                System.err.println("Got " + input);
                if ("Y".equals(input)) return;
                System.err.println("Didn't like answer");
                System.exit(1);
            }
        }
    }

    private Set<List<Integer>> makeSet(int[] arr) {
        symmetrify(arr);
        Set<List<Integer>> set = new HashSet<>();
        set.add(listify(arr));
        set.add(listify(complement(arr)));
        set.add(listify(reverse(arr)));
        set.add(listify(reverse(complement(arr))));
        return set;
    }

    private void symmetrify(int[] arr) {
        for (int i = 0; i < B; i++) {
            if (arr[i] != -1 && arr[B-1-i] == -1) {
                arr[i] = -1;
            }
        }

    }

    private List<Integer> listify(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private int[] setToArray(Set<List<Integer>> set) {
        if (set.size() != 1) {
            System.err.println("Expected set size 1");
            System.exit(1);
        }
        for (List<Integer> list : set) {
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
        System.err.println("Expected set size 1 (after)");
        System.exit(1);
        return null;
    }

    private int findWhere(Set<List<Integer>> set) {
        for (int i = 0; i < B; i++) {
            boolean seen0 = false;
            boolean seen1 = false;
            for (List<Integer> list : set) {
                if (list.get(i).intValue() == 0) seen0 = true;
                if (list.get(i).intValue() == 1) seen1 = true;
            }
            if (seen0 && seen1) return i;
        }
        System.err.println("No difference");
        System.exit(1);
        return -1;
    }

    private Set<List<Integer>> fixSet(Set<List<Integer>> set, int where, int val) {
        Iterator<List<Integer>> iter = set.iterator();
        while (iter.hasNext()) {
            List<Integer> list = iter.next();
            if (list.get(where).intValue() != val) iter.remove();
        }
//        System.err.println(set);
        return set;
    }

    private int readInput() throws Exception {
        String line = in.readLine();
        if ("N".equals(line)) {
            System.err.println("Said N");
            System.exit(1);
        }
        return Integer.parseInt(line);
    }

    int indexOfFirstUnknown(int[] arr) {
        for (int i = 0; i < B; i++) {
            if (arr[i] == -1) return i;
        }
        return -1;
    }

    int indexOfLastUnknown(int[] arr) {
        for (int i = B-1; i >= 0; i--) {
            if (arr[i] == -1) return i;
        }
        return -1;
    }

    int[] complement(int[] arr) {
        int[] res = arr.clone();
        for (int i = 0; i < B; i++) {
            if (res[i] == 0) res[i] = 1;
            else if (res[i] == 1) res[i] = 0;
        }
        return res;
    }

    int[] reverse(int[] arr) {
        int[] res = arr.clone();
        for (int i = 0; i < B; i++) {
            res[i] = arr[B-1-i];
        }
        return res;
    }

    public void run() throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        numCases = scan.nextInt();
        B = scan.nextInt();
        for (int i = 1; i <= numCases; i++) {
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}
