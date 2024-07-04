
import java.util.Scanner;
public class Solution{
 
    static boolean isTrue(String Sum){
                for(int j = 0;j< Sum.length();j++){
                    if(Sum.charAt(j) != '1'){
                        return false;
                    }
                }
            return true;
    }
    
    static String binary(int n){
        if(n<0) {
            n = -n;
        }
        int a = 0;
        String x = "";
         while(n > 0)
        {
            a = n % 2;

            x = a + "" + x;
            n = n / 2;
        }
        return x;
        
    }
    static int nextPowerOf2(int n) 
    { 
        if(n<0){
            n = -n;
        }
        int p = 1; 
        if (n > 0 && (n & (n - 1)) == 0) 
            return n; 
  
        while (p < n)  
            p <<= 1; 
      
        return p; 
    } 
  
    
    public static void main(String[] args){
        Scanner sc= new Scanner (System.in);
        int t = sc.nextInt();
        String res = "";
        for(int i =1;i<=t;i++){
            res = "";
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String Xb = binary(X);
            String Yb = binary(Y);
                int sum = Math.abs(X) + Math.abs(Y);
                String Sum = binary(sum);
                boolean is = isTrue(Sum);
                if(is == true){
                    if(X >=0&&Y>=0){
                        if(Xb.length()>Yb.length()){
                            for(int j =Xb.length()-1;j>= 0;j--){
                                if(Xb.charAt(j) == '1'){
                                    res+= 'E';
                                }else{
                                    res +='N';
                                }
                            }
                        }else{
                            for(int j =Yb.length()-1;j>= 0;j--){
                                if(Yb.charAt(j) == '1'){
                                    res+= 'N';
                                }else{
                                    res +='E';
                                }
                            }
                        }
                        
                    }else if(X>=0 && Y<=0){
                        if(Xb.length()>Yb.length()){
                            for(int j =Xb.length()-1;j>= 0;j--){
                                if(Xb.charAt(j) == '1'){
                                    res+= 'E';
                                }else{
                                    res +='S';
                                }
                            }
                        }else{
                            for(int j =Yb.length()-1;j>= 0;j--){
                                if(Yb.charAt(j) == '1'){
                                    res+= 'S';
                                }else{
                                    res +='E';
                                }
                            }
                        }
                    }
                    else if(X<=0 && Y>=0){
                        if(Xb.length()>Yb.length()){
                            for(int j =Xb.length()-1;j>= 0;j--){
                                if(Xb.charAt(j) == '1'){
                                    res+= 'W';
                                }else{
                                    res +='N';
                                }
                            }
                        }else{
                            for(int j =Yb.length()-1;j>= 0;j--){
                                if(Yb.charAt(j) == '1'){
                                    res+= 'N';
                                }else{
                                    res +='W';
                                }
                            }
                        }
                    }else if (X<=0 && Y<=0){
                        if(Xb.length()>Yb.length()){
                            for(int j =Xb.length()-1;j>= 0;j--){
                                if(Xb.charAt(j) == '1'){
                                    res+= 'W';
                                }else{
                                    res +='S';
                                }
                            }
                        }else{
                            for(int j =Yb.length()-1;j>= 0;j--){
                                if(Yb.charAt(j) == '1'){
                                    res+= 'S';
                                }else{
                                    res +='W';
                                }
                            }
                        }
                    }
                }else{
                    if(isTrue(binary(nextPowerOf2(X) + nextPowerOf2(X) - Math.abs(X) +Math.abs(Y)))){
                        String S = binary(nextPowerOf2(X) + nextPowerOf2(X) - Math.abs(X));
                        if(X >=0&&Y>=0){
                            if(S.length()>Yb.length()){
                                for(int j =S.length()-1;j>= 0;j--){
                                    if(S.charAt(j) == '1'){
                                        if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                            res+= 'E';
                                        }else{
                                            res+='W';
                                        }
                                    }else{
                                        res +='N';
                                    }
                                }
                            }else{
                                for(int j =Yb.length()-1;j>= 0;j--){
                                    if(Yb.charAt(j) == '1'){
                                        res+= 'N';
                                    }else if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='E';
                                    }else{
                                        res+='W';
                                    }
                                }
                            }
                        
                    }else if(X>=0 && Y<=0){
                        if(S.length()>Yb.length()){
                            for(int j =S.length()-1;j>= 0;j--){
                                if(S.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                            res+= 'E';
                                        }else{
                                            res+='W';
                                        }
                                }else{
                                    res +='S';
                                }
                            }
                        }else{
                            for(int j =Yb.length()-1;j>= 0;j--){
                                if(Yb.charAt(j) == '1'){
                                    res+= 'S';
                                }else if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='E';
                                    }else{
                                        res+='W';
                                    }
                            }
                        }
                    }
                    else if(X<=0 && Y>=0){
                        if(S.length()>Yb.length()){
                            for(int j =S.length()-1;j>= 0;j--){
                                if(S.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                            res+= 'W';
                                        }else{
                                            res+='E';
                                        }
                                }else{
                                    res +='N';
                                }
                            }
                        }else{
                            for(int j =Yb.length()-1;j>= 0;j--){
                                if(Yb.charAt(j) == '1'){
                                    res+= 'N';
                                }else if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='W';
                                    }else{
                                        res+='E';
                                    }
                                }
                            }
                        }
                    else if (X<=0 && Y<=0){
                        if(S.length()>Yb.length()){
                            for(int j =S.length()-1;j>= 0;j--){
                                if(S.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                            res+= 'E';
                                        }else{
                                            res+='W';
                                        }
                                }else{
                                    res +='S';
                                }
                            }
                        }else{
                            for(int j =Yb.length()-1;j>= 0;j--){
                                if(Yb.charAt(j) == '1'){
                                    res+= 'S';
                                }else if(binary(nextPowerOf2(X)).length() > j && binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='W';
                                    }else{
                                        res+='E';
                                    }
                                }
                            }
                        }
                    
                    }else if(isTrue(binary(nextPowerOf2(Y) + nextPowerOf2(Y) - Math.abs(Y) +Math.abs(X)))){
                        String R = binary(nextPowerOf2(Y) + nextPowerOf2(Y) - Math.abs(Y));
                        if(X >=0&&Y>=0){
                        if(Xb.length()>R.length()){
                            for(int j =Xb.length()-1;j>= 0;j--){
                                if(Xb.charAt(j) == '1'){
                                    res+= 'E';
                                }else{
                                    if(binary(nextPowerOf2(Y)).length() > j && binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='N';
                                    }else{
                                        res +='S';
                                    }
                                }
                            }
                        }else{
                            for(int j =R.length()-1;j>= 0;j--){
                                if(R.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(Y)).length() > j && binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='N';
                                    }else{
                                        res +='S';
                                    }
                                }else{
                                    res +='E';
                                }
                            }
                        }
                        
                    }else if(X>=0 && Y<=0){
                        if(Xb.length()>R.length()){
                            for(int j =Xb.length()-1;j>= 0;j--){
                                if(Xb.charAt(j) == '1'){
                                    res+= 'E';
                                }else{
                                    if(binary(nextPowerOf2(Y)).length() > j && binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='S';
                                    }else{
                                        res +='N';
                                    }
                                }
                            }
                        }else{
                            for(int j =R.length()-1;j>= 0;j--){
                                if(Yb.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(Y)).length() > j && binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='S';
                                    }else{
                                        res +='N';
                                    }
                                }else{
                                    res +='E';
                                }
                            }
                        }
                    }
                    else if(X<=0 && Y>=0){
                        if(Xb.length()>R.length()){
                            for(int j =Xb.length()-1;j>= 0;j--){
                                if(Xb.charAt(j) == '1'){
                                    res+= 'W';
                                }else{
                                   if(binary(nextPowerOf2(Y)).length() > j && binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='N';
                                    }else{
                                        res +='S';
                                    }
                                }
                            }
                        }else{
                            for(int j =R.length()-1;j>= 0;j--){
                                if(R.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='N';
                                    }else{
                                        res +='S';
                                    }
                                }else{
                                    res +='W';
                                }
                            }
                        }
                    }else if (X<=0 && Y<=0){
                        if(Xb.length()>R.length()){
                            for(int j =Xb.length()-1;j>= 0;j--){
                                if(Xb.charAt(j) == '1'){
                                    res+= 'W';
                                }else{
                                    if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='S';
                                    }else{
                                        res +='N';
                                    }
                                }
                            }
                        }else{
                            for(int j =R.length()-1;j>= 0;j--){
                                if(R.charAt(j) == '1'){
                                   if(binary(nextPowerOf2(Y)).length() > j && binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='S';
                                    }else{
                                        res +='N';
                                    }
                                }else{
                                    res +='W';
                                }
                            }
                        }
                    }
                    }else if(isTrue(binary(nextPowerOf2(X) + nextPowerOf2(X) - Math.abs(X) +nextPowerOf2(Y) + nextPowerOf2(Y) - Math.abs(Y)))){
                        String YY = binary(nextPowerOf2(Y) + nextPowerOf2(Y) -Math.abs(Y));
                        String XX = binary(nextPowerOf2(X) + nextPowerOf2(X) - Math.abs(X));
                        if(X >=0&&Y>=0){
                        if(XX.length()>YY.length()){
                            for(int j =XX.length()-1;j>= 0;j--){
                                if(XX.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='E';
                                    }else{
                                        res +='W';
                                    }
                                }else{
                                    if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='N';
                                    }else{
                                        res +='S';
                                    }
                                }
                            }
                        }else{
                            for(int j =YY.length()-1;j>= 0;j--){
                                if(YY.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='N';
                                    }else{
                                        res +='S';
                                    }
                                }else{
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='E';
                                    }else{
                                        res +='W';
                                    }
                                }
                            }
                        }
                        
                    }else if(X>=0 && Y<=0){
                        if(XX.length()>YY.length()){
                            for(int j =XX.length()-1;j>= 0;j--){
                                if(XX.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='E';
                                    }else{
                                        res +='W';
                                    }
                                }else{
                                    if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='S';
                                    }else{
                                        res +='N';
                                    }
                                }
                            }
                        }else{
                            for(int j =YY.length()-1;j>= 0;j--){
                                if(YY.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='S';
                                    }else{
                                        res +='N';
                                    }
                                }else{
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='E';
                                    }else{
                                        res +='W';
                                    }
                                }
                            }
                        }
                    }
                    else if(X<=0 && Y>=0){
                        if(XX.length()>YY.length()){
                            for(int j =XX.length()-1;j>= 0;j--){
                                if(XX.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='W';
                                    }else{
                                        res +='E';
                                    }
                                }else{
                                   if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='N';
                                    }else{
                                        res +='S';
                                    }
                                }
                            }
                        }else{
                            for(int j =YY.length()-1;j>= 0;j--){
                                if(YY.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='N';
                                    }else{
                                        res +='S';
                                    }
                                }else{
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='W';
                                    }else{
                                        res +='E';
                                    }
                                }
                            }
                        }
                    }else if (X<=0 && Y<=0){
                        if(XX.length()>YY.length()){
                            for(int j =XX.length()-1;j>= 0;j--){
                                if(XX.charAt(j) == '1'){
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='W';
                                    }else{
                                        res +='E';
                                    }
                                }else{
                                    if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='S';
                                    }else{
                                        res +='N';
                                    }
                                }
                            }
                        }else{
                            for(int j =YY.length()-1;j>= 0;j--){
                                if(YY.charAt(j) == '1'){
                                   if(binary(nextPowerOf2(Y)).length() > j &&binary(nextPowerOf2(Y)).charAt(j) == '1'){
                                        res +='S';
                                    }else{
                                        res +='N';
                                    }
                                }else{
                                    if(binary(nextPowerOf2(X)).length() > j &&binary(nextPowerOf2(X)).charAt(j) == '1'){
                                        res +='W';
                                    }else{
                                        res +='E';
                                    }
                                }
                            }
                        }
                    }
                    }else{
                        res = "IMPOSSIBLE";
                    }
                }
                
            

            System.out.println("Case #" + i + ": " + res);
        }
        
        
        
    }
    
    
    
}