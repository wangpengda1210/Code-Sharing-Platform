import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int findIndexOfKMin(int[] numbers, int k) {
        // write your code here
        if (numbers.length == 0) {
            return -1;
        } else {
            int[] sortedNumbers = numbers.clone();
            Arrays.sort(sortedNumbers);
            int min = sortedNumbers[0];

            int count = 0;
            int index = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (min == numbers[i]) {
                    count++;
                    if (count == k) {
                        index = i;
                        break;
                    }
                }
            }

            if (count == k) {
                return index;
            } else {
                return -1;
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int k;
        final int[] numbers;
        if (scanner.hasNextInt()) {
            numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            k = Integer.parseInt(scanner.nextLine());
        } else {
            numbers = new int[0];
            k = 1;
        }
        System.out.println(findIndexOfKMin(numbers, k));
    }
}