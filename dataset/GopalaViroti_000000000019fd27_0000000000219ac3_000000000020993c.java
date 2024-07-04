import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);
        int testCount = sc.nextInt();
        for (int i = 1; i <= testCount; i++)
            solve(i, sc, w);
        w.close();

	}
	public static void solve(int testNumber, Scanner sc, PrintWriter out) {
		int N = sc.nextInt();
		int [][]matrix = new int[N][N];
		int trace =0;
		int row=0,col=0;
		ArrayList<Integer> list []= new ArrayList[N]; 
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				matrix[i][j]=sc.nextInt();
				if(list[j]==null){
					list[j] = new ArrayList<Integer>();
					list[j].add(matrix[i][j]);
					//list.get(j).addAll(cols);
				}
				else
					list[j].add(matrix[i][j]);
				if(i==j)
					trace+=matrix[i][j];
			}
			if(hasDuplcate(matrix[i]))
				row++;
		}
		
		for(ArrayList<Integer> colLs:list){
			if(hasDuplcate(colLs))
				col++;
		}
		
		out.println("Case #" + testNumber + ": " + trace+" "+row+" "+col);
		
	}

	static boolean hasDuplcate(int numbers[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<numbers.length;i++){
			set.add(numbers[i]);
		}
		return set.size()!=numbers.length;
	}
	
	static boolean hasDuplcate(ArrayList<Integer> list) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(Integer num:list)
			set.add(num);
		return set.size()!=list.size();
	}	
	
}