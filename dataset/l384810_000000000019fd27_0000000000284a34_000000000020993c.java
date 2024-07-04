public class Vestigium {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();	//Number of test cases
		sc.nextLine();
		int trace[] = new int[T];	//Trace of each matrix
		int r[] = new int[T];
		int c[] = new int[T];
		int i = 0;

		while(i < T) {
			
			int N = sc.nextInt();	//Size of the matrix to explore
			sc.nextLine();
			String line[] = new String[N];
			
			for (int j = 0; j < N; j++) {
				line[j] = sc.nextLine();
				// Taking the element j of the line j and adding it to the trace of the matrix
				trace[i] += Integer.parseInt(line[j].split(" ")[j]);
			}
						
			for (int j = 0; j < N; j++) {
				String[] l = line[j].split(" ");
				ArrayList<String> l1 = new ArrayList<String>();
				ArrayList<String> l2 = new ArrayList<String>();
				
				for (int k = 0; k < l.length; k++) {
					if (!(l1.contains(l[k]))) {
						l1.add(l[k]);
					}
					if (!(l2.contains(line[k].split(" ")[j]))) {
						l2.add(line[k].split(" ")[j]);
					}
				}
				if (l1.size() < N)
					r[i]++;
				
				if (l2.size() < N)
					c[i]++;
			}
						
			i++;
		}
		
		for (int j = 0; j < T; j++) {
			System.out.println("Case #" + (j+1) + ": " + trace[j] + " " + r[j] + " " + c[j]);
		}
	}
	
}