
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int t = Integer.parseInt(scn.nextLine());
		int cs=1;
		while(t-->0){
			int n = Integer.parseInt(scn.nextLine());
			ArrayList<ArrayList<Character>> al = new ArrayList<ArrayList<Character>>();
			int mlen=0;
			for(int j=0;j<n;j++){
				ArrayList<Character> tba = new ArrayList<>();

				String s = scn.nextLine();
				
				mlen = Math.max(mlen, s.length());
				for(int i=s.length()-1;i>=0;i--){
					tba.add(s.charAt(i));
				}
				
				al.add(tba);
				
//				System.out.println(al);
			}
			for(int i=0;i<al.size();i++){
				int sz=al.get(i).size();
						
				if(al.get(i).size()<mlen){
					
					int j=0;
					while(j<=(mlen-sz-1)){
						al.get(i).add('.');
						j++;
					}
				}
			}
//			System.out.println(al);
			int eq=0;
			int os=0;
			int ans=0;
			for(int i=0;i<mlen;i++){
				os=0;
				for(int j=1;j<al.size();j++){
					
					if(al.get(j).get(i)!=al.get(j-1).get(i)){
						
						if(i<mlen-1)
						if((al.get(j).get(i)!='*' && al.get(j).get(i)!='.') && (al.get(j-1).get(i)!='*' && al.get(j-1).get(i)!='.')){
							eq=1;
							break;
						}
					}
					
					if(al.get(j).get(i)!='.' && al.get(j).get(i)!='*'){
						os=1;
					}
					if(os==0 && al.get(j).get(i)=='*'){
						ans=j;
					}
					if(al.get(j).get(i)=='.'){
						continue;
					}
					if(al.get(j).get(i)=='*'){
						continue;
					}
					
					
				}
				if(eq==1){
					break;
				}
			}
			if(eq==1){
				System.out.println("Case #"+cs+++": *");
			}
			else if(os==0){
				System.out.print("Case #"+cs+++": ");
				for(int i=al.get(ans).size()-2;i>=0;i--){
					char ch=al.get(ans).get(i);
					System.out.print(ch);
				}
				System.out.println();
			}
			
		}

	}

}
