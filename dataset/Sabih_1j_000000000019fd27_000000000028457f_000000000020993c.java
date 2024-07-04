import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void inp(int arr[][]) throws FileNotFoundException {
        int k = arr.length;
        int r = 0;
        int trace = 0;
        while (r < k) {
            trace = trace + arr[r][r];
            r++;
        }
        int rcount = 0, ccount = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int j = 0; j < k; j++) {
            for (int t = 0; t < k; t++) {
                if (!hs.add(arr[j][t])) {
                    rcount++;
                    break;
                }
            }
            hs.clear();
        }
        hs.clear();
        for (int j = 0; j < k; j++) {
            for (int t = 0; t < k; t++) {
                if (!hs.add(arr[t][j])) {
                    ccount++;
                    break;
                }
            }
            hs.clear();
        }
        try (BufferedWriter w = new BufferedWriter(new FileWriter("output.txt",true))) {
            w.write(trace + " " + rcount + " " + ccount + '\n');
            System.out.println(trace + " " + rcount + " " + ccount + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) throws IOException {
            try {
                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                int n = Integer.parseInt(in.nextLine());
                System.out.println(n);
                int p = 0;
                while (p < n) {
                    int k = Integer.parseInt(in.nextLine());
                    int arr[][] = new int[k][k];
                    for (int i = 0; i < k; i++) {
                        String[] numbers = in.nextLine().split(" ");
                        System.out.println(k);
                        for (int j = 0; j < k; j++) {
                            arr[i][j] = Integer.parseInt(numbers[j]);
                        }
                    }
                    System.out.println(p);
                    inp(arr);
                    p++;
                }
            }
            catch (Exception e){}
        }
}
