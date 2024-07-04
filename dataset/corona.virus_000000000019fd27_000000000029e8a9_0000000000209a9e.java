import java.io.*;
import java.util.*;
public class Solution{
    private final static String w_a="WRONG_ANSWER";
    private final static String c_a="CORRECT";
    private final static String t_s="TOO_SMALL";
    private final static String t_b="TOO_BIG";
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		Scanner input = new Scanner(System.in);
	    String[] in = br.readLine().split(" ");
	    int T = Integer.parseInt(in[0]);
	    int B = Integer.parseInt(in[1]);
		while(T-->0){
			
		    boolean ans = solve(input, B);
		    if(!ans) break;
		   
		    //bw.append("Case #"+(sc++)+": "+solve(events));
		    //if(T>0) bw.append("\n");
		}
		//bw.close();
    }

	private static boolean solve(Scanner input, int b) {
		int P=0;
		int n = b;
		int[] B = new int[b];
		
		int cnt=1; //first trial
		
		int[] one_one = new int[] {-1,-1};
		int[] z_z = new int[] {-1,-1};
		int[] one_z = new int[] {-1,-1};
		
		boolean same_alone=false;
		boolean not_same_alone=false;
		boolean mixed = false;
		
		boolean r_e=true;
		
		while(true) {
			int x1=-1;
			int w=-1;
			if(same_alone) {
				
				
				if(one_one[0]!=-1) {
					x1=one_one[0];
					w=0;
				}
				if(w==-1) {
					x1=z_z[0];
					w=1;
				}
				System.out.println(x1+1);//one index.
				x1=input.nextInt();
				cnt++;//read one.
				if(w==0 && B[one_one[0]]!=x1) {
					complement(B,P-1);
				}else if(w==1 && B[z_z[0]]!=x1) {
					complement(B,P-1);
				}
				same_alone=false;
				
			}else if(not_same_alone) {
				x1=one_z[0];
				System.out.println(x1+1);//1-index
				x1=input.nextInt();
				cnt++;
				if(B[one_z[0]] != x1) {
					complement(B,P-1);
				}
				not_same_alone=false;
			}else if(mixed) {//mixed
				if(one_one[0]!=-1) {
					x1=one_one[0];
					w=0;
				}
				if(w==-1) {
					x1=z_z[0];
					w=1;
				}
				System.out.println(x1+1);//one index.
				x1=input.nextInt();
				cnt++;//read one.
				if(w==0 && B[one_one[0]]!=x1) {
					complement(B,P-1);
				}else if(w==1 && B[z_z[0]]!=x1) {
					complement(B,P-1);
				}else {
					x1=one_z[0];
					System.out.println(x1+1);
					x1=input.nextInt();
					cnt++;
					if(B[one_z[0]] != x1) {
						reverse(B,P-1);
					}
				}
				mixed=false;
			}
			int lim=10-cnt%10+1;
			//System.out.println("aokeke: limit is "+lim);
			while(lim-->0) {
				//read
				if(r_e) System.out.println(P+1);
				else System.out.println(n-P);
				int x = input.nextInt();
				//int x=1;
				cnt++;
				if(2*P <= n-1) {
					if(r_e) {
						B[P]=x;r_e=false;
					}else {
						B[n-P-1]=x;r_e=true;P++;
					}
				}
			}//done reading for this iteration
			if(2*P > n-1) {//try to give final answer
				StringBuilder sb = new StringBuilder();
				for(int t:B) sb.append(t);
				System.out.println(sb.toString());
				if(input.next().equals("Y")) return true;
				return false;
			}//done giving answer return
			
			if(one_one[0]==-1) {
				one_one=find(B, P-1, 1, 1);
			}
			if(z_z[0]==-1) {
				z_z=find(B, P-1, 0, 0);
			}
			if(one_z[0]==-1) {
				one_z=find(B, P-1, 1, 0);
			}
			if(one_z[0]==-1) {
				one_z=find(B, P-1, 0, 1);
			}
			
			if((one_one[0]!=-1 || z_z[0]!=-1) && one_z[0]==-1) {//same_alone
				same_alone=true;
			}else if((one_one[0]==-1 && z_z[0]==-1) && one_z[0]!=-1) {//not_same_alone
				not_same_alone=true;
			}else {//mixed
				mixed=true;
			}
		}
	}

	private static void reverse(int[] B, int p) {
		int n = B.length;
		for(int i=0;i<=p;i++) {
			int tmp = B[i];
			B[i]=B[n-i-1];
			B[n-i-1]=tmp;
		}
		
	}

	private static void complement(int[] B, int p) {
		int n = B.length;
		for(int i=0;i<=p;i++) {
			B[i]=1-B[i];
			B[n-i-1]=1-B[n-i-1];
		}
	}

	private static int[] find(int[] b, int p, int x, int y) {
		int n=b.length;
		for(int i=0;i<=p;i++) {
			if(b[i]==x && b[n-i-1]==y) return new int[] {i,n-i-1};
		}
		return new int[] {-1,-1};
	} 
    
    
}