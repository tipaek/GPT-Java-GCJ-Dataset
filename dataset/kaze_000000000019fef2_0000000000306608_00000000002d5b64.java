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

            int time = (n*(k-1)+1)/2;
            System.out.println("Case #" + (turn + 1) + ": " + time);
            if (n%2 == 0) {
                for (int i = 0; i < k-1; i++) {
                    for (int j = 0; j < n/2; j++) {
                        System.out.println("2" +" "+ ((k-1-i)*n+(i+1)*(2*j+1)-2));

                    }
                }
            }else {
                if ((k-1)%2 == 1) {
                    for (int i = 1; i < (k - 1) * n; i = i + 2) {
                        int run = (i - 1) / n;
                        int wei = i % n;
                        if (wei != 0) {
                            System.out.println("2" + " " + ((k - 1) * n - (i - 1) + (run + 1) / 2 + (run + 2) * (wei - 1) + (run + 1) - 2));
                        } else {
                            System.out.println("2" + " " + ((k - 1) * n - (i - 1) + (run + 1) / 2 - 2));
                        }
                    }
                    int duo = (k - 1) / 2 + 1;
                    System.out.println(duo + " " + (k * n - duo));
                }else {
                    for (int i = 1; i < (k - 1) * n; i = i + 2) {
                        int run = (i - 1) / n;
                        int wei = i % n;
                        if (i + 2 >= (k-1) *n) {
                            int duo = (k - 1) / 2;
                            if (wei != 0) {
                                System.out.println((2+duo) + " " + (n*k-(k-(duo+1))-duo-2));
                            }
                            break;
                        }
                        if (wei != 0) {
                            System.out.println("2" + " " + ((k - 1) * n - (i - 1) + (run + 1) / 2 + (run + 2) * (wei - 1) + (run + 1) - 2));
                        } else {
                            System.out.println("2" + " " + ((k - 1) * n - (i - 1) + (run + 1) / 2 - 2));
                        }

                    }
                }
            }
        }
    }
}