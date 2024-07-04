
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		
		String name = reader.readLine();
		String name1 = reader.readLine();
		while(Integer.parseInt(name1)%10 == 1){
		System.out.println(Integer.parseInt(name)%10);
		System.out.flush();
		name1 = reader.readLine();
		}
	}
}
