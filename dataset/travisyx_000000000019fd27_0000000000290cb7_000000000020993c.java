import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	
	public static void main (String[] args) {
		Scanner scan= new Scanner(System.in);
		int num = scan.nextInt();
		for(int t = 0; t < num; ++t){
			int size = scan.nextInt();
			int trace = 0;
			int rowSame = 0;
			int colSame = 0;
			ArrayList<ArrayList<Integer>> row = new ArrayList<>();
			ArrayList<ArrayList<Integer>> col = new ArrayList<>();
			ArrayList<Boolean> rows = new ArrayList<>();
			ArrayList<Boolean> cols = new ArrayList<>();
			for(int i = 0; i < size; ++i){
				row.add(new ArrayList<Integer>());
				col.add(new ArrayList<Integer>());
				rows.add(false);
				cols.add(false);
			}
			
			for(int i = 0; i < size; ++i)
				for(int j = 0; j < size; ++j){
					int temp = scan.nextInt();
					if(i == j)
						trace += temp;
					if(row.get(i).contains(temp) && !rows.get(i)){
						rowSame++;
						rows.set(i, true);
					}
					else
						row.get(i).add(temp);
					if(col.get(j).contains(temp) && !cols.get(j)){
						colSame++;
						cols.set(j, true);
					}
					else
						col.get(j).add(temp);
					//System.out.println("rowsame " + rowSame + " colsame " + colSame );
				}
			System.out.println("Case #"  + (t+1) + ": " + trace + " " + rowSame + " " + colSame);
		}
	}
}

