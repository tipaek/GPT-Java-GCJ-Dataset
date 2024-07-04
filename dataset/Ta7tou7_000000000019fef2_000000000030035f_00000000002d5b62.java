import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int ca = 1; ca <= t; ca++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int x = Math.abs(X), y = Math.abs(Y);
            String res = solve(x, y);
            if(res == null) {
                System.out.println("Case #" + ca + ": IMPOSSIBLE");
                continue;
            }
            char[] tab = res.toCharArray();
            if (X != x) {
                for (int i = 0; i < tab.length; i++) {
                    if (tab[i] == 'E') tab[i] = 'W';
                    else if (tab[i] == 'W') tab[i] = 'E';
                }
            }
            if (Y != y) {
                for (int i = 0; i < tab.length; i++) {
                    if (tab[i] == 'N') tab[i] = 'S';
                    else if (tab[i] == 'S') tab[i] = 'N';
                }
            }
            System.out.println("Case #" + ca + ": " + new String(tab));
        }
    }

    private static String solve(int x, int y) {
        int cx = x, cy = y;
        int nx = 1;
        int resx = 1;
        while ((resx & x) == resx) {
            resx += 1 << nx;
            nx++;
        }
        int ny = 1;
        int resy = 1;
        while ((resy & y) == resy) {
            resy += 1 << ny;
            ny++;
        }
        String Xres1 ="";
        while (cx > 0){
            if((cx & 1) == 1) {
                Xres1 += "E";
            }
            else {
                Xres1 += "0";
            }
            cx >>= 1;
        }

        String Yres1 ="";
        while (cy > 0){
            if((cy & 1) == 1) {
                Yres1 += "N";
            }
            else {
                Yres1 += "0";
            }
            cy >>= 1;
        }
        String Xres2 = second(Xres1, nx-1, 'W', 'E');
        String Yres2 = second(Yres1, ny-1, 'S', 'N');
        String[] Xs = {Xres1, Xres2};
        String[] Ys = {Yres1, Yres2};
        return concat(Xs, Ys);
    }

    private static String concat(String[] xs, String[] ys) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < xs.length; i++) {
            for (int j = 0; j < ys.length; j++) {
                String min = xs[i].length() < ys[j].length() ? xs[i] : ys[j];
                String max = xs[i].length() < ys[j].length() ? ys[j] : xs[i];
                int minLength = min.equals("") ? 0 : min.length();
                int maxLength = max.equals("") ? 0 : max.length();
                for (int k = 0; k < maxLength-minLength; k++) {
                    min += '0';
                }
                String res = "";
                boolean noRes = false;
                for (int k = 0; k < max.length() ; k++) {
                    if(min.charAt(k) != '0' && max.charAt(k) != '0') {
                        noRes = true;
                        break;
                    }
                    if(min.charAt(k) == '0' && max.charAt(k) == '0') {
                        noRes = true;
                        break;
                    }
                    if(min.charAt(k) != '0') {
                        res+=min.charAt(k);
                    }
                    else if (max.charAt(k) != '0') {
                        res += max.charAt(k);
                    }
                }
                if(!noRes) list.add(res);
            }
        }
        return list.stream().min((l1,l2) -> l1.length() - l2.length())
                .orElse(null);
    }

    private static String second(String str, int i, char rep, char orig) {
        if(str.length() == 0) return "";
        if (i == 0) return str;
        char[] tab = str.toCharArray();
        for (int j = 1; j < i; j++) {
            tab[j] = '0';
        }
        tab[0] = rep;
        String res;
        if(i < str.length()){
            tab[i] = orig;
            res = new String(tab);
        }
        else {
            res = new String(tab);
            res+=orig;
        }

        return res;
    }

    int[] readInts(Scanner sc, int n) {
        int[] tab = new int[n];
        for (int i = 0; i < n; i++) {
            tab[i] = sc.nextInt();
        }
        return tab;
    }

    long[] readLongs(Scanner sc, int n) {
        long[] tab = new long[n];
        for (int i = 0; i < n; i++) {
            tab[i] = sc.nextLong();
        }
        return tab;
    }

    String[] readStrings(Scanner sc, int n) {
        String[] tab = new String[n];
        for (int i = 0; i < n; i++) {
            tab[i] = sc.next();
        }
        return tab;
    }

}

