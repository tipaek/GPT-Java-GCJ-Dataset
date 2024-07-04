import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Math;
import java.text.DecimalFormat; 

public class Solution {
	
	public static void main(String[] args) throws FileNotFoundException {
		try( Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int caseNumber = scanner.nextInt();
			if(caseNumber >= 1 && caseNumber <= 100) {
				for(int i=0; i<caseNumber; i++) {
					int N = scanner.nextInt();
					int m[][] = new int[N][N];
					
					List<Integer> rows = new ArrayList<Integer>();
					List<Integer> columns = new ArrayList<Integer>();
					
					int k = 0, r = 0, c = 0;
					for(int j=0; j<N; j++) {
						int tempR = 0;
						for(int l=0; l<N; l++) {
							m[j][l] = scanner.nextInt();
							if(j == l) k = k + m[j][l];
							if(rows.indexOf(m[j][l]) != -1) tempR ++;
							rows.add(m[j][l]);
						}
						if(tempR > 0) r++;
						rows.clear();
					}
					for(int j=0; j<N; j++) {
						int tempC = 0;
						for(int l=0; l<N; l++) {
							if(columns.indexOf(m[l][j]) != -1) tempC ++;
							columns.add(m[l][j]);
						}
						if(tempC > 0) c++;
						columns.clear();
					}
					
					System.out.println("Case #" + (i+1) + ": " + k + " " + r + " " + c);
				}
			}
		}
	}
	
}