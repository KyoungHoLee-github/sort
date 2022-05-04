package sort;


import java.util.*;



public class SortTestDrive {
    public static void main(String[] arg){
        Integer[] arr = {7, 8, 6, 5, 4, 3, 2, 1};

        //Sort<Float> sort = new QuickSort();
        
        ArrayList<Integer> aList = new ArrayList<>();
        aList.addAll(Arrays.asList(arr));

        aList = (ArrayList<Integer>) quicksort(aList);
        System.out.println(aList);

        /*Float[] res = sort.sort(arr, (x,y)-> {
            if (x < y) return -1;
            if (x > y) return 1;
            return 0;
        });*/

        /*for(int i = 0; i< res.length; i++){
            System.out.printf("%.1f ", res[i]);
        }*/
    }


    public static <T extends Comparable<? super T>> List<T> quicksort(List<T> list){
        if(list.size() <= 1) return list;
        int pivot = list.size() /2 ;
        List<T> a = new ArrayList<T>();
        List<T> b = new ArrayList<T>();
        int c = 0;

        for(T number : list){
            if(list.get(pivot).compareTo(number) < 0)
                b.add(number);
            else if(list.get(pivot).compareTo(number) > 0)
                a.add(number);
            else
                c++;

        }
        a = quicksort(a);


        for(int i=0 ; i<c ; i++)
            a.add(list.get(pivot));
        b = quicksort(b);


        List<T> sorted = new ArrayList<T>();
        sorted.addAll(a);
        sorted.addAll(b);
        return sorted;

    }

}
