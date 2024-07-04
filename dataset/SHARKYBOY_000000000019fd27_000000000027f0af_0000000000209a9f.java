import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		int t = Integer.parseInt(bf.readLine());
 		String[] answers = new String[t];
 		for(int i = 0;i<t;i++){
 			String a = bf.readLine();
 			String b = "";
 			String [] inserts = new String[a.length()+1];
 			int pdepth =0;
 			for(int j = 0;j<a.length();j++){
 				int d = Integer.parseInt(a.charAt(j)+ "") - pdepth;
				String st = "";
 				if (d < 0){

 					for(int l = 0;l<(0-d);l++){
 						st += ")";
 					}
 				}
 				else{
 					for(int l = 0;l<d;l++){
 						st += "(";
 					}
 				}
 				inserts[j] = st;
 				pdepth = Integer.parseInt(a.charAt(j)+ "");
 			}
 			String ab = "";
 			for(int l = 0;l<pdepth;l++){
					ab += ")";
			}
 			inserts[a.length()] = ab;
 			
 			for(int s = 0;s<a.length();s++){
 				b+= inserts[s];
 				b+= a.charAt(s);
 			}
 			b+= inserts[a.length()];
 			answers[i] = b;
 		}
 		
 		
 		
 		for(int i = 0;i<t;i++){
 			System.out.println("Case #"+ (i+1) + ": " + answers[i]);
 		}
 		
	}

}
