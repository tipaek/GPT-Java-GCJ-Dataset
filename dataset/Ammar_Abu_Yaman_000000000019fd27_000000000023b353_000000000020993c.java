
import java.util.HashSet;
import java.util.Scanner;

public class Vestigium{


    static Scanner scanner = new Scanner(System.in);
    static int n, t;
    static int[][] matrix = new int[101][101];


    public static void main(String[] args) {
        
        int trace;
     


        t = scanner.nextInt();

        for(int v = 1; v <= t; ++v){


            n = scanner.nextInt();
            trace = 0;

            for(int i = 1; i <= n; ++i)
                for(int j = 1; j <= n; ++j){


                    matrix[i][j] = scanner.nextInt();
                    if(i == j)
                        trace += matrix[i][j];

                }


                int r = checkRows();
                int c = checkColumns();


                System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);


        }


    }


    static int checkRows(){

        int r = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; ++i){

            set.clear();

            for(int j = 1; j <= n; ++j)
                set.add(matrix[i][j]);

            r = set.size() != n ? r + 1 : r;
                
        }

        return r;

    }


    static int checkColumns(){


        int c = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 1; i <= n; ++i){

            set.clear();
            for(int j = 1; j <= n; ++j)
                set.add(matrix[j][i]);

            c = set.size() != n ? c + 1 : c;

        }

        return c;

    }



}