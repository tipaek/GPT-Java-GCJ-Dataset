import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int total = in.nextInt();
		for (int counter = 1; counter <= total; counter++) {

			// Ignore
			in.nextInt();

			// Create a map from raw input
			Map<Integer, List<String>> data = new HashMap<Integer, List<String>>();
			for (int i = 0; i < 10000; i++) {
				String input = in.next() + in.nextLine();
				String[] io = input.split(" ");
				int query = Integer.parseInt(io[0]);
				String response = io[1];
				List<String> responseList = data.get(query);
				if (responseList == null) {
					responseList = new ArrayList<String>();
					data.put(query, responseList);
				}
				responseList.add(response);
			}

			// Decode using map
			StringBuffer output = new StringBuffer("");
			for (int i = 1; i <= 10; i++) {
				
				List<String> responseList = data.get(i);
				for(String response: responseList) {
					if(output.indexOf(response) < 0) {
						output.append(response);
						break;
					}
				}
			}
			
			char zero = output.charAt(output.length() - 1);
			String decode = zero + output.substring(0, output.length() - 2);
			System.out.println("Case #" + counter + ": " + decode);

		}
		in.close();
	}

}
