import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.next());
        int count = 0;
        while (t-- > 0) {
            count++;

            int n = Integer.parseInt(in.next());
            int[] s = new int[n];
            int[] e = new int[n];
            Map<Integer, Integer> emap = new HashMap<Integer, Integer>();
            Map<Integer, Integer> emap2 = new HashMap<Integer, Integer>();
            Map<Integer, Character> ansmap = new HashMap<Integer, Character>();
            Map<Integer, Integer> smap = new HashMap<Integer, Integer>();
            Map<Integer, Integer> smap2 = new HashMap<Integer, Integer>();

            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(in.next());
                e[i] = Integer.parseInt(in.next());
            }
            boolean flag = true;

            for (int i = 0; i < s.length && flag; i++) {
                if (emap.containsKey(s[i])) {
                    if (emap2.containsKey(s[i])) {
                        flag = false;
                    } else {
                        emap2.put(s[i], e[i]);
                    }
                } else {
                    emap.put(s[i], e[i]);
                }
            }


            for (int i = 0; i < s.length && flag; i++) {
                if (smap.containsKey(s[i])) {
                    if (smap2.containsKey(s[i])) {
                        flag = false;
                    } else {
                        smap2.put(s[i], i+1);
                    }
                } else {
                    smap.put(s[i], i+1);
                }
            }


            Arrays.sort(s);
            int cam = 0;
            int jas = 0;
int x = 0;
            for (int i = 0; i < s.length && flag; i++) {

                if (smap.containsKey(s[i])) {
                    x = smap.get(s[i]);
                    smap.remove(s[i]);
                } else {
                    x = smap2.get(s[i]);
                }

                if (cam <= jas) {

                    if (s[i] >= cam) {
                        if (emap.containsKey(s[i])) {
                            cam = emap.get(s[i]);
                            emap.remove(s[i]);
                            ansmap.put(x, 'C');
                        } else {
                            cam = emap2.get(s[i]);
                            emap2.remove(s[i]);
                            ansmap.put(x, 'C');
                        }
                    } else if (s[i] >= jas) {
                        if (emap.containsKey(s[i])) {
                            jas = emap.get(s[i]);
                            emap.remove(s[i]);
                            ansmap.put(x, 'J');
                        } else {
                            jas = emap2.get(s[i]);
                            emap2.remove(s[i]);
                            ansmap.put(x, 'J');
                        }
                    } else {
                        flag = false;
                    }
                } else {
                    if (s[i] >= jas) {
                        if (emap.containsKey(s[i])) {
                            jas = emap.get(s[i]);
                            emap.remove(s[i]);
                            ansmap.put(x, 'J');
                        } else {
                            jas = emap2.get(s[i]);
                            emap2.remove(s[i]);
                            ansmap.put(x, 'J');
                        }
                    } else if (s[i] >= cam) {
                        if (emap.containsKey(s[i])) {
                            cam = emap.get(s[i]);
                            emap.remove(s[i]);
                            ansmap.put(x, 'C');
                        } else {
                            cam = emap2.get(s[i]);
                            emap2.remove(s[i]);
                            ansmap.put(x, 'C');
                        }
                    } else {
                        flag = false;
                    }
                }
            }

            System.out.print("Case #" + count + ": ");

            if (flag) {
                for (int j = 1; j < s.length + 1; j++) {
                    System.out.print(ansmap.get(j) + " ");
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        in.close();
    }
}