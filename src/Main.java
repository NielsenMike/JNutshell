import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(190, 4, 88, 33, 2, 19, 177, 9
        , 78, 12, 16, 99, 30, 167));

        QSort quickSort = new QSort();
        quickSort.sort(array);

        for (int i=0; i < array.size(); i++){
            System.out.println(array.get(i) + ",");
        }
    }
}
