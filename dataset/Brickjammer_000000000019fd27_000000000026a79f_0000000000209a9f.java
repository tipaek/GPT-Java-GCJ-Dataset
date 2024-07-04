import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution
{
	private Scanner scanner;
	private InputStream in;
	private PrintStream out;

	public Solution(InputStream in, PrintStream out)
	{
		this.in = in;
		this.out = out;
		this.scanner = new Scanner(in);
	}

	public static void main(String args[])
	{
		Solution nestingdepth = new Solution(System.in, System.out);
		nestingdepth.go();
	}

	public void test(int testNum, String input)
	{
		String output = doTest(input);
		out.println("Case #" + testNum + ": " + output);
	}

	public String doTest(String input)
	{
		input = input.replace("1", "(1)");
		input = input.replace("2", "((2))");
		input = input.replace("3", "(((3)))");
		input = input.replace("4", "((((4))))");
		input = input.replace("5", "(((((5)))))");
		input = input.replace("6", "((((((6))))))");
		input = input.replace("7", "(((((((7)))))))");
		input = input.replace("8", "((((((((8))))))))");
		input = input.replace("9", "(((((((((9)))))))))");

		while (input.contains(")("))
		{
			input = input.replace(")(", "");
		}

		return input;
	}

	void go()
	{
		int tests = scanner.nextInt();

		for (int i = 1; i <= tests; i++)
		{
			String input = scanner.next();
			test(i, input);
		}
	}
}
