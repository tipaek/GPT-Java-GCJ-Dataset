import java.util.*; 
                   
public class Solution{
	static Scanner in;
     public static void main(String[] args) {		 
         in = new Scanner(System.in);	
         int T = in.nextInt(); 
         for(int cas = 1; cas <= T; cas++)
			 solve(cas);
	 }
	 
	 static void solve(int cas){
		 int u = in.nextInt();
		 String q, r;
		 char ch;
		 int[] limit = new int[26];
		 Arrays.fill(limit, 10);
		 boolean[] nonZero = new boolean[26];
		 for(int i = 0; i < 4000; i++){
			 q = in.next();  r = in.next();
			 ch = r.charAt(0);
			 nonZero[ch-'A'] = true;
			 if(r.length() == q.length()){
				 limit[ch-'A'] = Math.min(limit[ch-'A'], q.charAt(0)-'0');
			     if(q.length() > 1 && q.charAt(1) == '0' && nonZero[r.charAt(1)-'A'])
					 limit[ch-'A'] = Math.min(limit[ch-'A'], q.charAt(0)-'0'-1);
			 }
		 }
		 
		 boolean[] occur = new boolean[26];
		 StringBuilder sb = new StringBuilder();
		 for(int i = 0; i < 26; i++){
			 if(limit[i] < 10 && !nonZero[i]){	
				 occur[i] = true;
				 sb.append('A'+i);
				 break;
			 }
		 }
		 int cnt = 0;
		 while(sb.length() < 10 && cnt < 10000){
			 int bound = sb.length();
			 int min = 26,  mark = -1;
			 cnt++;
			 for(int i = 0; i < 26; i++){
				 if(limit[i] <= bound && !occur[i]){
					 if(min > limit[i]){
						 min = limit[i];
						 mark = i;
					 }
				 }
			 }
			 if(mark >= 0){
				 occur[mark] = true;
				 sb.append('A'+mark);
			 }
		 }
		 System.out.println("Case #"+cas+": "+sb.toString());
	 }
}

