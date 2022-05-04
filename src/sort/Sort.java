package sort;

import java.util.*;

public class Sort {
    public static void main(String[] arg){
        long startTime = System.nanoTime();

        //쉘정렬
        /*int size = (int) Math.pow(2,20);
        int[] arr = new int[size];

        Random r = new Random();

        int k = arr.length;
        for(int i = 0; i < k; i++){
            arr[i] = r.nextInt();
        }
        int[] dst = arr.clone();
        shellSort(dst);*/

        //힙정렬
       /* int size = (int) Math.pow(2,5);
        int[] arr = new int[size];

        //Random r = new Random();

        int k = arr.length;
        for(int i = 0; i < k; i++){
            arr[i] = k - i;
        }
        int[] dst = arr.clone();
        heapSort(dst);*/

        //선택정렬
        /*int size = (int) Math.pow(2,5);
        int[] arr = new int[size];

        Random r = new Random();

        int k = arr.length;
        for(int i = 0; i < k; i++){
            arr[i] = r.nextInt();
        }
        int[] dst = arr.clone();
        selectionSort(dst);*/

        /*for(int i = 0; i < dst.length; i++){
            System.out.printf("%3d ", dst[i]);
        }*/

        //버블정렬
        /*int size = (int) Math.pow(2,5);
        int[] arr = new int[size];

        //Random r = new Random();

        int k = arr.length;
        for(int i = 0; i < k; i++){
            arr[i] = i + 1;
        }
        int[] dst = arr.clone();
        bubleSort(dst);*/

        /*for(int i = 0; i < dst.length; i++){
            System.out.printf("%3d ", dst[i]);
        }*/

        //삽입정렬
        /*int size = (int) Math.pow(2,20);
        int[] arr = new int[size];

        Random r = new Random();

        int k = arr.length;
        for(int i = 0; i < k; i++){
            arr[i] = r.nextInt();
        }
        int[] dst = arr.clone();
        insertSort(dst);*/

        /*for(int i = 0; i < dst.length; i++){
            System.out.printf("%3d ", dst[i]);
        }*/

        //퀵정렬
        int size = (int) Math.pow(2,20);
        int[] arr = new int[size];

        Random r = new Random();

        int k = arr.length;
        for(int i = 0; i < k; i++){
            arr[i] = r.nextInt();
        }
        int[] dst = arr.clone();
        quickSort(dst,0,dst.length - 1);

        /*for(int i = 0; i < dst.length; i++){
            System.out.printf("%3d ", dst[i]);
        }*/


        /*int size = (int) Math.pow(2,20);
        Integer[] arr = new Integer[size];
        int k = arr.length;

        for(int i = 0; i < k; i++){
            arr[i] = k - i;
        }
        Sort<Integer> sort = new BubbleSort<>();

        Integer[] res = sort.sort(arr, (x,y)-> {
            if (x < y) return -1;
            if (x > y) return 1;
            return 0;
        });*/



        /*ArrayList<Integer> aList = new ArrayList<>();
        aList.addAll(Arrays.asList(arr));

        aList = (ArrayList<Integer>) quicksort(aList);
        System.out.println(aList);*/

        long endTime = System.nanoTime();
        System.out.println("running time: " + (endTime - startTime) + " ns");
    }


    private static void quickSort(int[] arr,int start, int end) {
        int part=partition(arr,start,end);
        if(start<part-1) quickSort(arr,start,part-1);
        if(end>part) quickSort(arr,part,end);
    }

    private static int partition(int[] arr,int start,int end) {
        int pivot=arr[(start+end)/2];
        while(start<=end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if(start<=end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr,int start,int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        return;
    }

    static int[] shellSort(int[] arr) {
        int gap = 1;
        while (gap <= arr.length / 3) {
            gap = gap * 3 + 1;
            // 크누스 간격순서
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int idx = i;
                while (idx > gap - 1 && arr[idx - gap] >= tmp) {
                    arr[idx] = arr[idx - gap];
                    idx -= gap;
                }
                arr[idx] = tmp;
            }
            gap = (gap - 1) / 3;
        }

        return arr;
    }



    public static void MAX_HEAPIFY(int[] base, int i, int len){
        int j;
        int tmp = base[i-1];
        while(i<=len/2){ // 자식 존재 여부
            j = i*2;
            if((j<len) && (base[j-1] <base[j])){
                j++;
            }
            if(tmp >= base[j-1]){
                break;
            }
            base[i-1] = base[j-1];
            i=j;
        }
        base[i-1] = tmp;
    }

    public static int[] heapSort(int[] base){
        int len = base.length;
        for(int i = len/2;i>0;i--){
            MAX_HEAPIFY(base,i,len);
        }
        do{
            int tmp = base[0];
            base[0] = base[len-1];
            base[len-1] = tmp;
            len = len-1;
            MAX_HEAPIFY(base,1,len);
        }while(len > 1);

        return base;
    }

    static int[] selectionSort(int[] arr) {
        int indexMin, temp;
        for (int i = 0; i < arr.length-1; i++) {
            indexMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            temp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] bubleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0 ; j < arr.length - i - 1 ; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] insertSort(int[] arr) {

        // 첫 번째 값은 정렬이 됐다고 생각하고 두 번째 인덱스 부터 정렬 시작
        for (int i = 1; i < arr.length; i++) {

            // 삽입될 위치를 저장하기 위한 idx
            int idx = i;
            // 현재 정렬대상 값
            int tmp = arr[i];

            // 1. 이미 정렬된 배열에서 현재 정렬대상 값이 삽입될 위치(인덱스)를 찾는다.
            // 2. 현재 정렬대상 값보다 큰 값은 뒤로 한 칸식 이동된다.
            while( (idx > 0) && (arr[idx - 1] > tmp) ) {
                arr[idx] = arr[idx -1];
                idx--;
            }

            // 삽입될 위치에 tmp 삽입
            arr[idx] = tmp;
        }
        return arr;
    }
}
