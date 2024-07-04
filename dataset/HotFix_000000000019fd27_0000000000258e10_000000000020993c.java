import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<String> ans = new ArrayList<String>();
        int testcase = 1;
        while (t != 0) {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int data = sc.nextInt();
                    mat[i][j] = data;
                }
            }
            String caseans = calculatedTraceCount(mat,n,testcase);
            ans.add(caseans);
            t--;
            testcase++;
        }
        for(String val : ans) {
            System.out.println(val);
        }
    }

    private static String calculatedTraceCount(int[][] mat, int n,int testcase){
        List<Integer> listrow = new ArrayList<Integer>();
        List<Integer> listcol = new ArrayList<Integer>();

        int sum = 0, rowcount = 0, colcount = 0;
        for (int i = 0; i < n; i++) {
            boolean checkrow = true;
            boolean checkcol = true;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    sum += mat[i][j];
                if ((checkrow) && (listrow.contains(mat[i][j]))) {
                    rowcount++;
                    checkrow = false;
                } else if (checkrow)
                    listrow.add(mat[i][j]);

                if ((checkcol) && (listcol.contains(mat[j][i]))) {
                    colcount++;
                    checkcol = false;
                } else if (checkcol)
                    listcol.add(mat[j][i]);
            }
            listcol.clear();
            listrow.clear();
        }
        return ("Case #"+testcase+": "+sum + " " + rowcount + " " + colcount);
    }
}
