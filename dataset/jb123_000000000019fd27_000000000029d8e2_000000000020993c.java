package org.codejam;

import java.io.StringWriter;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args){
        new Solution().Run();
    }
    public void Run(){
        ProblemUtil<TestCaseMatrix> p = new ProblemUtil<>(new TestCaseMatrix.TestCaseMatrixFactory());
        p.ReadInput();
        for(TestCaseMatrix t : p.testCaseList){
            process(t);
        }
    }

    private void process(TestCaseMatrix t) {
        try {
            Matrix m = new Matrix(t.matrixSize, t.matrixSize, t.testCase);
            System.out.print("Case #" + t.testCaseNum + ": " + m.computeTrace() + " ");
            int dupRows = 0, dupCols = 0;
            for (int iLoc = 0; iLoc < m.cols; iLoc++) {
                if (Arrays.stream((m.m[iLoc])).distinct().count() != m.m.length) {
                    dupRows++;
                }
                int finalILoc = iLoc;
                if (IntStream.range(0, m.m.length).map(i1 -> m.m[i1][finalILoc]).distinct().count() != m.m.length) {
                    dupCols++;
                }
            }
            System.out.print(dupRows + " ");
            System.out.print(dupCols);
            System.out.println("");
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        //System.out.println(m.toString());
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
    public TestCase(int testCaseNum){
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
    public TestCaseMatrix(int testCaseNum){
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
        matrixSize  = Integer.parseInt(in.nextLine());
        for(int i=0; i<matrixSize; i++){
            testCase.add(in.nextLine());
        }
    }
}
class Matrix {
    public int[][] m;
    public int rows;
    public int cols;
    public Matrix(int rows, int cols, List<String> values){
        m  = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
        int lrow = 0, lcol=0;
        for(String stringRow : values){
            String[] strArray = stringRow.split("\\s+");
            for(String val: strArray) {
                m[lrow][lcol++] = Integer.parseInt(val);
            }
            lcol = 0;
            lrow++;
        }
    }
    public int computeTrace(){
        if(rows != cols){
            throw new IllegalArgumentException("rows != cols");
        }
        int trace = 0;
        for(int i=0; i<rows; i++){
            trace += m[i][i];
        }
        return trace;
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        sw.write("\n");
        for(int i=0; i<rows; i++){
            Arrays.stream(m[i]).forEach(e -> sw.write(e + " "));
            sw.write("\n");
        }
        return "[" + sw.toString() + "]";
    }
}