import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t = 0; t < T; t ++) {
            int N = in.nextInt();
            in.nextLine();
            String resStart = "";
            List<String> midRes = new ArrayList<>();
            String resEnd = "";

            boolean notValid = false;
            for (int i = 0; i < N; i++) {
                String mask = in.nextLine().trim();
//                System.out.println(mask);
//                int astPos = mask.index('*');

                if (notValid) {
                    continue;
                }

                int p = -1;
                int startFrom = 0;
                while (true) {
                    int astPos = -1;
                    for (int j = startFrom; j < mask.length(); j++) {
                        if (mask.charAt(j) == '*') {
                            astPos = j;
                            break;
                        }
                    }

                    if (astPos == -1) {
                        if (resEnd.length() > mask.length() - startFrom - 1) {
                            if (!resEnd.endsWith(mask.substring(startFrom))) {
                                notValid = true;
                            }

                        } else {
                            if (!mask.substring(startFrom).endsWith(resEnd)) {
                                notValid = true;
                            }

                            resEnd = mask.substring(startFrom);
                        }

                        break;
                    }

                    if (p == -1) {
                        if (resStart.length() > astPos) {
                            if (!resStart.startsWith(mask.substring(0, astPos))) {
                                notValid = true;
                                break;
                            }
                        } else {
                            if (!mask.substring(0, astPos).startsWith(resStart)) {
                                notValid = true;
                                break;
                            }

                            resStart = mask.substring(0, astPos);
                        }
                    } else {

//                        if (startFrom - astPos == 0) {
//                            continue;
//                        }

                        boolean contains = false;
                        for (int j = 0; j < midRes.size(); j++) {
                            if (midRes.get(j).contains(mask.substring(startFrom, astPos))) {
                                contains = true;
                                break;
                            } else if (mask.substring(startFrom, astPos).contains(midRes.get(j))) {
                                contains = true;
                                midRes.set(i, mask.substring(startFrom, astPos));
                                break;
                            }

                        }

                        if (!contains) {
                            midRes.add(mask.substring(startFrom, astPos));
                        }
                    }

                    if(notValid) {
                        break;
                    }

                    p++;
                    startFrom = astPos + 1;
                    if (startFrom > mask.length() - 1) {
                        break;
                    }
                }
//
//                if (astPos != mask.length() - 1) {
//                    if (resEnd.length() > mask.length() - astPos - 1) {
//                        if(!resEnd.endsWith(mask.substring(1))) {
//                            notValid = true;
//                            break;
//                        }
//                    } else {
//                        if (!mask.endsWith(resEnd)) {
//                            notValid = true;
//                            break;
//                        }
//
//                        resEnd = mask.substring(astPos + 1);
//                    }
//                }
//
//                if (astPos != 0) {
//                    if (resStart.length() > astPos) {
//                        if(!resStart.startsWith(mask.substring(0, astPos))) {
//                            notValid = true;
//                            break;
//                        }
//                    } else {
//                        if (!mask.startsWith(resStart)) {
//                            notValid = true;
//                            break;
//                        }
//
//                        resStart = mask.substring(0, astPos);
//                    }
//                }
            }

            if (notValid) {
                System.out.println("*");
            } else {
                System.out.println(resStart + String.join("", midRes)+ resEnd);
            }
        }
    }
}