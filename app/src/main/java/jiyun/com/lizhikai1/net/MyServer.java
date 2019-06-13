package jiyun.com.lizhikai1.net;

import io.reactivex.Observable;
import jiyun.com.lizhikai1.bean.RevBean;
import retrofit2.http.GET;

public interface MyServer {
    public String URL="https://www.wanandroid.com/article/";
    @GET("list/0/json")
    Observable<RevBean>getData();
}
