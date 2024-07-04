import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			for(int c = 1; c<=t; ++c) {
				int l = Integer.parseInt(br.readLine());
				String act = "";
				boolean bandera = false;
				for(int i = 0; i < l; ++i) {
					String ln[] = br.readLine().split("\\*");
					
					if(i==0) {
						act = ln[1];
					}
					else {
						if(ln[1].endsWith(act) && ln[1].length()>=act.length()) {
							act = ln[1];
						}
						else if(act.endsWith(ln[1])) {
							continue;
						}
						else {
							bandera = true;
							System.out.println("Case #"+c+": *");
							
						}
						
					}
					
				}
				if(!bandera) System.out.println("Case #"+c+": "+act);
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
