package com.venturus.general.venturusflix.util;

import java.util.List;

public class DataUtils {

    public static boolean validString(String string) {
        return string != null && !string.isBlank();
    }

    public static boolean validList(List<String> list) {
        return list != null && !list.isEmpty();
    }
}
