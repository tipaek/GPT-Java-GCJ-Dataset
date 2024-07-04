import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(), b = in.nextInt();
            for (int i11=0;i11<t;i11++) {
                int[] arr = new int[b];
                int i1=0;
                while (i1<150) {
                    for (int i=0;i<b;i++) {
                        System.out.println(i+1);
                        arr[i] = in.nextInt();
                        i1++;
                    }
                    for (int i=0;i<b;i++)
                        System.out.print(arr[i]);
                    System.out.println();
                    String res = in.next();
                    if (res.equals("Y"))break;
                }
            }
        }
}