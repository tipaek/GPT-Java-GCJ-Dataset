// import java.util.;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 

class Solution {
    public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in)); 
  
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //Scanner sc = new  Scanner(System.in);
        //int T = sc.nextInt();
        int T = Integer.parseInt(br.readLine()); 
        //sc.nextLine();
        for(int t=1;t<=T;t++) {
            //String S = sc.nextLine();
            String S = br.readLine();
            String ans = "";
            
            int openParan = 0;
            for (int i=0; i<S.length(); i++) {
            	int dig = (int) (S.charAt(i) - '0');
            	if(openParan == dig) {
            		ans += S.charAt(i);
            		continue;
            	} else if (openParan < dig) {
            		while(openParan<dig) {
            			ans+= "(";
            			openParan++;
            		}
            		ans += S.charAt(i);
            	} else {
            		while(openParan > dig) {
            			ans+= ")";
            			openParan--;
            		}
            		ans += S.charAt(i);
            	}
            }
            while(openParan>0) {
        		ans+= ")";
        		openParan--;
        	}
        	System.out.println("Case #" + t + ": " + ans);
        }
    }
}