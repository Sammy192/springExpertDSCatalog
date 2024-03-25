package com.devsamuca.dscatalog.util;

import com.devsamuca.dscatalog.entities.Product;
import com.devsamuca.dscatalog.projections.IdProjection;
import com.devsamuca.dscatalog.projections.ProductProjection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    public static <ID> List<? extends IdProjection<ID>> replace(List<? extends IdProjection<ID>> ordered, List<? extends IdProjection<ID>> unordered) {
        //pega o segundo param que é lista desordenada e ordena ela com base na lista ordenada do primeiro param.

        //copia a lista pra dentro do map pois o map é mais eficiente na busca de um elemento
        Map<ID, IdProjection<ID>> map = new HashMap<>();
        for (IdProjection<ID> obj : unordered) {
            map.put(obj.getId(), obj);
        }

        List<IdProjection<ID>> result = new ArrayList<>();
        for ( IdProjection<ID> obj : ordered) {
            result.add(map.get(obj.getId()));
        }

        return result;
    }
}
