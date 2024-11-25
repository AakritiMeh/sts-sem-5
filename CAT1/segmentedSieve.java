package CAT1;

import java.util.*;

class segmentedSieve {
    // Function to generate all primes up to √high using the Sieve of Eratosthenes
    static ArrayList<Integer> generatePrimes(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    // Function to find primes in the range [low, high]
    static void segmentedSieve(int low, int high) {
        int sqrtHigh = (int) Math.sqrt(high);
        ArrayList<Integer> primes = generatePrimes(sqrtHigh);

        boolean isPrimeInRange[] = new boolean[high - low + 1];
        Arrays.fill(isPrimeInRange, true);

        // Mark non-primes in the range [low, high]
        for (int prime : primes) {
            int firstMultiple = Math.max(prime * prime, (low + prime - 1) / prime * prime);

            for (int i = firstMultiple; i <= high; i += prime) {
                isPrimeInRange[i - low] = false;
            }
        }

        // Print the primes in the range [low, high]
        for (int i = 0; i < isPrimeInRange.length; i++) {
            if (isPrimeInRange[i]) {
                System.out.print((i + low) + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt(); // Example input: 80
        int high = sc.nextInt(); // Example input: 90
        segmentedSieve(low, high);
    }
}
