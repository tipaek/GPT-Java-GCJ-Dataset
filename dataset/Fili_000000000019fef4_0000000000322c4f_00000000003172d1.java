import java.util.*;
public class Solution {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int T = scanner.nextInt();
        for(int i = 1; i <= T; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    public static void solve() {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int max = 1;
        double []a = new double[n];
        HashMap<Double, Integer> slices = new HashMap<>();
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextDouble();
            if(slices.containsKey(a[i])){
                int p = slices.get(a[i]);
                p++;
                slices.put(a[i], p);
                if(p > max) {
                    max = p;
                }
            }
            else {
                slices.put(a[i], 1);
            }
        }
        if(max >= d) {
            System.out.println(0 + "\n");
        }
        else if (d == 2 || max == 2){
            System.out.println(1 + "\n");
        }
        else {
            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j < n; j++) {
                    if(a[i] == a[j]/2 || a[i] == a[j]*2){
                        System.out.println(1 + "\n");
                        return;
                    }
                }
            }
            System.out.println(2 + "\n");
        }
    }
}
