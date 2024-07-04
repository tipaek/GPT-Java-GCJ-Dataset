import java.io.StringWriter;
import java.util.*;
import java.util.stream.IntStream;

public class Solution
{
    public static void main(String[] args) {
        new Solution().Run();
    }

    public void Run() {
        try {
            ProblemUtil<TestCase> p = new ProblemUtil<>(new TestCase.TestCaseFactory());
            p.ReadInput();
            for (TestCase t : p.testCaseList) {
                process(t);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private void process(TestCase t) {
        Stack<String> nesting = new Stack<>();
        List<Integer> digitsList = new ArrayList<>();
        char[] charArray = t.testCaseString.toCharArray();
        IntStream.range(0, charArray.length).forEach(i -> {
            digitsList.add(Integer.parseInt(charArray[i] + ""));
        });

        //System.out.println(digitsList);
        for(Integer digit : digitsList){
            IntStream.range(0, digit).forEach(i -> nesting.push("("));
            nesting.push(digit + "");
            IntStream.range(0, digit).forEach(i -> nesting.push(")"));
        }
        System.out.print("Case #" + t.testCaseNum + ": ");
        String result = String.join("", nesting.toArray(new String[]{}));
        System.out.println(result.replaceAll("\\)\\(", ""));
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
