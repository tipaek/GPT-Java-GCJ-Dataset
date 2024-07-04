import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.IntStream;

public class Solution
{
    public static void main(String[] args) {
        new Solution().Run();
    }

    public void Run() {
        try {
            ProblemUtil<TestCaseMatrix> p = new ProblemUtil<>(new TestCaseMatrix.TestCaseMatrixFactory());
            p.ReadInput();
            for (TestCaseMatrix t : p.testCaseList) {
                process(t);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private void process(TestCaseMatrix t) {
        List<Duration> durations = new ArrayList<>();
        for(int i=0; i<t.matrixSize; i++){
            String[] input  = t.testCase.get(i).split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            durations.add(new Duration(start, end));
        }
        durations.sort((d1, d2) -> ((Integer)d1.start).compareTo(d2.start));
        StringWriter result = new StringWriter();
        boolean c = true;
        Duration cPrev = null;
        Duration jPrev = null;
        for(Duration dCurr : durations){
            if (cPrev != null && cPrev.end > dCurr.start) {
                // c conflict
                if (jPrev != null && jPrev.end > dCurr.start) {
                    // both conflict
                }else {
                    result.append("J");
                    jPrev = dCurr;
                }
            }
            else {
                result.append("C");
                cPrev = dCurr;
            }
            //cPrev = dCurr;
        }
        System.out.println(durations);
        System.out.print("Case #" + t.testCaseNum + ": ");
        if(result.toString().length() != t.matrixSize) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(result);
        }
    }
}
class Duration{
    Duration(int start, int end){
        this.start = start;
        this.end = end;
    }
    int start;
    int end;

    @Override
    public String toString() {
        return "Duration{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
class ProblemUtil<T extends ITestCase> {
    public int numTestCases;
    public List<T> testCaseList = new ArrayList<T>();
    private Factory<T> fact;

    public ProblemUtil(Factory<T> fact) {
        this.fact = fact;
    }

    public void ReadInput() {
        Scanner in = new Scanner(System.in);
        //System.out.println("reading number of test cases");
        numTestCases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= numTestCases; i++) {
            T t = fact.factory(i);
            t.Read(in);
            testCaseList.add(t);
        }
    }
}

interface Factory<T extends ITestCase> {
    T factory(int testCaseNum);
}

interface ITestCase {
    public int getTestCaseNum();

    public void Read(Scanner in);
}

class TestCase implements ITestCase {
    public static class TestCaseFactory implements Factory<TestCase> {
        public TestCase factory(int testCaseNum) {
            return new TestCase(testCaseNum);
        }
    }

    public TestCase(int testCaseNum) {
        this.testCaseNum = testCaseNum;
    }

    public int testCaseNum;
    public String testCaseString;

    public int getTestCaseNum() {
        return testCaseNum;
    }

    @Override
    public void Read(Scanner in) {
        testCaseString = in.nextLine();
    }
}

class TestCaseMatrix implements ITestCase {
    public static class TestCaseMatrixFactory implements Factory<TestCaseMatrix> {
        public TestCaseMatrix factory(int testCaseNum) {
            return new TestCaseMatrix(testCaseNum);
        }
    }

    public TestCaseMatrix(int testCaseNum) {
        this.testCaseNum = testCaseNum;
    }

    public int testCaseNum;
    public List<String> testCase = new ArrayList<>();
    public int matrixSize;

    public int getTestCaseNum() {
        return testCaseNum;
    }

    @Override
    public void Read(Scanner in) {
        matrixSize = Integer.parseInt(in.nextLine());
        for (int i = 0; i < matrixSize; i++) {
            testCase.add(in.nextLine());
        }
    }
}
