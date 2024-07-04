import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Vestigium {

	public static void main(String[] args) {
		Vestigium main = new Vestigium();
		try {
			FileReader in_file = new FileReader("input_file.txt");
			BufferedReader buff_in = new BufferedReader(in_file);
			FileWriter out_file = new FileWriter("output_file.txt");
			BufferedWriter buff_out = new BufferedWriter(out_file);
			PrintWriter output = new PrintWriter(buff_out);
			StringTokenizer st = new StringTokenizer(buff_in.readLine());
			int numberTest = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < numberTest; i++) {
				st = new StringTokenizer(buff_in.readLine());
				int size = Integer.parseInt(st.nextToken());
				int test[][] = new int[size][size];
				int trace = 0;
				int rows = 0;
				int column = 0;
				boolean happened = false;
				for (int j = 0; j < size; j++) {
					st = new StringTokenizer(buff_in.readLine());
					ArrayList<Integer> numbers = new ArrayList<Integer>();
					happened = false;
					for (int k = 0; k < size; k++) {
						int curr = Integer.parseInt(st.nextToken());
						if (numbers.contains(curr) && !happened) {
							happened = true;
							rows++;
						}
						numbers.add(curr);
						test[j][k] = curr;
						if (j == k) {
							trace += test[j][k];
						}
					}
				}
				for(int j = 0; j < size; j++) {
					ArrayList<Integer> numbers = new ArrayList<Integer>();
					happened = false;
					for (int k = 0; k < size; k++) {
						int curr = test[k][j];
						if (numbers.contains(curr) && !happened) {
							happened = true;
							column++;
						}
						numbers.add(curr);
					}
				}
				output.println("Case #" + (i+1) + " " + trace + " " + rows + " " + column);
			}

			output.close();
			buff_in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}


}