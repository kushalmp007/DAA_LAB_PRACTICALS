
// Kushal M. Patel;
// Roll No.: 20BCE209;
import java.util.*;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }
        easy.print(arr);
        ////////////////////////////////////////////
        long start = System.nanoTime();
        fun.iterative_bubblesort(arr);
        System.out.println("Bubble sort iterative: ");
        long end = System.nanoTime();
        long elapsedTime = (end - start) / 1000;
        easy.print(arr);
        System.out.println(elapsedTime + " ms");
        ////////////////////////////////////////////
        long s1 = System.nanoTime();
        fun.recursive_bubblesort(arr,n);
        System.out.println("Bubble sort recursive: ");
        long e1 = System.nanoTime();
        long el1 = (e1 - s1) / 1000;
        easy.print(arr);
        System.out.println(el1 + " ms");
        ////////////////////////////////////////////
        long s2 = System.nanoTime();
        fun.iterative_insertionsort(arr);
        System.out.println("insertion sort iterative: ");
        long e2 = System.nanoTime();
        long el2 = (e2 - s2) / 1000;
        easy.print(arr);
        System.out.println(el2 + " ms");
        ///////////////////////////////////////////
        long s3 = System.nanoTime();
        fun.recursive_insertionsort(arr,n);
        System.out.println("insertion sort recursive: ");
        long e3 = System.nanoTime();
        long el3 = (e3 - s3) / 1000;
        easy.print(arr);
        System.out.println(el3 + " ms");
        ///////////////////////////////////////////
        long s4 = System.nanoTime();
        fun.iterative_selectionsort(arr);
        System.out.println("selection sort iterative: ");
        long e4 = System.nanoTime();
        long el4 = (e4 - s4) / 1000;
        easy.print(arr);
        System.out.println(el4 + " ms");
        //////////////////////////////////////////
        long s5 = System.nanoTime();
        fun.recursive_selectionsort(arr,n,0);
        System.out.println("selection sort recursive: ");
        long e5 = System.nanoTime();
        long el5 = (e5 - s5) / 1000;
        easy.print(arr);
        System.out.println(el5 + " ms");
        //////////////////////////////////////////
        sc.close();

    }

}

class fun {

    public static void iterative_bubblesort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    easy.swap(arr, j, j + 1);
                }
            }
        }

    }

    public static void recursive_bubblesort(int arr[], int n) {

        if (n == 1) {

            return;
        }

        int count = 0;

        for (int i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1]) {
                easy.swap(arr, i, i + 1);
                count = count + 1;
            }

        if (count == 0) {

            return;
        }

        recursive_bubblesort(arr, n - 1);
    }

    public static void iterative_insertionsort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

    }

    public static void recursive_insertionsort(int arr[], int n) {
        if (n <= 1)
            return;

        recursive_insertionsort(arr, n - 1);

        int last = arr[n - 1];
        int j = n - 2;

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;

    }

    public static void iterative_selectionsort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                easy.swap(arr, min, i);
            }
        }

    }

    public static void recursive_selectionsort(int arr[], int n, int index) {
        if (index == n)
            return;

        int k = easy.minIndex(arr, index, n - 1);

        if (k != index) {

            int temp = arr[k];
            arr[k] = arr[index];
            arr[index] = temp;
        }

        recursive_selectionsort(arr, n, index + 1);

    }
}

class easy {

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