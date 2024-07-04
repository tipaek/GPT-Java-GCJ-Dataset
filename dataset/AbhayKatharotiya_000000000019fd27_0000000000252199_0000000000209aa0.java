import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> ans = new ArrayList<>();
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        sc.nextLine();
        for (int i = 1; i <= t; ++i) {
            String ip = sc.nextLine();
            String[] ips = ip.split(" ");
            int n = Integer.parseInt(ips[0]);
            int k = Integer.parseInt(ips[1]);
            int n2 = k%n;
            int nf = 0;
            for (int j = 1; j <= n; j++) {
                nf = nf + j;
            }

            if (n2 == 0 || (k == nf && n>2)) {
                List<List<Integer>> matrix = getLatin(n);
                List<List<Integer>> finalMatrix = new ArrayList<>();
                if (n2==0){
                    int x = k/n;

                    for (int j=0;j<n;j++){
                        for (k=0;k<n;k++) {
                            if (matrix.get(k).get(j) == x) {
                                finalMatrix.add(matrix.get(k));
                                break;
                            }
                        }
                    }
                }
                else {
//                    List<List<Integer>> finalMatrix = new ArrayList<>();
                    for (int j=n;j>0;j--){
                        C:for (k=0;k<n;k++) {
                            if (matrix.get(k).get(j - 1) == j) {
                                finalMatrix.add(matrix.get(k));
                                break C;
                            }
                        }
                    }

                }
                String ansStr = "Case #"+i+": POSSIBLE";
                ans.add(ansStr);
                for (int j=0;j<n;j++){
                    String temp = "";
                    for (k=0;k<n;k++){
                        temp=temp+finalMatrix.get(j).get(k)+" ";
                    }
                    ans.add(temp);
                }
            }else {
                String ansStr = "Case #"+i+": IMPOSSIBLE";
                ans.add(ansStr);
            }
        }
        for (String an : ans) {
            System.out.println(an);
        }
    }

    static List<List<Integer>> getLatin(int n)
    {
        int k = n+1;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            List<Integer> matrixRow = new ArrayList<>();
            int temp = k;
            while (temp <= n)
            {
                matrixRow.add(temp);
                temp++;
            }
            for (int j = 1; j < k; j++)
                matrixRow.add(j);
            k--;
            matrix.add(matrixRow);
        }
        return matrix;
    }
}