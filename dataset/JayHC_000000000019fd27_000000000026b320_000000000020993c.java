import java.util.*;

public class Solution {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		List<Integer> results = new ArrayList<>();
		//System.out.println(findDups(new ArrayList<Integer>(Arrays.asList(1,2,3))));

		int testCases = scanner.nextInt();

		for(int i=0; i<testCases; i++) {

			int countRowDups = 0;
			int countColDups = 0;
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			int size = scanner.nextInt();

			for(int row=0; row<size; row++) {

				list.add(new ArrayList<Integer>());

				for(int col=0; col<size; col++) {
					list.get(row).add(scanner.nextInt());
				}

				countRowDups += findDups(list.get(row));
			}

			countColDups += findColDups(list);
			results.add(i+1);
			results.add(findTrace(list));
			results.add(countRowDups);
			results.add(countColDups);

		}

		scanner.close();

		for(int i=0; i<results.size(); i+=4) {
			System.out.println("Case #"+results.get(i)+": "+results.get(i+1)+" "+results.get(i+2)+" "+results.get(i+3));
		}
	}

	public static int findTrace(List<List<Integer>> list) {

		int sum=0;

		for(int i=0; i<list.size(); i++) {
			sum += list.get(i).get(i);
		}

		return sum;
	}

	public static int findColDups(List<List<Integer>> list) {

		int count = 0;

		for(int i=0; i<list.size(); i++) {

			List<Integer> colList = new ArrayList<>();

			for(int j=0; j<list.size(); j++) {
				colList.add(list.get(j).get(i));
			}

			count += findDups(colList);
		}

		return count;
	}

	public static int findDups(List<Integer> list) {

		Map<Integer, Integer> map = new HashMap<>();

		//count occurrences of each element
		for(int i : list) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}

		if(map.values().stream().filter(x -> x>1).findFirst().isPresent()) {
			return 1;
		}else {
			return 0;
		}
	}
}
