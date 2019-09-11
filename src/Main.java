import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        if(args.length > 0){
            if(args[0].matches("weather")){
                if(args.length > 1)
                {
                    String argument = "";
                    for(int i=1; i < args.length; i++)
                    {
                        argument = argument.concat(args[i] + " ");
                    }
                    main.callWeather(argument);
                }
            }
        }
    }

    public void showGUI(WeatherStream.WeatherData data){
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        frame.setMaximumSize(new Dimension(500, 200));
        frame.setMinimumSize(new Dimension(500, 200));
        frame.setResizable(false);

        JPanel panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(500, 50));
        JLabel label = new JLabel("Enter City");

        JTextField textField = new JTextField(20);
        JButton send = new JButton("Send");
        panelTop.add(label);
        panelTop.add(textField);
        panelTop.add(send);

        JPanel panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(500,50));
        JLabel weatherLabel = new JLabel("Weather in " + data.city + " " +
                data.type + " with " + data.description + " and temperature " + data.temperature);
        panelBottom.add(weatherLabel);
        panelBottom.add(weatherLabel);
        panelBottom.add(weatherLabel);

        frame.getContentPane().add(BorderLayout.NORTH, panelTop);
        frame.getContentPane().add(BorderLayout.SOUTH, panelBottom);
        frame.setVisible(true);


    }

    public void callWeather(String city){
        WeatherStream weatherStream = new WeatherStream("{YOUR APIKEY}", WeatherStream.UnitsForm.metric);
        WeatherStream.WeatherData data = weatherStream.requestWeatherData(city);
        this.showGUI(data);
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
