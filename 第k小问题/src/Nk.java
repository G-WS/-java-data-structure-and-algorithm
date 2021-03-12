import java.util.Scanner;

public class Nk {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("数组长度为");int n = in.nextInt();
        int[] b = new int[n];
        System.out.println("数组元素为");
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        System.out.println("第k小问题的k是");
        int k = in.nextInt();
        System.out.print("原数组为：");
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + ",");
        }
        System.out.println();
        quickSelect(b, 0, n - 1, k);
        System.out.println();
        System.out.println("第" + k + "小的元素为");
        System.out.println(b[k - 1]);
    }

    private static void quickSelect(int[] a, int left, int right, int k) {
        if (right - left <= 1) {
            return;
        }
        int pivot = findPivot(a, left, right);
        int i = left;
        int j = right - 1;
        for (; ; ) {
            while (a[++i] < pivot) {
            }
            while (a[--j] > pivot) {
            }
            if (i < j) {
                swap(a, i, j);
            } else {
                break;
            }
        }
        swap(a, i, right - 1);
        if (i == k) {
            return;
        } else if (i > k) {
            quickSelect(a, left, i - 1, k);
        } else {
            quickSelect(a, i + 1, right, k - i + 1);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    private static int findPivot(int[] a, int left, int right) {
        int mid = (left + right) / 2;
        if (a[left] > a[mid]) {
            swap(a, left, mid);
        }
        if (a[right] < a[mid]) {
            swap(a, right, mid);
        }
        if (a[left] > a[right]) {
            swap(a, left, right);
        }

        swap(a, mid, right - 1);
        return a[right - 1];
    }
}