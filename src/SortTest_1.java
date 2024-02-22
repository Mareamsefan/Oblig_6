import java.util.*;

public class SortTest_1 {

    public static void main(String argv[])
    {
        // Starter n på 1 mill
        int n = 1000000;
        System.out.printf("    n       tA       tL     tL/tA\n");
        System.out.printf("----------------------------------------------\n");

        // en løkke som kjører så lenge n er mindre eller lik 10 mill:
        while(n <= 10000000) {
            // noe av koden nedenfor er kopiert fra oppgaveteksten 1.3:
            
            int A[] = new int[n];
            Random r = new Random();
            for (int i = 0; i < n; i++)
                A[i] = r.nextInt(2 * n);

            LinkedList<Integer> L = new LinkedList<>();
            for (int i = n - 1; i >= 0; i--)
                L.addFirst(Integer.valueOf(A[i]));

            long tA, tL, t;

            // Tar tiden på sortering av array
            t = System.currentTimeMillis();
            Arrays.sort(A);
            tA = System.currentTimeMillis() - t;

            // Tar tiden på sortering av liste
            t = System.currentTimeMillis();
            Collections.sort(L);
            tL = System.currentTimeMillis() - t;


            // Skriver ut resultater av tidsforbruk:
            System.out.printf(" %-8d  %-5d    %-5d   %-5.1f\n", n, tA, tL, (float) tL / (float) tA);

            // Øker n med 1 mill
            n += 1000000;
        }
    }

}
