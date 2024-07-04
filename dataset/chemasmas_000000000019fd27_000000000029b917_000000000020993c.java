import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static Scanner keyboard = new Scanner(System.in);



    public static void main(String[] args) {


        int t, i = 1;
        t = keyboard.nextInt();
        keyboard.nextLine();
        while (t-->0){
            System.out.print("Case #");
            System.out.print(i);
            System.out.print(": ");
            solve();
            i++;
        }
    }

    private static void solve() {
        int[][] a = new int[101][101];
        int[][] t = new int[101][101];
        int n = keyboard.nextInt();
        keyboard.nextLine();

        int k=0 , r=0 , c = 0;

        for(int i = 0;i<n;i++){

            int[] line = Arrays.stream(keyboard.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0;j<n;j++){
                a[i][j] = line[j];  //Filas
                t[j][i] = line[j]; //Columnas
                if(i == j ){
                    k += line[i];
                }
            }
        }


        for(int i = 0;i<n;i++){
            long res = Arrays.stream(a[i]).filter(z -> z!=0).distinct().count() - Arrays.stream(a[i]).filter(z -> z!=0).count();
            if (res != 0) r++;
            long res2 = Arrays.stream(t[i]).filter(z -> z!=0).distinct().count() - Arrays.stream(t[i]).filter(z -> z!=0).count();
            if (res2 != 0) c++;
        }

        System.out.println(k + " " + r + " " + c );
    }
}
