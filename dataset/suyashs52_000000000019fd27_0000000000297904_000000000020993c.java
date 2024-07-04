import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {

    public static void main(String... s) throws Exception {
    

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		for (int i = 1; i < test + 1; i++) {
			int cas = Integer.parseInt(br.readLine());
			int sum = 0;
			int x = 0;
			int y = 0;
			int[] allset = new int[cas * cas];
			int ain = 0;
			for (int j = 0; j < cas; j++) {

				String[] str = br.readLine().split(" ");

				int[] inp1 = new int[cas + 1];
				boolean xduplicate = false;
				for (int k = 0; k < str.length; k++) {
					allset[ain] = Integer.parseInt(str[k]);
					if (!xduplicate && inp1[allset[ain]] > 0) {
						xduplicate = true;
						x++;

					}
					inp1[allset[ain]]++;
					if (j == cas - 1) {
						int[] inpy = new int[cas + 1];

						for (int jy = ain; jy > -1; jy -= cas) {
							if (inpy[allset[jy]] > 0) {
								y++;

								break;
							}
							inpy[allset[jy]]++;
						}

					}
					ain++;
				}

				sum += allset[cas * j + j];
			}
			System.out.println("Case #" + i + ": " + sum + " " + x + " " + y);

		}

	
    }
}