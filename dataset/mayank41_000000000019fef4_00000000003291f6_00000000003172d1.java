import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1;t<=tc;t++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] arr = new long[n];
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                
            }
            Arrays.sort(arr);
            int max =1;
            if(n==1) {
                System.out.println("Case #" + t + ": " + (d-1));
                continue;
            }
            int count=1;
            for(int i=1; i<n; i++) {
                if(arr[i] == arr[i-1]) {
                    count++; 
                }
            }
            if(count>=d) {
                System.out.println("Case #" + t + ": " + 0);
                continue;
            }
            System.out.println("Case #" + t + ": " + (d-1));

        }
    }
}
