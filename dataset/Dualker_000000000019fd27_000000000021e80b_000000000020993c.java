import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Vestigium {
    static int[][]matrix;
    static int n;
    public static void main(String[]args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(f.readLine());
        int cont = 0;
        while(cases-->0){
            cont++;
            n = Integer.parseInt(f.readLine());
            matrix = new int[n][n];
            for(int i = 0 ; i < n ; ++i){
                String[]data = f.readLine().split(" ");
                for(int j = 0 ; j < n ; ++j){
                    matrix[i][j]=Integer.parseInt(data[j]);
                }
            }
            int[]data = latinSquare();
            System.out.println("Case #"+cont+": " + data[0] +" " + data[1] + " " + data[2]);
        }
    }
    public static int[] latinSquare(){
        int[]data = new int[3];
        for(int i = 0 ; i < n ; i ++){
            data[0]+=matrix[i][i];
            data[1]+=repeatedColumn(i) ? 1 : 0;
            data[2]+=repeatedRow(i) ? 1 : 0;
        }
        return data;
    }
    public static boolean repeatedRow(int p){
        boolean[]repeated = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            int k = matrix[i][p];
            if(repeated[k-1])
                return true;
            else
                repeated[k-1]=true;
        }
        return false;
    }
    public static boolean repeatedColumn(int p){
        boolean[]repeated = new boolean[n];
        for(int j = 0 ; j < n ; j++){
            int k = matrix[p][j];
            if(repeated[k-1])
                return true;
            else
                repeated[k-1]=true;
        }
        return false;
    }
}
