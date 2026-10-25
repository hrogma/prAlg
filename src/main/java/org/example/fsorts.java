package org.example;




public class fsorts {
    public static void main(String[] args){
        int[] numbers = {1, 2, 10, 1, 9, 7, 8};

        quickSort(numbers);

        for (int number: numbers){
            System.out.print(number);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;

        int pivot = a[left + (right - left) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;

            if (i <= j) {
                int temporary = a[i];
                a[i] = a[j];
                a[j] = temporary;
                i++;
                j--;
            }
        }

        if (left < j) quickSort(a, left, j);
        if (i < right) quickSort(a, i, right);
    }
}