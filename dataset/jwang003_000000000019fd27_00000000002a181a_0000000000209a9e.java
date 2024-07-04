import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] info = in.nextLine().split(" ");
        int cases = Integer.parseInt(info[0]);
        int size = Integer.parseInt(info[1]);
        for (int i = 0; i < cases; i++) {
            if (size == 10) {
                StringBuilder bitArray = new StringBuilder();
                for (int j = 1; j <= 10; j++) {
                    System.out.println(j);
                    bitArray.append(Integer.parseInt(in.nextLine()));
                }
                System.out.println(bitArray.toString());
                if (in.nextLine().equals("Y")) {
                    continue;
                } else {
                    System.out.println("Wrong Answer");
                }
            } else if (size == 20) {
                StringBuilder bitArray = new StringBuilder();
                int[] order = new int[size];
                boolean sames = false, diff = false;
                int[] checkers = new int[4];
                //do the first ten
                for (int j = 1; j <= 10; j++) {
                    System.out.println((j%2==0)? (size - j/2+1) : Math.floor(j/2)+1);
                    order[j-1] = Integer.parseInt(in.nextLine());
                    if (j%2==0) {
                        if ((order[j-1] == order[j-2]) && !sames) {
                            sames = true;
                            checkers[0] = j/2;
                            checkers[1] = size - j/2 + 1;
                        } else if ((order[j-1] != order[j-2]) && !diff) {
                            diff = true;
                            checkers[2] = j/2;
                            checkers[3] = size - j/2 + 1;
                        }
                    }
                }
                int result = evaluate(checkers, order, sames, diff);
                order = changes(order, result);

                int count = 11;
                while (count <= size) {
                    if ((count-10)%6 == 1 && count >16) {
                        result = evaluate(checkers, order, sames, diff);
                        order = changes(order, result);
                    }
                    System.out.println(((count)%2==0)? (size - count/2 + 1) : count/2+1);
                    order[count - 1] = Integer.parseInt(in.nextLine());

                    if (count%2==0 && ((!sames) || (!diff))) {
                        if ((order[count-1] == order[count-2]) && !sames) {
                            sames = true;
                            checkers[0] = count/2;
                            checkers[1] = size - count/2 + 1;
                        } else if ((order[count-1] != order[count-2]) && !diff) {
                            diff = true;
                            checkers[2] = count/2;
                            checkers[3] = size - count/2 + 1;
                        }
                    }
                    count++;
                }
                for (int j = 0; j < size; j += 2) {
                    bitArray.append(order[j]);
                }
                for (int j = size - 1; j > 0; j -= 2) {
                    bitArray.append(order[j]);
                }
                System.out.println(bitArray.toString());
                if (in.nextLine().equals("Y")) {
                    continue;
                } else {
                    System.out.println("Wrong Answer");
                    break;
                }
            } else {
                StringBuilder bitArray = new StringBuilder();
                int[] order = new int[size];
                boolean sames = false, diff = false;
                int[] checkers = new int[4];
                //do the first ten
                for (int j = 1; j <= 10; j++) {
                    System.out.println((j%2==0)? (size - j/2+1) : j/2+1);
                    order[j-1] = Integer.parseInt(in.nextLine());
                    if (j%2==0) {
                        if (order[j-1] == order[j-2] && !sames) {
                            sames = true;
                            checkers[0] = j/2;
                            checkers[1] = size - j/2 + 1;
                        } else if (order[j-1] != order[j-2] && !diff) {
                            diff = true;
                            checkers[2] = j/2;
                            checkers[3] = size - j/2 + 1;
                        }
                    }
                }
                int result = evaluate(checkers, order, sames, diff);
                order = changes(order, result);

                int count = 11;
                while (count <= size) {
                    if ((count-10)%6 == 1 && count >16) {
                        result = evaluate(checkers, order, sames, diff);
                        order = changes(order, result);
                    }
                    System.out.println(((count)%2==0)? (size - count/2 + 1) : count/2+1);
                    order[count - 1] = Integer.parseInt(in.nextLine());
                    count++;
                }
                for (int j = 0; j < size; j += 2) {
                    bitArray.append(order[j]);
                }
                for (int j = size - 1; j > 0; j -= 2) {
                    bitArray.append(order[j]);
                }
                System.out.println(bitArray.toString());
                if (in.nextLine().equals("Y")) {
                    continue;
                } else {
                    System.out.println("Wrong Answer");
                    break;
                }
            }
        }
    }

    static int evaluate(int[] check, int[] order, boolean same, boolean diff) {
        Scanner in = new Scanner(System.in);
        int[] newValues = new int[4];
        for (int i = 0; i < 4; i++) {
            if (check[i] == 0) {
                System.out.println(1);
            } else {
                System.out.println(check[i]);
            }
            newValues[i] = Integer.parseInt(in.nextLine());
        }
        if (!same) {
            if (newValues[2] == order[check[2]-1]) {
                return 4;
            } else {
                return 1;
            }
        } else if (!diff) {
            if (newValues[0] == order[check[0]-1]) {
                return 4;
            } else {
                return 1;
            }
        } else {
            if (newValues[0] == order[check[0]] && newValues[2] != order[check[2]]) {
                return 2;
            } else if (newValues[0] != order[check[0]] && newValues[2] != order[check[2]]) {
                return 1;
            } else if (newValues[0] != order[check[0]] && newValues[2] == order[check[2]]) {
                return 3;
            } else {
                return 4;
            }
        }
    }

    static int[] changes(int[] order, int result) {
        switch (result) {
            case 1:
                for (int j = 0; j < order.length; j++) {
                    if (order[j] == 0) {
                        order[j] = 1;
                    } else {
                        order[j] = 0;
                    }
                }
                break;
            case 2:
                for (int j = 0; j < order.length; j+=2) {
                    int temp = order[j];
                    order[j] = order[j+1];
                    order[j+1] = temp;
                }
                break;
            case 3:
                for (int j = 0; j < order.length; j+=2) {
                    if (order[j] == order[j+1]) {
                        if (order[j] == 0) {
                            order[j] = order[j+1] = 1;
                        } else {
                            order[j] = order[j+1] = 0;
                        }
                    }
                }
                break;
            case 4:
                break;
        }
        return order;
    }
}
