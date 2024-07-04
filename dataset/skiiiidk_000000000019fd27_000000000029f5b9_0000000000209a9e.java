import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = scan.nextInt();
        int count = 1;
        int size = scan.nextInt();
        while (t-- > 0) {
            int[] nums = new int[size+1];
            for(int i = 0; i< nums.length; i++){
                nums[i] = -1;
            }

            int query = 0;
            int counter = 0;
            HashMap<Integer, Integer> same = new HashMap<>();
            HashMap<Integer, Integer> diff = new HashMap<>();

            while(query < size/2){
                query++;

                log.write(""+query+"\n");
                log.flush();
                int qans = scan.nextInt();
                nums[query] = qans;

                counter = (counter+1)%10;

                int queryinv = (size+1 - query);
                log.write(""+queryinv+"\n");
                log.flush();
                int qansinv = scan.nextInt();
                nums[queryinv] = qansinv;

                counter = (counter+1)%10;

                if(nums[query] == nums[queryinv]){
                    same.put(query, queryinv);
                }
                else{
                    diff.put(query, queryinv);
                }


                if(counter == 1){
                    if((same.size() == 0 && diff.size() != 0) || (diff.size() == 0 && same.size() != 0)){
                        int ind;
                        if(same.size() != 0){
                            ind = same.keySet().iterator().next();
                        }
                        else{
                            ind = diff.keySet().iterator().next();
                        }

                        log.write(""+ind+"\n");
                        log.flush();
                        int qinans = scan.nextInt();
                        counter = (counter+1)%10;
                        //here

                        log.write(""+ind+"\n");
                        log.flush();
                        int other = scan.nextInt();
                        counter = (counter+1)%10;

                        if(nums[ind] != qinans){
                            for(int i = 1; i<query; i++){
                                nums[i] = nums[i]^1;
                                int o = size +1 -i;
                                nums[o] = nums[o]^1;
                            }
                        }


                    }
                    else if(same.size()!=0 && diff.size()!=0){
                        int sameInd = -1;
                        int diffInd = -1;
                        sameInd = same.keySet().iterator().next();
                        diffInd = diff.keySet().iterator().next();

                        log.write(""+sameInd+"\n");
                        log.flush();
                        int sameAns = scan.nextInt();
                        counter = (counter+1)%10;

                        log.write(""+diffInd+"\n");
                        log.flush();
                        int diffAns = scan.nextInt();
                        counter = (counter+1)%10;


                        if(nums[sameInd] != sameAns && nums[diffInd] != diffAns){
                            //flip bits
                            for(int i = 1; i<query; i++){
                                nums[i] = nums[i]^1;
                                int o = size +1 -i;
                                nums[o] = nums[o]^1;
                            }
                        }
                        else if(nums[sameInd] == sameAns && nums[diffInd] != diffAns){
                            //rev
                            for(int i = 1; i<query; i++){
                                int temp = nums[i];
                                int o = size +1 -i;
                                nums[i] = nums[o];
                                nums[o] = temp;
                            }
                        }
                        else if(nums[sameInd] != sameAns && nums[diffInd] == diffAns){
                            //flip and rev
                            for(int i = 1; i<query; i++){
                                nums[i] = nums[i]^1;
                                int o = size +1 -i;
                                nums[o] = nums[o]^1;
                            }
                            for(int i = 1; i<query; i++){
                                int temp = nums[i];
                                int o = size +1 -i;
                                nums[i] = nums[o];
                                nums[o] = temp;
                            }
                        }

                    }


                }





            }

            for(int i = 1; i<=size; i++){ //size
                log.write(""+nums[i]);
            }


            //put output in them quotes
            log.write("\n");
            log.flush();
            //System.out.println(colRep);
            count++;

            scan.nextLine();
            String res = scan.nextLine();
            if(res.equals("N")){
                System.exit(0);
            }
        }
        System.exit(0);


    }
}
