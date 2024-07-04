import java.util.*;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;


public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int turn = 0; turn < T; turn++) {
            int n = input.nextInt();
            int k = input.nextInt();
            System.out.println("Case #" + (turn + 1) + ": ");
            if (n%2 == 0) {
                for (int i = 0; i < k-1; i++) {
                    for (int j = 0; j < n/2; j++) {
                        System.out.println("2" +" "+ ((k-1-i)*n+(i+1)*(2*j+1)-2));
                    }
                }
            }else {
                for (int i = 0; i < k-1; i++) {
                    for (int j = 0; j < n/2; j++) {
                        System.out.println("2" +" "+ ((k-1-i)*n+(i+1)*(2*j+1)-2));
                    }
                    System.out.println("1" + " " + (k*n-1));
                }
            }
        }
    }
}