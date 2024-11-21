package task1.b;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String string = "Here is my char array";
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList = MyUtility.takeThirdLetter(string);
        System.out.println(arrayList.toString());
    }

}
