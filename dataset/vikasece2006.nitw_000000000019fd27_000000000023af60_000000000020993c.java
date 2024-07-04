import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t=0;t < test;t++){
            int size = Integer.parseInt(br.readLine());

            int[][] matrix = new int[size][size];
            int trace = 0;
            int numRow = 0;
            int numCol = 0;
            
            for(int index=0;index < size;index++){
                matrix[index]=  getArray(br.readLine());
                trace+=matrix[index][index];
                int[] array = new int[size+1];
                for(int num : matrix[index]){
                    if(array[num]==1){
                        numRow++;
                        break;
                    }else{
                        array[num]++;
                    }
                }
            }
            for(int colIndex=0;colIndex < size;colIndex++){
                int[] array = new int[size+1];
                for(int row=0;row <size;row++){
                    if(array[matrix[row][colIndex]]==1){
                        numCol++;
                        break;
                    }else{
                        
                        array[matrix[row][colIndex]]++;
                    }
                }
            }
            System.out.println(trace+" "+numRow+" "+numCol);
        }
    }

    private static int[] getArray(String line) {
        String[] s = line.split(" ");
        int[] array = new int[s.length];
        int index = 0;
        for(String temp :s){
            array[index++] = Integer.parseInt(temp);
        }
        return array;
    }
}
