import java.util.Scanner;

class Solution{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<T;i++){
            String S = in.next();
            int lastD =-1;
            String out ="";
            for(int j=0;j<S.length();j++){
                int currD = ((int) S.charAt(j))-48;
                if(lastD==-1){
                    for(int k=0;k<currD;k++){
                        out+='(';
                    }
                    //out+=currD;
                }
                else{
                    if(currD<lastD){
                        for(int k=0;k<lastD-currD;k++){
                        out+=')';
                        }
                    }
                    else if(lastD<currD){
                        for(int k=0;k<currD-lastD;k++){
                        out+='(';
                        }
                    }
                }
                
                out+=currD;
                lastD = currD;
            }
            for(int k=0;k<lastD;k++){
                        out+=')';
            }
            
            
            System.out.println("Case #"+(i+1)+": "+out);
        }
    }
}