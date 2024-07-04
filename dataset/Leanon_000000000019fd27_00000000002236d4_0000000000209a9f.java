import java.util.*;
public class Solution{
  public static void main (String [] args){
    Scanner c = new Scanner(System.in);
    int t = c.nextInt();
    int cnt=1;
    c.nextLine();
    while (t>0){
        String s = c.nextLine();
        char[] sc = s.toCharArray();
        int[] fbrkt = new int[s.length()];
        int[] bbrkt = new int[s.length()];
        
        while (check(sc)) {
        	boolean f = false;
        	for (int i=0;i<sc.length;i++){
                if (f && sc[i]!='0'){
                    sc[i]--;
                    if (i==sc.length-1) {
                    	bbrkt[i]++;
                    }
                }
                else if (f && sc[i]=='0'){
                    f=false;
                    bbrkt[i-1]++;
                }
                else if (!f && sc[i]!='0'){
                    f=true;
                    fbrkt[i]++;
                    sc[i]--;
                    if (i==sc.length-1) {
                    	bbrkt[i]++;
                    }
                }
            }
        }
        
        System.out.print("Case #"+cnt+": ");
        for (int i=0;i<sc.length;i++){
            for (int j=0;j<fbrkt[i];j++){
                System.out.print("(");
            }
            System.out.print(s.charAt(i));
            for (int j=0;j<bbrkt[i];j++){
                System.out.print(")");
            }
        }
        System.out.println();
        cnt++;t--;
    }
  }

private static boolean check(char[] sc) {
	for (int i=0;i<sc.length;i++) {
		if (sc[i]!='0') {
			return true;
		}
		
	}
	return false;
}
}