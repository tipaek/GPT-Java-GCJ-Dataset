import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t =s.nextInt();
		for(int i=1;i<=t;i++) {
			String finalAnswer="";
			int n= s.nextInt();
			int matrix [][]= new int[n][2];
			for(int j=0;j<n;j++) {
				matrix[j][0]=s.nextInt();
				matrix[j][1] =s.nextInt();
			}
			List<Integer> cameron1 = new ArrayList<Integer>();
			List<Integer> cameron2 = new ArrayList<Integer>();
			List<Integer> james1 = new ArrayList<Integer>();
			List<Integer> james2 = new ArrayList<Integer>();
			
			cameron1.add(matrix[0][0]);
			cameron2.add(matrix[0][1]);
			finalAnswer= finalAnswer+"C";
			boolean found =false;
			
			for(int j=1; j<n;j++) {
				found =false;
				for(int k=0;k<cameron1.size();k++) {
					if(matrix[j][0]>cameron1.get(k) && matrix[j][0]<cameron2.get(k) || matrix[j][1]>cameron1.get(k) && matrix[j][1]<cameron2.get(k)) {
						found =true;
						break;	
					}
				}
				if(!found) {
					finalAnswer= finalAnswer+"C";
					cameron1.add(matrix[j][0]);
					cameron2.add(matrix[j][1]);
					
				}else {
					found =false;
					for(int k=0;k<james1.size();k++) {
						if(matrix[j][0]>james1.get(k) && matrix[j][0]<james2.get(k) || matrix[j][1]>james1.get(k) && matrix[j][1]<james2.get(k)) {
							found =true;
							break;	
						}
					}
					
					if(!found) {
						james1.add(matrix[j][0]);
						james2.add(matrix[j][1]);
						finalAnswer= finalAnswer+"J";
					}
					else {
						finalAnswer = "IMPOSSIBLE";
					}
							
				}
				
			}
			
			System.out.println("Case #"+i+": "+finalAnswer);
			
		}
		
	}

}
