package com.zlaqh.baseconverter;

import java.util.ArrayList;

/**
 * Created by zlaqh on 3/17/17.
 */

public class DecimalToOther {
    int startingNum, mod, quotient;
    String targetNum;
    ArrayList<Integer> modList;

    public String Convert(int startingNumber, int targetBase) {

//        - divide the sNum by the tBase and store in an int,
//        - mod the sNum by the tBase and store in an int,
//        - store the mod in reverse order in an array or arraylist
//        - keep going until you reach 0=sNum

        this.startingNum = startingNumber;
        modList = new ArrayList<>();

        do {
            startingNumber = (startingNumber / targetBase);
            mod = (startingNumber % targetBase);
            modList.add(0, mod);
        } while (startingNumber != 0);

        StringBuilder sb = new StringBuilder();
        for (int i: modList) {
            sb.append(i);
        }
        targetNum = sb.toString();

        return targetNum;
    }
}
