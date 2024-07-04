import java.util.BitSet;
import java.util.Scanner;
import java.util.ArrayList;

class Event {
    int type, pos;

    public Event(int type, int pos) {
        this.type = type;
        this.pos = pos;
    }
}

public class Solution {

    public static void main(String[] args) {
        int T, B, i, j, k, b1, b2, nr_pairs, count, neigh, index;
        boolean end, val_i, val_n, found_dif, final_state;
        char rez;
        ArrayList<Event> events = new ArrayList<>();
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
            neigh = 1; index = 1;
            found_dif = false; final_state = false;
            System.out.println(1);
            System.out.flush();
            b1 = sc.nextInt();
            System.out.println(B);
            System.out.flush();
            b2 = sc.nextInt();
            if(b1 != b2) {
                found_dif = true;
                index = 1;
            }
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
                    final_state = true;
                    index = i;
                    neigh = i - 1;
                }
                bs.set(i, b1 == 1);
                bs.set(B - i + 1, b2 == 1);
            }
            count = 5;
            val_i = bs.get(index);
            val_n = bs.get(neigh);
            end = false;
            while(!end) {
                System.out.println(index);
                System.out.flush();
                b1 = sc.nextInt();
                System.out.println(neigh);
                System.out.flush();
                b2 = sc.nextInt();
                if(final_state) {
                    if(((b1 == 0) && val_i) || ((b1 == 1) && !val_i)) {
                        val_i = !val_i;
                        if(((b2 == 0) && val_n) || ((b2 == 1) && !val_n)) {
                            events.add(new Event(0, count));
                            val_n = !val_n;
                        } else {
                            events.add(new Event(1, count));
                        }
                    } else if(((b2 == 0) && val_n) || ((b2 == 1) && !val_n)) {
                        events.add(new Event(2, count));
                        val_n = !val_n;
                    }
                    bs.set(neigh, b2 == 1);
                } else {
                    if(((b1 == 0) && bs.get(index)) || ((b1 == 1) && !bs.get(index))) {
                        events.add(new Event(0, count));
                        val_i = !val_i;
                    }
                }
                bs.set(index, b1 == 1);
                    
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
                        bs.set(count, b1 == 1);
                        bs.set(B - count + 1, b2 == 1);
                    }
                }
                if(count >= B / 2)
                    end = true;
            }
            for(i = events.size() - 1; i >= 0; i--) {
                Event ev = events.get(i);
                int st = ev.pos + 1;
                int en = B - st + 1;
                if(ev.type % 2 == 0)
                    bs.flip(st, en);
                if(ev.type > 0) {
                    for(j = st; j < en; j++) {
                        boolean baux = bs.get(j);
                        bs.set(j, bs.get(B - j + 1));
                        bs.set(B - j + 1, baux);
                    }
                }
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
