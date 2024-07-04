
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		System.out.println(t);
		System.out.flush();
		String name = reader.readLine();
		while(Integer.parseInt(name) == 1){
		System.out.println(Integer.parseInt(name)%10);
		System.out.flush();
		name = reader.readLine();
		}
	}
}
