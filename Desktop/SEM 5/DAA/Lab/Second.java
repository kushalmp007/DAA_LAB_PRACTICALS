import java.util.*;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }
        int a[] = new int[n];
        Arrays.sort(arr);
        easy.revArray(arr, a);
        sc.close();
        long s1 = System.nanoTime();
        quick_sort(arr, 0, n - 1);
        System.out.println("worst case: ");
        long e1 = System.nanoTime();
        long el1 = (e1 - s1) / 1000;
        easy.print(arr);
        System.out.println(el1 + " ms");
        long s2 = System.nanoTime();
        quick_sort(a, 0, n - 1);
        System.out.println("best case: ");
        long e2 = System.nanoTime();
        long el2 = (e2 - s2) / 1000;
        easy.print(a);
        System.out.println(el2 + " ms");
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;

                easy.swap(arr, i, j);
            }
        }

        easy.swap(arr, i + 1, high);

        return i + 1;
    }

    static void quick_sort(int arr[], int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quick_sort(arr, low, pi - 1);
            quick_sort(arr, pi + 1, high);
        }
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
