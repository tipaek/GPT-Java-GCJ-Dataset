import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution  {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCasesNumber = in.nextInt();
		int bitsInArray = in.nextInt();
		boolean stop = false;
		for(int i =0; i< testCasesNumber; i++) {
			String array = "";
			int maxQueries = 150;
			int numberOfMadeQueries = 0;
			int ind = 1;
			while(true) {
				System.out.println(ind++);
				String response = in.next();
				if(response.equals("N")) {
					stop = true;
					break;
				} else {
					int responseInt = Integer.parseInt(response);
					array += responseInt;
				}
				if(ind == bitsInArray + 1) {
					System.out.println(array);
					String success = in.next();
					if(success.equals("Y")) {
						break;
					} else {
						stop = true;
						break;
					}
				}
			}
			if(stop) {
				break;
			}
		}
		
	}
}
