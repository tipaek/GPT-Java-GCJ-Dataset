import java.io.*;
import java.util.ArrayList;
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		ArrayList<String>ans=new ArrayList<String>();
		for(int a=0;a<cases;a++) {
			String s=br.readLine();
			String fin="";
			int firstnum=s.charAt(0)-48;
			int ob=0; 
			
			ob+=firstnum;
			for(int i=0;i<firstnum;i++) { //starting
				fin=fin+"(";
				
			}
			fin=fin+firstnum;
			for(int i=1;i<s.length();i++) {
				int cnum=(int)s.charAt(i)-48;
				int prevnum=(int)s.charAt(i-1)-48;
				if(cnum>prevnum&&cnum!=0) {
					for(int j=0;j<cnum-prevnum;j++) {
						fin=fin+"(";
						
					}
					fin=fin+cnum;
					ob=ob+(cnum-prevnum);
				}
				else if(cnum<prevnum&&cnum!=0) {
					for(int j=0;j<prevnum-cnum;j++) {
						fin=fin+")";
					}
					fin=fin+cnum;
					ob=ob-(prevnum-cnum);
				}
				else if(cnum==0) {
					for(int j=0;j<ob;j++) {
						fin=fin+")";
					}
					ob=0;
					fin=fin+cnum;
				}
				else if(cnum==prevnum)fin=fin+""+cnum;
				
								
			}
			
			for(int i=0;i<ob;i++) {
				fin=fin+")";
			}
			ans.add(fin);
		}
		
		for(int i=0;i<ans.size();i++) {
			System.out.println("Case #"+(i+1)+": "+ans.get(i));
		}
	}

}
