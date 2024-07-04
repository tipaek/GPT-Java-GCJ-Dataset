import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
        {
            System.out.print("Case #" + i + ": ");
            int r = sc.nextInt();
            int s = sc.nextInt();
            ArrayList <Integer> pairs = new ArrayList<>();
            for (int ss = 1; ss <= s; ss++)
            {
                for (int rr = 1; rr <= r; rr++)
                {
                    pairs.add(rr);
                }
            }
            System.out.println((r-1)*(s-1));
            for (int ss = r; ss > 1; ss--)
            {
                for (int rr = s; rr > 1; rr--)
                {
                    int a = pairs.indexOf(ss);
                    int b = pairs.lastIndexOf(ss);
                    System.out.println(a+1 + " " + (b-a-1));
                    List <Integer> c = pairs.subList(0, a+1);
                    List<Integer> d = pairs.subList(a+1, b);
                    List<Integer> e = pairs.subList(b,pairs.size()-1);
                    pairs = new ArrayList<>();
                    pairs.addAll(d);
                    pairs.addAll(c);
                    pairs.addAll(e);
                }
                pairs.remove(pairs.size()-1);
            }
        }
    }
}