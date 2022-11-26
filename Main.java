import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //Aluno: Ramon Pessin da Silva
        
        int option = -1;
        while (option != 0) {
            System.out.println("\nCom quantos elementos você deseja iniciar o benchmark?" +
                    "\n1- 100" +
                    "\n2- 1000" +
                    "\n3- 10000" +
                    "\n4- 100000" +
                    "\n5- 1000000" +
                    "\n0- Sair");
            option = in.nextInt();
            switch (option) {
                case 1:
                    cemNumeros();
                    break;
                case 2:
                    milNumeros();
                    break;
                case 3:
                    dezMilNumeros();
                    break;
                case 4:
                    cemMilNumeros();
                    break;
                case 5:
                    umMilhaoNumeros();
                    break;
                case 0:
                    System.out.println("Aplicativo Fechado!");
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }

    static int[] randomArray100 = new int[100];
    static int[] ascArray100 = new int[100];
    static int[] vetor100decrescente = new int[100];

    static int[] randomArray1000 = new int[1000];
    static int[] ascArray1000 = new int[1000];
    static int[] vetor1000decrescente = new int[1000];

    static int[] randomArray10000 = new int[10000];
    static int[] ascArray10000 = new int[10000];
    static int[] vetor10000decrescente = new int[10000];

    static int[] randomArray100000 = new int[100000];
    static int[] ascArray100000 = new int[100000];
    static int[] vetor100000decrescente = new int[100000];

    static int[] randomArray1000000 = new int[1000000];
    static int[] ascArray1000000 = new int[1000000];
    static int[] vetor1000000decrescente = new int[1000000];

    //Bubble Sort
    public static long bubbleSort(int[] vet) {
       
        long init = System.currentTimeMillis();
        int n = vet.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (vet[j - 1] > vet[j]) {
                    temp = vet[j - 1];
                    vet[j - 1] = vet[j];
                    vet[j] = temp;
                }
            }
        }
        long time = System.currentTimeMillis() - init;
        return time;
    }
    //Custo do algoritmo: Θ(n^2)

    //Quick Sort
    public static long quickSort(int a[], int inicio, int fim) {
       
        long init = System.currentTimeMillis();
        if (inicio < fim) {
            int p = div(a, inicio, fim);
            quickSort(a, inicio, p - 1);
            quickSort(a, p + 1, fim);
        }
        long time = System.currentTimeMillis() - init;
        return time;
    }
    //Custo do algoritmo: θ(n log(n))

    //Merge Sort
    public static long mergeSort(int a[], int inicio, int fim) {
       
        long init = System.currentTimeMillis();
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(a, inicio, meio);
            mergeSort(a, meio + 1, fim);
            merge(a, inicio, meio, fim);
        }
        long time = System.currentTimeMillis() - init;
        return time;
    }
    //Custo do algoritmo: θ(n log(n))

    //Shell Sort
    public static long shellSort(int[] vet) {
       
        long init = System.currentTimeMillis();
        int n = vet.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = vet[i];
                int j = i;
                while (j >= gap && vet[j - gap] > key) {
                    vet[j] = vet[j - gap];
                    j -= gap;
                }
                vet[j] = key;
            }
        }
        long time = System.currentTimeMillis() - init;
        return time;
    }
    //Custo do algoritmo: θ(n log(n))

    //Selection Sort
    public static long selectionSort(int[] vet) {
        
        long init = System.currentTimeMillis();
        for (int i = 0; i < vet.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < vet.length; j++) {
                if (vet[j] < vet[index]) {
                    index = j;
                }
            }
            int smallerNumber = vet[index];
            vet[index] = vet[i];
            vet[i] = smallerNumber;
        }
        long time = System.currentTimeMillis() - init;
        return time;
    }
    //Custo do algoritmo: Θ(n^2)

    //Insertion Sort
    public static long insertionSort(int[] array) {
        
        long init = System.currentTimeMillis();
        for (int i = 0; i < array.length; ++i) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                int key = array[j];
                array[j] = array[j - 1];
                array[j - 1] = key;
                j = j - 1;
            }
        }
        long time = System.currentTimeMillis() - init;
        return time;
    }
    //Custo do algoritmo: Θ(n^2)

    public static void numberGenerator() {
       
        for (int i = 0; i < 1000000; i++) {
            if (i < 100) {
                randomArray100[i] = 1 + (int) (Math.random() * 100);
                ascArray100[i] = i;
            }
            if (i < 1000) {
                randomArray1000[i] = 1 + (int) (Math.random() * 1000);
                ascArray1000[i] = i;
            }
            if (i < 10000) {
                randomArray10000[i] = 1 + (int) (Math.random() * 10000);
                ascArray10000[i] = i;
            }
            if (i < 100000) {
                randomArray100000[i] = 1 + (int) (Math.random() * 100000);
                ascArray100000[i] = i;
            }
            if (i < 1000000) {
                randomArray1000000[i] = 1 + (int) (Math.random() * 1000000);
                ascArray1000000[i] = i;
            }
        }
    }

    private static int div(int a[], int inicio, int fim) {
        
        int p = a[fim];
        int i = (inicio - 1);

        for (int j = inicio; j <= fim - 1; j++) {
            if (a[j] < p) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[fim];
        a[fim] = t;
        return (i + 1);
    }

    private static void merge(int a[], int inicio, int meio, int fim) {
       
        int i, j, k;
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int vetEsquerda[] = new int[n1];
        int vetDireita[] = new int[n2];

        for (i = 0; i < n1; i++)
            vetEsquerda[i] = a[inicio + i];
        for (j = 0; j < n2; j++)
            vetDireita[j] = a[meio + 1 + j];

        i = 0;
        j = 0;
        k = inicio;

        while (i < n1 && j < n2) {
            if (vetEsquerda[i] <= vetDireita[j]) {
                a[k] = vetEsquerda[i];
                i++;
            } else {
                a[k] = vetDireita[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = vetEsquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = vetDireita[j];
            j++;
            k++;
        }
    }

    public static void cemNumeros() {
       
        numberGenerator(); System.out.println("Insertion Sort (números aleatórios): " + insertionSort(randomArray100));
        numberGenerator(); System.out.println("Selection Sort (números aleatórios): " + selectionSort(randomArray100));
        numberGenerator(); System.out.println("Bubble Sort (números aleatórios): " + bubbleSort(randomArray100));
        numberGenerator(); System.out.println("Shell Sort (números aleatórios): " + shellSort(randomArray100));
        numberGenerator(); System.out.println("Merge Sort (números aleatórios): " + mergeSort(randomArray100, 0, randomArray100.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números aleatórios): " + quickSort(randomArray100, 0, randomArray100.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números crescentes): " + insertionSort(ascArray100));
        numberGenerator(); System.out.println("Selection Sort (números crescentes): " + selectionSort(ascArray100));
        numberGenerator(); System.out.println("Bubble Sort (números crescentes): " + bubbleSort(ascArray100));
        numberGenerator(); System.out.println("Shell Sort (números crescentes): " + shellSort(ascArray100));
        numberGenerator(); System.out.println("Merge Sort (números crescentes): " + mergeSort(ascArray100, 0, ascArray100.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números crescentes): " + quickSort(ascArray100, 0, ascArray100.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números decrescentes): " + insertionSort(vetor100decrescente));
        numberGenerator(); System.out.println("Selection Sort (números decrescentes): " + selectionSort(vetor100decrescente));
        numberGenerator(); System.out.println("Bubble Sort (números decrescentes): " + bubbleSort(vetor100decrescente));
        numberGenerator(); System.out.println("Shell Sort (números decrescentes): " + shellSort(vetor100decrescente));
        numberGenerator(); System.out.println("Merge Sort (números decrescentes): " + mergeSort(vetor100decrescente, 0, vetor100decrescente.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números decrescentes): " + quickSort(vetor100decrescente, 0, vetor100decrescente.length - 1));
    }

    public static void milNumeros() {
       
        numberGenerator(); System.out.println("Insertion Sort (números aleatórios): " + insertionSort(randomArray1000));
        numberGenerator(); System.out.println("Selection Sort (números aleatórios): " + selectionSort(randomArray1000));
        numberGenerator(); System.out.println("Bubble Sort (números aleatórios): " + bubbleSort(randomArray1000));
        numberGenerator(); System.out.println("Shell Sort (números aleatórios): " + shellSort(randomArray1000));
        numberGenerator(); System.out.println("Merge Sort (números aleatórios): " + mergeSort(randomArray1000, 0, randomArray1000.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números aleatórios): " + quickSort(randomArray1000, 0, randomArray1000.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números crescentes): " + insertionSort(ascArray1000));
        numberGenerator(); System.out.println("Selection Sort (números crescentes): " + selectionSort(ascArray1000));
        numberGenerator(); System.out.println("Bubble Sort (números crescentes): " + bubbleSort(ascArray1000));
        numberGenerator(); System.out.println("Shell Sort (números crescentes): " + shellSort(ascArray1000));
        numberGenerator(); System.out.println("Merge Sort (números crescentes): " + mergeSort(ascArray1000, 0, ascArray1000.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números crescentes): " + quickSort(ascArray1000, 0, ascArray1000.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números decrescentes): " + insertionSort(vetor1000decrescente));
        numberGenerator(); System.out.println("Selection Sort (números decrescentes): " + selectionSort(vetor1000decrescente));
        numberGenerator(); System.out.println("Bubble Sort (números decrescentes): " + bubbleSort(vetor1000decrescente));
        numberGenerator(); System.out.println("Shell Sort (números decrescentes): " + shellSort(vetor1000decrescente));
        numberGenerator(); System.out.println("Merge Sort (números decrescentes): " + mergeSort(vetor1000decrescente, 0, vetor1000decrescente.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números decrescentes): " + quickSort(vetor1000decrescente, 0, vetor1000decrescente.length - 1));
    }

    public static void dezMilNumeros() {
       
        numberGenerator(); System.out.println("Insertion Sort (números aleatórios): " + insertionSort(randomArray10000));
        numberGenerator(); System.out.println("Selection Sort (números aleatórios): " + selectionSort(randomArray10000));
        numberGenerator(); System.out.println("Bubble Sort (números aleatórios): " + bubbleSort(randomArray10000));
        numberGenerator(); System.out.println("Shell Sort (números aleatórios): " + shellSort(randomArray10000));
        numberGenerator(); System.out.println("Merge Sort (números aleatórios): " + mergeSort(randomArray10000, 0, randomArray10000.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números aleatórios): " + quickSort(randomArray10000, 0, randomArray10000.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números crescentes): " + insertionSort(ascArray10000));
        numberGenerator(); System.out.println("Selection Sort (números crescentes): " + selectionSort(ascArray10000));
        numberGenerator(); System.out.println("Bubble Sort (números crescentes): " + bubbleSort(ascArray10000));
        numberGenerator(); System.out.println("Shell Sort (números crescentes): " + shellSort(ascArray10000));
        numberGenerator(); System.out.println("Merge Sort (números crescentes): " + mergeSort(ascArray10000, 0, ascArray10000.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números crescentes): " + quickSort(ascArray10000, 0, ascArray10000.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números decrescentes): " + insertionSort(vetor10000decrescente));
        numberGenerator(); System.out.println("Selection Sort (números decrescentes): " + selectionSort(vetor10000decrescente));
        numberGenerator(); System.out.println("Bubble Sort (números decrescentes): " + bubbleSort(vetor10000decrescente));
        numberGenerator(); System.out.println("Shell Sort (números decrescentes): " + shellSort(vetor10000decrescente));
        numberGenerator(); System.out.println("Merge Sort (números decrescentes): " + mergeSort(vetor10000decrescente, 0, vetor10000decrescente.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números decrescentes): " + quickSort(vetor10000decrescente, 0, vetor10000decrescente.length - 1));
    }

    public static void cemMilNumeros() {
        
        numberGenerator(); System.out.println("Insertion Sort (números aleatórios): " + insertionSort(randomArray100000));
        numberGenerator(); System.out.println("Selection Sort (números aleatórios): " + selectionSort(randomArray100000));
        numberGenerator(); System.out.println("Bubble Sort (números aleatórios): " + bubbleSort(randomArray100000));
        numberGenerator(); System.out.println("Shell Sort (números aleatórios): " + shellSort(randomArray100000));
        numberGenerator(); System.out.println("Merge Sort (números aleatórios): " + mergeSort(randomArray100000, 0, randomArray100000.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números aleatórios): " + quickSort(randomArray100000, 0, randomArray100000.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números crescentes): " + insertionSort(ascArray100000));
        numberGenerator(); System.out.println("Selection Sort (números crescentes): " + selectionSort(ascArray100000));
        numberGenerator(); System.out.println("Bubble Sort (números crescentes): " + bubbleSort(ascArray100000));
        numberGenerator(); System.out.println("Shell Sort (números crescentes): " + shellSort(ascArray100000));
        numberGenerator(); System.out.println("Merge Sort (números crescentes): " + mergeSort(ascArray100000, 0, ascArray100000.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números crescentes): " + quickSort(ascArray100000, 0, ascArray100000.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números decrescentes): " + insertionSort(vetor100000decrescente));
        numberGenerator(); System.out.println("Selection Sort (números decrescentes): " + selectionSort(vetor100000decrescente));
        numberGenerator(); System.out.println("Bubble Sort (números decrescentes): " + bubbleSort(vetor100000decrescente));
        numberGenerator(); System.out.println("Shell Sort (números decrescentes): " + shellSort(vetor100000decrescente));
        numberGenerator(); System.out.println("Merge Sort (números decrescentes): " + mergeSort(vetor100000decrescente, 0, vetor100000decrescente.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números decrescentes): " + quickSort(vetor100000decrescente, 0, vetor100000decrescente.length - 1));
    }

    public static void umMilhaoNumeros() {
        
        numberGenerator(); System.out.println("Insertion Sort (números aleatórios): " + insertionSort(randomArray1000000));
        numberGenerator(); System.out.println("Selection Sort (números aleatórios): " + selectionSort(randomArray1000000));
        numberGenerator(); System.out.println("Bubble Sort (números aleatórios): " + bubbleSort(randomArray1000000));
        numberGenerator(); System.out.println("Shell Sort (números aleatórios): " + shellSort(randomArray1000000));
        numberGenerator(); System.out.println("Merge Sort (números aleatórios): " + mergeSort(randomArray1000000, 0, randomArray1000000.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números aleatórios): " + quickSort(randomArray1000000, 0, randomArray1000000.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números crescentes): " + insertionSort(ascArray1000000));
        numberGenerator(); System.out.println("Selection Sort (números crescentes): " + selectionSort(ascArray1000000));
        numberGenerator(); System.out.println("Bubble Sort (números crescentes): " + bubbleSort(ascArray1000000));
        numberGenerator(); System.out.println("Shell Sort (números crescentes): " + shellSort(ascArray1000000));
        numberGenerator(); System.out.println("Merge Sort (números crescentes): " + mergeSort(ascArray1000000, 0, ascArray1000000.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números crescentes): " + quickSort(ascArray1000000, 0, ascArray1000000.length - 1));

        numberGenerator(); System.out.println("\nTempo Insertion Sort (números decrescentes): " + insertionSort(vetor1000000decrescente));
        numberGenerator(); System.out.println("Selection Sort (números decrescentes): " + selectionSort(vetor1000000decrescente));
        numberGenerator(); System.out.println("Bubble Sort (números decrescentes): " + bubbleSort(vetor1000000decrescente));
        numberGenerator(); System.out.println("Shell Sort (números decrescentes): " + shellSort(vetor1000000decrescente));
        numberGenerator(); System.out.println("Merge Sort (números decrescentes): " + mergeSort(vetor1000000decrescente, 0, vetor1000000decrescente.length - 1));
        numberGenerator(); System.out.println("Quick Sort (números decrescentes): " + quickSort(vetor1000000decrescente, 0, vetor1000000decrescente.length - 1));
    }
}