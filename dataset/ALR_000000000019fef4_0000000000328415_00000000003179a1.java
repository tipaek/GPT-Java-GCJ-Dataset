import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	static class Request {

		public Request(int m, String r) {
			super();
			M = m;
			R = r.split("");
		}
		int M;
		String[] R;
		@Override
		public String toString() {
			return "Request [M=" + M + ", R=" + Arrays.toString(R) + "]";
		}


	}
	static class Sort implements Comparator<Request>{
		public int compare(Request r1, Request r2) {
			return r1.M - r2.M;
		}
	}

	static class Input {
		int U;
		Request[] requests = new Request[10000];
		public void add(int m, String r,int i) {
			requests[i] = new Request(m,r);
		}

		@Override
		public String toString() {
			return "Input [U=" + U + ", requests=" + Arrays.toString(requests) + "]";
		}

		public void sort() {
			Arrays.sort(requests, new Sort());
		}

	}


	public static void main(String args[]) throws FileNotFoundException {
	    Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("./data_R1C/dataB.in"));

		int T = scan.nextInt();
		for (int ks = 1; ks <= T; ks++) {
			Input in = readInput(scan);
			//System.out.println(in);
			String  sol = solve(in);
			System.out.println("Case #"+ks+ ": "+sol);
		}
	}


	private static String solve(Input in) {
		String[] mapping = new String[10];


		//fill alphabet 
		Set<String> alphabet = new TreeSet<String>();
		for(Request req1: in.requests) {
			for(String st: req1.R) {
				alphabet.add(st);
			}
			if(alphabet.size()>=10)
				break;
		}

		Map<String,Integer> mapStat = new HashMap<String,Integer>();
		for(String alph:alphabet) {
			mapStat.put(alph, 0);
		}

		for(Request req: in.requests) {
			if(req.R.length ==in.U) {
				int a = mapStat.get(req.R[0])+1;
				mapStat.put(req.R[0], a);
			}
		}

		Integer[] arr = new Integer[10];
		int cpt=0;
		
		for(String letter :alphabet) {
			arr[cpt] = mapStat.get(letter);
			cpt++;

		}

		Arrays.sort(arr);

		for(int i=0;i<mapping.length;i++) {

			String key = null;
			for(String k: mapStat.keySet()) {
				if(mapStat.get(k)==arr[i])
					key = k;
			}	
			if(i==0)
				mapping[i] = key;
			else
				mapping[10-i] = key;
		}



		
		String sol="";
		for(int i=0;i<mapping.length;i++) {
			sol+=mapping[i];
		}
		return sol;
	}








	private static Input readInput(Scanner scan) {
		int U = scan.nextInt();
		Input input = new Input();
		input.U = U;
		for(int i=0;i<10000;i++) {
			int m = scan.nextInt();
			String R = scan.next();
			input.add(m,R,i);
		}
		input.sort();
		return input;
	}








}