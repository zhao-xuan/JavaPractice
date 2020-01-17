import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Practice014e {
    public static void main(String[] args) {
        for (long i = 0; i < Integer.parseInt(args[0]); i++) {
            int n = Integer.parseInt(args[0]);
            List<Integer> numList = new ArrayList<>();
            Random generator = new Random();
            int x = generator.nextInt(n - 1);
            while (!isFulfilled(numList, n)) {
                numList.add(x);
            }

            System.out.println("hello");
        }
    }

    public static Boolean isFulfilled(List<Integer> list, int n) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            temp.add(i);

        for (Integer integer : temp)
            if (!list.contains(integer))
                return false;

        return true;
    }
}