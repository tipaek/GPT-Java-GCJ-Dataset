import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("solution.in"));
		in.nextLine();
		while(in.hasNextLine()){
			String str = in.nextLine();
			String out = "";
			String [] arr = str.split("");
			ArrayList<Integer> array = new ArrayList<Integer>(); 

			for(int i = 0; i < arr.length; i++)
				array.add(Integer.parseInt(arr[i]));
			int opening = 0;
			int closing = array.get(0);
			for(int i = 0; i < array.get(0); i++)
				out+="(";

			for(int i = 0; i < array.size(); i++){
				if(i == array.size() - 1){
					out+=array.get(i);
					for(int p = 0; p < closing; p++)
						out+=")";
				}
				else if(array.get(i+1) > array.get(i)){
					int oploop = array.get(i+1) - array.get(i);

					closing += oploop;
					out+=array.get(i);
					for(int r = 0; r < oploop; r++){
						out+="(";
					}
				}
				else if(array.get(i+1) < array.get(i))
				{
					int clloop = array.get(i) - array.get(i+1);
					closing-=clloop;
					out+=array.get(i);
					for(int j = 0; j < clloop; j++)
						out+=")";
				}
				else if(array.get(i) == array.get(i+1))
				{
					out+=array.get(i);
					continue;
				}
			}
			System.out.println(out);

		}
	}
}