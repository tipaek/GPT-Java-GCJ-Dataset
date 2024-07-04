import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	int nrOfCases;
	int caseLength;
	int queryCounter;
	int [] workingArea;
	Scanner s;
	
	public Solution(){
		s = new Scanner(System.in);
	}
		
	public int getNumber(int pos){
		System.out.println(pos+1);
		queryCounter++;
		return s.nextInt();
	}
	public void submitSolution(){
		String result="";
		for (int i:workingArea){
			result += i;
		}
		System.out.println(result);
		if(s.nextLine().equals("N")){
			System.exit(0);
		}
	}
	public void bitflip(){
		for (int i=0; i<workingArea.length; i++){
			workingArea[i] = 1-workingArea[i]; 
		}
	}
	public void orderflip(){
		int swap;
		for (int i=0; i<workingArea.length/2; i++){
			swap = workingArea[i];
			workingArea[i] = workingArea[caseLength-1-i];
			workingArea[caseLength-1-i] = swap;
		}
	}

	
	public void resolveOperation(){
		boolean firstandLastEqual = (workingArea[0] == workingArea[caseLength-1]);
		int j=-1;
		for (int i=1; i<5; i++){
			boolean iEqual = (workingArea[i] == workingArea[caseLength-1-i]);
			
			if (firstandLastEqual != iEqual)
				j=i;
		}
		if(j<0){
			try {
				Thread.sleep(60*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int knownStart = workingArea[0];
		int knownEnd = workingArea[caseLength-1];
		int queriedStart = getNumber(0);
		int knownPivot = workingArea[j];
		int knownPivotEnd = workingArea[caseLength-1-j];
		int queriedPivot = getNumber(j);
		
		if (knownStart == queriedStart && knownPivot == queriedPivot){
			// no change
			
		} else if (knownStart != queriedStart && knownPivot != queriedPivot){
			// bitflip
			bitflip();
		} else if (knownStart != queriedStart && knownPivot == queriedPivot && firstandLastEqual){
			// double flip
			bitflip();
			orderflip();
		} else if (knownStart != queriedStart && knownPivot == queriedPivot && !firstandLastEqual){
			// flip
			orderflip();
		} else if (knownStart == queriedStart && knownPivot != queriedPivot && firstandLastEqual){
			// flip
			orderflip();
		} else {
			// double flip
			bitflip();
			orderflip();
		}
		
	}
	
	public void solvePuzzle(){
		workingArea = new int[caseLength];
		int queriedNumber = 0;
		queryCounter = 0;
		
		
		while (queriedNumber < caseLength){
			if (queriedNumber % 2 ==0){
				workingArea[queriedNumber/2] = getNumber(queriedNumber/2);
			} else {
				workingArea[caseLength - queriedNumber/2-1] = getNumber(caseLength - queriedNumber/2-1);
			}
			queriedNumber++;
			if (queryCounter % 10 == 0){
				resolveOperation();
			}
		}
		submitSolution();
	}
	public void run(){
		parseInput();
		
		for (int i=0; i<nrOfCases; i++){
			solvePuzzle();
		}
		s.close();
	}
	public void parseInput(){	
		nrOfCases  = s.nextInt();
		caseLength = s.nextInt();
	}
	public static void main(String[] args) {
		(new Solution()).run();
	}

}
