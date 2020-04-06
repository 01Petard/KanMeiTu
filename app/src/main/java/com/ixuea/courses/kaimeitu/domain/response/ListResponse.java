package com.ixuea.courses.kaimeitu.domain.response;

import java.util.List;

public class ListResponse<T> {

    private List<T> data;

    public List<T> getdata() {return data;}

    public void setData(List<T> data) {this.data = data;}


}
