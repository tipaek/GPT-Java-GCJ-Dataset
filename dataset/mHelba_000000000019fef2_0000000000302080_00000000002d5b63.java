import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nbTest;
		
		nbTest = in.nextInt();
		for(int i = 0; i < nbTest; i++){
			String reponse;
			boolean ok = false;
			int nbHit = 0;
			
			for(int j = -5; j <= 5; j++){
				for(int k = -5; k <= 5; k++){
					System.out.println(j + " " + k);
					System.out.flush();
					
					reponse = in.nextLine();
					nbHit++;
					if(reponse.equals("CENTER")){
						ok = true;
						j = 6;
						k = 6;
					}
				}
			}
			if(!ok){
				System.out.println("-1234567890 1234567890");
				System.out.flush();
				reponse = in.nextLine();
			}
		}
	}
}
