public class QuickSort {

    int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int m = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < m)
                i++;
            while (arr[j] > m)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    void quickSort(int arr[], int left, int right) {
        int index = this.partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    public static void main(String []args) {
        int array[] = {5, 4, 6, 8, 1, 3, 5};
        for(int i=0; i<array.length; i++)
            System.out.println(array[i]);
        QuickSort qs = new QuickSort();
        qs.quickSort(array, 0, array.length-1);
        System.out.println();
        for(int i=0; i<array.length; i++)
            System.out.println(array[i]);
    }
}