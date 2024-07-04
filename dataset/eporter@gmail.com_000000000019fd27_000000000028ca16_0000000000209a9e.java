import java.io.IOException;
import java.util.Scanner;

public class Solution {
    final Scanner in;
    static int b;
    boolean [] arr;
    int known = 0;
    boolean valid = false;
//    BufferedWriter writer;

	public static void main(String [] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
        Solution.run(scanner);
		scanner.close();
	}
    
    public static void run(Scanner in) {
        int cases = in.nextInt();
        b = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            new Solution(in).runCase(cs);
        }
    }
	
	public Solution(Scanner in) {
	    this.in = in;
//	    try {
//            writer = new BufferedWriter(new FileWriter("debug.txt"));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
	}
	
	private void runCase(int cs) {
	    arr = new boolean [b];
	    
	    read(10);
	    
	    while (known < b || !valid) {
	        if (!valid) {
	            validate();
	        } else {
	            int toRead = Math.min(8, b - known);
	            read(toRead);
	            if (toRead == 8) {
	                valid = false;
	            }
	        }
	    }
	    
	    StringBuilder buf = new StringBuilder();
	    for (boolean b : arr) {
	        buf.append(b ? "1" : "0");
	    }
//        try {
//            writer.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
	    println(buf.toString());
	    String judge = in.next();
	    if (!judge.equals("Y")) {
	        System.exit(-1);
	    }
	}
	
	// Always does 2 reads.
	private void validate() {
	    int side = known / 2;
	    boolean checkedComp = false, checkedRev = false;
	    // Check for a complement
	    for (int i = 0; i < side; i++) {
	        boolean low = arr[i];
	        boolean high = arr[b - 1 - i];
	        if (low == high) {
	            boolean res = check(i);
	            if (res != low) {
	                for (int j = 0; j < b; j++) {
	                    arr[j] = !arr[j];
	                }
	            }
                checkedComp = true;
                break;
	        }
	    }
	    if (!checkedComp) {
	        check(1);
	    }
	    
	    // Check for a reverse
	    for (int i = 0; i < side; i++) {
            boolean low = arr[i];
            boolean high = arr[b - 1 - i];
            if (low != high) {
                boolean res = check(i);
                if (res != low) {
                    for (int j = 0; j < b/2; j++) {
                        boolean t = arr[j];
                        arr[j] = arr[b-1-j];
                        arr[b-1-j] = t;
                    }
                }
                checkedRev = true;
                break;
            }
        }
        if (!checkedRev) {
            check(1);
        }
        valid = true;
	}

    private boolean check(int i) {
        println(String.valueOf(i + 1));
        String bit = in.next();
        return bit.equals("1");
    }
	
	private void read(int bits) {
	    int side = bits / 2;
	    int start = known / 2;
	    for (int i = start; i < start + side; i++) {
	        assign(i);
	    }
	    start = b - 1 - known / 2;
	    for (int i = start - side + 1; i <= start ; i++) {
            assign(i);
        }
	    known += bits;
	}

    private void assign(int i) {
        println(String.valueOf(i + 1));
        String bit = in.next();
        arr[i] = bit.equals("1");
//        try {
//            writer.write(i + " = " + bit + "\n");
//            writer.flush();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
    
    private static void println(String s) {
        System.out.println(s);
        System.out.flush();
    }
}
