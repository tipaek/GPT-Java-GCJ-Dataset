import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t =scn.nextInt();
		int k=1;
		while(t-->0){
			String s =scn.next();
			StringBuilder sb=new StringBuilder();
			int pr=0;
			for(int i=0;i<s.length();i++){
				int val =(int)(s.charAt(i)-'0');
				  if(pr-val>=0){
					  int x =pr-val;
					  while(x>0){
						  sb.append(")");
						  x--;
					  }
					  sb.append(s.charAt(i));
				  }else{
					  int x =val-pr;
					    while(x>0){
					    	sb.append("(");
					    	x--;
					    }
					    sb.append(s.charAt(i));
				  }
				  pr=val;
			}
			while(pr>0){
				sb.append(")");
				pr--;
			}
			System.out.println("Case #"+k+": "+sb);
     	   k++;
		
		}

	}

}