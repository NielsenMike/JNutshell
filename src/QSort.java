import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class QSort {
    public List<Integer> sort(List<Integer> array) {
        if(array.size() > 1) {

            int pivot = array.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < pivot){
                    less.add(array.get(i));
                }
                else if (array.get(i) > pivot){
                    greater.add(array.get(i));
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
