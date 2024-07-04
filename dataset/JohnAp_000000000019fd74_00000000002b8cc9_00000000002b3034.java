import java.util.Scanner;
import java.util.Vector;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num=input.nextInt();
		input.nextLine();
		for(int i=1; i<=num; i++) {
			int N=input.nextInt();
			input.nextLine();
			boolean imp=false;
			Vector<String> begin=new Vector<String>();
			Vector<String> middle=new Vector<String>();
			Vector<String> end=new Vector<String>();
			for(int k=0; k<N; k++) {
				String tmp=input.nextLine();
				String[] arr=tmp.split("\\*");
				if(!arr[0].isEmpty()){
					begin.add(arr[0]);
				}
				for(int l=1; l<arr.length-1; l++) {
					middle.add(arr[l]);
				}
				if(!tmp.endsWith("\\*")) {
					end.add(arr[arr.length-1]);
				}else {
					middle.add(arr[arr.length-1]);
				}
			}
			String res="";
			for(String s: begin) {
				if(s.startsWith(res)) {
					res=s;
				}else if(!res.startsWith(s)) {
					imp=true;
					break;
				}
			}
			for(String s: middle) {
				res=res+s;
			}
			String fin="";
			for(String s: end) {
				if(s.endsWith(fin)) {
					fin=s;
				}else if(!fin.endsWith(s)) {
					imp=true;
					break;
				}
			}
			res=res+fin;
			if(imp) {
				System.out.println("Case #"+i+": *");
			}else {
				System.out.println("Case #"+i+": "+res);
			}
			
		}
		
		input.close();
	}

}
