package CAT2;

import java.util.*;

class LeadersInArray {
    public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = arr[n - 1];
        ans.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--)
            if (arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }

        return ans;
    }

    public static void main(String args[]) {
        int n = 6;
        int arr[] = { 1, 2, 12, 13, 0, 6 };
        ArrayList<Integer> ans = printLeadersBruteForce(arr, n);
        Collections.sort(ans, Collections.reverseOrder());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}
