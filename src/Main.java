import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        WeatherStream weatherStream = new WeatherStream("eabbf3f8b05e66dbbd3f99c7b8a59a69", WeatherStream.UnitsForm.metric);
        weatherStream.makeRequest("New York");
    }


    public void OldMain() {
        List<Integer> array = new ArrayList<>(Arrays.asList(190, 4, 88, 33, 2, 19, 177, 9
                , 78, 12, 16, 99, 30, 167));

        QSort quickSort = new QSort();
        quickSort.sort(array);

        for (int a : array){
            System.out.println(a + ",");
        }


        TestData.User paul = new TestData().new User("Paul", 3,4,4,1,4);
        TestData.User justin = new TestData().new User("Justin", 4,3,5,1,5);
        TestData.User morpheus = new TestData().new User("Morpheus", 2,5,1,3,1);


        double distance = KNearest.distance(paul.getKValues(), justin.getKValues());

        System.out.println("Distance = " + distance);
    }

}
