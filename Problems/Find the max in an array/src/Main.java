import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int findMax(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(findMax(numbers));
    }
}