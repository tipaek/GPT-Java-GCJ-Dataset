import java.util.*;
class codejam {
    Scanner sc = new Scanner(System.in);
    void main(){
        int testcases = sc.nextInt();
        //check limitation
        if (testcases>=1 && testcases<=100){
            for (int i=0; i<testcases; i++){
                boolean ab = false;
                //accept the size of matrix
                int size = sc.nextInt();
                //check limitation
                if(size>=2 && size<=100){
                    int a[][] = new int[size][size];
                    //now accept matrix
                    for(int j=0; j<size; j++){
                        for(int k=0; k<size; k++){
                            int m = sc.nextInt();
                            //check limitation
                            if(m>=1 && m<=size)
                                a[j][k] = m;
                            else
                            	System.exit(0);
                        }
                    }
                    int z=0;
                    for(int j=0; j<size; j++){
                        for(int k=0; k<size; k++){
                            if(j==k)
                                z += a[j][k];
                        }
                    }
                    int r=0;
                    for(int j=0; j<size; j++){
                        ab = false;
                        for(int k=0; k<size; k++){
                            for(int l=k; l<size-1; l++){
                                if(a[j][k] == a[j][l+1]){
                                    r += 1;
                                    ab = true;
                                    break;
                                }    
                            }
                            if(ab)
                                    break;
                        }
                    }
                    int c = 0;
                    for(int j=0; j<size; j++){
                        ab = false;
                        for(int k=0; k<size; k++){
                            for(int l=k; l<size-1; l++){
                                if(a[k][j] == a[l+1][j]){
                                    c += 1;
                                    ab = true;
                                    break;
                                }
                            }
                            if(ab)
                                break;
                        }
                    }
                    System.out.println("Case #" + (i+1) + ": " + z + " " + r + " " + c);
                }
                else
                	System.exit(0);
            }
        }
        else
        	System.exit(0);
    }
}