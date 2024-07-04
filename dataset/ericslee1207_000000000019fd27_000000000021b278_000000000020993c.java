import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int di=scanner.nextInt();
            int [][] grid=new int[di][di];
            int diagonal=0;
            int numrow=0;
            int numcolumn=0;
            for (int j = 0; j < di; j++) {
                for (int k = 0; k < di; k++) {
                    int num = scanner.nextInt();
                    if (k == j) {
                        diagonal += num;
                    }
                    grid[j][k] = num;
                }
            }
            for (int j = 0; j < di; j++) {
                boolean horizontal=false;
                boolean vertical=false;
                HashSet<Integer> row=new HashSet<>();
                HashSet<Integer> col=new HashSet<>();
                for (int k = 0; k < di; k++) {
                    if (horizontal==true && vertical==true){
                        break;
                    }
                    if (horizontal==false){
                        if (row.contains(grid[j][k])){
                            horizontal=true;
                        }
                        else{
                            row.add(grid[j][k]);
                        }
                    }
                    if (vertical==false){
                        if(col.contains(grid[k][j])){
                            vertical=true;
                        }
                        else{
                            col.add(grid[k][j]);
                        }
                    }
                }
                if (horizontal==true){
                    numrow++;
                }
                if (vertical==true){
                    numcolumn++;
                }

            }

            int testcase=i+1;
            System.out.println("Case #"+testcase+": "+diagonal+" "+numrow+" "+numcolumn);

        }
    }
}
