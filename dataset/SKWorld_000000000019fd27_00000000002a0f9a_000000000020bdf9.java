import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> al = new ArrayList<>();
		ArrayList<int[]> ini = new ArrayList<>();
		ArrayList<int[]> Cameron = new ArrayList<>();
		ArrayList<int[]> Jamie = new ArrayList<>();

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			boolean possible=true;
			 al.clear();
			 ini.clear();
			 Cameron.clear();
			 Jamie.clear();
			
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String s[] = br.readLine().split(" ");
				
			    int arr[] = new int[2];
				arr[0] = Integer.parseInt(s[0]);
				arr[1] =  Integer.parseInt(s[1]);
				al.add(arr);
				ini.add(arr);
			}
			al.sort((o1, o2) -> {
				if (  o1[1] > o2[1] && o1[0] == o2[0]) 
					return 1;
				if (o1[0] > o2[0])
					return 1;
				if(o1[0] == o2[0] && o1[1] == o2[1])
					return 0;
				return -1;
			});
			Cameron.add(al.get(0));
			if (n > 1)
				Jamie.add(al.get(1));
			int idx1 = 0;
			int idx2 = 0;
			for (int i = 2; i < n; i++) {

				 if (al.get(i)[0] >= Cameron.get(idx2)[1]) {
					Cameron.add(al.get(i));
					idx2++;
				} else if (al.get(i)[0] >= Jamie.get(idx1)[1]) {
					Jamie.add(al.get(i));
					idx1++;
				}
				else {
					possible=false;
				}
			}

			String ans = "";
			if (possible) {
				for (int i = 0; i < ini.size(); i++) {
					if (Cameron.contains(ini.get(i))) {
						ans = ans+"C";
					} else {
						ans = ans+"J";
					}
				}
				System.out.println("Case #" + (t + 1) + ": " + ans.toString());

			} else {
				ans = ans+"";
				System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");

			}

		}

	}
}
