import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static class Element {

        public int left;
        public int right;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        int task = 1;

        while(task <= test) {

            char[] charInput = br.readLine().toCharArray();

            int[] input = new int[charInput.length];

            for(int i = 0; i < charInput.length; ++ i) {

                input[i] = Integer.parseInt(String.valueOf(charInput[i]));
            }

            StringBuilder builder = new StringBuilder();

            Element[] diff = new Element[input.length];

            for(int i = 0; i < input.length; ++ i) {

                int value = input[i];

                diff[i] = new Element();

                int next = i + 1;
                int previous = i - 1;

                if (previous >= 0) {

                    diff[i].left = Math.abs(input[previous] - value);
                }else {
                    diff[i].left = value;
                }

                if(next < input.length) {

                    diff[i].right = Math.abs(input[next] - value);
                }else {
                    diff[i].right = value;
                }
            }

            for(int i = 0; i < input.length; ++ i) {

                int current = input[i];

                int previous = i - 1;
                int next = i + 1;

                if(previous >= 0) {

                    if(input[previous] < current) {

                        int temp = diff[i].left;

                        while(temp > 0) {

                            builder.append("(");
                            --temp;
                        }
                    }
                }else {

                    int temp = diff[i].left;

                    while(temp > 0) {

                        builder.append("(");
                        --temp;
                    }
                }

                builder.append(current);

                if(next < input.length) {

                    if(input[next] < current) {

                        int temp = diff[i].right;

                        while(temp > 0) {

                            builder.append(")");
                            -- temp;
                        }
                    }
                }else {

                    int temp = diff[i].right;

                    while(temp > 0) {

                        builder.append(")");
                        -- temp;
                    }
                }

            }

            System.out.println("Case #" + task + ": " + builder.toString());

            ++ task;
        }

    }

}
