import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(), n, k;
        boolean possible;
        for (int i = 1; i <= t; i++) {
            possible = false;
            n = sc.nextInt();
            k = sc.nextInt();
            possible = n*(n+1) == k;
            int part = k/n;
            possible = possible || (part < n && k*n == k);
//            System.out.println(part);
            if (n*(n+1) == 2*k) {
                System.out.println("Case #" + i + ": POSSIBLE");
                for(int j=1; j<=n; j++) {
                    for(int h=1; h<=n; h++) {
                        System.out.print((j+h)%n + 1 + " ");
                    }
                    System.out.println();
                }
            } else if (part < n && k*n == k) {
                System.out.println("Case #" + i + ": POSSIBLE");
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(part);
                for(int j=1; j<n; j++) {
                    if(j!=part)
                        arr.add(j);
                }
                int rotation = 0;
                for(int j=1; j<=n; j++) {
                    for(int h=n-rotation; h<n; h++) {
                        System.out.print(arr.get(h) + " ");
                    }
                    for(int h=0; h<n-rotation; h++) {
                        System.out.print(arr.get(h) + " ");
                    }
                    rotation++;
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}
