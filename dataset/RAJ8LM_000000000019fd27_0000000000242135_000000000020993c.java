public class Solution implements Callable<String> {

    int testCasenum;
    Integer[][] intArr;

    public Solution(Integer testCasenum, Integer[][] intArr){
        this.testCasenum = testCasenum;
        this.intArr = intArr;
    }

    @Override
    public String call() {

        int trace = 0;
        //  Finding duplicates in rows
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

        //  Finding duplicated in columns
        int duplicateColCount = 0;

        for(int i = 0; i < intArr[0].length; i++){
            duplicateFound = false;
            HashSet<Integer> colSet = new HashSet<>();
            for(int j = 0; j < intArr.length; j++){
                // System.out.println("for Test Case: "+testCasenum+" Col Traversal: "+intArr[j][i]);
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

        return "Case #" + testCasenum + ": " + trace + " " + duplicateRowCount + " " + duplicateColCount;
    }

    public static void main(String[] args) {

        captureInputAndSolveTestCase();
    }

    // This method is created to capture input where the first line of the input
    // is the number
    // of test cases, and all the following lines are test cases.
    public static void captureInputAndSolveTestCase() {
        Scanner scn = new Scanner(System.in);
        boolean DEBUG = false;
        try {
            int countOfTestCases = scn.nextInt();
            ExecutorService testthreadPool = Executors.newFixedThreadPool(DEBUG ? 1 : Runtime.getRuntime().availableProcessors());
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
            System.out.println("All added");

            List<Future<String>> results = testthreadPool.invokeAll(tests);
            for (Future<String> f : results) {
                System.out.println(f.get());
            }
            testthreadPool.shutdown();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
