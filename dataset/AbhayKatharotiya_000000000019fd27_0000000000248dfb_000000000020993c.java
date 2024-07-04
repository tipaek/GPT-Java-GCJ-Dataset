import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> ans = new ArrayList<>();
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            sc.nextLine();
            List<String> matrixInp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                matrixInp.add(sc.nextLine());
            }
            List<List<Integer>> matrix = new ArrayList<>();
            for (String s : matrixInp) {
                String[] temp = s.split(" ");
                List<Integer> matrixRow = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    matrixRow.add(Integer.parseInt(temp[k]));
                }
                matrix.add(matrixRow);
            }
            int ans1 = 0;
            for (int j = 0; j < n; j++) {
                ans1 = ans1 + matrix.get(j).get(j);
            }
            int ans2 = 0;
            for (int j = 0; j < n; j++) {
                B:for (int k = 0; k < n - 1; k++) {
                    for (int a = k + 1; a < n; a++) {
                        if (matrix.get(j).get(k).equals(matrix.get(j).get(a))) {
                            ans2++;
                            break B;
                        }
                    }
                }
            }
            int ans3 = 0;
            for (int j=0;j<n;j++){
                C:for (int k =0;k<n;k++){
                    for (int a = k + 1; a < n; a++) {
                        if (matrix.get(k).get(j).equals(matrix.get(a).get(j))) {
                            ans3++;
                            break C;
                        }
                    }
                }
            }
            String ansStr = "Case #"+i+": "+ans1 +" "+ans2 +" "+ans3;
            ans.add(ansStr);
        }
        for (String an : ans) {
            System.out.println(an);
        }
    }
}