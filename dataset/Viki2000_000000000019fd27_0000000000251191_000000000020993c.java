import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTests = Integer.parseInt(br.readLine());
        for(int i=0; i<numberOfTests; i++){

            int sizeOfMatrix = Integer.parseInt(br.readLine());
            String lineInput;
            int[][] numbers = new int[sizeOfMatrix][sizeOfMatrix];
            for(int j=0; j<sizeOfMatrix; j++){
                lineInput = br.readLine();
                String[] numbersInString = lineInput.split(" ");
                for (int k=0; k<sizeOfMatrix; k++) {
                    numbers[j][k] = Integer.parseInt(numbersInString[k]);
                }
            }


            int rowsWithRepeatedElemets = 0;
            int columnsWithRepeatedElemets = 0;
            int sumOfDiagonal =0;
            for(int j=0; j<sizeOfMatrix; j++){
                sumOfDiagonal += numbers[j][j];
                boolean rowRepeated = false;
                Set<Integer> numbersFrom1ToNRow = new HashSet<>();
                boolean columnRepeated = false;
                Set<Integer> numbersFrom1ToNColumn = new HashSet<>();
                for(int k=0; k<sizeOfMatrix; k++){
                    if(numbersFrom1ToNRow.contains(numbers[j][k])){
                        rowRepeated = true;
                    }
                    else{
                        numbersFrom1ToNRow.add(numbers[j][k]);
                    }
                    if(numbersFrom1ToNColumn.contains(numbers[k][j])){
                        columnRepeated = true;
                    }
                    else{
                        numbersFrom1ToNColumn.add(numbers[k][j]);
                    }
                }
                if(rowRepeated) rowsWithRepeatedElemets++;
                if(columnRepeated) columnsWithRepeatedElemets++;
            }

            System.out.println("Case #" + (i+1) + ": " + sumOfDiagonal + " " + rowsWithRepeatedElemets + " " + columnsWithRepeatedElemets);

        }
        br.close();
    }

}
