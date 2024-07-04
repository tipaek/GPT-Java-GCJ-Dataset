import java.util.*;
class euler {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 1; z <= t; z++) {
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int k = 0;
            for (int i = 0; i < n; i++) 
                        k += a[i][i];
        
            HashSet<Integer> h = new HashSet<>();
            int r = 0;
            for (int i = 0; i < n; i++) {
                h.clear();
                for (int j = 0; j < n; j++) {
                    if (!h.contains(a[i][j])) {
                        h.add(a[i][j]);
                    } else {
                        r++;
                        break;
                    }
                }
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                h.clear();
                for (int j = 0; j < n; j++) {
                    if (!h.contains(a[j][i])) {
                        h.add(a[j][i]);
                    } else {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + z + ": " + k + " " + r + " " + c);
        }
    }
}

