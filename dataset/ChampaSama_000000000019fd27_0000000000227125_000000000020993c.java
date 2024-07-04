
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		try {
			int testCases = Integer.parseInt(br.readLine());
			for(int cases = 0; cases < testCases; cases++) {
				int size = Integer.parseInt(br.readLine());
				ArrayList<ArrayList<Integer>> list = new ArrayList<>();
				StringTokenizer st = null;
				int repeatedRow = 0, repeatedColumn = 0, trace = 0;
				boolean rFlag = true, cFlag[] = new boolean[size];
				
				for(int i = 0; i < size; i++) {
					st = new StringTokenizer(br.readLine());
					list.add(new ArrayList<>(size));
					rFlag = true;
					for(int j = 0; j < size; j++) {
						int element = Integer.parseInt(st.nextToken());
						//System.out.println(i+"  "+j+" "+list.size());
						if(list.get(i).contains(element) && rFlag) {
							repeatedRow++;
							rFlag = false;
						}
						for(int k = 0; k < list.size() - 1; k++) {
							if(list.get(k).get(j) == element && !cFlag[j]) {
								repeatedColumn++;
								cFlag[j] = true;
							}
						}
						if(i == j) {
							trace += element;
						}
						list.get(i).add(element);
					}
				}
				System.out.println("Case #"+(cases+1)+": "+trace+" "+repeatedRow+" "+repeatedColumn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
