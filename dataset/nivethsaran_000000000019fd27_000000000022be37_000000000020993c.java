import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

	public static void main(String args[]) {
		//getDataFromFile();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int it=1;
		while (t-- > 0) {
			int n=in.nextInt();
			int a[][]=new int[n][n];
			int k=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j]=in.nextInt();
					if(i==j)
					{
						k+=a[i][j];
					}
				}
			}
			int r=0;
			Set<Integer> set;			
			for(int i=0;i<n;i++)
			{
				set=new TreeSet<Integer>();
				for(int j=0;j<n;j++)
				{
					if(set.contains(a[i][j]))
					{
						r++;
						break;
					}
					else
					{
						set.add(a[i][j]);
					}
				}
			}
			int c=0;
			for (int i = 0; i < n; i++) {
				set = new TreeSet<Integer>();
				for (int j = 0; j < n; j++) {
					if (set.contains(a[j][i])) {
						c++;
						break;
					} else {
						set.add(a[j][i]);
					}
				}
			}
			System.out.println("Case #"+(it++)+": "+k+" "+r+" "+c);
		}
		in.close();
	}



	static void getDataFromFile() {
		try {
			FileInputStream fin = new FileInputStream(new File("input.txt"));

			InputStream cin = System.in;
			System.setIn(fin);
			PrintStream o = null;
			PrintStream err = null;
			o = new PrintStream(new File("output.txt"));
			err = new PrintStream(new File("error.txt"));
			PrintStream console = System.out;
			System.setOut(o);
			System.setErr(err);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}