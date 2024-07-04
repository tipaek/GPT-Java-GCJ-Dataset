import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int caseNumber = 0; caseNumber<cases; caseNumber++){
            String input[] = bufferedReader.readLine().trim().split(" ");
            int size = Integer.parseInt(input[0]);
            int sum = Integer.parseInt(input[1]);
            if(sum % size == 0){
                System.out.println("Case #" + (caseNumber+1) + ": POSSIBLE");
                printMatrix(size, sum/size);
            }else{
                System.out.println("Case #" + (caseNumber+1) + ": IMPOSSIBLE");
            }
        }
        bufferedReader.close();
    }

    private static void printMatrix(int size, int start) {

        for (int i = 0; i < size; i++) {
            for (int j = 0, size1 = size - 1; j < size1; j++) {
                if(start == size + 1){
                    start = 1;
                }
                System.out.print(start+" ");
                start++;
            }
            if(start == size + 1){
                start = 1;
            }
            System.out.println(start+" ");
        }
    }


}
