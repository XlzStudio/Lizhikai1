package jiyun.com.lizhikai1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import jiyun.com.lizhikai1.R;
import jiyun.com.lizhikai1.bean.Onebean;
import jiyun.com.lizhikai1.bean.RevBean;

public class RevAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<RevBean.DataBean.DatasBean>list;



    public RevAdapter(Context context, ArrayList<RevBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View view = View.inflate(context, R.layout.layout_item_one, null);
            OneViewHolder holder = new OneViewHolder(view);
            return holder;
        }else if (i==1){
            View view = View.inflate(context, R.layout.layout_item_two, null);
            TwoViewHolder holder1 = new TwoViewHolder(view);
            return holder1;
        }else {
            View view = View.inflate(context, R.layout.layout_item_two, null);
            ThreeViewHolder holder2 = new ThreeViewHolder(view);
            return holder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (getItemViewType(i)==0){
            OneViewHolder holder= (OneViewHolder) viewHolder;

        }else if (getItemViewType(i)==1){
            TwoViewHolder holder1= (TwoViewHolder) viewHolder;
            holder1.twotv.setText(list.get(i).getTitle());
            Glide.with(context).load(list.get(i).getEnvelopePic()).into(holder1.twoimg);
          /* viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   clickListener.onclick(i,list.get(i));
               }
           });*/
        }else {
            ThreeViewHolder holder2= (ThreeViewHolder) viewHolder;
            int pos=0;
            if (list.size() > 0) {
                pos = i - 1;
            }else {
                pos = i;
            }
            holder2.threetv.setText(list.get(pos).getTitle());
            Glide.with(context).load(list.get(pos).getEnvelopePic()).into(holder2.threeimg);
        }


    }

    @Override
    public int getItemCount() {
        if (list.size() > 0) {
            return list.size() + 1;
        } else {
            return list.size();
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    class OneViewHolder extends RecyclerView.ViewHolder {
        private ImageView oneimg;
        private TextView onetv;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            oneimg=itemView.findViewById(R.id.oneimg);
            onetv=itemView.findViewById(R.id.onetv);
        }
    }
    class TwoViewHolder extends RecyclerView.ViewHolder {
        private ImageView twoimg;
        private TextView twotv;
        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            twoimg=itemView.findViewById(R.id.twoimg);
            twotv=itemView.findViewById(R.id.twotv);

        }
    }
    class ThreeViewHolder extends RecyclerView.ViewHolder {
        private ImageView threeimg;
        private TextView threetv;
        public ThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            threeimg=itemView.findViewById(R.id.threeimg);
            threetv=itemView.findViewById(R.id.threetv);
        }
    }
    private OnClickListener clickListener;

    public void setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnClickListener{
        void onclick(int p,RevBean.DataBean.DatasBean datasBean);
    }
}
