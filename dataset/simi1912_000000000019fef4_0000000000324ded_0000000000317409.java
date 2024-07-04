import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static Scanner scanner;
	static List<TestCase> testCases = new ArrayList<>();
	
	public static void main(String[] args) {
		
		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int numCases = Integer.parseInt(scanner.next());
		
		TestCase testCase = null;
		for(int i=0; i<numCases; i++) {
		
			testCase = new TestCase(
					scanner.nextInt(), 
					scanner.nextInt(), 
					scanner.next()+"  "
					);
			
			testCases.add(testCase);
		}
		
		scanner.close();
		printOutput();
	}
	
	private static void printOutput() {
		int caseNr = 0;
		
		for(TestCase testCase: testCases) {
			
			caseNr++;
			System.out.println("Case #"+caseNr+": "+testCase.getSolution());
		}
	}
}

class TestCase{

	int X;
	int Y;
	List<String> moves = new ArrayList<>();
	
	public TestCase(int x, int y, String m) {
		X=x;
		Y=y;
		for(int i=0; i<m.length(); i++) {
			moves.add(m.charAt(i)+"");
		}
	}

	public String getSolution() {
		
		return new Resolver(this).computeAnswear();
	}
	

	public int getNextMoveX() {
		
		if(moves.get(0).equals("E")) {
			moves.remove(0);
			return ++X;
			}
		if(moves.get(0).equals("W")) {
			moves.remove(0);
			return --X;
			}
		return X;
	}

	public int getNextMoveY() {
		
		if(moves.get(0).equals("N")) {
			moves.remove(0);
			return ++Y;
			}
		if(moves.get(0).equals("S")) {
			moves.remove(0);
			return --Y;
			}
		return Y;
	}
}

class Resolver{
	
	TestCase testCase;
	
	public Resolver(TestCase testCase) {this.testCase = testCase;}

	public String computeAnswear() {
		
		RecursiveSolver recursiveSolver = new RecursiveSolver(testCase);                                                                                                                                                       
		
		recursiveSolver.checkForSolution( 0, 0, testCase.X, testCase.Y, testCase.moves.size(), 0);
		
		return recursiveSolver.getSolution();
	}
	
}

class RecursiveSolver{
	
	TestCase testCase;
	
	int minNumberOfMovesMade = Integer.MAX_VALUE;
	
	String answear = "IMPOSSIBLE";
	
	public RecursiveSolver(TestCase testCase) {this.testCase = testCase;}

	public String getSolution() {return answear;}

	public void checkForSolution(int myX, int myY, int X, int Y, int numberOfMovesLeft, int numberOfMovesMade) {
		
		System.out.println(myX+" "+myY+" "+X+" "+Y);
		
//		try {
//			Thread.sleep(250);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		if (numberOfMovesLeft<2) {
			return;
		}
		
		if (myX == X && myY == Y) {
			
			if(numberOfMovesMade < minNumberOfMovesMade) {
				minNumberOfMovesMade = numberOfMovesMade;
				answear = minNumberOfMovesMade+"";
				System.out.println(true);
			}
			return;
		} else {
			
			X = testCase.getNextMoveX();
			Y = testCase.getNextMoveY();
			
			checkForSolution(myX+1, myY, X, Y, numberOfMovesLeft - 1, numberOfMovesMade + 1);
			checkForSolution(myX, myY+1, X, Y, numberOfMovesLeft - 1, numberOfMovesMade + 1);
			checkForSolution(myX-1, myY, X, Y, numberOfMovesLeft - 1, numberOfMovesMade + 1);
			checkForSolution(myX, myY-1, X, Y, numberOfMovesLeft - 1, numberOfMovesMade + 1);
			checkForSolution(myX, myY, X, Y, numberOfMovesLeft - 1, numberOfMovesMade + 1);
		}
	}
}
