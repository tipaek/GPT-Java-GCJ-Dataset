import java.util.*;
                      
public class Solution{
	static Scanner in;
     public static void main(String[] args) {		 
     in = new Scanner(System.in);
     int T = in.nextInt();
     for(int cas = 1; cas <= T; cas++){
		 solve(cas);
	 }
	 }
	 static void solve(int cas){
		 int n = in.nextInt();  
		 String[] str = new String[n];
		 for(int i = 0; i < n; i++)
			 str[i] = in.next();
		 
		 
		 List<String> prefix = new ArrayList<>();
		 List<String> suffix = new ArrayList<>();
		 String longestPre = "",  longestSur = "";
		 int[] firstStar = new int[n];
		 int [] lastStar = new int[n];
		 for(int i = 0; i < n; i++){
			 firstStar[i] = str[i].length(); lastStar[i] = 0;			 
			 for(int j = 0; j < str[i].length(); j++){
				 if(str[i].charAt(j) == '*'){
					 firstStar[i] = j;
					 break;
				 }
			 }
			for(int j = str[i].length()-1; j >= 0; j--){
				 if(str[i].charAt(j) == '*'){
					 lastStar[i] = j;
					 break;
				 }
			 }
			 if(firstStar[i] != 0){
				 prefix.add(str[i].substring(0,firstStar[i]));
				 if(prefix.get(prefix.size()-1).length() > longestPre.length())
					 longestPre = prefix.get(prefix.size()-1);
			 }
			 if(lastStar[i] != str[i].length()-1){
				 suffix.add(str[i].substring(lastStar[i]+1));
				 if(suffix.get(suffix.size()-1).length() > longestSur.length())
					 longestSur = suffix.get(suffix.size()-1);
			 }
		 }
		         //System.out.println(longestPre+" ... "+longestSur);   //System.out.println(prefix.size()+" ,,, "+suffix.size()); 
		 for(int i = 0; i < prefix.size(); i++){
			 if(conflict(prefix.get(i),longestPre)){
				 System.out.println("Case #"+cas+": *");
				 return;
			 }
		 }
		 String rever = reverse(longestSur);
		 for(int i = 0; i < suffix.size(); i++){
			 if(conflict(reverse(suffix.get(i)),rever)){  
				 System.out.println("Case #"+cas+": *");
				 return;
			 }
		 }
		 StringBuilder sb = new StringBuilder();
		 for(int i = 0; i < n; i++){
			 if(firstStar[i] != str[i].length() && lastStar[i] != 0){
				 for(int j = firstStar[i]+1; j < lastStar[i]; j++)
					 if(str[i].charAt(j) != '*')
						 sb.append(str[i].charAt(j));
			 }
		 }
		 String ans = longestPre + sb.toString() + longestSur;
		 System.out.println("Case #"+cas+": "+ans);
	 }
	 
	 static boolean conflict(String s1, String s2){
		 for(int i = 0; i < s1.length(); i++){
			 if(s1.charAt(i) != s2.charAt(i)){ 
			 return true;}
		 }
		 return false;
	 }
	 static String reverse(String s){
		 StringBuilder sb = new StringBuilder();
		 for(int i = s.length()-1; i>= 0; i--)
			 sb.append(s.charAt(i));
		 return sb.toString();
	 }
}
			 
				 
			 
			
			
			