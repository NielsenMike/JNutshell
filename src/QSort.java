/*
    Basic Quicksort Algorithm
    Autor: Mike Nielsen
    Project: JNutshell
 */
import java.util.ArrayList;
import java.util.List;

public class QSort {
    public List<Integer> sort(List<Integer> array) {
        if(array.size() > 1) {

            int pivot = array.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();

            for (int a : array) {
                if (a < pivot){
                    less.add(a);
                }
                else if (a > pivot){
                    greater.add(a);
                }
            }
            array.clear();
            array.addAll(sort(less));
            array.add(pivot);
            array.addAll(sort(greater));
            return array;
        }
        return array;
    }

}
