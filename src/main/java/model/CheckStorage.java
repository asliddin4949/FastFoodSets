package model;

import java.util.List;

public interface CheckStorage <T> {
    //******** interface to check Existing Objects from Storage*********
    boolean isExist(List<T> list,String field);
}
