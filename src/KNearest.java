/*
    KNN Algorithm
    Autor: Mike Nielsen
    Project: JNutshell
 */

import java.util.List;

class KValue{
    double value;
    public KValue(double value){
        this.value = value;
    }
}
public class KNearest {
    public static double distance(List<KValue> value1, List<KValue>  value2){
        double sum = -1;
        if(value1.size() == value2.size()){
            sum = 0;
            for(int i=0; i < value1.size(); i++){
                sum += Math.pow((value1.get(i).value - value2.get(i).value), 2);
            }
            sum = Math.sqrt(sum);
        }
        return sum;
    }
}
