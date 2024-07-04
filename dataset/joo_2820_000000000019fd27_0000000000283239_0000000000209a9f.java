//package jam_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases=scan.nextInt();
		scan.nextLine();
		int j;
		for(int i=1;i<=testCases;i++) {
			String result="";
			
			String S=scan.nextLine(); 
			char []Splitted=S.toCharArray();
			for(int tt=0;tt<Integer.parseInt(Character.toString(Splitted[0]));tt++) {
				result=result.concat("(");
			}
			result=result.concat(Character.toString(Splitted[0]));
			for( j=0;j<Splitted.length-1;j++) {
				int d=(int )Splitted[j]-(int )Splitted[j+1];
				if(d>0) {
					for(int k=0;k<d;k++) {
						result=result.concat(")");
					}
				}
				else if(d<0) {
					for(int k=d;k<0;k++) {
						result=result.concat("(");
					}
					
				}
				result=result.concat(Character.toString(Splitted[j+1]));
			}
			for(int tt=0;tt<Integer.parseInt(Character.toString(Splitted[j]));tt++) {
				result=result.concat(")");
			}
			j=0;
		System.out.println("Case #"+i+":"+result);
		}

	}

	}


