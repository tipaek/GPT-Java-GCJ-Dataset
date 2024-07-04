import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
	static Scanner next= new Scanner(System.in);
	 public static class time {
	       int start;
	       int end;
	       String name;
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
		test[i].start=next.nextInt();
		test[i].end=next.nextInt();
		}
		boolean possibale=true;
		test[0].name="C";
		int ctestor,jtestor;
		for(int i=1;i<N;i++) {
			ctestor=0;jtestor=0;
			for(int k=0;k<i;k++) {
				//System.out.println(test[i].start+"<"+test[k].end+","+test[i].end+">"+test[k].start);
				if(test[i].start<test[k].end&&test[i].end>test[k].start) {
					if(test[k].name=="C")  {
						ctestor=1;
					}
					else {
						jtestor=1;
					}
				
				}
				
			}
			if(jtestor==0&&ctestor==1) {
				test[i].name="J";
			}else if(jtestor==1&&ctestor==0) {
				test[i].name="C";
			}else if(jtestor==0&&ctestor==0) {
				test[i].name=test[i-1].name;
			}else {
				possibale=false;
				break;
			}
			
			
		}
		for(int i=0;i<N;i++) {
			updated_string+=test[i].name;
		}	
		if(possibale) {
		return updated_string;}
		else {
			return "Case"+" #"+Integer.toString(test_order)+":"+" "+"IMPOSSIBLE";
		}
	}
	
}


