import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    static List<int[][]> natualLatinSquares = new ArrayList<>();
    public static void main(String[] args){

        Scanner stdScanner = new Scanner(System.in);
        String stream = "";
        int testCases = Integer.parseInt(stdScanner.nextLine().trim());
        int id = 0;
        int[][] first = {{1}};
        natualLatinSquares.add(first);


        while(id < testCases){

            stream = stdScanner.nextLine().trim();
            //System.out.println(stream);
            String[] line = stream.split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int[][] current = getnls(n);
            int[] pos = new int[current.length];
            for(int i = 0 ; i < current.length ; i++){
                pos[i] = -1;
            }

            if(isTracePossible(current, k, 0, new boolean[current.length], 1, pos)) {
                System.out.println("Case #" + (id +1) + ": POSSIBLE");
                int[][] reordered = new int[current.length][];
                for (int i = 0; i < current.length; i++) {
                    reordered[pos[i]] = current[i];
                    //System.out.print(pos[i] + " ");
                }
                printmatrix(reordered);
            }
            else{
                System.out.println("Case #" + (id +1) + ": IMPOSSIBLE");
            }
            id++;
        }
        stdScanner.close();
    }
    static boolean isTracePossible(int[][] matrix, int k, int rowindex, boolean[] columnvisited, int prevSelected, int[] pos){

        int remselect = matrix.length - rowindex;
        if(remselect == 0){
            if(k == 0) {
                return true;
            }
            else{
                return false;
            }
        }
        for(int j = 0 ; j < matrix.length ; j++){

            int digit = matrix[rowindex][j];
            if(!columnvisited[j] && digit >= prevSelected && digit <= k/remselect){

                columnvisited[j] = true;
                pos[rowindex] = j;
                boolean res = isTracePossible(matrix, k-digit,rowindex+1, columnvisited, digit, pos);
                if(res)
                    return true;
                columnvisited[j] = false;
                pos[rowindex] = -1;
            }
        }
        return false;
    }

    static void printmatrix(int[][] matrix){

        for(int i = 0 ;i < matrix.length ; i++){

            String line = "";
            for(int j = 0;j< matrix.length ; j++) {
                line += matrix[i][j] + " ";
            }
            System.out.println(line.trim());
        }
    }

    static int[][] getnls(int n){

        if(natualLatinSquares.size() < n) {

            int[][] prev = getnls(n - 1);
            int[][] curr = computecurrent(prev);
            natualLatinSquares.add(curr);
        }
        return natualLatinSquares.get(n-1);
    }

    private static int[][] computecurrent(int[][] prev) {

        int[][] current = new int[prev.length+1][prev.length+1];
        int rowsum = current.length*(current.length+1)/2;
        boolean[] isvisited = new boolean[current.length];
        boolean[] addedtocolumn = new boolean[current.length];
        for(int j = 0 ;j < current.length-1 ; j++){

            current[0][j] = prev[0][j];
        }
        current[0][current.length-1] = current.length;

        for(int i = 1 ;i < current.length-1 ; i++){

            int toadd = -1;
            boolean fixed = false;
            for(int j = current.length-2 ; j >= 0 ; j--){

                int digit = prev[i][j];
                //System.out.println(digit + " " + prev.length);
                if(!fixed && !isvisited[digit-1] && !addedtocolumn[j]){

                    toadd = digit;
                    isvisited[digit-1] = true;
                    addedtocolumn[j] = true;
                    fixed = true;
                    current[i][j] = current.length;
                }
                else{
                    current[i][j] = prev[i][j];
                }
            }
            current[i][current.length -1] = toadd;
        }
        for(int j = 0; j < current.length ; j++){

            int sum = 0;
            for(int i = 0 ; i< current.length -1 ; i++){

                sum += current[i][j];
            }
            current[current.length-1][j] = rowsum - sum;
        }
        return current;
    }
}
