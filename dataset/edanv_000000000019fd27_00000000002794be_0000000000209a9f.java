import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt(),cont=1;
		while (n > 0) {
			String str = sc.next();
			str = str.replace("1", "(1)");
			str = str.replace(")(", "");
			System.out.println("Case #"+cont+": "+str);
			cont++;
			n--;
		}
	}

}