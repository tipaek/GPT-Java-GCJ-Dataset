import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputCount = scanner.nextInt();
        int B = scanner.nextInt();

        for (int c = 0; c < inputCount; c++) {
            String answer = getAnswer( B);
            System.out.println(answer);
            String result = scanner.nextLine();
            if (result.equals("N")){
                break;
            }
        }

    }

    private static String getAnswer(Integer B) {
        int checkIndex1 = 1;
        int checkIndex2 = -1;

        int index1Value;
        int index2Value = -1;

        Integer[] referenceSmallBit;

        int queryCount = 2;
        Boolean mil = false;

        int first = get(1);
        int last = get(B - 1 + 1);

        index1Value = first;

        if (first == last) {
            mil = true;
        }

        int checkFrom = 1;
        while (queryCount <= 148) {

            for (int i = checkFrom; i <= (checkFrom + 4); i++) {
                if (i == 1) continue;
                first = get(i);
                last = get(B - i + 1);
                queryCount += 2;

                if (mil) {
                    if (first != last) {
                        checkIndex2 = i;
                        index2Value = first;
                        break;
                    }
                } else {
                    if (first == last) {
                        checkIndex2 = i;
                        index2Value = first;
                        break;
                    }
                }


            }
            checkFrom = checkFrom + 5;
            if ((checkFrom + 4) > B) {
                break;
            }
            if (checkIndex2 != -1) {
                break;
            }
        }


        Integer[] output = new Integer[B];

        if (checkIndex2 != -1) {

            if (queryCount >= 11) {
                if (queryCount % 10 == 0) {
                    index1Value = get(checkIndex1);
                    index2Value = get(checkIndex2);

                    queryCount += 2;
                } else {
                    index1Value = get(checkIndex1);
                    queryCount++;
                }
            }

            output[checkIndex1 - 1] = index1Value;
            output[checkIndex2 - 1] = index2Value;

            referenceSmallBit = getSmallBits(mil, index1Value, index2Value);

            int status = 0;

            int index = 2;
            while (queryCount <= 147) {

                if (queryCount % 10 == 0) {
                    int newCurrentVal1 = get(checkIndex1);
                    int newCurrentVal2 = get(checkIndex2);
                    queryCount += 2;

                    Integer[] currentSmallBit = getSmallBits(mil, newCurrentVal1, newCurrentVal2);
                    status = getStatus(referenceSmallBit, currentSmallBit);
                }

                int val;
                switch (status) {
                    case 0:
                        if (index != checkIndex2) {
                            val = get(index);
                            queryCount++;
                            output[index - 1] = val;
                        }
                        index++;
                        break;
                    case 1:
                        if (index != checkIndex2) {
                            val = get(index);
                            queryCount++;
                            output[index - 1] = val == 1 ? 0 : 1;
                        }
                        index++;
                        break;
                    case 2:
                        if (index != checkIndex2) {
                            val = get(B - index + 1);
                            queryCount++;
                            output[index - 1] = val;
                        }
                        index++;
                        break;
                    case 3:
                        if (index != checkIndex2) {
                            val = get(B - index + 1);
                            queryCount++;
                            output[index - 1] = val == 1 ? 0 : 1;
                        }
                        index++;
                        break;
                    default:
                }

                if (index > B) {
                    break;
                }

            }

            switch (status) {
                case 0:
                    break;
                case 1:
                    output = getComplement(output);
                    break;
                case 2:
                    output = getReverse(output);
                    break;
                case 3:
                    output = getComplement(output);
                    output = getReverse(output);
                    break;
                default:
            }

        } else {
            // XXXX
            if (queryCount >= 11) {
                if (queryCount % 10 == 0) {
                    index1Value = get(1);
                    index2Value = get(2);
                    queryCount += 2;
                } else {
                    index1Value = get(1);
                    queryCount++;
                }
            }

            output[0] = index1Value;
            output[1] = index2Value;

            referenceSmallBit = getSmallBits(mil, index1Value, index2Value);

            int status = 0;

            int index = 2;
            while (queryCount <= 147) {

                if (queryCount % 10 == 0) {
                    int newCurrentVal1 = get(1);
                    int newCurrentVal2 = get(2);
                    queryCount += 2;

                    Integer[] currentSmallBit = getSmallBits(mil, newCurrentVal1, newCurrentVal2);
                    status = getStatus(referenceSmallBit, currentSmallBit);
                }

                int val;
                switch (status) {
                    case 0:
                        if (index != checkIndex2) {
                            val = get(index);
                            queryCount++;
                            output[index - 1] = val;
                        }
                        index++;
                        break;
                    case 1:
                        if (index != checkIndex2) {
                            val = get(index);
                            queryCount++;
                            output[index - 1] = val == 1 ? 0 : 1;
                        }
                        index++;
                        break;
                    default:
                }

                if (index > B) {
                    break;
                }

            }


            switch (status) {
                case 0:
                    break;
                case 1:
                    output = getComplement(output);
                    break;
                case 2:
                    output = getReverse(output);
                    break;
                case 3:
                    output = getComplement(output);
                    output = getReverse(output);
                    break;
                default:
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<output.length;i++){
            sb.append(output[i]);
        }
        return sb.toString();
    }

    public static Integer[] getComplement(Integer[] output) {
        for (int i = 0; i < output.length; i++) {
            if (output[i] == 0) {
                output[i] = 1;
            } else {
                output[i] = 0;
            }
        }
        return output;
    }

    public static Integer[] getReverse(Integer[] output) {
        Integer[] newStore = new Integer[output.length];
        for (int i = 0; i < output.length; i++) {
            newStore[output.length - 1 - i] = output[i];
        }
        return newStore;
    }

    public static Integer[] getSmallBits(Boolean mil, int value1, int value2) {
        Integer[] smallBitsR = new Integer[4];

        smallBitsR[0] = value1;
        smallBitsR[1] = value2;
        smallBitsR[0] = value1;
        smallBitsR[1] = value2;

        if (mil) {

            smallBitsR[3] = value1;
            smallBitsR[2] = (value2 == 0) ? 1 : 0;
        } else {
            smallBitsR[3] = (value1 == 0) ? 1 : 0;
            smallBitsR[2] = value2;
        }
        return smallBitsR;
    }

    public static int getStatus(Integer[] ref, Integer[] current) {
        boolean same = true;
        boolean c = true;
        boolean r = true;
        boolean rc = true;
        for (int i = 0; i < 4; i++) {
            if (ref[i] != current[i] && same) {
                same = false;
            }

            if (Math.abs(ref[i] - current[i]) != 1 && c) {
                c = false;
            }
            if (ref[i] != current[3 - i] && r) {
                r = false;
            }

            if (Math.abs(ref[i] - current[3 - i]) != 1 && rc) {
                rc = false;
            }
        }

        if (same) {
            return 0;
        } else if (c) {
            return 1;
        } else if (r) {
            return 2;
        } else if (rc) {
            return 3;
        } else {
            return -1;
        }
    }

    public static int get(int i) {
        System.out.println(i);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
