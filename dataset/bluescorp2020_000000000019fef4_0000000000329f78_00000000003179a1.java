import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {

	public static void solve(Scanner s){
		int u=s.nextInt();
		char a[] = new char[10];
		ArrayList<HashSet<Character>> chars = new ArrayList<HashSet<Character>>(10);
		for(int i=0;i<10;i++)
			chars.add(new HashSet<>());
		ArrayList<Input> p=new ArrayList<>();
		for(int i=0;i<10000;i++){
			Input in=new Input();
			in.q=s.nextInt();
			in.r=s.next();
			p.add(in);
		}
		Collections.sort(p);
		for(int i=0;i<10000;i++){
			int q=p.get(i).q;
			String r=p.get(i).r;
			if(q/10==9 || q%10==9){
				int temp=1;
			}
			if(q<10 || r.length()==1){
				for(int j=0;j<=q%10;j++){
					if(chars.get(j).contains(r.charAt(0)))
						break;
					chars.get(j).add(r.charAt(0));
				}
			}else{
				for(int j=1;j<=q/10;j++){
					if(chars.get(j).contains(r.charAt(0)))
						break;
					chars.get(j).add(r.charAt(0));
				}
				for(int j=0;j<=q%10;j++){
					if(chars.get(j).contains(r.charAt(1)))
						break;
					chars.get(j).add(r.charAt(1));
				}
				
			}
		}
		for(int i=9;i>=0;i--){
			a[i]=chars.get(i).iterator().next();
			for(int j=i-1;j>=0;j--){
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

class Input implements Comparable<Input>{
	
	Integer q;
	String r;
	
	@Override
	public int compareTo(Input o) {
		
		return this.q.compareTo(o.q);
	}
	
	
}
