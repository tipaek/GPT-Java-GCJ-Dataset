import java.util.Scanner;

public class Solution {
	public static String mul(String a,int i){
		String res="";
		while(i>0){
			res+=a;
			i--;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test = sc.nextInt();
		sc.nextLine();
		for(int t=0; t<test; t++){
			String s=sc.nextLine();
			
			int brkCnt=Character.getNumericValue(s.charAt(0));
	        
	        String res="";
	        res+=mul("(",brkCnt)+s.charAt(0);
	        
	        for (int i=1;i<s.length();i++){
	        	if(s.charAt(i)==s.charAt(i-1)){
	        		res+=s.charAt(i);
	        	}
	        	else if(s.charAt(i)>s.charAt(i-1)){
	        		int temp=Character.getNumericValue(s.charAt(i))-Character.getNumericValue(s.charAt(i-1));
	        		res+=mul("(",temp)+s.charAt(i);
	        		
	        	}
	        	else{
	        		int temp=Character.getNumericValue(s.charAt(i-1))-Character.getNumericValue(s.charAt(i));
	        		res+=mul(")",temp)+s.charAt(i);
	        	}
	        	brkCnt=Character.getNumericValue(s.charAt(i));
	        }
	        if(brkCnt!=0){
	        	res+=mul(")",brkCnt);
	        }
	        System.out.println("Case #"+(t+1)+": "+res);
		        }
		        
			}
		}