package sort;

import java.util.Comparator;

public class InsertSort<T> extends Sort<T> {
    public T[] sort(T[] src, Comparator<T> comp) {
        System.out.println(this.getClass().getSimpleName());
        T[] dst = src.clone();

        for(int i = 0; i < dst.length; i++) {
            T temp = dst[i];
            int j = i - 1;

            while (j >= 0 && comp.compare(dst[j],temp) > 0) {
                dst[j + 1] = dst[j];
                j--;
            }
            dst[j + 1] = temp;
        }
        return dst;
    }
}
