
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = 10;
		System.out.println(t);
		String name = reader.readLine();
		while(Integer.parseInt(name) == 1){
		System.out.println(Integer.parseInt(name)%10);
		name = reader.readLine();
		}
	}
}
