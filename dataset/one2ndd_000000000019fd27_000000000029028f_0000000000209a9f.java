import java.io.*;

public class Solution{
	public static String Sprime(String S){
		int N=S.length();
		String Sp="",subString="";
		for(int i=0;i<N;i++){
			subString="";
			if(S.charAt(i)=='0'){
				while(i<N&&S.charAt(i)=='0'){ subString+="0"; i++; }
				i--;
				Sp+=subString;
			}else{
				while(i<N&&S.charAt(i)=='1'){ subString+="1"; i++; }
				i--;
				Sp+="("+subString+")";		
			}
		}return Sp;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			String S=br.readLine();
			System.out.println("Case #"+t+": "+Sprime(S));
		}
	}
}