
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(in);
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            in = sc.nextLine();
            StringTokenizer ab = new StringTokenizer(in);
            int N = Integer.parseInt(ab.nextToken());
            List<List<Integer>> matrix = new ArrayList<>(N);
            for (int index = 0; index < N; index++) {
                in = sc.nextLine();
                StringTokenizer cd = new StringTokenizer(in);
                List<Integer> row = new ArrayList<>(N);
                for (int count = 0; count < N; count++) {
                    int a = Integer.parseInt(cd.nextToken());
                    row.add(a);
                }
                matrix.add(row);
            }
            int repX = 0;
            for (int index = 0; index < N; index++) {

                for (int count = 0; count < N - 1; count++) {
                    int curr = matrix.get(index).get(count);
                    boolean check = false;
                    for (int indic = count + 1; indic < N; indic++) {
                        int temp = matrix.get(index).get(indic);

                        if (temp == curr) {
                            repX++;
                            check = true;
                            break;
                        }

                    }
                    if (check == true) {
                        break;
                    }
                }
            }
            int repY = 0;
            for (int index = 0; index < N; index++) {
                for (int count = 0; count < N - 1; count++) {
                    int curr = matrix.get(count).get(index);
                    boolean check = false;
                    for (int indic = count + 1; indic < N; indic++) {
                        int temp = matrix.get(indic).get(index);
                        if (temp == curr) {
                            repY++;
                            check = true;
                            break;
                        }
                    }
                    if (check == true) {
                        break;
                    }
                }
            }
            int trace = 0;
            for (int index = 0; index < N; index++) {
                trace += matrix.get(index).get(index);
            }
            out.println("Case #" + i + ": " + trace + " " + repX + " " + repY);
        }
        out.close();

    }

}
