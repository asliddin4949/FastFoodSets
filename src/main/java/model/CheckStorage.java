package model;

import java.util.List;

public interface CheckStorage <T> {
    boolean isExist(List<T> list,String field);
}
