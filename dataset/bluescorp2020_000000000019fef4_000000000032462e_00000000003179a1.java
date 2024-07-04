import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {

	public static void solve(Scanner s){
		int u=s.nextInt();
		char a[] = new char[10];
		ArrayList<HashSet<Character>> chars = new ArrayList<HashSet<Character>>(10);
		for(int i=0;i<10;i++)
			chars.add(new HashSet<>());
		for(int i=0;i<10000;i++){
			int q=s.nextInt();
			String r=s.next();
			if(q==10){
				if(r.length()==2){
					chars.add(0, new HashSet<Character>());
					chars.get(0).add(r.charAt(1));
				}
			}else if(q<10){
				chars.get(q).add(r.charAt(0));
			}
		}
		for(int i=0;i<10;i++){
			a[i]=chars.get(i).iterator().next();
			for(int j=i+1;j<10;j++)
			{
				chars.get(j).remove(a[i]);
			}
		}
		for(char c: a){
			System.out.print(c);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i=1;i<=t;i++){
			System.out.print("Case #"+i+": ");
			solve(s);
		}
		s.close();
	}
}
