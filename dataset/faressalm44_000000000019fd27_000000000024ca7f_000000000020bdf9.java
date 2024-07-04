
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
	static Scanner next= new Scanner(System.in);
	 public static class time {
	       int start;
	       int end;
	   
	 }
	public static void main(String[] args)  {
	int T;
	T=next.nextInt();
	String tests[]= new String[T];
	for(int i=1 ;i<=T;i++) {
	  tests[i-1] =elavatuer(i);
	}
	for(int i=0;i<T;i++) {
		
		System.out.print(tests[i]);
		if(i!=T-1) {
			System.out.println();
	}
		}

          	}
	
	public static String elavatuer(int test_order) {
		int N=next.nextInt();
		time test[]=new time[N];
		for (int i = 0; i < N; i++)
		    test[i] = new time();
		String updated_string="";
		updated_string+="Case"+" #"+Integer.toString(test_order)+":"+" ";
		for(int i=0;i<N;i++) {
		
		int n=next.nextInt();
		test[i].start=n;
		test[i].end=next.nextInt();
		}
		boolean possibale=true;
		List<time> j = new ArrayList<time>();
		List<time> c = new ArrayList<time>();
		updated_string+="C";
		c.add(test[0]);
		String conditon="C";
		for(int i=1;i<N;i++) {
				if(conditon=="J") {boolean yes=true;
					for(int k=0;k<j.size();k++) {
						
						if(test[i].start<j.get(k).end&&test[i].end>j.get(k).start) {
							yes=false;
							break;
						}
					}
					if(yes) {
						j.add(test[i]);
						conditon="J";
						updated_string+=conditon;
					}
					else {
						for(int k=0;k<c.size();k++) {
							if(test[i].start<c.get(k).end&&test[i].end>c.get(k).start) {
								possibale=false;
								break;
							}
						}
						if(possibale) {
							c.add(test[i]);
							conditon="C";
							updated_string+=conditon;
						}
						else {
							break;
						}
					}
				}
				else {
					boolean yes2=true;
					for(int k=0;k<c.size();k++) {
						if(test[i].start<c.get(k).end&&test[i].end>c.get(k).start) {
							yes2=false;
							break;
						}
					}
					if(yes2) {
						c.add(test[i]);
						conditon="C";
						updated_string+=conditon;
					}
					else {
						for(int k=0;k<j.size();k++) {
							if(test[i].start<j.get(k).end&&test[i].end>j.get(k).start) {
								possibale=false;
								break;
							}
						}
						if(possibale) {
							j.add(test[i]);
							conditon="J";
							updated_string+=conditon;
						}
						else {
							break;
						}
					}
				}
			

		}
		if(possibale) {
		return updated_string;}
		else {
			return "Case"+" #"+Integer.toString(test_order)+":"+" "+"IMPOSSIBLE";
		}
	}
	
}
