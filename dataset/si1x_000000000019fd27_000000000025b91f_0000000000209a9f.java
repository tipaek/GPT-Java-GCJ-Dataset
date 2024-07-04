import java.util.Scanner;

public class Solution {
        public static void main(String[] args) {
            StringBuilder stringBuffer = new StringBuilder();
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            int s = 0;
            scanner.nextLine();
            for (int j = 0; j < i; j++) {
                stringBuffer.delete(0, stringBuffer.length());
                String k = scanner.next();
                int[] starts = new int[k.length()];
                int[] ends = new int[k.length()];
                starts[0] = (k.charAt(0) - '0');
                s = starts[0];
                for(int l = 1; l < k.length(); l++){
                    if(k.charAt(l) < k.charAt(l-1)){
                        ends[l] = (k.charAt(l-1)  - '0') - (k.charAt(l)  - '0');
                        s -= ends[l];
                        continue;
                    }
                    if(k.charAt(l) > k.charAt(l-1)){
                        starts[l] = (k.charAt(l) - '0') - s;
                        s += starts[l];
                        continue;
                    }
                }
                ends[k.length() - 1] = s;

                for(int h = 0; h < k.length(); h++){
                    if(starts[h] != 0 && ends[h] == 0){
                        for(int c = 0; c < starts[h]; c++){
                            stringBuffer.append('(');
                        }
                        stringBuffer.append(k.charAt(h));
                    } else if(ends[h] != 0 && starts[h] == 0){
                        for(int c = 0; c < ends[h]; c++){
                            stringBuffer.append(')');
                        }
                        stringBuffer.append(k.charAt(h));
                    } else if(ends[h] != 0 && starts[h] != 0){
                        for(int c = 0; c < starts[h]; c++){
                            stringBuffer.append('(');
                        }
                        stringBuffer.append(k.charAt(h));
                        for(int c = 0; c < ends[h]; c++){
                            stringBuffer.append(')');
                        }
                    }else {
                        stringBuffer.append(k.charAt(h));
                    }
                }
                System.out.println("\n" + "Case #" + (j+1) + ":" + ' ' + stringBuffer.toString());
            }
        }
}
