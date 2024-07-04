

import java.math.BigInteger;
import java.sql.Ref;
import java.util.*;

public class Solution {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        long inputCount = scanner.nextInt();

        for (int c = 0; c < inputCount; c++) {
            System.out.print("Case #" + (c + 1) + ": ");

            Long X = Long.parseLong(scanner.next());
            Long Y = Long.parseLong(scanner.next());
            System.out.println(getPath(X,Y));
        }



    }


    public static String getPath(Long X, Long Y) {
        String toReturn = "IMPOSSIBLE";
        StringBuilder sb = new StringBuilder();
        if (Math.abs(X) % 2 == 1 && (Math.abs(Y) % 2 == 1) || (Math.abs(X) % 2 == 0 && (Math.abs(Y) % 2 == 0))) {
            toReturn = "IMPOSSIBLE";
        } else if (Math.abs(X) % 2 == 1) {
            Long X1 = Math.abs(X) - 1;
            Long Y1 = Math.abs(Y);

            String extra = "E";
            Stack<Long> withSignX = new Stack();
            Stack<Long> withSignY = new Stack();
            Set<Long> setX = getSet(X1, null, withSignX);
            Set<Long> setY = getSet(Y1, setX, withSignY);

            if (setX == null || setY == null) {
                X1 = Math.abs(X) + 1;
                extra = "W";
                withSignX = new Stack();
                withSignY = new Stack();
                setX = getSet(X1, null, withSignX);
                setY = getSet(Y1, setX, withSignY);
            }

            if (setX == null || setY == null) {
                toReturn = "IMPOSSIBLE";
            } else {
                sb = new StringBuilder();
                sb.append(extra);
                while (!withSignX.isEmpty() || !withSignY.isEmpty()) {
                    if ((!withSignX.isEmpty() && !withSignY.isEmpty())) {
                        Long x = withSignX.pop();
                        Long y = withSignY.pop();

                        if (Math.abs(x) < Math.abs(y)) {
                            if (x < 0) {
                                sb.append("W");
                            } else {
                                sb.append("E");
                            }
                            if (y < 0) {
                                sb.append("S");
                            } else {
                                sb.append("N");
                            }
                        }else {
                            if (y < 0) {
                                sb.append("S");
                            } else {
                                sb.append("N");
                            }
                            if (x < 0) {
                                sb.append("W");
                            } else {
                                sb.append("E");
                            }
                        }
                    }else if(!withSignX.isEmpty()) {
                        Long x = withSignX.pop();
                        if (x < 0) {
                            sb.append("W");
                        } else {
                            sb.append("E");
                        }
                    }else if(!withSignY.isEmpty()) {
                        Long y = withSignY.pop();
                        if (y < 0) {
                            sb.append("S");
                        } else {
                            sb.append("N");
                        }
                    }

                }
            }


        } else if (Math.abs(Y) % 2 == 1) {
            Long X1 = Math.abs(X);
            Long Y1 = Math.abs(Y) - 1;

            sb = new StringBuilder();

            String extra = "N";

            Stack<Long> withSignX = new Stack();
            Stack<Long> withSignY = new Stack();
            Set<Long> setX = getSet(X1, null, withSignX);
            Set<Long> setY = getSet(Y1, setX, withSignY);


            if (setX == null || setY == null) {
                Y1 = Math.abs(Y) + 1;
                extra = "S";
                withSignX = new Stack();
                withSignY = new Stack();
                setX = getSet(X1, null, withSignX);
                setY = getSet(Y1, setX, withSignY);
            }

            if (setX == null || setY == null) {
                toReturn = "IMPOSSIBLE";
            } else {
                sb = new StringBuilder();
                sb.append(extra);
                while (!withSignX.isEmpty() || !withSignY.isEmpty()) {
                    if ((!withSignX.isEmpty() && !withSignY.isEmpty())) {
                        Long x = withSignX.pop();
                        Long y = withSignY.pop();

                        if (Math.abs(x) < Math.abs(y)) {
                            if (x < 0) {
                                sb.append("W");
                            } else {
                                sb.append("E");
                            }
                            if (y < 0) {
                                sb.append("S");
                            } else {
                                sb.append("N");
                            }
                        }else {
                            if (y < 0) {
                                sb.append("S");
                            } else {
                                sb.append("N");
                            }
                            if (x < 0) {
                                sb.append("W");
                            } else {
                                sb.append("E");
                            }
                        }
                    }else if(!withSignX.isEmpty()) {
                        Long x = withSignX.pop();
                        if (x < 0) {
                            sb.append("W");
                        } else {
                            sb.append("E");
                        }
                    }else if(!withSignY.isEmpty()) {
                        Long y = withSignY.pop();
                        if (y < 0) {
                            sb.append("S");
                        } else {
                            sb.append("N");
                        }
                    }

                }
            }
        }


        if (!sb.toString().isEmpty()){
            toReturn = sb.toString();
            sb = new StringBuilder();
            for(int i =0 ;i < toReturn.length();i++){

                char c = toReturn.charAt(i);
                if (c=='W' || c=='E'){
                    if (X<0){
                        if (c== 'W'){
                            sb.append('E');
                        }else {
                            sb.append('W');
                        }

                    }else {
                        sb.append(c);
                    }
                }else {
                    if (Y<0){
                        if (c== 'S'){
                            sb.append('N');
                        }else {
                            sb.append('S');
                        }

                    }else {
                        sb.append(c);
                    }
                }
            }

            toReturn = sb.toString();
        }
        return toReturn;
    }


    public static Set<Long> getSet(Long Num, Set<Long> refSet, Stack<Long> withSign) {
        Set<Long> set = new HashSet<>();

        if (refSet == null) {
            refSet = new HashSet<>();
        }

        Boolean gotNegative = false;
        while (Num != 0) {
            Long nPow = Math.round(Math.log((double) Num) / Math.log(2));

            Long negative = (long) Math.pow(2, nPow);
            if (negative == 1) {
                return null;
            }

            if (!set.contains(negative) && !refSet.contains(negative)) {
                if (Num > 0) {
                    Num = Num - negative;

                    withSign.add(negative);

                    if (gotNegative) {
                        break;
                    }
                } else {
                    gotNegative = true;
                    Num = Num + negative;
                    withSign.add(negative * -1);
                }
            } else {
                return null;
            }
            set.add(negative);

        }

        if (Num > 0) {
            return null;
        }

        return set;
    }

}
