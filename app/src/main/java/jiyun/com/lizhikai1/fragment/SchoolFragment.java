package jiyun.com.lizhikai1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.lizhikai1.R;
import jiyun.com.lizhikai1.adapter.RevAdapter;
import jiyun.com.lizhikai1.bean.DbBean;
import jiyun.com.lizhikai1.bean.RevBean;
import jiyun.com.lizhikai1.net.MyServer;
import jiyun.com.lizhikai1.utils.DbUtils;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends Fragment implements RevAdapter.OnClickListener {


    private RecyclerView rev;
    private ArrayList<RevBean.DataBean.DatasBean> list;
    private RevAdapter adapter;

    public SchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention, container, false);
        initView(view);
        initData();
        return view;

    }
//网络解析
    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer server = retrofit.create(MyServer.class);
        Observable<RevBean> data = server.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RevBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RevBean revBean) {
                        list.addAll(revBean.getData().getDatas());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rev = (RecyclerView) view.findViewById(R.id.rev);
        //创建数据源
        list = new ArrayList<>();
        //绑定适配器
        adapter = new RevAdapter(getContext(), list);
        rev.setAdapter(adapter);
        //布局展现方式
        rev.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setClickListener(this);
    }

    @Override
    public void onclick(int p, RevBean.DataBean.DatasBean datasBean) {
        DbBean bean = new DbBean();
        bean.setTitle(datasBean.getTitle());
        bean.setPic(datasBean.getEnvelopePic());
        DbUtils.getDbutils().insert(bean);
    }
}
