import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Round0Problem2 {

	public static void main(String[] args) {
		
		try {
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			int T = Integer.parseInt(bf.readLine());
			
			for (int i=0; i<T; i++) {
				
				String S = bf.readLine();

				int braceCount = 0;
				StringBuffer sb = new StringBuffer();
				
				for (int pos=0; pos<S.length(); pos++) {
					int num = Integer.parseInt(S.substring(pos, pos+1));
					
					//Open Braces
					int openBraces = num - braceCount;
					for (int x=0; x<openBraces; x++) sb.append("(");
					
					//Close Braces
					int closeBraces = braceCount - num;
					for (int x=0; x<closeBraces; x++) sb.append(")");
					
					sb.append(S.substring(pos, pos+1));
					
					braceCount = num;
				}
				
				for (int x=braceCount; x>0; x--) sb.append(")");
				
				System.out.println("Case #" + (i+1) + ": " + sb.toString());
			}
			
			
		} catch (Exception e) {
			
		}
		
	}
	
}
