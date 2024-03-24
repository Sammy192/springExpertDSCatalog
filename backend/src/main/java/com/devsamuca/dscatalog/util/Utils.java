package com.devsamuca.dscatalog.util;

import com.devsamuca.dscatalog.entities.Product;
import com.devsamuca.dscatalog.projections.ProductProjection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    public static List<Product> replace(List<ProductProjection> ordered, List<Product> unordered) {
        //pega o segundo param que é lista desordenada e ordena ela com base na lista ordenada do primeiro param.

        //copia a lista pra dentro do map pois o map é mais eficiente na busca de um elemento
        Map<Long, Product> map = new HashMap<>();
        for (Product obj : unordered) {
            map.put(obj.getId(), obj);
        }

        List<Product> result = new ArrayList<>();
        for ( ProductProjection obj : ordered) {
            result.add(map.get(obj.getId()));
        }

        return result;
    }
}
