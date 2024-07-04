import java.util.*;

public class Solution implements Comparator <String> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            sc.nextLine();
            String[] patters = new String[N];
            for (int j = 0; j < N; j++) {
                patters[j] = sc.nextLine();
            }
            String res = solve(patters);
            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }

    public static String checkIfAllEqual(String[] p) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < p.length; i++) {
            if (set.contains(p[i].replaceAll("\\*", ""))) {
                return "*";
            } else {
                set.add(p[i].replaceAll("\\*", ""));
            }
        }
        return p[0].replaceAll("\\*", "");
    }


    public static String solve(String[] p) {
        char c = '*';
        String starting = "", ending = "";
        ArrayList<String> bodies = new ArrayList<>(), first = new ArrayList<>(), last = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            int firstIn = p[i].indexOf(c), lastIn = p[i].lastIndexOf(c);
            if (firstIn == -1) {
                return checkIfAllEqual(p);
            }
            String f = p[i].substring(0, firstIn);
            first.add(f);
            last.add(p[i].substring(lastIn + 1));
            bodies.add(p[i].substring(firstIn, lastIn));
        }
        Collections.sort(first, new Solution());
        Collections.sort(bodies, new Solution());
        Collections.sort(last, new Solution());
//        System.out.println(first);
//        System.out.println(bodies);
//        System.out.println(last);
        if (!first.get(0).isEmpty()) {
            starting = first.get(0);
            for (int i = 1; i < first.size(); i++) {
                if (!starting.startsWith(first.get(i))) {
                    return "*";
                }
            }
        }
        if (!last.get(0).isEmpty()) {
            ending = last.get(0);
            for (int i = 1; i < last.size(); i++) {
                if (!ending.endsWith(last.get(i))) {
                    return "*";
                }
            }
        }
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < bodies.size(); i++) {
            body.append(bodies.get(i).replaceAll("\\*", ""));
        }
        return starting + body.toString() + ending;
    }

    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s2.length(), s1.length());
    }
}

/*

3
7
*CONUTS
*CO*CONUTS
*OCO*NUTS
*CONUTS
*khfsdfkl*
hhhh*
*S
2
*XZ
*XYZ
2
A*C*E
*B*D*


 */
