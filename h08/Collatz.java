import java.util.Scanner;

public class Collatz {
    long [] keys;
    private static long low;
    private static long high;
     

    public static void main(String[] args) {
        Collatz collatz = new Collatz();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the range: ");

        low = scan.nextInt();
        high = scan.nextInt();
        scan.close();

        long maxLength = 0;
        long collatzLength = 0;
        for (long i = low; i < high; i++) {
            long length = collatz.collatzLength(i);
            if (maxLength < length) {
                maxLength = length;
                collatzLength = i;
            }
        }
        System.out.println("The number with the maximum Collatz length in the range: " + collatzLength);
        System.out.println("Its Collatz length: " + maxLength);
    }
    

    public Collatz() {
        keys = new long[100000000];
    }


    public long collatzLength(long x) {
        long index = 0;
        if (isInBounds(x)) {
            index = x;
        }
            
        if (keys[(int)index] >= 1) {
            return keys[(int)index];
        }
        
        if (x == 1) {
            return 1;
        }

        long y = 0;
        if (x % 2 == 0) {
            y  = (collatzLength(x / 2) + 1);
            if (isInBounds(x)) {
                keys[(int)index] = y;
            }
        }

        else { 
            y = (collatzLength((3 * x) + 1) + 1);
            if (isInBounds(x)) {   
                keys[(int)index] = y;
            }
        }
        return y;
    }

    
    public boolean isInBounds(long x) {
        if (x <= 100000000 && x >= 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
