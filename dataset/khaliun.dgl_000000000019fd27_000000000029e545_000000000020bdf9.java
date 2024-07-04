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
	
	public static class Pair {
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
					
					for(int j=0; j< N; j++) {
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
		StringBuilder res = new StringBuilder();
		

		List<Pair> cameron = new ArrayList<Pair>();
		List<Pair> james = new ArrayList<Pair>();
		
		if(jobs.size() == 0) {
			return "IMPOSSIBLE";
		}
		if(jobs.size()>= 1) {
			res.append("C");
			cStart = jobs.get(0).start;
			cEnd = jobs.get(0).end;
			cameron.add(new Pair(jobs.get(0).start, jobs.get(0).end));
		}
		if(jobs.size()>= 2) {
			res.append("J");
			jStart = jobs.get(1).start;
			jEnd = jobs.get(1).end;
			james.add(new Pair(jobs.get(1).start, jobs.get(1).end));
		}
		
		for(int i=2; i< jobs.size(); i++) {
			Pair job = jobs.get(i);

			boolean found = false;
			if(cStart >= job.end) {
				res.append("C");
				cStart = job.start;
				cameron.add(new Pair(job.start, job.end));
				found = true;
			}
			else if(jStart >= job.end){
				res.append("J");
				jStart = job.start;
				james.add(new Pair(job.start, job.end));
				found = true;
			}
			
			else {
				int minCameron = 0;
				Pair minCameronObj = new Pair(0, 0);

				int minJames = 0;
				Pair minJamesObj = new Pair(0, 0);
				
				for(int c=0; c<cameron.size()-1; c++) {
					Pair temp = cameron.get(c);
					Pair tempNext = cameron.get(c+1);
					
					if(temp.end<=job.start && job.end <= tempNext.start) {
						if(minCameron == 0 || minCameron > tempNext.start - temp.end) {
							minCameronObj.start = temp.end;
							minCameronObj.end = tempNext.start;
							minCameron = tempNext.start - temp.end;
						}
//						res.append("C");
//						cameron.add(new Pair(job.start, job.end));
//						found = true;
					}
//					if(found) break;
				}
//				if(minCameron > 0) {
					for(int c=0; c<james.size()-1; c++) {
						Pair temp = james.get(c);
						Pair tempNext = james.get(c+1);
						
						if(temp.end<=job.start && job.end <= tempNext.start) {
							if(minJames == 0 || minJames > tempNext.start - temp.end) {
								minJamesObj.start = temp.end;
								minJamesObj.end = tempNext.start;
								minJames = tempNext.start - temp.end;
							}
//							res.append("J");
//							cameron.add(new Pair(job.start, job.end));
//							found = true;
				// 			break;
						}
//					    if(found) break;
					}
//				}

				if(minCameron == 0 && minJames == 0) {
					found = false;
				}
				else if(minJames == 0) {
					res.append("C");
					cameron.add(new Pair(job.start, job.end));
					found = true;
				}
				else if(minCameron == 0) {
					res.append("J");
					james.add(new Pair(job.start, job.end));
					found = true;
				}
				else if(minCameron < minJames) {
					res.append("C");
					cameron.add(new Pair(job.start, job.end));
					found = true;
				}
				else if(minCameron >= minJames){
					res.append("J");
					cameron.add(new Pair(job.start, job.end));
					found = true;
				}
			}
			if(!found) {
				if(job.start >= cEnd) {
					res.append("C");
					cEnd = job.end;
					cameron.add(new Pair(job.start, job.end));
					found = true;
				}
				else if(job.start >= jEnd) {
					res.append("J");
					jEnd = job.end;
					james.add(new Pair(job.start, job.end));
					found = true;
				}
			}
			if(!found) {
		        StringBuilder str = new StringBuilder(); 
				res = str.append("IMPOSSIBLE");
				break;
			}
		}
		
		return res.toString();
	}
	
}