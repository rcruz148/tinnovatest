package com.zurcnanor.tinnovatest.interfaces;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interface to map the information FROM an object TO another
 *
 * @param <TFrom>
 * @param <STo>
 */
public interface IMapper<TFrom, STo>{

    STo map(TFrom from);

    default List<STo> map(List<TFrom> fromList) {
        if (null == fromList)
            return Collections.EMPTY_LIST;

        return fromList.stream()
                .map(from -> map(from))
                .collect(Collectors.toList());
    }

}
