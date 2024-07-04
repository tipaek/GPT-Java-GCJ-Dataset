import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] tr = build(500);

        Map<Integer, String> mPath = new HashMap<>();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = in.nextInt();
        for (int t = 1; t <= tc; ++t) {
            int n = in.nextInt();
            String path = "";

            Set<String> pathM = new HashSet<>();
            pathM.add(String.format("%s,%s", 0, 0));

            if (mPath.containsKey(n)) {
                path = mPath.get(n);
            } else {
                path = walk(n, 0, 0, "", tr, pathM, mPath);
            }

            System.out.println(String.format("Case #%s:", t));
            
            String[] parts = path.split("\\|");
            for (String part: parts) {
                if (part.length() > 0) {
                    String[] ind = part.split(",");
                    System.out.println(ind[0] + " " + ind[1]);
                }
            }


        }
    }

    public static String walk(int n, int i, int j, String curr, int[][] tr, Set<String> set, Map<Integer, String> mPath) {
        if (n > 0 && set.size() < 500) {
            List<String> arr = new ArrayList<>();
            String next = append(curr, i, j);
            if (i > 0 && j < tr[i - 1].length && n - tr[i - 1][j] >= 0) {
                //String next = append(curr, i - 1, j);
                if (!set.contains(String.format("%s,%s", i - 1, j))) {
                    set.add(String.format("%s,%s", i - 1, j));
                    mPath.put(n - tr[i - 1][j], next);
                    String r = walk(n - tr[i - 1][j], i - 1, j, next, tr, set, mPath);
                    if (r != null && r.length() > 0) {
                        arr.add(r);
                    }
                }
            }
            if(i < tr.length - 1 && n - tr[i + 1][j] >= 0) {
                //String next = append(curr, i + 1, j);
                if (!set.contains(String.format("%s,%s", i + 1, j))) {
                    set.add(String.format("%s,%s", i + 1, j));
                    mPath.put(n - tr[i + 1][j], next);
                    String r = walk(n - tr[i + 1][j], i + 1, j, next, tr, set, mPath);
                    if (r != null && r.length() > 0) {
                        arr.add(r);
                    }
                }
            }
            if(j > 0 && n - tr[i][j - 1] >= 0) {
                //String next = append(curr, i, j - 1);
                if (!set.contains(String.format("%s,%s", i, j - 1))) {
                    set.add(String.format("%s,%s", i, j - 1));
                    mPath.put(n - tr[i][j - 1], next);
                    String r = walk(n - tr[i][j - 1], i, j - 1, next, tr, set, mPath);
                    if (r != null && r.length() > 0) {
                        arr.add(r);
                    }
                }
            }
            if(j < i && n - tr[i][j + 1] >= 0) {
                //String next = append(curr, i, j + 1);
                if (!set.contains(String.format("%s,%s", i, j + 1))) {
                    set.add(String.format("%s,%s", i, j + 1));
                    mPath.put(n - tr[i][j + 1], next);
                    String r = walk(n - tr[i][j + 1], i, j + 1, next, tr, set, mPath);
                    if (r != null && r.length() > 0) {
                        arr.add(r);
                    }
                }
            }
            if(i > 0 && j > 0 && n - tr[i - 1][j - 1] >= 0) {
                //String next = append(curr, i - 1, j - 1);
                if (!set.contains(String.format("%s,%s", i - 1, j - 1))) {
                    set.add(String.format("%s,%s", i - 1, j - 1));
                    mPath.put(n - tr[i - 1][j - 1], next);
                    String r = walk(n - tr[i - 1][j - 1], i, j - 1, next, tr, set, mPath);
                    if (r != null && r.length() > 0) {
                        arr.add(r);
                    }
                }
            }
            if(i < tr.length - 1 && j < i && n - tr[i + 1][j + 1] >= 0) {
                //String next = append(curr, i + 1, j + 1);
                if (!set.contains(String.format("%s,%s", i + 1, j + 1))) {
                    set.add(String.format("%s,%s", i + 1, j + 1));
                    mPath.put(n - tr[i + 1][j + 1], next);
                    String r = walk(n - tr[i + 1][j + 1], i, j + 1, next, tr, set, mPath);
                    if (r != null && r.length() > 0) {
                        arr.add(r);
                    }
                }
            }
            //System.out.println(arr);
            //System.out.println(mPath);
            if (arr.isEmpty()) {
                return null;
            } else {
                return arr.get(0);
            }
        } else {
            return curr;
        }
    }


    public static String append(String p, int i, int j) {
        return p + i + "," + j + "|";
    }

    public static List<List<Integer>> split(String p) {
        String[] r = p.split("\\|");
        List<List<Integer>> re = new ArrayList<>();
        for (String pp: r) {
            if (pp.length() > 0) {
                String[] indexes = pp.split(",");
                List<Integer> point = new ArrayList<>();
                point.add(Integer.parseInt(indexes[0]) + 1);
                point.add(Integer.parseInt(indexes[1]) + 1);
                re.add(point);
            }
        }
        return re;
    }

    public static int[][] build(int n) {
        int[][] arr = new int[n][];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = new int[i];
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    arr[i - 1][j - 1] = 1;
                } else {
                    arr[i - 1][j - 1] = arr[i - 2][j - 2] + arr[i - 2][j - 1];
                }

            }
        }
        return arr;
    }


}
