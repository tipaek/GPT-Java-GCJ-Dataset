import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
//	Scanner in = null;
//	try {
//		in = new Scanner(new File("D:\\perso\\GoogleCodeJam\\GoogleCodeJam\\src\\_2020\\QualificationRound\\A\\files\\A.TXT"));
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

	
    		int nbCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    		for(int caseNumber = 0; caseNumber < nbCases; caseNumber++){
        		int length = in.nextInt();
        		int sumDiag = 0;
        		int nbColKO = 0;
        		int nbLinesKO = 0;
        		int[][]tableau = new int[length][length];
        		for (int i = 0; i < length; i++) {
        			for (int j = 0; j < length; j++) {
        				tableau[i][j] = in.nextInt();
        			}
        		}
        		for (int i = 0; i < length; i++) {
        			sumDiag+=tableau[i][i];
        		}
        		for (int i = 0; i < length; i++) {
        			List<Integer> liste = new ArrayList<>();
        			boolean isOK = true;
        			for (int j = 0; j < length; j++) {
        				if (liste.contains(tableau[i][j])) {
        					isOK = false;
        					break;
        				}
        				liste.add(tableau[i][j]);
        			}
        			if (!isOK) {
        				nbLinesKO ++;
        			}
        		}
        		for (int i = 0; i < length; i++) {
        			List<Integer> liste = new ArrayList<>();
        			boolean isOK = true;
        			for (int j = 0; j < length; j++) {
        				if (liste.contains(tableau[j][i])) {
        					isOK = false;
        					break;
        				}
        				liste.add(tableau[j][i]);
        			}
        			if (!isOK) {
        				nbColKO ++;
        			}
        		}
        		
        		
				System.out.println("Case #"+(caseNumber+1) + ": " + sumDiag +" "+nbLinesKO+" "+nbColKO);
			}
    		in.close();
	}
}