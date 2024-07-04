import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int cases = sc.nextInt();
	    for (int c = 1; c <= cases; c++) {
			int a = sc.nextInt();
			String r = "";

			ArrayList<ArrayList<Integer>> jS = new ArrayList<>();
			jS.add(new ArrayList<Integer>());
			jS.add(new ArrayList<Integer>());
			ArrayList<ArrayList<Integer>> cS = new ArrayList<>();
			cS.add(new ArrayList<Integer>());
			cS.add(new ArrayList<Integer>());

			ArrayList<Integer> sArr = new ArrayList<>();
			ArrayList<Integer> fArr = new ArrayList<>();

			for (int i = 0; i < a; i++) {
				int t = -1;
				if (fArr.size() > 0)
					t = fArr.get(fArr.size() - 1);

				sArr.add(sc.nextInt());
				fArr.add(sc.nextInt());
				int start = sArr.get(sArr.size() - 1);
				int last = fArr.get(fArr.size() - 1);

				if (!r.equals("IMPOSSIBLE")) {
					boolean jBusy = false;
					for (int j = 0; j < jS.get(0).size(); j++) {
						if ((start >= jS.get(0).get(j) && start < jS.get(1).get(j))) {
							jBusy = true;
							break;
						}
					}

					if (jBusy) {
						boolean cBusy = false;
						for (int j = 0; j < cS.get(0).size(); j++) {
							if ((start >= cS.get(0).get(j) && start < cS.get(1).get(j))) {
								cBusy = true;
								break;
							} else if (start <= cS.get(0).get(j) && (last >= cS.get(0).get(j) && last < cS.get(1).get(j))) {
								cBusy = true;
								break;
							}
						}

						if (cBusy) {
							r = "IMPOSSIBLE";
							continue;
						} else {
							cS.get(0).add(sArr.get(sArr.size() - 1));
							cS.get(1).add(fArr.get(fArr.size() - 1));

							r += "C";
						}

					} else {
						jS.get(0).add(sArr.get(sArr.size() - 1));
						jS.get(1).add(fArr.get(fArr.size() - 1));

						r += "J";
					}

				}
			}

			System.out.println(String.format("Case #%d: %s", c, r));
		}
    }
}
