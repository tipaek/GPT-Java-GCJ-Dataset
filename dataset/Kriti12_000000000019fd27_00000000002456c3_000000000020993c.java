import java.util.Scanner;

class Vestigium{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int t = s.nextInt();
        
        for(int i=1;i<=t;i++){
            int sum=0,rcount=0,colcount=0;
            int n = s.nextInt();
            int M[][]= new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    M[j][k] = s.nextInt();
                    if(j==k)
                        sum+=M[j][k];
                }
            }
            
            for (int k = 0;k<M.length;k++) {
            	for(int j=0;j<M[k].length;j++) {
            		for(int p =j+1;p<M.length;p++) {
            			if(M[k][j]==M[k][p]) {
            				rcount++;
            				break;
            		}
            		}
            		break;
            	}
            }
            
            for (int k = 0;k<M.length;k++) {
            	for(int j=0;j<M[k].length;j++) {
            		for(int p =j+1;p<M.length;p++) {
            			if(M[j][k]==M[p][k]) {
            				colcount++;
            				break;
            		}
            		}
            		break;
            	}
            }
            System.out.println("Case #"+ i +": "+ sum +" "+rcount+" "+colcount);
        }
    }
}