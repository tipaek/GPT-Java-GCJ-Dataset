import java.util.*;
public class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n*n];
            System.out.print("Case #" + (i+1) + ":");
            int trace = 0;
            List<Integer> alist = new ArrayList<>();
            for(int j=0; j<n*n; j++) {
                arr[j] = sc.nextInt();
                if(j % (n+1) == 0) trace += arr[j];
            }
            System.out.print(" " + trace);
            int r=0;
            for(int k=0; k<n; k++) 
            for(int j=k*n; j<(k+1)*n; j++) {
                if(alist.contains(arr[j])) {
                    r++;
                    break;
                }
                alist.add(arr[j]);
            }
            System.out.print(" " + r);
            int c=0;
            alist.clear();
            for(int k=0; k<n; k++)
            for(int j=k; j<n*n; j+=n) {
                if(alist.contains(arr[j])) {
                    c++;
                    break;
                }
                alist.add(arr[j]);
            }
            System.out.print(" " + c);
        }
    }
}