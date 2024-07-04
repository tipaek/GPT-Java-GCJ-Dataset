import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int x = 1; x <= t; ++x) {
			int slices = in.nextInt();
			int customers = in.nextInt();
			float[] angles = new float[slices];

			for (int i = 0; i < slices; i++)
				angles[i] = in.nextFloat();

			System.out.println("Case #" + x + ": " + getCuts(slices, customers, angles));
		}
		in.close();
	}

	private static int getCuts(int slices, int customers, float[] angles) {
		HashMap<Float, Integer> occur = new HashMap<>();
		for (int i = 0; i < angles.length; i++) {
			if (!occur.containsKey(angles[i]))
				occur.put(angles[i], 0);
			occur.replace(angles[i], occur.get(angles[i]) + 1);
		}

		//System.out.println(occur + ", " + Arrays.toString(angles));

		if (occur.containsValue(customers))
			return 0;

		//System.out.println("detection");

		ArrayList<Float> ang = new ArrayList<>();
		for (float i : angles)
			ang.add(i);

		int out = 0;
		int counter = 0;
		while (!occur.isEmpty() && customers > 0 && !ang.isEmpty()) {
			Map.Entry<Float, Integer> entry = occur.entrySet().iterator().next();
			float max = entry.getKey();
			int index = 0;
			for (int i = 0; i < ang.size(); i++) {
				try {
					if (occur.get(ang.get(i)) > occur.get(max)) {
						max = ang.get(i);
						i = index;
					}
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
			
			int occ = occur.remove(max);
			counter++;
			
			//System.out.println(occ + ", " + max);

			for (int i = customers - occ; i > 1; i--) {
				for (int j = 0; j < ang.size(); j++) {
					if (j != index && (ang.get(j) % i) == 0) {
						customers -= i + occ;
						out += i - 1;
						//System.out.println(customers + ", " + out);
						ang.remove(index);
						
						if(index > j)
							ang.remove(j);
						else
							ang.remove(j - 1);
						
						counter--;
					}
				}
			}
		}

		if (customers == 0)
			return out;
		else
			return customers - 1;
	}

}