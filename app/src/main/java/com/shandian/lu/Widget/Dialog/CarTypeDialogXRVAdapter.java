package com.shandian.lu.Widget.Dialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhyan.shandiankuaiyunlib.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by az on 2017/4/26.
 */

public class CarTypeDialogXRVAdapter extends RecyclerView.Adapter<CarTypeDialogXRVAdapter.ItemViewHolder>  {

    private String[] stringList;
    private Context context;
    private LayoutInflater inflater;
    private ImageLoader imageLoader;
    private final int CITY_CHANGE_SELECTED = 99;
    private TextView textView;
    CarTypeDialog cityChangeDialog;
    public interface OnSelectListener{
        public void onClick(boolean isSelected);
    }
    public OnSelectListener onSelectListener;
    public void setOnSelectedCallBack(OnSelectListener onSelectListener1){
        this.onSelectListener = onSelectListener1;
    }

    public CarTypeDialogXRVAdapter(Context context1, String[] stringList1, TextView textView1, CarTypeDialog cityChangeDialog1){
        stringList = stringList1;
        context = context1;
        inflater = LayoutInflater.from(context1);
        imageLoader = ImageLoader.getInstance();
        textView = textView1;
        cityChangeDialog = cityChangeDialog1;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ItemViewHolder(inflater.inflate(R.layout.dialog_main_release_zhuanxianwuliu_cartype_lly,parent,false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.tvMainReleaseCarType.setText(stringList[position]);
        holder.pos = position;
      /*      holder.tvMainIndexCityChangeCity.setText(stringList.get(position).getProvince());*/
       /* imageLoader.displayImage(holder.ivMainMineWoDeHuoYuan,stringList.getContent().get(position).getImg1());*/
    }

    @Override
    public int getItemCount() {
        return stringList.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        int pos = 0;
        View view1;
        @BindView(R.id.tv_main_release_cartype)
        TextView tvMainReleaseCarType;
        @BindView(R.id.rly_main_release_cartype)
        RelativeLayout rlymainReleaseCarType;
        @OnClick(R.id.rly_main_release_cartype)
        public void rlymainReleaseCarTypeOnclick(){
            textView.setText(tvMainReleaseCarType.getText().toString());
            if(onSelectListener != null) {
                onSelectListener.onClick(true);
            }
            cityChangeDialog.dismiss();
          /*  ((Activity) context).finish();*/
        }
        public ItemViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
            view1 = view;
        }
    }
}
