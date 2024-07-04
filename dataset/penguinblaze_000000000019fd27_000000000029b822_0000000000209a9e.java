import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
		for(int t = 1; t<=T; t++){
		    
		    int[] bits = new int[B];
		    
		    int firstsame = -1;
		    int firstdiff = -1;
		    
		    for(int i = 0; i < 5; i++){
    			System.out.println(i+1);
    			bits[i] = in.nextInt();
    			System.out.println(B-i);
    			bits[B-i-1] = in.nextInt();

    			if(firstsame == -1 && bits[i] == bits[B-i-1]){
    				firstsame = i;
    			}else if(firstdiff == -1 && bits[i] != bits[B-i-1]){
    				firstdiff = i;
    			}
    		}
    		
    		int step = 10;
    		int idx = 5;
    		boolean fromstart = true;
    		while(!completed(bits)){
    			if(step%10 == 0){
    				int same = -1;
    				int diff = -1;
    				int newsame = -1;
    				int newdiff = -1;
    				if(firstsame != -1){
    					same = bits[firstsame];
    					System.out.println(firstsame+1);
    					newsame = in.nextInt();
    				}
    				if(firstdiff != -1){
    					diff = bits[firstdiff];
    					System.out.println(firstdiff+1);
    					newdiff = in.nextInt();
    				}
    				
    				if(firstsame != -1 && firstdiff == -1){
    					if(same != newsame)
    						negate(bits);
    				}else if(firstsame == -1 && firstdiff != -1){
    					if(diff == newdiff)
    						negate(bits);
    				}else{
    					if(same == newsame && diff == newdiff){ 
    					}else if(same != newsame & diff == newdiff){ 
    						negate(bits);
    						reverse(bits);
    					}else if(same != newsame && diff != newdiff){ 
    						negate(bits);
    					}else{
    						reverse(bits);
    					}
    				}
    			}
    			
    			if(fromstart){
    				System.out.println(idx+1);
    				bits[idx] = in.nextInt();
    			}else{
    				System.out.println(B-idx);
    				bits[B-idx-1] = in.nextInt();
    				if(firstsame == -1 && bits[idx] == bits[B-idx-1]){
    					firstsame = idx;
    				}else if(firstdiff == -1 && bits[idx] != bits[B-idx-1]){
    					firstdiff = idx;
    				}
    				idx++;
    			}
    			
    			step++;
    			fromstart = !fromstart;
    		}
		    
		    String solution = "";
		    for(int b : bits){
		        solution += b;
		    }
		    System.out.println(solution);
		    
		    char next = in.next().charAt(0);
		    if(next == 'N'){
		        System.exit(0);
		    }
		}
    }
    
    static boolean completed(int[] bits){
		for(int b : bits)
			if(b == -1)
				return false;
		return true;
	}
	
	static void reverse(int[] bits){
		for(int i = 0; i < bits.length/2; i++){
			int b = bits[i];
			bits[i] = bits[bits.length-i-1];
			bits[bits.length-i-1] = b;
		}
	}
	
	static void negate(int[] bits){
		for(int i = 0; i < bits.length; i++){
			if(bits[i] != -1)
				bits[i] = 1-bits[i];
		}
	}
}