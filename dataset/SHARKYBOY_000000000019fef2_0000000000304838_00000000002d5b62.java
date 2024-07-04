import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws Exception{
		int num = 998244353;
		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		
 		int t = Integer.parseInt(bf.readLine());
 		String[] answers = new String[t];
 		for(int i = 0;i<t;i++){
 			boolean finished = true;
 			StringTokenizer st = new StringTokenizer(bf.readLine());
 			int a = Integer.parseInt(st.nextToken());
 			boolean nega = false;
 			if (a < 0){
 				nega = true;
 				a = -a;
 			}
 			int b = Integer.parseInt(st.nextToken());
 			boolean negb = false;
 			if (b < 0){
 				negb = true;
 				b = -b;
 			}
 			if ((a+b)%2==0){
 				finished = false;
 				answers[i] = "IMPOSSIBLE";
 			}
 			else{
 				String answer = "";
 				String as = Integer.toBinaryString(a);
 				int asdf = as.length() + 0;
 				for(int j = 0;j<31-asdf;j++){
 					as = "0" + as;
 				}
 				String bs = Integer.toBinaryString(b);
 				int bsdf = bs.length() + 0;
 				for(int j = 0;j<31-bsdf;j++){
 					bs = "0" + bs;
 				}
 				boolean oneoneloop = false;
 				boolean onelooplonger = false; //true == x coord, false == ycoord
 				int index1 = 30;
 				int index2 = 30;
 				while(index1 >=0 && index2 >= 0){
 					if (oneoneloop == true){
 						if (onelooplonger == true){
 							if (as.charAt(index1) == '0' && bs.charAt(index2) == '0'){
 								oneoneloop = false;
 								if (nega == true)
 		 							answer = answer + "W";
 		 						else
 		 							answer = answer + "E";
 							}
 							if (as.charAt(index1) == '1' && bs.charAt(index2) == '0'){
 								finished = false;
 								answers[i] = "IMPOSSIBLE";
 		 						break;
 							}
 							if (as.charAt(index1) == '0' && bs.charAt(index2) == '1'){
 								if (nega == true)
 		 							answer = answer + "W";
 		 						else
 		 							answer = answer + "E";
 							}
 							if (as.charAt(index1) == '1' && bs.charAt(index2) == '1'){
 								if (negb == true)
 		 							answer = answer + "S";
 		 						else
 		 							answer = answer + "N";
 							}
 						}
 						else{
 							if (as.charAt(index1) == '0' && bs.charAt(index2) == '0'){
 								oneoneloop = false;
 								if (negb == true)
 		 							answer = answer + "S";
 		 						else
 		 							answer = answer + "N";
 							}
 							if (as.charAt(index1) == '0' && bs.charAt(index2) == '1'){
 								finished = false;
 								answers[i] = "IMPOSSIBLE";
 		 						break;
 							}
 							if (as.charAt(index1) == '1' && bs.charAt(index2) == '0'){
 								if (negb == true)
 		 							answer = answer + "S";
 		 						else
 		 							answer = answer + "N";
 							}
 							if (as.charAt(index1) == '1' && bs.charAt(index2) == '1'){
 								if (nega == true)
 		 							answer = answer + "W";
 		 						else
 		 							answer = answer + "E";
 							}
 							
 						}
 						index1-=1;
 						index2-=1;
 					}
 					else if (as.charAt(index1) == '1' && bs.charAt(index2) == '1'){
 						oneoneloop = true;
 						if (answer.charAt(answer.length()-1) == 'E' || answer.charAt(answer.length()-1) == 'W'){
 							onelooplonger = true;
 							if (answer.charAt(answer.length()-1) == 'E')
 								answer = answer.substring(0, answer.length()-1) + "W";
 							else if (answer.charAt(answer.length()-1) == 'W')
 								answer = answer.substring(0, answer.length()-1) + "E";
 							if (negb == true)
 	 							answer = answer + "S";
 	 						else
 	 							answer = answer + "N";
 						}
 						else{
 							onelooplonger = false;
 							if (answer.charAt(answer.length()-1) == 'N')
 								answer = answer.substring(0, answer.length()-1) + "S";
 							else if (answer.charAt(answer.length()-1) == 'S')
 								answer = answer.substring(0, answer.length()-1) + "N";
 							if (nega == true)
 	 							answer = answer + "W";
 	 						else
 	 							answer = answer + "E";
 						}
 						index1-=1;
 						index2-=1;
 					}
 					else if (as.charAt(index1) == '1' && bs.charAt(index2) == '0'){
 						if (nega == true)
 							answer = answer + "W";
 						else
 							answer = answer + "E";
 						index1-=1;
 						index2-=1;
 					}
 					else if (as.charAt(index1) == '0' && bs.charAt(index2) == '1'){
 						if (negb == true)
 							answer = answer + "S";
 						else
 							answer = answer + "N";
 						index1-=1;
 						index2-=1;
 					}
 					else if (as.charAt(index1) == '0' && bs.charAt(index2) == '0'){
 						for(int ab = 0;ab <= index1;ab++){
 							if (as.charAt(ab) == '1')
 								finished = false;
 						}
 						for(int ab = 0;ab <= index2;ab++){
 							if (bs.charAt(ab) == '1')
 								finished = false;
 						}
 						if (finished == true)
 							break;
 						else{
 							finished = false;
 							answers[i] = "IMPOSSIBLE";
 							break;
 						}
 					}
 				}
 				if (finished == true)
 					answers[i] = answer;
 			}
 		}
 		for(int i = 0;i<t;i++){
 			System.out.println("Case #"+ (i+1) + ": " + answers[i]);
 		}
	}
}
