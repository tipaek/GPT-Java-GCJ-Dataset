import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int h = 0; h < n; h++) {
			System.out.print("Case #" + (h + 1) + ": ");
			String s = sc.next();
			String[] s1 = s.split("");
			ArrayList<String> ar = new ArrayList<String>();
			// String[] ar=new String[10];
			int j = 0;
			boolean flag = false;
			// System.out.println(s.length());
			for (int i = 0, k = 1; i < s.length(); i++) {
				// System.out.println("i=" + i);
				if (s1[i].equals("0")) {
					ar.add(j, "0");
					System.out.print(ar.get(j));
					j++;
				} else {
					if (i <= s.length() - 2) {

						if (s1[i].equals(s1[i + 1])) {
							if (flag == false) {
								ar.add(j, "(");
								System.out.print(ar.get(j));
								j++;
								ar.add(j, s1[i]);
								System.out.print(ar.get(j));
								j++;
								k++;
								flag = true;

							} else if (s1[i].equals(s1[i + 1])) {
								ar.add(j, s1[i]);
								System.out.print(ar.get(j));
								j++;

							}
						} else {
							if (flag == false) {
								ar.add(j, "(");
								System.out.print(ar.get(j));
								j++;
							}

							ar.add(j, s1[i]);
							System.out.print(ar.get(j));
							j++;

							ar.add(j, ")");
							System.out.print(ar.get(j));
							j++;
							flag = false;
						}
					} else {
						if (flag == false) {
							ar.add(j, "(");
							System.out.print(ar.get(j));
							j++;
						}

						ar.add(j, s1[i]);
						System.out.print(ar.get(j));
						j++;

						ar.add(j, ")");
						System.out.print(ar.get(j));
						j++;
					}

				}
                
			}
            System.out.println();
		}
	}
}
