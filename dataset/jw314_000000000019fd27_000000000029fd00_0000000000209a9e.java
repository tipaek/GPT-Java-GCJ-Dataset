import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        //Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        int b = scan.nextInt();
        List<Integer> bits = new ArrayList<Integer>();
        for(int i = 0; i < b; i++){
            bits.add(-1);
        }
        for(int testNum = 0; testNum < tests; testNum++){
            for(int i = 0; i < b; i++){
                bits.set(i, -1);
            }
            int cycle = 0;
            //GET SIGNATURE
            int aInd = -1;
            int aTyp = 0;
            int bInd = -1;
            int bTyp = 0;
            
            for(int i = 0; i < b/2; i++){
                if(cycle >= 10){
                    cycle -= 10;
                    if(aInd != -1){
                        System.out.println(aInd+1);
                        aTyp = scan.nextInt();
                        System.out.println(1);//dummy; all cycles come in pairs
                        int dummy = scan.nextInt();
                        cycle += 2;
                    }
                    if(bInd != -1){
                        System.out.println(bInd+1);
                        bTyp = scan.nextInt();
                        System.out.println(1);//dummy; all cycles come in pairs
                        int dummy = scan.nextInt();
                        cycle += 2;
                    }
                }
                cycle += 2;
                System.out.println(i+1);
                int n1 = scan.nextInt();
                System.out.println(b-i);
                int n2 = scan.nextInt();
                if(n1 == n2){
                    if(aInd == -1){
                        aTyp = n1;
                        aInd = i;
                    }
                }else{
                    if(bInd == -1){
                        bTyp = n1;
                        bInd = i;
                    }
                }
                if(aInd != -1 && bInd != -1){
                    break;
                }
            }
            if(aInd != -1 && bInd != -1){
                for(int i = 0; i < b/2; i++){
                    if(cycle >= 10){
                        cycle -= 10;
                        //CHECK SIGNATURES
                        System.out.println(aInd);
                        int n1 = scan.nextInt();
                        System.out.println(bInd);
                        int n2 = scan.nextInt();
                        cycle += 2;
                        if(n1 == aTyp){
                            if(n2 == bTyp){
                                //NOTHING
                            }else{
                                //REVERSE ORDER
                                for(int j = 0; j < b/2; j++){
                                    int temp = bits.get(j);
                                    bits.set(j, bits.get(b-j-1));
                                    bits.set(b-j-1, temp);
                                }
                            }
                        }else{
                            if(n2 == bTyp){
                                //DO BOTH
                                for(int j = 0; j < b/2; j++){
                                    int temp = bits.get(j);
                                    bits.set(j, bits.get(b-j-1));
                                    bits.set(b-j-1, temp);
                                }
                                for(int bit : bits){
                                    if(bit == 1){
                                        bit = 0;
                                    }else{
                                        bit = 1;
                                    }
                                }                                
                            }else{
                                //FLIP BITS
                                for(int bit : bits){
                                    if(bit == 1){
                                        bit = 0;
                                    }else{
                                        bit = 1;
                                    }
                                }
                            }                            
                        }
                        aTyp = n1;
                        bTyp = n2;
                    }
                    if(i != aInd && i != bInd){
                        if(i < bInd){
                            System.out.println(i+1);
                            int n1 = scan.nextInt();
                            bits.set(i, n1);
                            bits.set(b-i-1, n1); //a-index; same
                            i++; //go onto the next iteration
                            System.out.println(i+1);
                            n1 = scan.nextInt();
                            bits.set(i, n1);
                            bits.set(b-i-1, n1); //a-index; same                            
                        }else if (i < aInd){
                            System.out.println(i+1);
                            int n1 = scan.nextInt();
                            bits.set(i, n1);
                            if(n1 == 1){
                                n1 = 0;
                            }else{
                                n1 = 1;
                            }
                            bits.set(b-i-1, n1); //b-index; diff
                            i++; //go onto the next iteration
                            System.out.println(i+1);
                            n1 = scan.nextInt();
                            bits.set(i, n1);
                            if(n1 == 1){
                                n1 = 0;
                            }else{
                                n1 = 1;
                            }
                            bits.set(b-i-1, n1); //b-index; diff                           
                        }else{
                            System.out.println(i+1);
                            int n1 = scan.nextInt();
                            System.out.println(b-i);
                            int n2 = scan.nextInt();
                            bits.set(i, n1);
                            bits.set(b-i-1, n2);
                        }
                        cycle+=2;
                    }
                }
                //CHECK AGAIN FOR CYCLE
                if(cycle >= 10){
                    cycle -= 10;
                    //CHECK SIGNATURES
                    System.out.println(aInd);
                    int n1 = scan.nextInt();
                    System.out.println(bInd);
                    int n2 = scan.nextInt();
                    cycle += 2;
                    if(n1 == aTyp){
                        if(n2 == bTyp){
                            //NOTHING
                        }else{
                            //REVERSE ORDER
                            for(int j = 0; j < b/2; j++){
                                int temp = bits.get(j);
                                bits.set(j, bits.get(b-j-1));
                                bits.set(b-j-1, temp);
                            }
                        }
                    }else{
                        if(n2 == bTyp){
                            //DO BOTH
                            for(int j = 0; j < b/2; j++){
                                int temp = bits.get(j);
                                bits.set(j, bits.get(b-j-1));
                                bits.set(b-j-1, temp);
                            }
                            for(int bit : bits){
                                if(bit == 1){
                                    bit = 0;
                                }else{
                                    bit = 1;
                                }
                            }                                
                        }else{
                            //FLIP BITS
                            for(int bit : bits){
                                if(bit == 1){
                                    bit = 0;
                                }else{
                                    bit = 1;
                                }
                            }
                        }                            
                    }
                    aTyp = n1;
                    bTyp = n2;
                }
                System.out.println(aInd);
                int n1 = scan.nextInt();
                System.out.println(bInd);
                int n2 = scan.nextInt();
                bits.set(aInd, n1);
                bits.set(b-aInd-1, n1);
                bits.set(bInd, n2);
                if(n2 == 1){
                    n2 = 0;
                }else{
                    n2 = 1;
                }
                bits.set(b-bInd-1, n2);
                cycle+=2;
            }
            else if(bInd == -1){
                //ALL A INDEX
                for(int i = 0; i < b/2; i++){
                    if(cycle >= 10){
                        cycle -= 10;
                        //CHECK SIGNATURES
                        System.out.println(aInd);
                        int n1 = scan.nextInt();
                        cycle += 2;
                        if(n1 == aTyp){
                            //NOTHING
                        }else{
                            //FLIP BITS
                            for(int bit : bits){
                                if(bit == 1){
                                    bit = 0;
                                }else{
                                    bit = 1;
                                }
                            }                           
                        }
                        aTyp = n1;
                    }
                    if(i != aInd){
                        System.out.println(i+1);
                        int n1 = scan.nextInt();
                        bits.set(i, n1);
                        bits.set(b-i-1, n1); //a-index; same
                        i++; //go onto the next iteration
                        System.out.println(i+1);
                        n1 = scan.nextInt();
                        bits.set(i, n1);
                        bits.set(b-i-1, n1); //a-index; same                            
                        cycle+=2;
                    }
                }
                //CHECK AGAIN FOR CYCLE
                if(cycle >= 10){
                    cycle -= 10;
                    //CHECK SIGNATURES
                    System.out.println(aInd);
                    int n1 = scan.nextInt();
                    cycle += 2;
                    if(n1 == aTyp){
                        //NOTHING
                    }else{
                        //FLIP BITS
                        for(int bit : bits){
                            if(bit == 1){
                                bit = 0;
                            }else{
                                bit = 1;
                            }
                        }                           
                    }
                    aTyp = n1;
                }
                System.out.println(aInd);
                int n1 = scan.nextInt();
                bits.set(aInd, n1);
                bits.set(b-aInd-1, n1);
            }else{
                //ALL B INDEX
                for(int i = 0; i < b/2; i++){
                    if(cycle >= 10){
                        cycle -= 10;
                        //CHECK SIGNATURES
                        System.out.println(bInd);
                        int n1 = scan.nextInt();
                        cycle += 2;
                        if(n1 == bTyp){
                            //NOTHING
                        }else{
                            //FLIP BITS
                            for(int bit : bits){
                                if(bit == 1){
                                    bit = 0;
                                }else{
                                    bit = 1;
                                }
                            }                           
                        }
                        bTyp = n1;
                    }
                    if(i != bInd){
                        System.out.println(i+1);
                        int n1 = scan.nextInt();
                        bits.set(i, n1);
                        if(n1 == 1){
                            n1 = 0;
                        }else{
                            n1 = 1;
                        }
                        bits.set(b-i-1, n1); //b-index; diff
                        i++; //go onto the next iteration
                        System.out.println(i+1);
                        n1 = scan.nextInt();
                        bits.set(i, n1);
                        if(n1 == 1){
                            n1 = 0;
                        }else{
                            n1 = 1;
                        }
                        bits.set(b-i-1, n1); //b-index; diff                           
                        cycle+=2;
                    }
                }
                //CHECK AGAIN FOR CYCLE
                if(cycle >= 10){
                    cycle -= 10;
                    //CHECK SIGNATURES
                    System.out.println(bInd);
                    int n1 = scan.nextInt();
                    cycle += 2;
                    if(n1 == bTyp){
                        //NOTHING
                    }else{
                        //FLIP BITS
                        for(int bit : bits){
                            if(bit == 1){
                                bit = 0;
                            }else{
                                bit = 1;
                            }
                        }                           
                    }
                    bTyp = n1;
                }
                System.out.println(bInd);
                int n2 = scan.nextInt();
                bits.set(bInd, n2);
                if(n2 == 1){
                    n2 = 0;
                }else{
                    n2 = 1;
                }
                bits.set(b-bInd-1, n2);
                cycle+=2;
            }
            String out = "";
            for(int i = 0; i < b; i++){
                String temp = Integer.toString(bits.get(i));
                out = out.concat(temp);
            }
            System.out.println(out);
            String resp = scan.next();
            if(resp == "N"){
                break;
            }
        }
    }
    
}