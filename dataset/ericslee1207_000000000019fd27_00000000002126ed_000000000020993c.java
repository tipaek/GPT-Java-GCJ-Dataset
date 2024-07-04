import java.util.HashSet;
import java.util.Scanner;

class square {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int di=scanner.nextInt();
            int[][] grid=new int[di][di];
            int diagonal=0;
            int numrow=0;
            int numcolumn=0;
            for (int j = 0; j < di; j++) {
                HashSet<Integer> visited=new HashSet<>();
                int duplicaterow=0;
                for (int k = 0; k < di; k++) {
                    int num=scanner.nextInt();
                    if (j==k){
                        diagonal+=num;
                    }
                    if (visited.contains(num)){
                        duplicaterow=1;
                    }
                    else{
                        visited.add(num);
                    }
                    grid[j][k]=num;
                }
                if (duplicaterow==1){
                    numrow++;
                }
            }
            for (int j = 0; j < di; j++) {
                HashSet<Integer> visited=new HashSet<>();
                int duplicatecolumn=0;
                for (int k = 0; k < di; k++) {
                    if (visited.contains(grid[k][j])){
                        duplicatecolumn=1;
                    }
                    else{
                        visited.add(grid[k][j]);
                    }
                }
                if (duplicatecolumn==1){
                    numcolumn++;
                }
            }
            int testcase=i+1;
            System.out.println("Case #"+testcase+": "+diagonal+" "+numrow+" "+numcolumn);

        }
    }
}
