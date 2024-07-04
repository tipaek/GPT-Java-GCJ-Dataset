import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));) {
			int t = in.nextInt();
			int b = in.nextInt();
			for (int i = 0; i < t; i++) {
				String bits = in.nextInt()+"";
				int number=Integer.valueOf(bits, 2);
				Map<Integer,Integer> digits=new LinkedHashMap<>();
				for(int p=1,k=1;;p++,k++){
					if(p>number){
						p=1;
					}
					System.out.println(p);
					int bit=in.nextInt();
					if(p%10==0){
						if(!digits.isEmpty()){
							if(isValid(bits,digits)){
								bits=bits;
							}else if(isValid(reverse(bits),digits)){
								bits=reverse(bits);
							}else if(isValid(compliment(bits),digits)){
								bits=compliment(bits);
							}else if(isValid(reverseCompliment(bits),digits)){
								bits=reverseCompliment(bits);
							}
							number=Integer.valueOf(bits, 2);
							digits.clear();
						}												
					}
					digits.put(p-1, bit);
					if(k==160){
						break;
					}
				}
				if("N".equals(in.next())){
					System.exit(-1);
				}
			}
		}
	}
	
	public static Boolean isValid(String bits,Map<Integer,Integer> digits){
		Boolean isValid=true;
		for(Map.Entry<Integer,Integer> entry: digits.entrySet()){
			if(!entry.getValue().equals(Integer.parseInt(bits.charAt(entry.getKey())+""))){
				isValid=false;
			}
		}
		return isValid;
	}
	
	public static String reverseCompliment(String bits){
		String reverseCompliment=reverse(bits);
		reverseCompliment=compliment(reverseCompliment);
		return reverseCompliment;		
	}
	
	public static String compliment(String bits){
		StringBuffer complimentBits=new StringBuffer();
		for(int i=0;i<bits.length();i++){
			if("0".equals(bits.charAt(i)+"")){
				complimentBits.append("1");
			}else{
				complimentBits.append("0");
			}
		}
		return complimentBits.toString();
	}
	
	public static String reverse(String bits){
		return new StringBuffer(bits).reverse().toString();
	}	
	
}
