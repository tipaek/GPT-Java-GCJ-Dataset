import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author bytz
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner scanner=new Scanner(System.in);
		Writer writer=new PrintWriter(System.out);
		Integer T=scanner.nextInt();
		for(int t=0;t<T;t++){
			Integer N=scanner.nextInt();
			List<Set<Integer>> rows=new ArrayList<>();
			List<Set<Integer>> columns=new ArrayList<>();
			for(int i=0;i<N;i++){
				rows.add(new HashSet<>());
				columns.add(new HashSet<>());
			}
			Integer k=0,r=0,c=0;
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++){
					Integer M=scanner.nextInt();
					rows.get(i).add(M);
					columns.get(j).add(M);
					if(i==j)
						k+=M;
				}
			for(int i=0;i<N;i++){
				if(rows.get(i).size()<N)r++;
				if(columns.get(i).size()<N)c++;
			}
			writer.write("Case #"+(t+1)+": "+k+" "+r+" "+c);
			writer.write(System.lineSeparator());
			writer.flush();
		}
		writer.close();
		scanner.close();
	}
	
}
