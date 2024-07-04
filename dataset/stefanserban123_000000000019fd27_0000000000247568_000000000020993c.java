package com.codeJam.testBed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//@SpringBootApplication
public class TestBedApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TestBedApplication.class, args);
		
		// below is (incomplete) submitable code. To be used as a template how to read inputs, mostly.
		// debugging is done by using tests.
		// Just make it all into one file and you're g2g
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int tests = sc.nextInt();
		// sc.nextLine(); ?
		
		for (int i=1; i<=tests; i++) {
			//System.out.println("Case #" + i + ": " + (SaveWorld.saveWorld(new TestCase(sc.nextLine()))));
			int n = sc.nextInt();
			List<String> theLines = new ArrayList<String>();
			
			for (int j=0;j<n;j++) {
				theLines.add(sc.nextLine());
			}
			
			System.out.println(solve(theLines, n, i));
		}
		
	}
	
	public static String solve (List<String> theLines, int n, int index) {
		Integer[][] a = new Integer[n][n];
		
		for (int i=0;i<n;i++) {
			String[] row = theLines.get(i).split(" ");
			for (int j=0;j<n;j++) {
				a[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		int dupR = 0;
		int dupC = 0;
		int trace = 0;
		
		for (int i=0;i<n;i++) {
			dupR += duplicateR(a, n, i);
	        dupC += duplicateC(a, n, i);
	        trace += a[i][i];
		}
		
		return "Case #" + (index + 1) + ": " + trace + " " + dupR + " " + dupC;	
	}
	
	public static int duplicateR (Integer[][] a, int n, int i) {		
		Set<Integer> aSet = new HashSet<Integer>(Arrays.asList(a[i]));
		return aSet.size() == n ? 0 : 1;
	}
	
	public static int duplicateC (Integer[][] a, int n, int i) {
		Set<Integer> aSet = new HashSet<Integer>();
		
		for (int k = 0; k < n; k++) {
			aSet.add(a[k][i]);
        }
		
		return aSet.size() == n ? 0 : 1;
	}
	
}
