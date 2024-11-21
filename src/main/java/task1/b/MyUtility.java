package task1.b;

import java.util.ArrayList;

public final class MyUtility {
    private MyUtility() {};

    public static ArrayList<Character> takeThirdLetter (String s) {
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 2; i < s.length(); i+=3) {
            arrayList.add(s.charAt(i));
        }
        return arrayList;
    }

}
