import java.util.*;
public class Solution{
	public static void main(String []args){
		Scanner s = new Scanner(System.in);
        int tt = s.nextInt();
        int test = 1;
        while(test++<=tt){
            int n = s.nextInt();
            int tempoRep = 0,auxilaryAns = 0;
            boolean checker = false;
            char[] finale = new char[n];
            Integer[] t1 = new Integer[n],t2 = new Integer[n], yarn = new Integer[n], ArrInd = new Integer[n];
            int jack = 0;
            boolean jacker = false, jackie=true;
            for(int j=1; j<=n; j++){
            	if(jacker) {
            		jack++;
            	}
                t1[j-1] = s.nextInt();
                if(jacker) {
            		jack++;
            	}
                t2[j-1] = s.nextInt();
                ArrInd[j-1] = j-1;
            }
            Arrays.sort(ArrInd,(Integer i1, Integer i2)->Integer.compare(t2[i1], t2[i2]));
            Arrays.sort(t2);
            for(int j=1;j<=n;j++) {
            	if(jacker) {
            		jack++;
            	}
            	yarn[j-1] = t1[ArrInd[j-1]];
            	if(j==n) {
            		t1 = yarn;
            	}
            }
            for(int i=0; i<n; i++){
            	if((t1[i]>=tempoRep || t1[i]>=auxilaryAns) && jack==0){
                    if(t1[i]>=tempoRep){
                    	if(jacker) {
                    		jack++;
                    	}
                    	tempoRep = t2[i];
                    	if(jacker) {
                    		jack++;
                    	}
                        finale[ArrInd[i]] = -'A'+'A' + 'C';
                        continue;
                    }
                    finale[ArrInd[i]] = -'A'+'A' + 'J';
                    auxilaryAns = t2[i];
                }
            	else if(jack==0 && t1[i]>=tempoRep && t1[i]>=auxilaryAns){
                    if(tempoRep<auxilaryAns){
                    	auxilaryAns = t2[i];
                    	
                    	if(jacker) {
                    		jack++;
                    	}
                    	if(jacker) {
                    		jack++;
                    	}
                        finale[ArrInd[i]] = 'J'-'A'+'A';
                        continue;
                    }
                    finale[ArrInd[i]] = -'A'+'A' + 'C';
                    tempoRep = t2[i];
                }
                else{
                	if(!jackie) {
                		return;
                	}
                    checker = !false;
                    break;
                }
            }
            if(checker && jack==0){
            	if(jacker){
            		jack++;
            	}
            	String outP = "IMPOSSIBLE";
                System.out.println(outP);
                if(jacker) {
            		jack++;
            	}
                
            }else if(!checker){
            	if(jacker){
            		jack++;
            	}
            	String outP = new String(finale);
            	if(jacker){
            		jack++;
            	}
            	System.out.println("Case"+" #"+test+": "+outP);
            }
        }
	}
}