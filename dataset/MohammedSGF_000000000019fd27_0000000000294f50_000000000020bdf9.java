import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner read=new Scanner(System.in);
		
		ArrayList<Integer> c=new ArrayList();
		ArrayList<Integer> j=new ArrayList();
		ArrayList<String> names=new ArrayList();
		int loop=1;
		boolean im=false;
	
		
		int testCase=read.nextInt();
		while(loop<=testCase) {
			
			int N=read.nextInt();
			int task=1;
			String s="";
			while(task<=N) {
				
				int StartTime=read.nextInt();
				int EndTime=read.nextInt();
				boolean isC=true;
				boolean isJ=true;
				for(int i=0;i<c.size()/2;i++) {
					int str=c.get(i);
					int end=c.get(++i);
					if((str<=StartTime && StartTime<end) ||  (EndTime<=end && EndTime>str)) {
						isC=false;
						break;
					}
				}
				
				for(int i=0;i<j.size()/2;i++) {
					int str=j.get(i);
					int end=j.get(++i);
					if((str<=StartTime && StartTime<end) ||  (EndTime<=end && EndTime>str)) {
						isJ=false;
						break;
					}
				}
				
				if(isC) {
					c.add(StartTime);
					c.add(EndTime);
					s=s+"C";
				}
				else if(isJ) {
					j.add(StartTime);
					j.add(EndTime);
					s=s+"J";
				}
				else {
					s="IMPOSSIBLE";
					break;
				}

				
			task++;
			}
			
				System.out.println("Case #"+loop+": "+s);
				c.clear();
				j.clear();
				loop++;
			}
			
			
		}
		
		
		
		
	}


