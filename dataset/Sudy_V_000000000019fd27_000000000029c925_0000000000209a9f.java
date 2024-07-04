import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args)
            throws IOException {
        Scanner scanFile = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanFile.nextInt();
        scanFile.nextLine();
        for (int q = 0; q < t; q++) {
            String s = scanFile.nextLine();
            LinkedList<String> a = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                a.add(s.charAt(i) + "");
            }
            int open = 0;
            if (a.size() == 1) {
                open = Integer.parseInt(a.get(0));
                for (int i = 0; i < open; i++) {
                    a.add(0, "(");
                    a.add(")");
                }
            } else {
                for (int i = 0; i < a.size() - 1; i++) {
                   if (!(a.get(i).equals("(")) && !(a.get(i).equals(")")) && !(a.get(i + 1).equals("(")) && !(a.get(i + 1).equals(")"))) {
                        if (i == 0) {
                            open = Integer.parseInt(a.get(i));
                            if (Integer.parseInt(a.get(i + 1)) < Integer.parseInt(a.get(i))) {
                                int diff = open - Integer.parseInt(a.get(i + 1));
                                for (int k = 0; k < diff; k++) {
                                    a.add(i + 1, ")");
                                }
                                for (int k = 0; k < open; k++) {
                                    a.add(0, "(");
                                }
                                open -= diff;
                            } else if (Integer.parseInt(a.get(i + 1)) > Integer.parseInt(a.get(i))) {
                                int diff = Integer.parseInt(a.get(i + 1)) - open;
                                for (int k = 0; k < diff; k++) {
                                    a.add(i + 1, "(");
                                }
                                for (int k = 0; k < open; k++) {
                                    a.add(0, "(");
                                }
                                open += diff;
                            } else if (Integer.parseInt(a.get(i + 1)) == Integer.parseInt(a.get(i))) {
                                for (int k = 0; k < open; k++) {
                                    a.add(0, "(");
                                }
                            }
                        } else if (Integer.parseInt(a.get(i + 1)) < Integer.parseInt(a.get(i))) {
                            int diff = open - Integer.parseInt(a.get(i + 1));
                            for (int k = 0; k < diff; k++) {
                                a.add(i + 1, ")");
                            }
                            open -= diff;

                        } else if (Integer.parseInt(a.get(i + 1)) > Integer.parseInt(a.get(i))) {
                            int diff = Integer.parseInt(a.get(i + 1)) - open;
                            for (int k = 0; k < diff; k++) {
                                a.add(i + 1, "(");
                            }
                            open += diff;
                        }
                    }
                    if(i == a.size()-2){
                       if(open > 0) {
                           for (int k = 0; k < open; k++) {
                               a.add(")");
                           }
                       }
                       open =0;
                    }
                }
            }
            System.out.print("Case #" + (q + 1) + ":  ");
            for(int i =0 ; i < a.size(); i++){
                System.out.print(a.get(i));
            }
            System.out.println();
        }
    }
}
/* Problem #1
    Scanner scanFile = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanFile.nextInt();
        for(int q =0; q < t; q++){
            int n= scanFile.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            int[][] x = new int[n][n];
            for(int i =0; i< n; i++){
                HashSet<Integer> s = new HashSet<Integer>();
                for(int j = 0; j < n; j++) {
                    int curr = scanFile.nextInt();
                    x[i][(j)] = curr;
                    s.add(curr);
                    if (j == n-1) {
                        if (s.size() != n) {
                            r++;
                        }
                    }
                }
            }
            for(int i= 0; i < n; i++){
                HashSet<Integer> s = new HashSet<Integer>();
                for(int j = 0; j < n; j++) {
                    int curr = x[j][i];
                    s.add(curr);
                    if (j == n-1) {
                        if (s.size() != n) {
                            c++;
                        }
                    }
                }
            }
            for(int i =0 ; i < n; i++){
                int sum = x[i][i];
                k = k+ sum;
            }
            System.out.println("Case #" + (q + 1) + ":  " + k + " " + r + " " + c);
//
        }
 */