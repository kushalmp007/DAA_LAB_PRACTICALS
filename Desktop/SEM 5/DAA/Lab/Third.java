import java.util.*;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        long s1 = System.nanoTime();
        int sum1= ncube(arr,n);
        long e1 = System.nanoTime();
        long el1 = (e1 - s1) / 1000;
        System.out.println(sum1);
        ///////////////////////////
        long s2 = System.nanoTime();
        int sum2=nsquare(arr,n);
        long e2 = System.nanoTime();
        long el2 = (e2 - s2) / 1000;
        System.out.println(sum2);
        ////////////////////////////
        long s3 = System.nanoTime();
        int sum3= kadane(arr);
        long e3 = System.nanoTime();
        long el3 = (e3 - s3) / 1000;
        System.out.println(sum3);
        ////////////////////////////
        long s4 = System.nanoTime();
        int sum4=recursive(arr,0,n-1);
        long e4 = System.nanoTime();
        long el4 = (e4 - s4) / 1000;
        System.out.println(sum4);
        ////////////////////////////
        long time[]={el1,el2,el3,el4};
        for(int i=0;i<4;i++){
            System.out.print(time[i]+" ");
        }
        sc.close();
    }

    static int ncube(int arr[], int n) {
        if (arr == null || n == 0)
            return 0;

        int maxSum = arr[0];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currSum = 0;

                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }

                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }

    static int nsquare(int arr[], int n) {
        if (arr == null || n == 0)
            return 0;

        int maxSum = arr[0];

        for (int i = 0; i < n; i++) {
            int currSum = 0;

            for (int j = i; j < n; j++) {
                currSum += arr[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }

    static int kadane(int a[]) {
        int size = a.length;
        int max = Integer.MIN_VALUE, maxi = 0;

        for (int i = 0; i < size; i++) {
            maxi = maxi + a[i];
            if (max < maxi)
                max = maxi;
            if (maxi < 0)
                maxi = 0;
        }
        return max;
    }

    static int recursive(int arr[], int l, int h) {
        if (l > h)
            return Integer.MIN_VALUE;

        if (l == h)
            return arr[l];

        int m = (l + h) / 2;

        return Math.max(Math.max(recursive(arr, l, m - 1), recursive(arr, m + 1, h)), maxCrossingSum(arr, l, m, h));
    }

    static int maxCrossingSum(int arr[], int l, int m, int h) {

        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        return Math.max(left_sum + right_sum - arr[m], Math.max(left_sum, right_sum));
    }

}
class easy {
    public static void revArray(int mainArray[], int reversedArray[]) {
        int n = mainArray.length;
        for (int i = 0; i < n; i++) {
            reversedArray[i] = mainArray[n - i - 1];
        }
    }

    public static void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void print(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void maxInArray(int arr[], int start_index, int end_index) {
        int max = Integer.MIN_VALUE;
        for (int i = start_index; i < end_index; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
    }

    public static void minInArray(int arr[], int start_index, int end_index) {
        int min = Integer.MAX_VALUE;
        for (int i = start_index; i < end_index; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
    }

    public static int minIndex(int a[], int i, int j) {
        if (i == j)
            return i;

        int k = minIndex(a, i + 1, j);

        return (a[i] < a[k]) ? i : k;
    }

}

