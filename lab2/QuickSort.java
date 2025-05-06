package lab2;

import java.util.Scanner;

public class QuickSort {

    // Задача 1: Реализация алгоритма сортировки (используем быструю сортировку)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Задача 2: Сумма элементов на главной и побочной диагоналях
    public static void diagonalSums(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;

        int mainSum = 0; // главная диагональ
        int secondarySum = 0; // побочная диагональ

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    mainSum += matrix[i][j];
                }
                if (i + j == n - 1) {
                    secondarySum += matrix[i][j];
                }
            }
        }

        System.out.println("Сумма главной диагонали: " + mainSum);
        System.out.println("Сумма побочной диагонали: " + secondarySum);
    }

    // Задача 3: Нахождение определителя матрицы (только для квадратных матриц)
    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int det = 0;
        for (int i = 0; i < n; i++) {
            int[][] minor = new int[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0, l = 0; k < n; k++) {
                    if (k == i) continue;
                    minor[j - 1][l++] = matrix[j][k];
                }
            }
            det += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * determinant(minor);
        }
        return det;
    }

    // Задача 4: Поиск минимального элемента и его индексов
    public static void findMinElement(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Матрица пуста");
            return;
        }

        int min = matrix[0][0];
        int minRow = 0, minCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        System.out.println("Минимальный элемент: " + min);
        System.out.println("Его индексы: [" + minRow + "][" + minCol + "]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк N: ");
        int n = scanner.nextInt();
        System.out.print("Введите количество столбцов M: ");
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nВыберите операцию:");
        System.out.println("1 - Сумма диагоналей");
        System.out.println("2 - Определитель матрицы");
        System.out.println("3 - Минимальный элемент");
        System.out.println("4 - Демонстрация сортировки");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Выполнение задачи 2
                diagonalSums(matrix);
                break;
            case 2:
                // Выполнение задачи 3
                if (n != m) {
                    System.out.println("Определитель можно вычислить только для квадратной матрицы!");
                } else {
                    System.out.println("Определитель матрицы: " + determinant(matrix));
                }
                break;
            case 3:
                // Выполнение задачи 4
                findMinElement(matrix);
                break;
            case 4:
                // Выполнение задачи 1
                System.out.println("Демонстрация сортировки:");
                int[] arr = new int[n * m];
                int index = 0;
                for (int[] row : matrix) {
                    for (int num : row) {
                        arr[index++] = num;
                    }
                }
                System.out.print("Исходный массив: ");
                for (int num : arr) System.out.print(num + " ");

                quickSort(arr, 0, arr.length - 1);

                System.out.print("\nОтсортированный массив: ");
                for (int num : arr) System.out.print(num + " ");
                break;
            default:
                System.out.println("Неверный выбор!");
        }

        scanner.close();
    }
}