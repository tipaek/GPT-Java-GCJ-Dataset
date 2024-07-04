import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args)
            throws IOException {
        Scanner scanFile = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanFile.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanFile.nextInt();
            int k = scanFile.nextInt();
            int[][] x = new int[n][n];
            String ans = "";
            int s = -1;
            if(k > n*n){
                ans = "IMPOSSIBLE";
            } else if(k < n){
                ans = "IMPOSSIBLE";
            } else{
                for(int i = 1; i <= n; i++){
                    if(n*i == k){
                        ans = "POSSIBLE";
                        s = i;
                        break;
                    } else{
                        ans = "IMPOSSIBLE";
                    }
                }
                int sum = ((n)*(n+1))/2;
                if(sum == k && ans.equals("IMPOSSIBLE")){
                    ans = "POSSIBLE";
                    s = (n/2)+1;
                }
                if(ans.equals("POSSIBLE")){
                    for(int i = 0; i < n; i++){
                        x[i][i] = s;
                        if(i != n-1) {
                            for (int j = i + 1; j < n; j++) {
                                if ((x[i][j - 1] + 1) % n == 0) {
                                    x[i][j] = n;
                                } else {
                                    x[i][j] = (x[i][j - 1] + 1) % n;
                                }
                            }
                        }
                        if(i != 0) {
                            for (int j = i - 1; j >= 0; j--) {
                                if ((x[i][j + 1] - 1) % n == 0) {
                                    x[i][j] = n;
                                } else {
                                    x[i][j] = (x[i][j + 1] - 1) % n;
                                }
                            }
                        }
                    }
                }
            }
            if(ans.equals("IMPOSSIBLE")){
                System.out.println("Case #" + (q + 1) + ":  " + "IMPOSSIBLE");
            } else if(ans.equals("POSSIBLE")){
                System.out.println("Case #" + (q + 1) + ":  " + "POSSIBLE");
                print2D(x);
            }
        }
    }
    public static void print2D(int mat[][]) {
        for (int[] row : mat){
            for(int i = 0; i < row.length; i++){
                System.out.print(row[i]+ " ");
            }
            System.out.println();
        }

    }
}
/* Problem #3
 Scanner scanFile = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanFile.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanFile.nextInt();
            int[][] x = new int[n][4];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    x[i][j] = scanFile.nextInt();
                }
                x[i][2] = i;
            }
            sorter(x);
            String ans = "C";
            int c = 0;
            x[0][3] = 0;
            int j = -1;
            for (int i = 1; i < n; i++) {
                if (x[i][0] >= x[i - 1][1]) {
                    String curr = ans.charAt(i - 1) + "";
                    ans += curr;
                    if (curr.equals("C")) {
                        c = i;
                        x[i][3] = 0;
                    } else if (curr.equals("J")) {
                        j = i;
                        x[i][3] = 1;
                    }
                } else {
                    if (j == -1) {
                        ans += "J";
                        x[i][3] = 1;
                        j = i;
                    } else {
                        if (x[i][0] >= x[j][1]) {
                            ans += "J";
                            x[i][3] = 1;
                            j = i;
                        } else if (x[i][0] >= x[c][1]) {
                            ans += "C";
                            x[i][3] = 0;
                            c = i;
                        } else {
                            ans = "IMPOSSIBLE";
                            break;
                        }
                    }
                }
            }
            sorter2(x);
            if (ans.equals("IMPOSSIBLE")) {
                System.out.println("Case #" + (q + 1) + ":  " + "IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (q + 1) + ":  ");
                for (int i = 0; i < n; i++) {
                    if (x[i][3] == 0) {
                        System.out.print("C");
                    } else {
                        System.out.print("J");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void sorter(int arr[][]) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(final int[] entry1,
                               final int[] entry2) {

                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static void sorter2(int arr[][]) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(final int[] entry1,
                               final int[] entry2) {

                if (entry1[2] > entry2[2])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
 */
/*
Problem #2
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

 */
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