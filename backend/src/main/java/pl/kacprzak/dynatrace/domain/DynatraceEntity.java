package pl.kacprzak.dynatrace.domain;


import java.util.List;

public class DynatraceEntity {


    private String id;
    private List<Integer> data;

    private int size;


    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
