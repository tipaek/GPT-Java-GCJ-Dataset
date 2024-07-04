import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int p = 0; p < t; p++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int a = r * (s - 1);
            int b = r - 1;
            int count = 0;
            
            while (b > 0) {
                for (int i = 0; i < (s - 1); i++) {
                    list.add(a);
                    list.add(b);
                    count++;
                    a--;
                }
                b--;
            }
            
            System.out.println("Case #" + (p + 1) + ": " + count);
            for (int i = 0; i < count * 2; i += 2) {
                System.out.println(list.get(i) + " " + list.get(i + 1));
            }
        }
        
        sc.close();
    }
}