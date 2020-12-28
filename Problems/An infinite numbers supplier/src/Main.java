import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        // write your code here
        AtomicInteger i = new AtomicInteger();
        return i::getAndIncrement;
    }

    public static void main(String[] args) {
        int count = new Scanner(System.in).nextInt();

        Supplier<Integer> sup = getInfiniteRange();
        for(int i = 0; i < count; i++) {
            System.out.print(sup.get() + " ");
        }

        System.out.println();

        Supplier<Integer> sup1 = getInfiniteRange();
        Supplier<Integer> sup2 = getInfiniteRange();

        for(int i = 0; i < count; i++) {
            System.out.print(sup1.get() + " " + sup2.get() + " ");
        }
    }

}