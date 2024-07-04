import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	private static final String CAMERON = "C";
	private static final String JAMIE = "J";
	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// one line with a number of test cases
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		// boucle for testCases #x = i
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt(); // n tareas

			String stOutput = "";
			Map<String, Integer[]> freeTime = new HashMap<>();
			String oldPersonAssigned = CAMERON;

			// Start reading tareas
			for (int j = 1; j <= n; j++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();

				// If IMPOSSIBLE not detected
				if (!oldPersonAssigned.isEmpty()) {

					int freeEnd = 0;
					int freeStart = 0;

					// If para poder continuar con esa persona
					if (freeTime.containsKey(oldPersonAssigned)) {

						if (!(freeTime.get(oldPersonAssigned)[1] < startTime
								|| freeTime.get(oldPersonAssigned)[0] > endTime)) {

							// No puedo asignarle la nueva tarea a la misma persona de antes
							// Comporbar si puedo a la otra persona o es IMPOSSIBLE

							// IF para comprobar que existen las otras personas
							if (freeTime.containsKey(JAMIE)) {
								if (freeTime.get(JAMIE)[0] >= endTime || freeTime.get(JAMIE)[1] <= startTime) {
									oldPersonAssigned = JAMIE;
								} else if (freeTime.get(CAMERON)[0] >= endTime
										|| freeTime.get(CAMERON)[1] <= startTime) {
									oldPersonAssigned = CAMERON;
								} else {
									oldPersonAssigned = "";
									stOutput = IMPOSSIBLE;
								}
							} else {
								// FirstCase for JAMIE
								oldPersonAssigned = JAMIE;
								freeEnd = startTime;
								freeStart = endTime;
								freeTime.put(oldPersonAssigned, new Integer[] { freeEnd, freeStart });
							}
						}

						// Actualisation del freeTime si no es IMPOSSIBLE
						if(!oldPersonAssigned.isEmpty()) {
							freeEnd = Math.min(freeTime.get(oldPersonAssigned)[0].intValue(), startTime);
							freeStart = Math.max(freeTime.get(oldPersonAssigned)[1].intValue(), endTime);
						}

					} else {
						// FirstCase
						freeEnd = startTime;
						freeStart = endTime;
					}

					freeTime.put(oldPersonAssigned, new Integer[] { freeEnd, freeStart });
					stOutput = concatenate(stOutput, oldPersonAssigned);
				}
			}

			System.out.println("Case #" + i + ": " + stOutput);
		}

	}

	public static String concatenate(String... s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length; i++)
			sb = sb.append(s[i]);

		return sb.toString();
	}

}
