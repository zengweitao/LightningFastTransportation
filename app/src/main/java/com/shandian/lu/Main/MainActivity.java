package com.shandian.lu.Main;

import android.app.Notification;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/*
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.SocializeConstants;*/
import com.j256.ormlite.stmt.query.In;
import com.shandian.lu.Main.AdviceFragment.MainAdviceFragment;
import com.shandian.lu.Main.IndexFragment.NewMainIndexFragment;
import com.shandian.lu.Main.MessageFragment.ChatMessageFragment;
import com.shandian.lu.Main.MineFragment.NewMainMineFragment;
import com.shandian.lu.Main.ReleaseFragment.HuiTouChe.HuiTouCheActivity;
import com.shandian.lu.Main.ReleaseFragment.MainReleaseFragment;
/*import ChatMessageFragment;*/
import com.shandian.lu.Main.ReleaseFragment.TestActivity;
import com.shandian.lu.R;
import com.shandian.lu.Widget.Dialog.ReleaseDialog;
import com.tencent.bugly.Bugly;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends FragmentActivity {
/*
    @BindView(R.id.rb_main_bottom_index)
    RadioButton rbMainBottomIndex;
    @OnClick(R.id.rb_main_bottom_index)
    public void rbMainBottomIndexOnclick(){
        getFragment("index");
    }
    @BindView(R.id.rb_main_bottom_release)
    RadioButton rbMainBottomRelease;
    @OnClick(R.id.rb_main_bottom_release)
    public void rbMainBottomReleaseOnclick(){
        getFragment("release");
    }
    @BindView(R.id.rb_main_bottom_advice)
    RadioButton rbMainBottomAdvice;
    @OnClick(R.id.rb_main_bottom_advice)
    public void rbMainBottomAdviceOnclick(){
        getFragment("advice");
    }
    @BindView(R.id.rb_main_bottom_message)
    RadioButton rbMainBottomMessage;
    @OnClick(R.id.rb_main_bottom_message)
    public void rbMainBottomMessageOnclick(){
        getFragment("message");
    }
    @BindView(R.id.rb_main_bottom_mine)
    RadioButton rbMainBottomMine;
    @OnClick(R.id.rb_main_bottom_mine)
    public void rbMainBottomMineOnclick(){
        getFragment("mine");
    }*/

    /*private MainIndexFragment mainIndexFragment;*/

    private boolean isFirst = true;
    @BindView(R.id.tv_new_main_bottom_message_unread)
    TextView tvNewMainBottomMessageUnRead;
    @BindView(R.id.rb_new_main_bottom_index)
    RadioButton rbMainBottomIndex;
    @OnClick(R.id.rb_new_main_bottom_index)
    public void rbMainBottomIndexOnclick(){
        getFragment("index");
        mainController.isSound = true;
    }

    @BindView(R.id.rb_new_main_bottom_advice)
    RadioButton rbNewMainBottomAdvice;
    @OnClick(R.id.rb_new_main_bottom_advice)
    public void rbNewMainBottomAdviceOnclick(){
        getFragment("advice");
        mainController.isSound = true;
    }
    @BindView(R.id.rb_new_main_bottom_chat)
    RadioButton rbNewMainBottomMessage;
    @OnClick(R.id.rb_new_main_bottom_chat)
    public void rbNewMainBottomMessageOnclick(){
        getFragment("message");
        tvNewMainBottomMessageUnRead.setText("0");
        tvNewMainBottomMessageUnRead.setVisibility(View.GONE);
        mainController.isSound = false;
     /*   Intent intent = new Intent(this, HuiTouCheActivity.class);
        startActivity(intent);*/
    }
    ReleaseDialog releaseDialog ;
    @BindView(R.id.ib_new_main_bottom_publish)
    ImageButton ibNewMainBottomPublish;
    @OnClick(R.id.ib_new_main_bottom_publish)
    public void ibNewMainBottomPublishOnclick(){
        releaseDialog = new ReleaseDialog(this).Build.build(this);

        showDialog();


      /*  Intent intent = new Intent(this, NewFaBuHuoYuanActivity.class);*/
       /* Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);*/
    }
    public void showDialog() {
        if (releaseDialog != null && !releaseDialog.isShowing())
            releaseDialog.show();
    }

    public void dissmissDialog() {
        if (releaseDialog != null && releaseDialog.isShowing())
            releaseDialog.dismiss();
    }

    @BindView(R.id.rb_new_main_bottom_mine)
    RadioButton rbMainBottomMine;
    @OnClick(R.id.rb_new_main_bottom_mine)
    public void rbMainBottomMineOnclick(){
        getFragment("mine");
        mainController.isSound = true;
    }











    FragmentManager manager;
    private NewMainIndexFragment mainIndexFragment;
    private MainReleaseFragment mainReleaseFragment;
    private MainAdviceFragment mainAdviceFragment;
    private ChatMessageFragment chatMessageFragmentl;
    /*private MainMineFragment mainMineFragment;*/
    private NewMainMineFragment mainMineFragment;
    private MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        setContentView(R.layout.activity_new_main);
        init();
    // Example of a call to a native method

    }

    private void init(){
        ButterKnife.bind(this);
        initController();

        getFragment("index");

    /*    initYouMeng();*/
    }
    private void initController(){
        mainController = new MainController(this);
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
  /*  public native String stringFromJNI();*/

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }






    private void hideFragment(FragmentTransaction transaction){
        if(mainIndexFragment !=null){
            transaction.hide(mainIndexFragment);
        }
        if(mainReleaseFragment != null){
            transaction.hide(mainReleaseFragment);
        }
        if(mainAdviceFragment != null){
            transaction.hide(mainAdviceFragment);
        }
        if(chatMessageFragmentl != null){
            transaction.hide(chatMessageFragmentl);
        }
        if(mainMineFragment != null){
            transaction.hide(mainMineFragment);
        }
    }
    /* 初始化fragment*/
    private void initFragment(FragmentTransaction transaction){
        /* manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();*/
        if(mainIndexFragment == null){
           /* mainController.initStatusBar("index");*/
          /*  mainIndexFragment = new MainIndexFragment();*/
            mainIndexFragment = new NewMainIndexFragment();
            transaction.add(R.id.fly_new_main_content, mainIndexFragment, "index");
        }
        if(mainReleaseFragment == null){
            mainReleaseFragment = new MainReleaseFragment();
            transaction.add(R.id.fly_new_main_content, mainReleaseFragment, "release");
        }
        if(mainAdviceFragment == null){
            mainAdviceFragment = new MainAdviceFragment();
            transaction.add(R.id.fly_new_main_content, mainAdviceFragment, "advice");
        }
        if(chatMessageFragmentl == null){
            chatMessageFragmentl = new ChatMessageFragment();
            transaction.add(R.id.fly_new_main_content, chatMessageFragmentl, "message");
        }
        if(mainMineFragment != null){
            /*mainMineFragment = new MainMineFragment();*/
            mainMineFragment = new NewMainMineFragment();
            transaction.add(R.id.fly_new_main_content, mainMineFragment, "mine");
        }
       /* transaction.show(mainIndexFragment);*/
    /*    transaction.commit();*/
    }

    private void getFragment(String type){
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(isFirst) {
            initFragment(transaction);
            isFirst = false;
        }
        hideFragment(transaction);
        // 动态增加Fragment
        switch (type){
            case "index":
                mainController.initStatusBar("index");
                if(mainIndexFragment !=null){
                    transaction.show(mainIndexFragment);
                }else {
                    /*mainIndexFragment = new MainIndexFragment();*/
                    mainIndexFragment = new NewMainIndexFragment();
                    transaction.add(R.id.fly_new_main_content, mainIndexFragment, "index");
                }
                break;
            case "release":
                mainController.initStatusBar("release");
                if(mainReleaseFragment != null){

                    transaction.show(mainReleaseFragment);
                }else {
                    mainReleaseFragment = new MainReleaseFragment();

                    transaction.add(R.id.fly_new_main_content, mainReleaseFragment, "release");
                }
                break;
            case "advice":
                mainController.initStatusBar("advice");
                if(mainAdviceFragment != null){

                    transaction.show(mainAdviceFragment);
                }else {
                    mainAdviceFragment = new MainAdviceFragment();

                    transaction.add(R.id.fly_new_main_content, mainAdviceFragment, "advice");
                }
                break;
            case "message":
                mainController.initStatusBar("message");
                if(chatMessageFragmentl != null){

                    transaction.show(chatMessageFragmentl);
                }else {
                    chatMessageFragmentl = new ChatMessageFragment();

                    transaction.add(R.id.fly_new_main_content, chatMessageFragmentl, "message");
                }

                break;
            case "mine":
                mainController.initStatusBar("mine");
                if(mainMineFragment != null){

                    transaction.show(mainMineFragment);
                }else {
                    /*mainMineFragment = new MainMineFragment();*/
                    mainMineFragment = new NewMainMineFragment();

                    transaction.add(R.id.fly_new_main_content, mainMineFragment, "mine");
                }
                break;

        }

        transaction.commit();
    }









    @Override
    protected void onResume(){
        super.onResume();
        Bugly.init(getApplicationContext(), "17b9bbc524", false);
        dissmissDialog();
        mainController.isNotice = false;
        mainController.onResume();
    }
    @Override
    protected void onStop(){
        super.onStop();
        mainController.onStop();
        mainController.isNotice = true;
    }









    long mExitTime = 0;
  //  改写返回键事件监听，使得back键功能类似home键，让Acitivty退至后台时不被系统销毁，代码如下：
  //  回退点击一次
   /* public boolean onKeyDown(int keyCode, KeyEvent event) {
        PackageManager pm = getPackageManager();
        ResolveInfo homeInfo =
                pm.resolveActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME), 0);
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ActivityInfo ai = homeInfo.activityInfo;
            Intent startIntent = new Intent(Intent.ACTION_MAIN);
            startIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            startIntent.setComponent(new ComponentName(ai.packageName, ai.name));
            startActivitySafely(startIntent);
            return true;
        } else
            return super.onKeyDown(keyCode, event);
    }*/
    private void startActivitySafely(Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "null",
                    Toast.LENGTH_SHORT).show();
        } catch (SecurityException e) {
            Toast.makeText(this, "null",
                    Toast.LENGTH_SHORT).show();
        }
    }

        @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
            PackageManager pm = getPackageManager();
            ResolveInfo homeInfo =
                    pm.resolveActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME), 0);
        if(keyCode==event.KEYCODE_BACK){
            if((System.currentTimeMillis()-mExitTime)>2000){
//				Toast.makeText(MainFragmentActivity.this,"在按一次退出程序",Toast.LENGTH_SHORT).show();
                showToast("在按一次退出程序",0,0);
                mExitTime=System.currentTimeMillis();
            }else{
                ActivityInfo ai = homeInfo.activityInfo;
                Intent startIntent = new Intent(Intent.ACTION_MAIN);
                startIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                startIntent.setComponent(new ComponentName(ai.packageName, ai.name));
                startActivitySafely(startIntent);
               /* finish();*/
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void showToast(String text, int offx, int offy) {
        Toast mToast = null;
        if (mToast == null) {
            mToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
//	            LogUtil.i("----------------"+mToast.getGravity()+"-"+mToast.getXOffset()+"-"+mToast.getYOffset());
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
//	        mToast.setGravity(gravity, offx, offy);
        mToast.show();
    }



}
