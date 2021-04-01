package com.fuwafuwa.workflow.plugins.cipher.lib;

import androidx.annotation.NonNull;

import com.fuwafuwa.utils.RegexHelper;
import com.fuwafuwa.workflow.bean.Kwags;
import com.fuwafuwa.workflow.plugins.cipher.payload.CipherPayload;
import com.fuwafuwa.workflow.plugins.ibase.MapFormDict;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CipherRemark {

    public static String get(@NonNull CipherPayload payload) {
        HashMap<String, List<Kwags>> mapper = MapFormDict.optionsMaker(payload.getCipherType());
        StringBuilder stringBuilder = new StringBuilder();
        if (RegexHelper.isNotEmpty(mapper)) {
            stringBuilder.append("备注：\n\n");
            for (Map.Entry<String, List<Kwags>> entry : mapper.entrySet()) {
                stringBuilder.append(String.format("『%s』\n", entry.getKey()));
                List<Kwags> list = entry.getValue();
                if (list != null) {
                    for (Kwags item : list) {
                        stringBuilder.append("\t")
                                .append(item.getKey())
                                .append(" 值: ")
                                .append(item.getValue())
                                .append("\n");
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
