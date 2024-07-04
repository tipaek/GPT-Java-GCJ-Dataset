import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner read=new Scanner(System.in);
		
		ArrayList<Integer> time=new ArrayList();
		ArrayList<String> names=new ArrayList();
		int loop=1;
		boolean im=false;
	
		
		int testCase=read.nextInt();
		while(loop<=testCase) {
			
			int N=read.nextInt();
			int task=1;
			while(task<=N) {
				
				int StartTime=read.nextInt();
				int EndTime=read.nextInt();
				
				if(!names.contains("C")) {
					names.add("C");
					names.add("x");
					time.add(StartTime);
					time.add(EndTime);
				}
				else if(!names.contains("J")) {
					names.add("J");
					names.add("x");
					time.add(StartTime);
					time.add(EndTime);
				}
				else {
					for(int i=0;i<names.size();i++) {
						
						if(names.get(i).equals("C")) {
							if(EndTime<=time.get(i)||StartTime>=time.get(i+1)) {
								names.add("C");
								names.add("x");
								time.add(StartTime);
								time.add(EndTime);
								break;
							}
						}
						else if(names.get(i).equals("J")) {
							if(EndTime<=time.get(i)||StartTime>=time.get(i+1)) {
								names.add("J");
								names.add("x");
								time.add(StartTime);
								time.add(EndTime);
								break;
							}
						}
						
						if(i+1==names.size()) {
							System.out.println("Case #"+loop+": "+"IMPOSSIBLE");
							im=true;
							break;
						}
						
						
						
					}
				}
			task++;
			}
			if(!im) {
				String a="";
				for(String s:names) {
					a=a+s.replaceAll("x","");
				}
				System.out.println("Case #"+loop+": "+a);
			}
			im=false;
			loop++;
			names.clear();
			time.clear();
		}
		
		read.close();
		
		
	}

}
