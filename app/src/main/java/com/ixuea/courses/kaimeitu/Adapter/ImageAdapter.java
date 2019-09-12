package com.ixuea.courses.kaimeitu.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ixuea.courses.kaimeitu.R;
import com.ixuea.courses.kaimeitu.domain.Image;
import com.ixuea.courses.kaimeitu.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<Image> datas = new ArrayList<com.ixuea.courses.kaimeitu.domain.Image>();
    private final Context context;
    private final LayoutInflater inflater;

    public ImageAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //注意这里，一定要将parent传递到inflate方法
        return new ViewHolder(inflater.inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(ArrayList<com.ixuea.courses.kaimeitu.domain.Image> datas){
        this.datas.clear();
        this.datas.addAll(datas);
        //刷新数据，只有刷新数据，RecycleView才知道数据变更了
        notifyItemRangeInserted(0,this.datas.size());
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }

        public void bindData(com.ixuea.courses.kaimeitu.domain.Image image) {
            //显示图片
            ImageUtil.show((Activity) context,iv,image.getUri());
        }
    }
}
