import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t=1; t<=T; t++) {
            int N = sc.nextInt();
            int D = sc.nextInt();

            Map<Long, Integer> map = new HashMap<>();
            long max = 0;

            for (int i=0; i<N; i++) {
                long x = sc.nextLong();
                map.putIfAbsent(x, 0);
                map.put(x, map.get(x)+1);
                if (x>max){
                    max = x;
                }
            }

            int ans=0;

            if (D==2){
                boolean double_exists = false;
                for (Map.Entry<Long, Integer> entry: map.entrySet()) {
                    if (entry.getValue()>=2) {
                        double_exists = true;
                        break;
                    }
                }
                if (double_exists){
                    ans = 0;
                }else {
                    ans = 1;
                }
            }else {
                boolean double_exists = false;
                for (Map.Entry<Long, Integer> entry: map.entrySet()) {
                    if (entry.getValue()>=3) {
                        double_exists = true;
                        break;
                    }
                }
                if (double_exists){
                    ans = 0;
                }else {
                    for (Map.Entry<Long, Integer> entry: map.entrySet()) {
                        if (entry.getValue()>=2 && max>entry.getKey()) {
                            double_exists = true;
                            break;
                        }
                        if (map.containsKey(entry.getKey()*2)) {
                            double_exists = true;
                            break;
                        }
                    }

                    if (double_exists) {
                        ans = 1;
                    }else{
                        ans=2;
                    }
                }
            }

            System.out.println("Case #"+t+": "+ans);
        }
    }
}
