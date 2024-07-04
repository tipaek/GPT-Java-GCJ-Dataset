import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test = sc.nextInt();
		sc.nextLine();
		for(int t=0; t<test; t++){
			String s=sc.nextLine();
			
				Pattern pattern = Pattern.compile("0+|1+");
		        Matcher matcher = pattern.matcher(s);
		        String res="";
		        while(matcher.find()){
		        	String stt=matcher.group(0);
		        	if(stt.contains("0")){
		        		res+=stt;
		        	}
		        	else{
		        		res+="("+stt+")";
		        	}
		        	
		        }
		        System.out.println("Case #"+(t+1)+": "+res);
		        }
		        
			}
		}

	


