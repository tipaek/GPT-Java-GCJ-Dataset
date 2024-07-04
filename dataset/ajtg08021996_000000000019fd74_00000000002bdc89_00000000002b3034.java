import java.util.*;
public class Solution{
	

	public static void main(String[] args) {

			int T=0,N=0;
			
		Scanner sc=new Scanner(System.in);
		
		ArrayList<String> al1=new ArrayList<>();
		if(sc.hasNext()) {
			T=sc.nextInt();
		}
		
		
		
		for(int i=0;i<T;i++) {
			if(sc.hasNext()) {
				N=sc.nextInt();
				
			}
			ArrayList<String> al=new ArrayList<>();
			ArrayList<String> alf=new ArrayList<>();
			ArrayList<String> alr=new ArrayList<>();
			String ss="";
			
			for(int j=0;j<N;j++) {
				if(sc.hasNext()) {
					ss=sc.next();
				}
				if(ss.charAt(0)=='*') {
						String[] ar=ss.split("*");
						for(int k=0;k<ar.length;k++) {
							alr.add(ar[k]);
						}
				}
				else if(ss.charAt(ss.length()-1)=='*') {
					String[] ar=ss.split("*");
					for(int k=0;k<ar.length;k++) {
						alf.add(ar[k]);
				}
			}
				String[] ar=ss.split("*");
				for(int k=0;k<ar.length;k++) {
					al.add(ar[k]);
			}
			}
			
			if(alf.size()==alr.size()) {
				for(int k=0;k<alf.size();k++) {
					
				}
			}
			
			
			
			
			String s=al.get(0);
			
			for(int j=1;j<N;j++) {
				if(s.length()<al.get(j).length()) {
					s=al.get(j);
				}
			}
			for(int j=0;j<N;j++) {
				
			}
			
			
			
			
			
			
			
		}
		
		

	}
	
	
	
	
	
}