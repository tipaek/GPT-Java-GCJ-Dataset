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
				//sb.append(" ");
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
	List<Integer> random = new ArrayList<>();
	public void build(int maxSize) {
		square = new int[maxSize][maxSize];
		this.maxSize = maxSize;
		for(int i= 0;i<maxSize;i++) {
			random.add(i+1);
		}
		Collections.shuffle(random);
		square = buildSquare(square,0,0);
		
	}
	
	public void evaluate(int target) {
		for(int i =0;i<maxSize;i++) {
			trace+=square[i][i];
		}
		this.ecart = Math.abs(trace - target);
	}

	private int[][] buildSquare(int[][] tmpSquere,int row,int coulmn) {
		
		List<Integer> allowNumber = new ArrayList(this.random);
		
		
		Set<Integer> columNumb = new HashSet<>();
		for(int iRow = 0;iRow<row;iRow++) {
			columNumb.add(tmpSquere[iRow][coulmn]);
		}
		for(int iCol = 0;iCol<coulmn;iCol++) {
			columNumb.add(tmpSquere[row][iCol]);
		}
		
		allowNumber.removeAll(columNumb);
		
		Collections.shuffle(allowNumber);
		
		for(int randomNum : allowNumber) {
	
			
			
			if(tmpSquere[maxSize-1][maxSize-1] !=0) {
				break;
			}
			else {
				tmpSquere[row][coulmn] = randomNum ;
				
				int newCol = (coulmn+1) % maxSize;
				if(newCol < coulmn) row++;
				tmpSquere=buildSquare(tmpSquere,row,newCol);
			}
			
			
		}
		
		return tmpSquere;
		
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
	
	int numberOfSolution = 200;
	
	int target;
	int maxSize;
	LatinSquare solution =null;
	List<LatinSquare> solutions = new ArrayList<>();
	



	public Genetic(int target,int maxSize) {
		this.target = target;
		this.maxSize = maxSize;
	}
	
	
	private void generateSolution() {
		for(int i =0;i< numberOfSolution;i++)
		{
			LatinSquare lt = new LatinSquare();
			lt.build(maxSize);
			lt.evaluate(this.target);
			if(lt.ecart==0) {
				solution = lt;
				break;
			}
			else {
				solutions.add(lt);
			}
		}
		
		 
		solutions = solutions.stream().sorted((LatinSquare lt1, LatinSquare lt2) -> Integer.compare(lt1.ecart,lt2.ecart)).collect(Collectors.toList());
	
	}
	
	public LatinSquare getSolution() {
		
		generateSolution();
		if(solution!=null) {
			return solution;
		}
		else {
			return null;
		}
		
	}
	
}

