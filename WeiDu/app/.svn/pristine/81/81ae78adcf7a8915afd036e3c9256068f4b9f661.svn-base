package com.bw.movie.ui.cinema.view;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.mvpbase.BasePresenter;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends BaseActivity implements LocationSource, AMapLocationListener {
    private static final String TAG = MapActivity.class.getSimpleName();
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.mapView)
    MapView mapView;
    @BindView(R.id.activity_test_location)
    RelativeLayout activityTestLocation;
    private AMap aMap;
    private AMapLocationClient mLocationClient = null;
    private AMapLocationClientOption mLocationOption = null;
    private OnLocationChangedListener mListener = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        init();
        // 创建地图
        mapView.onCreate(savedInstanceState);
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_map;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }

    private void init() {
        Log.i(TAG,"init()");
        location = (TextView) findViewById(R.id.location);
        mapView =(MapView) findViewById(R.id.mapView);
        if (aMap == null) {
            // 显示地图
            aMap = mapView.getMap();
        }

        aMap.getUiSettings().setZoomControlsEnabled(false);
        // 设置地图默认的指南针是否显示
        aMap.getUiSettings().setCompassEnabled(true);
        // 设置定位监听
        aMap.setLocationSource(this);
        // 设置默认定位按钮是否显示
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setMyLocationEnabled(true);
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);

        // 初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        // 设置高德地图定位回调监听
        mLocationClient.setLocationListener(this);
        // 初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        // 高精度定位模式：会同时使用网络定位和GPS定位，优先返回最高精度的定位结果，以及对应的地址描述信息
        // 设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        // 低功耗定位模式：不会使用GPS和其他传感器，只会使用网络定位（Wi-Fi和基站定位）；
        //设置定位模式为AMapLocationMode.Battery_Saving，低功耗模式。
        //mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        // 仅用设备定位模式：不需要连接网络，只使用GPS进行定位，这种模式下不支持室内环境的定位，自 v2.9.0 版本支持返回地址描述信息。
        // 设置定位模式为AMapLocationMode.Device_Sensors，仅设备模式。
        //mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);
        // SDK默认采用连续定位模式，时间间隔2000ms
        // 设置定位间隔，单位毫秒，默认为2000ms，最低1000ms。
        mLocationOption.setInterval(3000);
        // 设置定位同时是否需要返回地址描述
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        // 设置是否强制刷新WIFI，默认为强制刷新。每次定位主动刷新WIFI模块会提升WIFI定位精度，但相应的会多付出一些电量消耗。
        // 设置是否强制刷新WIFI，默认为true，强制刷新。
        mLocationOption.setWifiActiveScan(true);
        // 设置是否允许模拟软件Mock位置结果，多为模拟GPS定位结果，默认为false，不允许模拟位置。
        // 设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        // 设置定位请求超时时间，默认为30秒
        // 单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        mLocationOption.setHttpTimeOut(50000);
        // 设置是否开启定位缓存机制
        // 缓存机制默认开启，可以通过以下接口进行关闭。
        // 当开启定位缓存功能，在高精度模式和低功耗模式下进行的网络定位结果均会生成本地缓存，不区分单次定位还是连续定位。GPS定位结果不会被缓存。
        // 关闭缓存机制
        mLocationOption.setLocationCacheEnable(false);
        // 设置是否只定位一次，默认为false
        mLocationOption.setOnceLocation(false);
        // 给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        // 启动高德地图定位
        mLocationClient.startLocation();
    }



    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        Log.i(TAG,"onLocationChanged()");
        // 解析AMapLocation对象
        // 判断AMapLocation对象不为空，当定位错误码类型为0时定位成功
        if (aMapLocation != null) {
            Log.i(TAG,"onLocationChanged()--aMapLocation.getErrorCode():"+aMapLocation.getErrorCode());
            if (aMapLocation.getErrorCode() == 0) {
                int locationType = aMapLocation.getLocationType(); // 获取当前定位结果来源，如网络定位结果，详见定位类型表
                double latitude= aMapLocation.getLatitude(); // 获取纬度
                double longitude = aMapLocation.getLongitude(); // 获取经度
                float accuracy = aMapLocation.getAccuracy(); // 获取精度信息
                String address = aMapLocation.getAddress(); // 地址，如果option中设置isNeedAddress为false，则没有此结果，
                // 网络定位结果中会有地址信息，GPS定位不返回地址信息。
                String country = aMapLocation.getCountry(); // 国家信息
                String province = aMapLocation.getProvince(); // 省信息
                String city = aMapLocation.getCity(); // 城市信息
                String district = aMapLocation.getDistrict(); // 城区信息
                String street = aMapLocation.getStreet(); // 街道信息
                String streetNum= aMapLocation.getStreetNum(); // 街道门牌号信息
                String cityCode = aMapLocation.getCityCode(); // 城市编码
                String adCode = aMapLocation.getAdCode(); // 地区编码
                String aoiName= aMapLocation.getAoiName(); // 获取当前定位点的AOI信息
                String buildingId = aMapLocation.getBuildingId(); // 获取当前室内定位的建筑物Id
                String floor= aMapLocation.getFloor(); // 获取当前室内定位的楼层
                int gpsAccuracyStatus = aMapLocation.getGpsAccuracyStatus(); //获取GPS的当前状态
                // 获取定位时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);

                Log.i(TAG,"onLocationChanged()---"+"\n"
                        +"--locationType:"+locationType +"\n"
                        +"--latitude:"+latitude+"\n"
                        +"--longitude:"+longitude+"\n"
                        +"--accuracy:"+accuracy+"\n"
                        +"--address:"+address+"\n"
                        +"--country:"+country+"\n"
                        +"--province:"+province+"\n"
                        +"--city:"+city+"\n"
                        +"--district:"+district+"\n"
                        +"--street:"+street+"\n"
                        +"--streetNum:"+streetNum+"\n"
                        +"--cityCode:"+cityCode+"\n"
                        +"--adCode:"+adCode+"\n"
                        +"--aoiName:"+aoiName+"\n"
                        +"--buildingId:"+buildingId+"\n"
                        +"--floor:"+floor+"\n"
                        +"--gpsAccuracyStatus:"+gpsAccuracyStatus+"\n"
                        +"--date:"+date);

                // 设置缩放级别
                aMap.moveCamera(CameraUpdateFactory.zoomTo(17));
                // 将地图移动到定位点
                aMap.moveCamera(CameraUpdateFactory.changeLatLng(
                        new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
                // 点击定位按钮 能够将地图的中心移动到定位点
                mListener.onLocationChanged(aMapLocation);

                location.setText(address);
            } else {
                // 定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                Log.e("HLQ_Struggle", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Log.i(TAG,"onPointerCaptureChanged----hasCapture:"+hasCapture);
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        Log.i(TAG,"activate()");
        mListener = onLocationChangedListener;
    }

    @Override
    public void deactivate() {
        Log.i(TAG,"deactivate()");
        mListener = null;
    }


    @Override
    protected void onResume() {
        Log.i(TAG,"onResume()");
        super.onResume();
        // 重新绘制加载地图
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"onPause()");
        super.onPause();
        // 暂停地图的绘制
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"onDestroy()");
        super.onDestroy();
        // 销毁地图
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState()");
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
