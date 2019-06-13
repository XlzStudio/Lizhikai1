package jiyun.com.lizhikai1.bean;

public class Onebean {
    private String name;
    private String imag;

    public Onebean(String name, String imag) {
        this.name = name;
        this.imag = imag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "Onebean{" +
                "name='" + name + '\'' +
                ", imag='" + imag + '\'' +
                '}';
    }
}
