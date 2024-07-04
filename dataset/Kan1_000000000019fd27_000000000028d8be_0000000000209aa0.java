import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {


	static Solution sol = new Solution();
	 
	 
	static int trace = 0;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();


		for(int usease = 0; usease< T;usease++) {

			int N = scann.nextInt(); //Number of activities
			int K = scann.nextInt(); // Value to found
			
			Genetic gen = new Genetic(K,N);
			LatinSquare solution = gen.getSolution();
			//System.out.println("-------------------");
			if(solution!=null) {
				System.out.println(String.format("Case #%s: POSSIBLE",usease+1));
				System.out.println(printArr(solution.square));
			}else {
				System.out.println(String.format("Case #%s: IMPOSSIBLE",usease+1));
			}
			
			//square = buildSquare(square,0,0,K,N,columnsUsedNumber,allowRowNumer);

			

		}


	}
	

	static String printArr(int[][] square) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i< square.length;i++) {
			for(int j = 0;j< square.length;j++) {
				sb.append(square[i][j]);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.toString().length()-1);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.toString().length()-1);

		return sb.toString();
	}



}

class LatinSquare{
	int[][] square;
	int maxSize =0;
	int trace=0;
	int ecart;

	
	public void evaluate(int target) {
		for(int i =0;i<square.length;i++) {
			trace+=square[i][i];
		}
		this.ecart = Math.abs(trace - target);
	}

	
	
	boolean isInColumn(int rand,int colIndex) {
		for(int i = 0; i< this.maxSize;i++) {
			if (this.square[i][colIndex]==rand) return true;
		}
	return false;
	}
	
	public int generateRandom() {
		Random rand = new Random();
		return rand.nextInt(maxSize)+1;
	}
	
}


class Genetic{
	
	int numberOfSolution = 10000;
	
	int target = 0;
	int maxSize = 0;
	int[][] refSquare = new int[0][0];
	boolean continueSearch = true;
	double numberOfPermutation =  0;
	LatinSquare solution =null;
	List<LatinSquare> solutions = new ArrayList<>();
	

	public static int generateRandomIndex(int bounder) {
		Random rand = new Random();
		return rand.nextInt(bounder);
	}

	public Genetic(int target,int maxSize) {
		
		this.target = target;
		this.maxSize = maxSize;
		buildRef();
		numberOfPermutation =  fact(this.maxSize);
	}
	
	
	private void buildRef() {
		refSquare = new int[this.maxSize][this.maxSize];
		for(int i = 0;i< this.maxSize;i++) {
			for(int j=0;j<this.maxSize;j++) {
				refSquare[i][j] =((i+j)%this.maxSize)+1;
			}
			
		}
		
	}

	 public static int fact (int n) {
	        if (n==0) return(1);
	        else return(n*fact(n-1));
	    }
	 
	private void generateSolutions() {
		
		for(int tryNumber = 0;tryNumber < numberOfSolution;tryNumber++) {
			
		geneateFreshSolution(numberOfPermutation);
		
		solutions = solutions.stream().sorted((LatinSquare lt1, LatinSquare lt2) -> Integer.compare(lt1.ecart,lt2.ecart)).collect(Collectors.toList());//Order
		if(solutions.get(0).ecart==0) {
			this.solution = solutions.get(0);
			return;
		}
		if(solution==null) {
			solutions = solutions.subList(0, (int) (numberOfPermutation/10));//Elitisme
			for(int i = 1;i<solutions.size();i++) {
				cross(solutions.get(i-1), solutions.get(i));
			}
			if(generateRandomIndex(this.maxSize) < this.maxSize /10) solutions.forEach(s -> mutate(s));
			
			
		}
		
		}
		
	}
	public void mutate(LatinSquare lt) {	
			int index1 = generateRandomIndex(this.maxSize);
			int index2 = generateRandomIndex(this.maxSize);			
			lt.square = swapRow(lt.square,index1,index2);
			lt.square = swapColumn(lt.square,index1,index2);			
	}
	
	
	public void cross(LatinSquare lt1,LatinSquare lt2) {
		int index1 = generateRandomIndex(this.maxSize);
		int index2 = generateRandomIndex(this.maxSize);
		
		int[] tmpRow = lt1.square[index1];
		lt1.square[index1]=lt2.square[index2];
		lt2.square[index2] = tmpRow;
		
		
		for(int i =0;i<this.maxSize;i++) {
			int tmp = lt2.square[i][index1];
			lt2.square[i][index1] = lt1.square[i][index2];
			lt1.square[i][index2] = tmp;
		}
		

	}
	
	public void geneateFreshSolution(double limite) {
		
		for(int row = 0;row< limite;row ++) {
			LatinSquare lt = new LatinSquare();
			int index1 = generateRandomIndex(this.maxSize);
			int index2 = generateRandomIndex(this.maxSize);
			
			lt.square = swapRow(refSquare,index1,index2);
			lt.evaluate(this.target);
			solutions.add(lt);
			
			lt = new LatinSquare();
			lt.square = swapColumn(refSquare,index1,index2);
			lt.evaluate(this.target);
			solutions.add(lt);
			}

	}
	
	private int[][] swapColumn(int[][] tmp,int col1, int col2) {
		
		
		for(int i =0;i<this.maxSize;i++) {
			int tmpInt = tmp[i][col1];
			tmp[i][col1] = tmp[i][col2];
			tmp[i][col2] =tmpInt;
		}
		return tmp;
		
	}

	private int[][] swapRow(int[][] tmp,int row1, int row2) {
		
		for(int i =0;i<this.maxSize;i++) {
			int tmpInt = tmp[row1][i];
			tmp[row1][i] = tmp[row2][i];
			tmp[row2][i] =tmpInt;
		}
		return tmp;
		
	}
	public LatinSquare getSolution() {
		
		generateSolutions();
		if(solution!=null) {
			return solution;
		}
		else {
			return null;
		}
		
	}
	
}

