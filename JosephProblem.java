import java.io.*;

class josephus {
    static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        else

            return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println(josephus(n, k));
    }
}

// import java.util.List;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;

// public class JosephProblem {
// public static void main(String[] args) {
// int winner = joseph(5, 3);
// System.out.println(winner);
// }

// public static int joseph(int noOfPeople, int remPosition) {
// int tempPos = remPosition - 1;
// int[] people = new int[noOfPeople];
// for (int i = 0; i < noOfPeople; i++) {
// people[i] = i + 1;
// }
// int iteration = noOfPeople - 1;
// List<Integer> list =
// IntStream.of(people).boxed().collect(Collectors.toList());
// while (iteration > 0) {
// list.remove(tempPos);
// tempPos += remPosition - 1;
// if (tempPos > list.size() - 1) {
// tempPos = tempPos % list.size();
// }
// iteration--;
// }
// return list.get(0);
// }

// }
