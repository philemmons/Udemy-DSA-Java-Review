package academy.learnprogramming.challengeThree;

public class Main {

    public static void main(String[] args) {
        String[] stringsArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};


        radixSort(stringsArray, 26, 5);

        for (String s : stringsArray) {
            System.out.println(s);
        }
    }
    public static void radixSort(String[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(String[] input, int position, int radix) {
        position++;
        int numItems = input.length;
        int[] countArray = new int[radix];

        for (String value: input) {
            countArray[getIndex(position, value, radix)]++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j++) {//for (int i = width - 1; i >= 0; i--) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {

            temp[--countArray[getIndex(position, input[tempIndex], radix)]] =
                    input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }

    public static int getIndex(int position, String value, int radix) {
        return (value.charAt(value.length()-position ) -97)  % radix;
    }

    //public static int getIndex(int position, String value) {
    //    return value.charAt(position) - 'a';
    //}

}
