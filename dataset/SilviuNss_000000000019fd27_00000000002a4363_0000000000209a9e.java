import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int T, B, i, j, k, b1, b2, nr_pairs, count, neigh, index;
        boolean end, val_i, val_n, found_dif, final_state;
        char rez;
        BitSet bs;
        Scanner sc = new Scanner(System.in);
        StringBuilder out_bits;
        
        T = sc.nextInt();
        B = sc.nextInt();
        bs = new BitSet(B +  2);
        
        for(k = 1; k <= T; k++) {
            if(B == 10) {
                out_bits = new StringBuilder("");
                for(i = 1; i <= B; i++) {
                    System.out.println(i);
                    System.out.flush();
                    b1 = sc.nextInt();
                    out_bits.append(b1);
                }
                System.out.println(out_bits.toString());
                System.out.flush();
                rez = sc.next().charAt(0);
                if(rez == 'N')
                    break;
                continue;
            }
            bs.clear();
            neigh = 1; index = 1;
            found_dif = false; final_state = false;
            System.out.println(1);
            System.out.flush();
            b1 = sc.nextInt();
            System.out.println(B);
            System.out.flush();
            b2 = sc.nextInt();
            if(b1 != b2)
                found_dif = true;
            bs.set(1, b1 == 1);
            bs.set(B, b2 == 1);
            
            for(i = 2; i <= 5; i++) {
                System.out.println(i);
                System.out.flush();
                b1 = sc.nextInt();
                System.out.println((B - i + 1));
                System.out.flush();            
                b2 = sc.nextInt();
                if(found_dif && b1 == b2) {
                    final_state = true;
                    index = i - 1;
                    neigh = i;
                } else if(!found_dif && b1 != b2) {
                    found_dif = true;
                    final_state = true;
                    index = i;
                    neigh = i - 1;
                }
                bs.set(i, b1 == 1);
                bs.set(B - i + 1, b2 == 1);
            }
            count = 5;
            end = false;
            
            while(!end) {
                val_i = bs.get(index);
                val_n = bs.get(neigh);
                System.out.println(index);
                System.out.flush();
                b1 = sc.nextInt();
                System.out.println(neigh);
                System.out.flush();
                b2 = sc.nextInt();
                if(final_state) {
                    if(((b1 == 0) && val_i) || ((b1 == 1) && !val_i)) {
                        if(((b2 == 0) && val_n) || ((b2 == 1) && !val_n)) {
                            bs.flip(1, count + 1);
                            bs.flip(B - count + 1, B + 1);
                        } else {
                            for(j = 1; j <= count; j++) {
                                boolean baux = bs.get(j);
                                bs.set(j, bs.get(B - j + 1));
                                bs.set(B - j + 1, baux);
                            }
                        }
                    } else if(((b2 == 0) && val_n) || ((b2 == 1) && !val_n)) {
                        bs.flip(1, count);
                        bs.flip(B - count + 1, B + 1);
                        for(j = 1; j <= count; j++) {
                            boolean baux = bs.get(j);
                            bs.set(j, bs.get(B - j + 1));
                            bs.set(B - j + 1, baux);
                        }
                    }
                } else {
                    if(((b1 == 0) && val_i) || ((b1 == 1) && val_i)) {
                        bs.flip(1, count + 1);
                        bs.flip(B - count + 1, B + 1);
                    }
                }
                bs.set(index, b1 == 1);
                bs.set(neigh, b2 == 1);
                
                if(!found_dif)
                    nr_pairs = 5;
                else
                    nr_pairs = 4;
                for(i = 1; i <= nr_pairs; i++) {
                    count++;
                    if(count > B / 2) {
                        end = true;
                        break;
                    }
                    System.out.println(count);
                    System.out.flush();
                    b1 = sc.nextInt();
                    System.out.println(B - count + 1);
                    System.out.flush();
                    b2 = sc.nextInt();
                    if(!final_state) {
                        if(found_dif && b1 == b2) {
                            final_state = true;
                            index = i - 1;
                            neigh = i;
                        } else if(!found_dif && b1 != b2) {
                            final_state = true;
                            index = i;
                            neigh = i - 1;
                        }
                    }
                    bs.set(count, b1 == 1);
                    bs.set(B - count + 1, b2 == 1);
                }
                if(count >= B / 2)
                    end = true;
            }
            out_bits = new StringBuilder("");
            for(i = 1; i <= B; i++) {
                if(bs.get(i))
                    out_bits.append(1);
                else
                    out_bits.append(0);
            } 
            System.out.println(out_bits.toString());
            System.out.flush();
            rez = sc.next().charAt(0);
            if(rez == 'N')
                break;
        }
    }
}
