package threads;

public class Factorials implements Runnable{
         int number;
         int index;
         long[] result;

        public Factorials(int number, int index, long[] result) {
            this.number = number;
            this.index = index;
            this.result = result;
        }

        public void run() {
            result[index] = computeFactorial(number);
        }

        private long computeFactorial(int n) {
            long fact = 1;
            for (int i = 2; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
}

