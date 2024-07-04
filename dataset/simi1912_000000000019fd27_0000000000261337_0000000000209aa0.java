import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

	static Scanner scanner;
	static List<TestCase> testCases = new ArrayList<>();
	
	public static void main(String[] args) {

		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int numCases = scanner.nextInt();
		
		TestCase testCase;
		int n;
		int k;
		for(int i=0; i<numCases; i++) {
			
			n = scanner.nextInt();
			k = scanner.nextInt();
			
			testCase = new TestCase(n, k);
			testCases.add(testCase);
		}
		scanner.close();
		
		int nrCase = 0;
		for(TestCase testCase2: testCases) {
			nrCase++;
			
			testCase2.writeSolution(nrCase);
		}
	}
}

class TestCase {
	
	private int n;
	private int k;
	
	public TestCase(int n, int k) {
		this.n = n;
		this.k = k;
	}
		
	public int getN() {return n;}
	
	public int getK() {return k;}
	
	public void writeSolution(int nrCase) {
		
		System.out.println("Case #"+nrCase+": IMPOSIBLE");
	}
}
