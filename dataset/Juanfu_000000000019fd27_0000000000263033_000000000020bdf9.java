import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

			Boolean[] booleanC = new Boolean[1440];
			Arrays.fill(booleanC, Boolean.FALSE);
			Boolean[] booleanJ = new Boolean[1440];
			Arrays.fill(booleanJ, Boolean.FALSE);

			Map<String, Boolean[]> mapCalendar = new HashMap<>();
			mapCalendar.put(CAMERON, booleanC);
			mapCalendar.put(JAMIE, booleanJ);

			// Inicio pongo donde sea
			// Si puedo en los dos dejo la tarea en standby para un retrabajo

			String oldPersonAssigned = CAMERON;

			Map<Integer, Integer[]> standby = new HashMap<>();

			// Empiezo tareas
			for (int j = 1; j <= n; j++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();

				Integer[] tarea = new Integer[] { startTime, endTime };

				// If IMPOSSIBLE not detected
				if (!stOutput.equals(IMPOSSIBLE)) {

					boolean forCameron = canShedulerFor(mapCalendar.get(CAMERON), tarea);
					boolean forJamie = canShedulerFor(mapCalendar.get(JAMIE), tarea);
					if (forCameron && forJamie) {
						if (j == 1) {
							sheduleFor(mapCalendar.get(CAMERON), tarea);
						} else {
							oldPersonAssigned = "";
							standby.put(j, tarea);
						}
					} else if (forCameron) {
						sheduleFor(mapCalendar.get(CAMERON), tarea);
						oldPersonAssigned = CAMERON;
					} else if (forJamie) {
						sheduleFor(mapCalendar.get(JAMIE), tarea);
						oldPersonAssigned = JAMIE;
					} else {
						// IMPOSSIBLE
						oldPersonAssigned = "";
						stOutput = IMPOSSIBLE;
					}
					stOutput = concatenate(stOutput, oldPersonAssigned);
				}

			}
			// If IMPOSSIBLE not detected
			if (!stOutput.equals(IMPOSSIBLE)) {

				// Retrabajo en tareas que valen para los dos
				for (Map.Entry<Integer, Integer[]> entry : standby.entrySet()) {
					Integer[] tarea = entry.getValue();

					boolean forCameron = canShedulerFor(mapCalendar.get(CAMERON), tarea);
					boolean forJamie = canShedulerFor(mapCalendar.get(JAMIE), tarea);
					if (forCameron) {
						sheduleFor(mapCalendar.get(CAMERON), tarea);
						oldPersonAssigned = CAMERON;
					} else if (forJamie) {
						sheduleFor(mapCalendar.get(JAMIE), tarea);
						oldPersonAssigned = JAMIE;
					} else {
						// IMPOSSIBLE
						oldPersonAssigned = "";
						stOutput = IMPOSSIBLE;
					}
					if (!stOutput.equals(IMPOSSIBLE)) {
						stOutput = insert(stOutput, oldPersonAssigned, entry.getKey());
					}
				}
			}
			System.out.println("Case #" + i + ": " + stOutput);
		}
	}

	private static void sheduleFor(Boolean[] booleans, Integer[] tarea) {
		// [0,0,0,0,0,0,0,0...]
		// [5,7]
		for (int i = tarea[0]; i < tarea[1]; i++) {
			booleans[i] = true;
		}
	}

	private static boolean canShedulerFor(Boolean[] booleans, Integer[] tarea) {
		// [0,0,0,0,0,0,0,0...]
		// [5,7]
		boolean result = true;
		for (int i = tarea[0]; i < tarea[1]; i++) {
			if (booleans[i]) {
				result = false;
			}
		}
		return result;
	}

	public static String concatenate(String... s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length; i++)
			sb = sb.append(s[i]);

		return sb.toString();
	}

	private static String insert(String stOutput, String string, Integer pos) {
		return new StringBuilder(stOutput).insert(pos - 1, string).toString();
	}

}
