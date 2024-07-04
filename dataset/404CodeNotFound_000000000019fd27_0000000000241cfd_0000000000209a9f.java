import java.util.*;
public class Solution{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		ArrayList<Character> arr;
		String s, res;
		char c;
		int len = 0, a, k=0, flag, i=0;
		for(int j=0;j<t;j++){
			s = sc.nextLine();
			k = 0;
			i = 0;
			res = "";
			arr = new ArrayList<Character>();
			len = s.length();
			while(i<len){
				// q.add();
				flag=0;
				k = 1;
				c = s.charAt(i);
				// a = Integer.parseInt(String.valueOf(c));
				if(c=='1'){
					arr.add('(');
					arr.add(c);
					res+="(1";
					while((i+k)<len){
						if(s.charAt(i+k)=='1'){
							res+='1';
							k++;
						}
						else{
							break;
						}
					}
					arr.add(')');
					res+=')';
					i = i+k;
				}
				else{
					arr.add(c);
					res+=c;
					i++;
				}

			}
			System.out.println("Case #"+(j+1)+": "+res);
		}
	}
}