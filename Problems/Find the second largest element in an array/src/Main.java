import java.util.*;

public class Main {

    public static int findSecondLargestNumber(int[] numbers) {
        // write your code here
        HashSet<Integer> numberSet = new HashSet<>();

        for (int number : numbers) {
            numberSet.add(number);
        }

        List<Integer> numberList = new ArrayList<>(numberSet);

        if (numberList.size() < 2) {
            return Integer.MIN_VALUE;
        } else {
            Collections.sort(numberList);
            return numberList.get(numberList.size() - 2);
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
        System.out.println(findSecondLargestNumber(numbers));
    }
}