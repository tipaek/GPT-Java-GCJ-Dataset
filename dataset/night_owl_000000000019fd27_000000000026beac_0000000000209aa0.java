import java.util.Scanner;

class Incidium {
	public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int i,j;
        BigInteger b1, b2;
        int tcase = 1;
        for (;tcase <= testCases; tcase++) {
            i = scanner.nextInt(); b1 = new BigInteger(i);
            j = scanner.nextInt(); b2 = new BigInteger(j);
            b1 = b1.multiply(b1.subtract(1));
            b1 = b1.divide(BigInteger.valueOf(2));
            if(b1.compareTo(b2) == 0) {
                System.out.println("Case #" + tcase +": "+"POSSIBLE");
            } else {
                System.out.println("Case #" + tcase +": "+"IMPOSSIBLE");
            }
        }
    }
}