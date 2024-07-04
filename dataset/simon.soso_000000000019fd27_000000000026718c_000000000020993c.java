import java.io.FileNotFoundException;//这个在我的Netbeans上必须添加，�则�能通过编译
import java.io.FileReader;//用这个包装输入文件
import java.io.FileWriter;//用这个包装输出文件
import java.io.IOException;//这个在我的Netbeans上必须添加，�则�能通过编译import java.io.PrintWriter;//这个进行输出��定�，用法跟System.out一样
import java.util.Scanner;//输入�大家都很熟悉了�
import java.math.*;
import java.util.Collections;
import java.util.Vector;

public class Solution {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(System.in));
		PrintStream ps=new PrintStream(new FileOutputStream(System.out));
		System.setOut(ps);
		
		int cnt = sc.nextInt();
		for(int cc=1; cc<=cnt; cc++) {
			String s = sc.next(), t = sc.next();
			System.out.println("Case #" + cc + ": FALSE");
		}
    }
}
