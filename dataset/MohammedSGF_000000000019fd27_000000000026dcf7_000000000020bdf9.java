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
				
				if(names.isEmpty()) {
					names.add("C");
					names.add("x");
					time.add(StartTime);
					time.add(EndTime);
				}
				else {
					int index=names.lastIndexOf("C");
					if(index!=-1) {
						if(time.get(index+1)<=StartTime ||time.get(index)>EndTime) {
							names.add("C");
							names.add("x");
							time.add(StartTime);
							time.add(EndTime);
						}
						else {
							index=names.lastIndexOf("J");
							if(index!=-1) {
								if(time.get(index+1)<=StartTime||time.get(index)>EndTime) {
									names.add("J");
									names.add("x");
									time.add(StartTime);
									time.add(EndTime);
								}
								else {
									System.out.println("Case #"+loop+": "+"IMPOSSIBLE");
									im=true;
									break;
								}
							}
							else {
								names.add("J");
								names.add("x");
								time.add(StartTime);
								time.add(EndTime);
							}
							
						}
					}
					else {
						names.add("C");
						names.add("x");
						time.add(StartTime);
						time.add(EndTime);
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
