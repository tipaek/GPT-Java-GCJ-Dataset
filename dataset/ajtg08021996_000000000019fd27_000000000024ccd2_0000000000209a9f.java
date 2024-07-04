

public class Solution {

	public static void main(String[] args) {
int  T=0;
String s="";
char c='a';
		java.util.Scanner sc=new java.util.Scanner(System.in);
	
		if(sc.hasNext()) {
			T=sc.nextInt();
	
		}
		for(int t=0;t<T;t++) {
		
			if(sc.hasNext())
			s=sc.next();
		
		s=s.strip();
		
		char x=s.charAt(0);
		for(int i=1;i<s.length();i++) {
			if(x<s.charAt(i)) {
				x=s.charAt(i);
			}
		}
		
		
				int l=x;
		int value=0;
		c=s.charAt(s.length()-1);
		java.util.ArrayList<Character> al=new java.util.ArrayList<>();
		
		
		//for l+i-x
		for(int i=0;i<s.length();i++) {
			
			value=l+s.charAt(i)-x-48;
			
			if(value>0&&s.charAt(i)>=48&&s.charAt(i)<=57) {
			
				for(int j=0;j<value;j++) {
			
					al.add('(');
			
				}
				l-=value;
				al.add(s.charAt(i));
			
			}
			else if(value<0&&s.charAt(i)>=48&&s.charAt(i)<=57) {
				value=-(value);
			
				for(int j=0;j<value;j++) {
								al.add(')');
			
				}
				x-=value;
				al.add(s.charAt(i));
						}
			else if(value==0&&s.charAt(i)>=48&&s.charAt(i)<=57) {
				al.add(s.charAt(i));
			}
				
			}		
		
		//for last 
for(int i=0;i<c-48;i++) {
	al.add(al.size(), ')');	

}

		StringBuilder sb=new StringBuilder(al.size());
		for(Character cc: al) {
			sb.append(cc);
		}
		System.out.println("Case #"+(t+1)+": "+sb.toString());
		
		
		
		}
		sc.close();
		}

	}


