/*
    TestData
    Autor: Mike Nielsen
    Project: JNutshell
 */

import java.util.ArrayList;
import java.util.List;

public class TestData {
    class User {

        private String name;
        private int comedy;
        private int action;
        private int drama;
        private int horror;
        private int romance;


        public User(String name, int comedy, int action, int drama, int horror, int romance) {
            this.name = name;
            this.comedy = comedy;
            this.action = action;
            this.drama = drama;
            this.horror = horror;
            this.romance = romance;
        }

        public List<KValue> getKValues() {
            List<KValue> values = new ArrayList<>();
            values.add(new KValue(this.comedy));
            values.add(new KValue(this.action));
            values.add(new KValue(this.drama));
            values.add(new KValue(this.horror));
            values.add(new KValue(this.romance));
            return values;
        }


        public String getName() {
            return this.name;
        }

        public int getComedy() {
            return this.comedy;
        }

        public int getAction() {
            return this.action;
        }

        public int getDrama() {
            return this.drama;
        }

        public int getHorror() {
            return this.horror;
        }

        public int getRomance() {
            return romance;
        }
    }
}
