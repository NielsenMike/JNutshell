import java.util.ArrayList;
import java.util.List;

public class QSort {
    public Integer[] sort(Integer array[]) {
        System.out.println("Start sorting!");

        if(array.length > 1) {

            int pivot = array[0];
            System.out.println("Pivot: " + pivot);

            List<Integer> less = new ArrayList<Integer>();
            List<Integer> greater = new ArrayList<Integer>();

            for (int i = 0; i < array.length; i++) {
                if (array[i] < pivot){
                    less.add(array[i]);
                    System.out.println("Less: " + array[i]);
                }
                else if (array[i] > pivot){
                    greater.add(array[i]);
                    System.out.println("Greater: " + array[i]);
                }
            }
            Integer[] lessArray = new Integer[less.size()];
            lessArray = less.toArray(lessArray);

            return sort(lessArray);
        }
        return array;
    }

}
