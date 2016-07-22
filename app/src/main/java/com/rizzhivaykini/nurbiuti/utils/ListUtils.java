package com.rizzhivaykini.nurbiuti.utils;

import java.util.List;

/**
 * Created by GrkRise on 19.07.2016.
 */

public class ListUtils {
    public static final String DEFAULT_JOIN_SEPARATOR = ",";

    private ListUtils(){
        throw new AssertionError();
    }

    public static <V> int getSize(List<V> sourceList){
        return sourceList == null ? 0 : sourceList.size();
    }
}
