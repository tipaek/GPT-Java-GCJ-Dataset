public class MineMertric {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new FileReader("a2.in")));
		PrintStream ps=new PrintStream(new FileOutputStream("a2.out"));
		System.setOut(ps);
		
		int cnt = sc.nextInt();
		for(int cc=1; cc<=cnt; cc++) {
			String s = sc.next(), t = sc.next();
			System.out.println("Case #" + cc + ": FALSE");
		}
    }
}
