import java.util.Scanner;
import java.lang.Math;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        for(int i=0; i<t; i++)
            System.out.println(String.format("Case #%d:\n%s", (i+1), doit(i)));
    }

    private static String doit(int t) {
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if(n <= 500) {
            for(int i=0; i<n; i++) {
                sb.append(String.format("%d 1\n", i+1));
            }
            return sb.deleteCharAt(sb.length()-1).toString().trim();
        }

        int tmp = 1, i=1;
        sb.append("1 1\n");
        while(true) {
            tmp += i++;
            if(tmp > n) {
                tmp -= --i;
                for(int j=tmp; j<n; j++)
                    sb.append(String.format("%d 1\n", ++i));
                break;
            }
            sb.append(String.format("%d 2\n", i));
        }

        return sb.deleteCharAt(sb.length()-1).toString().trim();
    }
}

