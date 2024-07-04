import java.io.*;
import java.util.HashSet;
public class duplicate {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("./src/input.txt"))) {
            int n = Integer.parseInt(br.readLine());
            int p = 0;
            while (p < n) {
                int k = Integer.parseInt(br.readLine());
                int arr[][]=new int[k][k];
                for (int i = 0; i < k; i++) {
                    String[] numbers = br.readLine().split(" ");
                    for (int j = 0; j < k; j++) {
                        arr[i][j] = Integer.parseInt(numbers[j]);
                    }
                }
                inp(arr);
                p++;
            }
            }
    }
}
