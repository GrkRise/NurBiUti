package com.rizzhivaykini.nurbiuti.Classes;

import com.rizzhivaykini.nurbiuti.R;

import java.util.Random;

/**
 * Created by GrkRise on 08.07.2016.
 */

public class Cheeses {
    private static final Random RANDOM = new Random();

    public static int getRandomCheesesDrawable(){
        switch (RANDOM.nextInt(5)){
            default:
                return R.drawable.cheese_1;
            case 0:
                return R.drawable.cheese_1;
            case 1:
                return R.drawable.cheese_2;
            case 2:
                return R.drawable.cheese_3;
            case 3:
                return R.drawable.cheese_4;
            case 4:
                return R.drawable.cheese_5;
            case 5:
                return R.drawable.cheese_5;
        }

    }

    public static final String[] sCheeseString = {
            "Emma", "Holly", "Molly", "Steve", "Bill",
            "Adam", "Joe", "Frank", "Green", "Ashby",
            "Coco", "Lloyd", "Eve", "Cris", "Sisi",
            "Don", "Dom", "Tom", "Rom", "Lom",
            "Rick", "Dick", "Jack", "Blake", "Tess",
            "Rose", "Pol", "Norm", "Set", "Zet",
            "Hope", "Gareth", "Yumi", "Collin", "Patrik"
    };
}
