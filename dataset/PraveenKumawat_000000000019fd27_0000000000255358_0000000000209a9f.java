import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String testcase = br.readLine();
		String[] t = testcase.split(" ");
		int T = Integer.parseInt(t[0]);

		for (int j = 0; j < T; j++) {

			String str = "";
			String input = br.readLine();
			int track_closing = 0;
			int old_number = 0, new_number;

			for (int i = 0; i < input.length(); i++) {
				new_number = Character.getNumericValue(input.charAt(i));

				if (new_number == old_number) {
					str += new_number;
					old_number = new_number;
				} 
				else if (new_number < old_number) {

					for (int k = 0; k < (old_number - new_number); k++)
						str += ')';

					str += new_number;
					track_closing = track_closing - (old_number - new_number);
					old_number = new_number;
				}
				else {
					for (int k = 0; k < new_number - old_number; k++)
						str += '(';

					str += new_number;
					track_closing = track_closing + (new_number - old_number);
					old_number = new_number;
				}

			}

			if (track_closing > 0) {
				for (int i = 0; i < track_closing; i++) 
					str += ')';
			}

			System.out.println("Case #"+(j+1)+": "+str);
		}
	}
}
