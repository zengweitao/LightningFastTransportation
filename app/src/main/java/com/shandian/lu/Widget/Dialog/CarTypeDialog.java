package com.shandian.lu.Widget.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhyan.shandiankuaiyuanwidgetlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by az on 2017/5/6.
 */

public class CarTypeDialog extends Dialog {
    Context context;
    public CarTypeDialogXRVAdapter carTypeDialogXRVAdapter;

    List<String> listBeen;
    TextView textView;
    public interface OnAdapterListener{
        public void isOnclick(boolean isOnclick);
    }
    public interface DialogCallBackListener{//通过该接口回调Dialog需要传递的值
        public void callBack(String tel);//具体方法
    }
    public CarTypeDialog(Context context1, TextView textView1) {
        super(context1);
        this.context = context1;
        textView = textView1;
    }
    public CarTypeDialog(Context context1, int themeResId) {
        super(context1, themeResId);
        this.context = context1;
    }

    protected CarTypeDialog(Context context1, boolean cancelable, OnCancelListener cancelListener) {
        super(context1, cancelable, cancelListener);
        this.context = context1;
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public Builder Build = new Builder(context);
    //用Builder模式来构造Dialog
    public  class Builder {
        private Context mContext;
        private View contentView;
        private String title;
        private String message;
        private String positiveText;
        private String negativeText;
        private OnClickListener positiviOnclickListener;
        private OnClickListener negativeOnclickListener;
        private DialogCallBackListener mDialogCallBackListener;
        private OnAdapterListener onAdapterListener;

        public Builder(Context mContext) {
            this.mContext = mContext;
        }

        public Builder setContentView(View contentView) {//设置dialog的主view
            this.contentView = contentView;
            return this;
        }

        public Builder setTitle(String title) {//设置dialog的标题
            this.title = title;
            return this;
        }

        public Builder setMessage(String msg) {//设置dialig的内容
            this.message = msg;
            return this;
        }

        public Builder setPositiveButton(String text, OnClickListener positiviOnclickListener) {//dialog的确认按钮
            this.positiveText = text;
            this.positiviOnclickListener = positiviOnclickListener;
            return this;
        }

        public Builder setNegativeButton(String text, OnClickListener negativeOnclickListener) {//dialog的取消按钮
            this.negativeText = text;
            this.negativeOnclickListener = negativeOnclickListener;
            return this;
        }

        public Builder setCallBackListener(OnAdapterListener onAdapterListener1){//设置回调
            this.onAdapterListener = onAdapterListener1;
            return this;
        }


        /**
         * 1,加载要显示的布局
         * 2，通过dialog的addContentView将布局添加到window中
         * 3，基本逻辑处理
         * 4，显示dialog的布局
         */
        public CarTypeDialog build(Context context) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final CarTypeDialog cityChangeDialog = new CarTypeDialog(context, R.style.MyDialogStyle);//默认调用带style的构造
            cityChangeDialog.setCanceledOnTouchOutside(true);//默认点击布局外不能取消dialog
            View view = mInflater.inflate(R.layout.dialog_citychange, null);
            cityChangeDialog.addContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            final RecyclerView rvCityChange= (RecyclerView) view.findViewById(R.id.rv_main_index_citychange_citychange);
            initXRV(rvCityChange,cityChangeDialog);



            cityChangeDialog.setContentView(view);
            return cityChangeDialog;
        }
        private void initXRV(RecyclerView recyclerView,CarTypeDialog cityChangeDialog){


            String[]carTypes=new String []{"厢式车","平板车","高低板车","高栏车","中栏车","低栏车","罐式车","冷藏车","保温车","危险品车","铁笼车","集装箱车","自卸货车","其他车型",};

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3);
            carTypeDialogXRVAdapter = new CarTypeDialogXRVAdapter(context,carTypes,textView,cityChangeDialog);
            carTypeDialogXRVAdapter.setOnSelectedCallBack(new CarTypeDialogXRVAdapter.OnSelectListener() {
                @Override
                public void onClick(boolean isSelected) {
                    if(isSelected == true){
                        if(onAdapterListener != null){
                            onAdapterListener.isOnclick(true);
                        }
                    }
                }
            });
            recyclerView.setAdapter(carTypeDialogXRVAdapter);
            recyclerView.setLayoutManager(gridLayoutManager);
        }

    }

}
