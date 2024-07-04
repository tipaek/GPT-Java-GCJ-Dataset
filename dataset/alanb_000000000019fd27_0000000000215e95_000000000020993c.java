import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

class Vest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            int n = scan.nextInt();
            int trace = 0;
            int rows = 0;
            int cols = 0;
            HashSet<Integer> set = new HashSet<>(n);
            int[][] arr = new int[n][n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    arr[j][k] = scan.nextInt();
                    set.add(arr[j][k]);
                    if(j==k)
                        trace+=arr[j][k];
                }
                if(set.size()<n)
                    rows++;
                set.clear();
            }
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    set.add(arr[k][j]);
                }
                if(set.size()<n)
                    cols++;
                set.clear();
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + rows + " " + cols);
        }
        scan.close();
    }
}