import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

	public static void main(String args[]) {
// 		getDataFromFile();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int it=1;
		while (t-- > 0) {
			String S;
			S=in.next();
			S+="0";
			String answer="";
			int depth=0;
			for(int i=0;i<S.length();i++)
			{
				
				int temp=S.charAt(i)-48;
				if(temp>depth)
				{
					for(int j=0;j<(temp-depth);j++)
					{
						answer+="(";
					}
					depth = temp;
					answer+=temp;
				}
				else if(temp==depth)
				{
					answer+=temp;
				}
				else if(temp<depth)
				{	
					for (int j = 0; j < (depth - temp); j++) {
						answer += ")";
					}
					answer+=temp;
					depth = temp;
				}
				
			}
			System.out.println("Case #"+(it++)+": "+answer.substring(0,answer.length()-1));
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