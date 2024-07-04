import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Solution implements Callable<String> {

    int testCaseNo;
    Integer[][] intArr;

    public Solution(Integer testCaseNo, Integer[][] intArr){
        this.testCaseNo = testCaseNo;
        this.intArr = intArr;
    }

    public static void main(String[] args) {
        findSolution();
    }

    @Override
    public String call() {
        int trace = 0;
        int duplicateRowCount = 0;
        boolean duplicateFound;
        for(int i = 0; i < intArr.length; i++){
            duplicateFound = false;
            HashSet<Integer> rowset = new HashSet<>();
            for(int j = 0; j < intArr[i].length; j++){
                if(i == j)
                    trace += intArr[i][j];
                if(!duplicateFound) {
                    if (rowset.contains(intArr[i][j])) {
                        duplicateRowCount++;
                        duplicateFound = true;

                    } else {
                        rowset.add(intArr[i][j]);
                    }
                }
            }
        }

        int duplicateColCount = 0;

        for(int i = 0; i < intArr[0].length; i++){
            duplicateFound = false;
            HashSet<Integer> colSet = new HashSet<>();
            for(int j = 0; j < intArr.length; j++){

                if(!duplicateFound) {
                    if (colSet.contains(intArr[j][i])) {
                        duplicateColCount++;
                        duplicateFound = true;

                    } else {
                        colSet.add(intArr[j][i]);
                    }
                }
            }
        }

        return "Case #" + testCaseNo + ": " + trace + " " + duplicateRowCount + " " + duplicateColCount;
    }

    public static void findSolution() {
        Scanner scn = new Scanner(System.in);
        boolean DEBUG = false;
        try {
            int countOfTestCases = scn.nextInt();
            ExecutorService mythreadPool = Executors.newFixedThreadPool(DEBUG ? 1 : Runtime.getRuntime().availableProcessors());
            List<Solution> tests = new ArrayList<>();

            for (int i = 1; i <= countOfTestCases; i++) {
                int sizeOfArr = scn.nextInt();

                Integer[][] arr = new Integer[sizeOfArr][sizeOfArr];
                for (int row = 0; row < sizeOfArr; row++) {
                    for (int col = 0; col < sizeOfArr; col++) {
                        arr[row][col] = scn.nextInt();
                    }
                }

                tests.add(new Solution(i, arr));
            }


            List<Future<String>> results = mythreadPool.invokeAll(tests);
            for (Future<String> f : results) {
                System.out.println(f.get());
            }
            mythreadPool.shutdown();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}



