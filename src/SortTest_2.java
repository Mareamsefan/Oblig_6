import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class SortTest_2 {

    public static void main(String argv[]) {
        int n = 1000000;
        System.out.printf("    n       tA       tL     tL/tA\n");
        System.out.printf("----------------------------------------------\n");

        while (n <= 10000000) {
            int A[] = new int[n];
            Random r = new Random();
            int third = n / 3;
            LinkedList<Integer> L = new LinkedList<>();

            long tA, tL, t;

            for (int i = 0; i < n; i++) {
                if (i < third)
                    A[i] = i;
                else if (i < 2 * third)
                    A[i] = r.nextInt(2 * n);
                else
                    A[i] = i - third;

                L.addFirst(Integer.valueOf(A[i]));
            }

            t = System.currentTimeMillis();
            Arrays.sort(A);
            tA = System.currentTimeMillis() - t;

            t = System.currentTimeMillis();
            Collections.sort(L);
            tL = System.currentTimeMillis() - t;

            System.out.printf(" %-8d  %-5d    %-5d   %-5.1f\n", n, tA, tL, (float) tL / (float) tA);

            n += 1000000;
        }
    }
}
