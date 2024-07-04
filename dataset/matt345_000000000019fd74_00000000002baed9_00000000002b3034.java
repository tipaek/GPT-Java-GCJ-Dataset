import java.io.*;
import java.util.ArrayList;
public class Solution{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String>answers=new ArrayList<String>();
		int cases=Integer.parseInt(br.readLine());
		for(int a=0;a<cases;a++) {
			
			int longest=0;
			int longidx=0;
			int words=Integer.parseInt(br.readLine());
			String[]w=new String[words];
			for(int i=0;i<words;i++) {
				w[i]=br.readLine();
				if(w[i].length()-1>longest) {
					longest=w[i].length()-1;
					longidx=i; //string with the longest index
				}
			}
			String ans="";
			String compare="";
			compare=w[longidx];
			boolean done=false;
			
			for(int i=0;i<w.length;i++) {
				int difference=compare.length()-w[i].length();
				for(int j=w[i].length()-1;j>0;j--) { //ignore asterisk at pos 0
					if(w[i].charAt(j)!=compare.charAt(j+difference)) {
						answers.add("*"); //impossible
						done=true;
						break;
					}
					
				}
				
				if(done) break;
				
			}
			
			if(done) {
				done=false;
				continue;
			}
			else {
				done=false;
				answers.add(compare.substring(1,compare.length()));
			}
		}
		
		for(int i=0;i<answers.size();++i) {
			System.out.println("Case #"+(i+1)+": "+answers.get(i));
		}
	}

}
