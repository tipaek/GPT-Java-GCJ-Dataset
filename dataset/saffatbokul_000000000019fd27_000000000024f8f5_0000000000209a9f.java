package B;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.valueOf(reader.readLine());

		for (int i = 0; i < size; i++) {
			StringBuilder sb1 = new StringBuilder("");
			ArrayList<Integer> arrayList = new ArrayList<Integer>();

			String inp = reader.readLine();

			for (int iter = 0; iter < inp.length(); iter++) {
				arrayList.add(inp.charAt(iter) - '0');
			}

			int lastval = 0;
			for (int iter = 0; iter < arrayList.size(); iter++) {
				if (arrayList.get(iter) == 0) {
					sb1.append('0');
				} else if (arrayList.get(iter) == lastval) {
					sb1.append(arrayList.get(iter));
				} else {

					for (int opener = 0; opener < arrayList.get(iter); opener++) {
						sb1.append('(');
					}

					sb1.append(arrayList.get(iter));

				}
				lastval = arrayList.get(iter);
				if ((iter+1) < arrayList.size()) {
					if (arrayList.get(iter) != arrayList.get(iter + 1)) {
						for (int opener = 0; opener < arrayList.get(iter); opener++) {
							sb1.append(')');
						}
					}
				}
				if (iter==arrayList.size()-1){
					if (arrayList.get(iter) == 0) {
						
					}else {
						for (int opener = 0; opener < arrayList.get(iter); opener++) {
							sb1.append(')');
						}
					}
				}
			}

			System.out.println("Case #"+(i+1)+": "+sb1);
		}

	}
}