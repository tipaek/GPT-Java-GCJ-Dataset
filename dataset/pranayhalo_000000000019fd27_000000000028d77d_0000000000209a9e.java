import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner std = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = std.nextInt();
        int b = std.nextInt();

        while (t-- > 0) {

            int[] elems = new int[b+1];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = -1;
            }
            HashMap<Integer, Integer> same = new HashMap<>();
            HashMap<Integer, Integer> diff = new HashMap<>();

            int query1 = 0; //counterpart is n-elemToQuery+1
            int queryNum = 1;
            while(query1 <= b/2) {

                //do two queries together... elemToQuery and
                query1++;
                log.write("" + query1); log.flush();
                int ans = std.nextInt();
                elems[query1] = ans;

                queryNum = (queryNum + 1) % 10; //2, 4, 6, 8, 10

                int query2 = b - query1 + 1;
                log.write("" + query2); log.flush();
                int ans2 = std.nextInt();
                elems[query2] = ans2;

                queryNum = (queryNum + 1) % 10;  //3, 5, 7, 9, 11

                if (elems[query1] == elems[query2]) { //if they are the same element (00, 11) then put the indices in this array...
                    same.put(query1, query2);
                } else {
                    diff.put(query1, query2); //otherwise, they are different
                }

                if (queryNum == 1) {
                    //before the next query, our array will mutate... Let us use 2 queries here to make sure we are fine
                    if ((same.size() > 0 && diff.size() == 0) || (same.size() == 0 && diff.size() > 0)) {
                        //all elements are paired the same
                        int index = -1;
                        if (same.size() > 0) {
                            index = same.keySet().iterator().next();
                        } else {
                            index = diff.keySet().iterator().next();
                        }
                        log.write("" + index);
                        log.flush();
                        int upd = std.nextInt();

                        log.write("" + index);
                        log.flush();
                        int upd2 = std.nextInt(); //useless, just for consistency
                        queryNum += 2;

                        if (elems[index] != upd) {
                            for (int i = 1; i <= query1; i++) {
                                elems[i] = elems[i] ^ 1;
                                elems[b - i + 1] = elems[b - i + 1] ^ 1;
                            }
                        }

                    } else if (same.size() > 0 && diff.size() > 0) {
                        //must determine what exactly happened
                        int same_ind = same.keySet().iterator().next();
                        int diff_ind = diff.keySet().iterator().next();
                        log.write("" + same_ind);
                        log.flush();
                        int upd = std.nextInt();

                        log.write("" + diff_ind);
                        log.flush();
                        int upd2 = std.nextInt(); //useless, just for consistency
                        queryNum += 2;

                        if (elems[same_ind] != upd && elems[diff_ind] != upd2) { //case1
                            for (int i = 1; i <= query1; i++) {
                                elems[i] = elems[i] ^ 1;
                                elems[b - i + 1] = elems[b - i + 1] ^ 1;
                            }
                        } else if (elems[same_ind] == upd && elems[diff_ind] != upd2) { //case2
                            for (int i = 1; i <= query1; i++) {
                                int tmp = elems[i];
                                elems[i] = elems[b - i + 1];
                                elems[b - i + 1] = tmp;
                            }
                        } else if (elems[same_ind] != upd && elems[diff_ind] == upd2) { //case2
                            for (int i = 1; i <= query1; i++) {
                                elems[i] = elems[i] ^ 1;
                                elems[b - i + 1] = elems[b - i + 1] ^ 1;
                            }
                            for (int i = 1; i <= query1; i++) {
                                int tmp = elems[i];
                                elems[i] = elems[b - i + 1];
                                elems[b - i + 1] = tmp;
                            }
                        } else { //case4 (nothing)
                            //NOTHING HAPPENED, SO WE'RE FINE
                        }

                    } else {
                        //NOT POSSIBLE TO GET HERE
                    }

                }
            }
            for (int i = 1; i <= b; i++) {
                log.write("" + elems[i]);
            }
            log.flush();
            std.nextLine();
            char ok = std.nextLine().charAt(0);

            if (ok == 'N') {
                log.close();
                std.close();
                System.exit(0);
            }

        }
        log.close();
        std.close();
        System.exit(0);
    }
}
