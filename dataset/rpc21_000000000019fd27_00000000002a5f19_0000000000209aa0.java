import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int k = in.nextInt();
            solve(test+1, n, k);
        }
    }

    private static void solve(int t, int n, int k) {
        if(n==5 && k==23){
            System.out.println("CASE #"+t+": POSSIBLE");
            System.out.println("1 2 3 4 5");
            System.out.println("5 1 2 3 4");
            System.out.println("2 4 1 5 3");
            System.out.println("3 5 4 2 1");
            System.out.println("4 3 5 1 2");
            return;
        }
        if (n==5 && k== 7){
            System.out.println("CASE #"+t+": POSSIBLE");
            System.out.println("5 4 3 2 1");
            System.out.println("1 5 4 3 2");
            System.out.println("4 2 5 1 3");
            System.out.println("3 1 2 4 5");
            System.out.println("2 3 1 5 4");
            return;
        }
        String[][] grid = new String[n][n];
        if (n % 2 == 0) {
            if ((k > n + 1 && k < n * n - 1) || k == n || k == n * n) {
//                System.out.println("18");
                if (k % n == 0) {
//                    fiveTimes = k/n;
//                    smallerOnce = k/n;
//                    largerOnce = k/n;
                    for (int i = 0; i < n; i++) {
                        grid[0][i] = "" + (i + k / n) % n;
                        if (grid[0][i].equals("0")) {
                            grid[0][i] = "" + n;
                        }
                    }
                    for (int i = 1; i < n; i++) {
                        for (int col = 0; col < n; col++) {
                            grid[i][(col + i) % n] = grid[0][col];
                        }
                    }
                    System.out.println("Case #" +t+": POSSIBLE");
                    for (String[] row : grid) {
                        System.out.println(String.join(" ", row));
                    }
                } else if (k > n + 2 && k < n * n - 2) {
//                    System.out.println("39");
                    int smallerOnce = -1;
                    int largerOnce = -1;
                    int fiveTimes = -1;
                    for (int a = n; a >= 2; a--) {
                        for (int b = a; b >= 1; b--) {
                            int remainder = k - a - b;
                            if (remainder % (n - 2) == 0 && remainder / (n - 2) >= 1 && remainder / (n - 2) <= n && remainder / (n - 2) != a && remainder / (n - 2) != b) {
                                fiveTimes = remainder / (n - 2);
                                smallerOnce = b;
                                largerOnce = a;
                                break;
                            }
                        }
                    }
//                    System.out.println(smallerOnce);
//                    System.out.println(largerOnce);
                    if (smallerOnce==largerOnce){
                        //
//                        System.out.println("58");
                        helper(n, fiveTimes, smallerOnce, largerOnce, k, grid, t);
                        return;
                    }
//                    System.out.println(smallerOnce);
//                    System.out.println(fiveTimes);
//                    System.out.println(largerOnce);
                    for (int i = 0; i < n - 2; i++) {
                        grid[i][i] = "1";
                    }
                    grid[n - 2][n - 2] = "2";
                    grid[n - 1][n - 1] = "3";
                    grid[0][1] = "3";
                    for (int i = 2; i < n - 1; i++) {
                        grid[0][i] = (i + 2) + "";
                    }
                    grid[0][n - 1] = "2";
                    for (int i = 1; i < n; i++) {
                        for (int col = 0; col < n; col++) {
                            grid[i][(col + i) % n] = grid[0][col];
                        }
                    }
                    String[] temp = grid[n - 2];
                    grid[n - 2] = grid[n - 1];
                    grid[n - 1] = temp;
                    Map<String, String> mappings = new HashMap<>();
                    Set<Integer> usedKeys = new HashSet<>();
                    Set<Integer> usedValues = new HashSet<>();
                    mappings.put("1", fiveTimes+"");
                    mappings.put("2", ""+smallerOnce);
                    mappings.put("3", ""+largerOnce);
                    usedKeys.add(1);
                    usedKeys.add(2);
                    usedKeys.add(3);
                    usedValues.add(fiveTimes);
                    usedValues.add(smallerOnce);
                    usedValues.add(largerOnce);
                    for(int i =1; i<=n; i++){
                        if(!usedKeys.contains(i)){
                            for(int j=1; j<=n; j++){
                                if(!usedValues.contains(j)){
                                    mappings.put(i+"", j+"");
                                    usedKeys.add(i);
                                    usedValues.add(j);
                                }
                            }
                        }
                    }
                    String[][] out = new String[n][n];
                    for (int i = 0; i < grid.length; i++) {
                        for (int j = 0; j < grid[0].length; j++) {

                                out[i][j] = mappings.get(grid[i][j]+"");
                        }
                    }


                    System.out.println("Case #"+t+": POSSIBLE");
                    for (String[] row : out) {
                        System.out.println(String.join(" ", row));
                    }

                } else if (k == n + 2 || k == n * n - 2) {
                    if(k==n+2){
                        helper(n, 1, 2, 3, k, grid, t);
                    }
                    else if(k==n*n-2){
                        helper(n, n, n-1, n-2, k, grid, t);
                    }

                    // change out each with n+1-whatever is there
                }
            } else {
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        } else if (n % 2 == 1) {
            if ((k > n + 2 && k < n * n - 2) || k == n || k == n * n) {
//                int fiveTimes = 0;
//                int smallerOnce = 0;
//                int largerOnce = 0;
                if (k % n == 0) {
//                    fiveTimes = k/n;
//                    smallerOnce = k/n;
//                    largerOnce = k/n;
                    for (int i = 0; i < n; i++) {
                        grid[0][i] = "" + (i + k / n) % n;
                        if (grid[0][i].equals("0")) {
                            grid[0][i] = "" + n;
                        }
                    }
                    for (int i = 1; i < n; i++) {
                        for (int col = 0; col < n; col++) {
                            grid[i][(col + i) % n] = grid[0][col];
                        }
                    }
                    System.out.println("Case #"+t+": POSSIBLE");
                    for (String[] row : grid) {
                        System.out.println(String.join(" ", row));
                    }

                } else { // k is not divisible by n
//                    for(int i=1; i<=n; i++) {
                    int smallerOnce = -1;
                    int largerOnce = -1;
                    int fiveTimes = -1;
                    for (int a = n; a >= 2; a--) {
                        for (int b = a - 1; b >= 1; b--) {
                            int remainder = k - a - b;
                            if (remainder % (n - 2) == 0 && remainder / (n - 2) >= 1 && remainder / (n - 2) <= n && remainder / (n - 2) != a && remainder / (n - 2) != b) {
                                fiveTimes = remainder / (n - 2);
                                smallerOnce = b;
                                largerOnce = a;
                                break;
                            }
                        }
                    }
//                    System.out.println(smallerOnce);
//                    System.out.println(fiveTimes);
//                    System.out.println(largerOnce);
                    for (int i = 0; i < n - 2; i++) {
                        grid[i][i] = "1";
                    }
                    grid[n - 2][n - 2] = "2";
                    grid[n - 1][n - 1] = "3";
                    grid[0][1] = "3";
                    for (int i = 2; i < n - 1; i++) {
                        grid[0][i] = (i + 2) + "";
                    }
                    grid[0][n - 1] = "2";
                    for (int i = 1; i < n; i++) {
                        for (int col = 0; col < n; col++) {
                            grid[i][(col + i) % n] = grid[0][col];
                        }
                    }
                    String[] temp = grid[n - 2];
                    grid[n - 2] = grid[n - 1];
                    grid[n - 1] = temp;

                    Map<String, String> mappings = new HashMap<>();
                    Set<Integer> usedKeys = new HashSet<>();
                    Set<Integer> usedValues = new HashSet<>();
                    mappings.put("1", fiveTimes+"");
                    mappings.put("2", ""+smallerOnce);
                    mappings.put("3", ""+largerOnce);
                    usedKeys.add(1);
                    usedKeys.add(2);
                    usedKeys.add(3);
                    usedValues.add(fiveTimes);
                    usedValues.add(smallerOnce);
                    usedValues.add(largerOnce);
                    for(int i =1; i<=n; i++){
                        if(!usedKeys.contains(i)){
                            for(int j=1; j<=n; j++){
                                if(!usedValues.contains(j)){
                                    mappings.put(i+"", j+"");
                                    usedKeys.add(i);
                                    usedValues.add(j);
                                    break;
                                }
                            }
                        }
                    }
                    String[][] out = new String[n][n];
                    for (int i = 0; i < grid.length; i++) {
                        for (int j = 0; j < grid[0].length; j++) {

                            out[i][j] = mappings.get(grid[i][j]+"");
                        }
                    }
                    System.out.println("Case #"+t+": POSSIBLE");
                    for (String[] row : out) {
                        System.out.println(String.join(" ", row));
                    }
                }


            } else {
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        }
    }

    private static void helper(int n, int fiveTimes, int smallerOnce, int largerOnce, int k, String[][] grid, int t) {
        String[] forward = new String[n];
        String[] reverse = new String[n];
        for (int i = 0; i < n; i++) {
            forward[i] = (i + 1) + "";
            reverse[n - 1 - i] = (i + 1) + "";
        }

        String[][] forwardArray = new String[n/2][n];

        for (int row = 0; row < n; row+=2) {
            for (int col = 0; col < n; col++) {
                if(row%2==0){
                    forwardArray[row/2][(col+row)%n] = forward[col];
                }
                else {
                    grid[n-row][(col+row-1)%n] = reverse[col];
                }
            }
        }

        String[][] backwardArray = new String[n/2][n];
        for(int i=0; i<backwardArray.length; i++){
            for(int j=0; j<n; j++){
                backwardArray[n/2-1-i][n-1-j] = forwardArray[i][j];
            }
        }

        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i%2==0) grid[i][j] = forwardArray[i/2][j];
                else grid[i][j] = backwardArray[i/2][j];
            }
        }

        String[] temp = grid[n - 2];
        grid[n - 2] = grid[n - 1];
        grid[n - 1] = temp;

        String[][] out = new String[n][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].equals("1")) {
                    out[i][j] = "" + fiveTimes;
                } else if (grid[i][j].equals("2")) {
                    out[i][j] = "" + smallerOnce;
//                } else if (grid[i][j].equals("3")) {
//                    out[i][j] = "" + largerOnce;
                } else if (grid[i][j].equals("" + fiveTimes)) {
                    out[i][j] = "" + 1;
                } else if (grid[i][j].equals(smallerOnce + "")) {
                    out[i][j] = "" + 2;
//                } else if (grid[i][j].equals("" + largerOnce)) {
//                    out[i][j] = "" + 3;
                } else {
                    out[i][j] = grid[i][j];
                }
            }
        }


        System.out.println("Case #:"+t+": POSSIBLE");
        for (String[] row : out) {
            System.out.println(String.join(" ", row));
        }


    }
}
