import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1;t<=tc;t++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                if(map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i])+1);
                } else {
                    map.put(arr[i], 1);
                }
            }
            int max =0;
            for(Map.Entry entry : map.entrySet()) {
                if((int)entry.getValue() >= d) {
                    System.out.println("Case #" + t + ": " + 0);
                }
                max = Math.max(max, (int)entry.getValue());
            }
            System.out.println("Case #" + t + ": " + (d-1));
            
        }
    }
}
