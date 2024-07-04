import java.util.Scanner;

public class Practise {
	public static void main(String aa[]) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for(int i = 0;i<t;i++) {
			int N = scan.nextInt();
			int K = scan.nextInt();
			if(verifyPossibleDiagonalSum(N,K))
				System.out.println("Case #"+i+": POSSIBLE");
			else 
				System.out.println("Case #"+i+": IMPOSSIBLE");
		}
	}
	public static boolean verifyPossibleDiagonalSum(int N,int K){
        int sum = 0;
        boolean flag = false;
        if(N==2) {
        	if(K==2||K==4) 
        		flag =true;
        }
        else {
        	for(int i = 1; i <= N; i++){
        		if(K == add(i,N)){
        			flag = true;
        		}
        		sum += i;
        	}
        	if(!flag && K==sum){
        		flag = true;
        	}
        }
        return flag;
    }
     public static int add(int a, int n){
            int add1 = 0;
            for(int j =1;j<=n;j++)
            add1 +=a;
            return add1;
        }
}