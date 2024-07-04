import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt( in .next());
        int count = 0;
        while (t-- > 0) {
            count++;

            int n = Integer.parseInt( in .next());
            int[] s = new int[n];
            int[] e = new int[n];
            Map < Integer, Integer > smap = new HashMap < Integer, Integer > ();
            Map < Integer, Integer > emap = new HashMap < Integer, Integer > ();
            Map < Integer, Character > ansmap = new HashMap < Integer, Character > ();

            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt( in .next());
                e[i] = Integer.parseInt( in .next());
            }

            for (int i = 0; i < s.length; i++) {
                smap.put(s[i], i + 1);
                emap.put(s[i], e[i]);
            }

            Arrays.sort(s);
            int cam = 0;
            int jas = 0;
            boolean flag = true;

            for (int i = 0; i < s.length; i++) {
                if(cam<jas){
                if (s[i] >= cam) {
                    cam = emap.get(s[i]);
                    ansmap.put(i + 1, 'C');
                } else if (s[i] >= jas) {
                    jas = emap.get(s[i]);
                    ansmap.put(i + 1, 'J');
                } else {
                    flag = false;
                }}
                else{
                    if (s[i] >= jas) {
                        jas = emap.get(s[i]);
                        ansmap.put(i + 1, 'J');
                    } else if (s[i] >= cam) {
                        cam = emap.get(s[i]);
                        ansmap.put(i + 1, 'C');
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
        } in .close();
    }
}