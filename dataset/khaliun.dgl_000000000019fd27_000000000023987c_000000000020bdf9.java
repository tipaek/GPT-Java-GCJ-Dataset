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
	
	private static class Pair {
        public int start;
        public int end;

        public Pair(int item1, int item2) {
            this.start = item1;
            this.end = item2;
        }
    }
	
	public static void main(String[] args) throws FileNotFoundException {
		try( Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int caseNumber = scanner.nextInt();
			if(caseNumber >= 1 && caseNumber <= 100) {
				for(int i=0; i<caseNumber; i++) {
					int N = scanner.nextInt();

					List<Pair> jobj = new ArrayList<Pair>();
					
					for(int j=0; i< N; i++) {
						int start = scanner.nextInt();
						int end = scanner.nextInt();
						jobj.add(new Pair(start, end));
					}
					
					String res = calc(jobj);
					
					System.out.println("Case #" + (i+1) + ": " + res);
				}
			}
		}
	}
	
	public static String calc (List<Pair> jobs) {
		
		int cStart = 0, cEnd = 0, jStart = 0, jEnd = 0;
		String res = "";
		
		for(int i=0; i< jobs.size(); i++) {
			Pair job = jobs.get(i);
			
			if(job.start >= cEnd || job.end <= cStart) {
				res = res + "C";
				cStart = job.start;
				cEnd = job.end;
			}
			else if(job.start >= jEnd || job.end <= jStart) {
				res = res + "J";
				jStart = job.start;
				jEnd = job.end;
			}
			else {
				res = "IMPOSSIBLE";
				break;
			}
		}
		
		return res;
	}
	
	
}