import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int findIndexOfMin(int[] numbers) {
        // write your code here
        if (numbers.length == 0) {
            return -1;
        } else {
            int min = numbers[0];
            int minIndex = 0;

            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < min) {
                    min = numbers[i];
                    minIndex = i;
                }
            }

            return minIndex;
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] numbers;
        if (scanner.hasNextInt()) {
            numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        } else {
            numbers = new int[0];    
        }
        System.out.println(findIndexOfMin(numbers));
    }
}