import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0; ++i<=t; ) {
            int n = Integer.parseInt(in.nextLine());
            String[] arr = new String[n];
            for(int j = 0; j<n; j++) {
                arr[j] = in.nextLine();
            }
            System.out.print("Case #"+i+": ");
            printOut(arr,n);
            System.out.println();
        }
    }

    private static void printOut(String[] arr, int n) {
        int sum = 0, r=0, c=0;
        Set set1, set2;
        for(int i = 0; i<n; i++) {
            String[] ints = arr[i].split(" ");
            sum += Integer.parseInt(ints[i]);
        }
        System.out.print(sum+" ");
        for(int i = 0; i<n; i++) {
            String[] ints = arr[i].split(" ");
            set1 = new HashSet();
            for(int j=0; j<n; j++) {
                set1.add(Integer.parseInt(ints[j]));
            }
            if(set1.size() != n)
                r++;
            set1 = null;
        }
        System.out.print(r+" ");
        for(int i = 0; i<n; i++) {
            set2 = new HashSet();
            for(int j =0; j<n; j++) {
                String[] ints = arr[j].split(" ");
                set2.add(Integer.parseInt(ints[i]));
            }
            if(set2.size() != n)
                c++;
            set2 = null;
        }
        System.out.print(c);
    }
}
