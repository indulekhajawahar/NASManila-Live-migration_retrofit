package com.mobatia.nasmanila.activities.staff_directory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mobatia.nasmanila.R;
import com.mobatia.nasmanila.activities.home.HomeListAppCompatActivity;
import com.mobatia.nasmanila.activities.staff_directory.adapter.CustomStaffDeptRecyclerAdapter;
import com.mobatia.nasmanila.activities.staff_directory.adapter.StaffAdapterAdapterNew;
import com.mobatia.nasmanila.activities.staff_directory.model.StaffCategoriListResponseModel;
import com.mobatia.nasmanila.activities.staff_directory.model.StaffModel;
import com.mobatia.nasmanila.constants.JSONConstants;
import com.mobatia.nasmanila.constants.URLConstants;
import com.mobatia.nasmanila.manager.AppUtils;
import com.mobatia.nasmanila.manager.HeaderManager;
import com.mobatia.nasmanila.manager.PreferenceManager;
import com.mobatia.nasmanila.retrofit.APIClient;
import com.mobatia.nasmanila.retrofit.APIInterface;
import com.mobatia.nasmanila.retrofit.Categori;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gayatri on 17/3/17.
 */
public class StaffListActivity extends Activity implements URLConstants, JSONConstants {
    private Context mContext;
    RelativeLayout relativeHeader;
    HeaderManager headermanager;
    ImageView back;
    ImageView home;
    //ListView mStaffListView;
    private RecyclerView mStaffListView;

    Bundle extras;
    String category_id, title;
    ArrayList<StaffModel> mStaffDeptList;
    ArrayList<Map<String, ArrayList<StaffModel>>> list=new ArrayList<>();
    HashMap<String, ArrayList<StaffModel>> hashmap =
            new HashMap<String, ArrayList<StaffModel>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_list);
        mContext = this;
        initialiseUI();
        if (AppUtils.isNetworkConnected(mContext)) {
            callStaffListAPI(URL_GETSTAFFLDEPT_LIST);
        } else {
            AppUtils.showDialogAlertDismiss((Activity) mContext, "Network Error", getString(R.string.no_internet), R.drawable.nonetworkicon, R.drawable.roundred);

        }
    }

    private void initialiseUI() {
        extras = getIntent().getExtras();
        if (extras != null) {
            category_id = extras.getString("category_id");
            title = extras.getString("title");
        }
        relativeHeader = (RelativeLayout) findViewById(R.id.relativeHeader);
        mStaffListView = (RecyclerView) findViewById(R.id.mStaffListView);
        mStaffListView.setHasFixedSize(true);
        headermanager = new HeaderManager(StaffListActivity.this, title);
        headermanager.getHeader(relativeHeader, 0);
        back = headermanager.getLeftButton();
        headermanager.setButtonLeftSelector(R.drawable.back,
                R.drawable.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.hideKeyBoard(mContext);
                finish();
            }
        });
        home = headermanager.getLogoButton();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(mContext, HomeListAppCompatActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mStaffListView.setLayoutManager(llm);

       /* mStaffListView.addOnItemTouchListener(new RecyclerItemListener(getApplicationContext(), mStaffListView,
                new RecyclerItemListener.RecyclerTouchListener() {
                    public void onClickItem(View v, int position) {

                    }

                    public void onLongClickItem(View v, int position) {
                        System.out.println("On Long Click Item interface");
                    }
                }));*/
    }

    private void callStaffListAPI(String URL) {


        APIInterface service = APIClient.getRetrofitInstance().create(APIInterface.class);
        JsonObject paramObject = new JsonObject();
        paramObject.addProperty("staffcategory_id", category_id);
        Call<StaffCategoriListResponseModel> call = service.getstaffdeptlist("Bearer "+PreferenceManager.getAccessToken(mContext),paramObject);
        call.enqueue(new Callback<StaffCategoriListResponseModel>()
        {
            @Override
            public void onResponse(Call<StaffCategoriListResponseModel> call, Response<StaffCategoriListResponseModel> response) {
                if (response.isSuccessful()) {
                    StaffCategoriListResponseModel apiResponse = response.body();
                    String responsCode = apiResponse.getResponsecode();
                    if (responsCode.equals("200")) {
                        String statusCode = apiResponse.getResponse().getStatuscode();

                        if (statusCode.equals("303")) {
                            ArrayList<String> deptArrayList = new ArrayList<String>();
                            if (apiResponse.getResponse().getData().getDepartments().size() > 0) {
                                String depObject = "";

                                for (int i = 0; i < apiResponse.getResponse().getData().getDepartments().size(); i++) {

                                    depObject = apiResponse.getResponse().getData().getDepartments().get(i);
                                    deptArrayList.add(depObject);

                                }
                                for (int j = 0; j < deptArrayList.size(); j++) {


                                    ArrayList<Categori> listt=new ArrayList<Categori>();



                                    // System.out.println("staffdept----name--1--" + j + "---" + keyArray);
                                    mStaffDeptList = new ArrayList<>();
                                    for (Map<String, ArrayList<StaffModel>> departmentMap : apiResponse.getResponse().getData().getStaffs()) {
                                        for (Map.Entry<String, ArrayList<StaffModel>> entry : departmentMap.entrySet()) {
                                            Categori directory = new Categori(entry.getKey(), entry.getValue());
                                            listt.add(directory);
                                            Log.e("list", String.valueOf(listt));
                                            //Log.e("list1", String.valueOf(listt.get(0).getDepartmentName()));
                                           // Log.e("list1", String.valueOf(listt.get(0).getStaffList().get(0).getStaffName()));


                                        }
                                    }
                                      StaffAdapterAdapterNew customStaffDeptAdapter = new StaffAdapterAdapterNew(mContext, listt);
                                mStaffListView.setAdapter(customStaffDeptAdapter);
                                    /*if (apiResponse.getResponse().getData().getStaffs().size() > 0) {
                                        for (int l = 0; l < apiResponse.getResponse().getData().getStaffs().size(); l++) {
                                            list.add(apiResponse.getResponse().getData().getStaffs().get(l));

                                            Log.e("list", String.valueOf(list));
                                          //  try {
                                                *//*JSONObject jsonObject = new JSONObject(eventJson);
                        Log.e("jsonobjet", String.valueOf(jsonObject));
                                                mStaffDeptList.add(addStaffDeptDetails(jsonObject));*//*
                                                // Log.e("Parentessentialsq", String.valueOf(newsLetterModelArrayList));

                                         //   } catch (JSONException e) {
                                            //    e.printStackTrace();
                                        //    }


                                        }

                                    }*/
                                    hashmap.put(deptArrayList.get(j), mStaffDeptList);

                                }

                                System.out.println("hashmap size--" + hashmap.size() + "--" + mStaffDeptList.size());

                               /* StaffAdapterAdapterNew customStaffDeptAdapter = new StaffAdapterAdapterNew(mContext, list);
                                mStaffListView.setAdapter(customStaffDeptAdapter);*/
                                if (hashmap.size() == 1 && mStaffDeptList.size() == 0) {
                                    AppUtils.showDialogAlertFinish((Activity) mContext, mContext.getString(R.string.alert_heading), mContext.getString(R.string.no_details_available), R.drawable.exclamationicon, R.drawable.round);

                                } else {
                                    /*StaffAdapterAdapterNew customStaffDeptAdapter = new StaffAdapterAdapterNew(mContext, deptArrayList, hashmap);
                                    mStaffListView.setAdapter(customStaffDeptAdapter);*/
                                }
                            }
                            else {
                                mStaffDeptList = new ArrayList<>();
                                for (int j = 0; j < apiResponse.getResponse().getData().getStaffs().size(); j++) {
                                  //  JSONObject staffObject = staffArray.getJSONObject(j);
                                  /*  StaffModel item = apiResponse.getResponse().getData().getStaffs().get(j);
                                    Gson gson = new Gson();
                                    String eventJson = gson.toJson(item);
                                    try {
                                        JSONObject jsonObject = new JSONObject(eventJson);

                                        mStaffDeptList.add(addStaffDeptDetails(jsonObject));                                        // Log.e("Parentessentialsq", String.valueOf(newsLetterModelArrayList));

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }*/

                                    //System.out.println("staffdept----name--"+currentKey);


                                }
                                System.out.println("staffdept----name--" + mStaffDeptList.size());

                                CustomStaffDeptRecyclerAdapter customStaffDeptAdapter = new CustomStaffDeptRecyclerAdapter(mContext, mStaffDeptList, "");
                                mStaffListView.setAdapter(customStaffDeptAdapter);

                            }
                        }
                    }
                }
                //Log.e("response", String.valueOf(apiResponse));
            }
            @Override
            public void onFailure(Call<StaffCategoriListResponseModel> call, Throwable t) {
                //progressDialogP.hide();
                Log.e("toadst", String.valueOf(t));
                //Toast.makeText(mContext, "Successfully sent email to staff"+t, Toast.LENGTH_SHORT);

            }});



       /* VolleyWrapper volleyWrapper = new VolleyWrapper(URL);
        String[] name = {"access_token", "staffcategory_id"};
        String[] value = {PreferenceManager.getAccessToken(mContext), category_id};
        volleyWrapper.getResponsePOST(mContext, 11, name, value, new VolleyWrapper.ResponseListener() {
            @Override
            public void responseSuccess(String successResponse) {
                System.out.println("The response is" + successResponse);
                try {
                    JSONObject obj = new JSONObject(successResponse);
                    String response_code = obj.getString(JTAG_RESPONSECODE);
                    if (response_code.equalsIgnoreCase("200")) {
                        JSONObject secobj = obj.getJSONObject(JTAG_RESPONSE);
                        String status_code = secobj.getString(JTAG_STATUSCODE);
                        if (status_code.equalsIgnoreCase("303")) {

                            JSONObject dataObject = secobj.getJSONObject("data");
                            ArrayList<String> deptArrayList = new ArrayList<String>();
                            JSONArray staffArray = dataObject.getJSONArray("staffs");
                            JSONArray depArray = dataObject.getJSONArray("departments");
                            if (depArray.length() > 0) {
                                String depObject = "";

                                for (int i = 0; i < depArray.length(); i++) {

                                    depObject = depArray.getString(i);
                                    deptArrayList.add(depObject);

                                }

                                for (int j = 0; j < deptArrayList.size(); j++) {


                                    JSONObject staffObject = staffArray.getJSONObject(j);

                                    JSONArray keyArray = staffObject.getJSONArray(deptArrayList.get(j));
                                    System.out.println("staffdept----name--1--" + j + "---" + keyArray);
                                    mStaffDeptList = new ArrayList<>();
                                    if (keyArray.length() > 0) {
                                        for (int l = 0; l < keyArray.length(); l++) {

                                            JSONObject keyObj = keyArray.getJSONObject(l);
                                            mStaffDeptList.add(addStaffDeptDetails(keyObj));
                                        }

                                    }*//*else{
                                        deptArrayList.remove(j);
                                    }*//*
                                    //if(mStaffDeptList.size()>0) {
                                        hashmap.put(deptArrayList.get(j), mStaffDeptList);
                                   // }

                                }
                                System.out.println("hashmap size--" + hashmap.size()+"--"+mStaffDeptList.size());

                                *//*StaffAdapterAdapterNew customStaffDeptAdapter = new StaffAdapterAdapterNew(mContext, deptArrayList,mStaffDeptList);
                                mStaffListView.setAdapter(customStaffDeptAdapter);*//*
                              if(hashmap.size()==1&&mStaffDeptList.size()==0){
                                  AppUtils.showDialogAlertFinish((Activity) mContext, mContext.getString(R.string.alert_heading), mContext.getString(R.string.no_details_available), R.drawable.exclamationicon, R.drawable.round);

                              }else {
                                  StaffAdapterAdapterNew customStaffDeptAdapter = new StaffAdapterAdapterNew(mContext, deptArrayList, hashmap);
                                  mStaffListView.setAdapter(customStaffDeptAdapter);
                              }
                            } else {
                                mStaffDeptList = new ArrayList<>();
                                for (int j = 0; j < staffArray.length(); j++) {
                                    JSONObject staffObject = staffArray.getJSONObject(j);

                                    mStaffDeptList.add(addStaffDeptDetails(staffObject));
                                    //System.out.println("staffdept----name--"+currentKey);


                                }
                                System.out.println("staffdept----name--" + mStaffDeptList.size());

                                    CustomStaffDeptRecyclerAdapter customStaffDeptAdapter = new CustomStaffDeptRecyclerAdapter(mContext, mStaffDeptList, "");
                                    mStaffListView.setAdapter(customStaffDeptAdapter);

                            }


                                *//*CustomStaffDirectoryAdapter customStaffDirectoryAdapter = new CustomStaffDirectoryAdapter(mContext, mStaffDirectoryListArray);
                                mStaffDirectoryList.setAdapter(customStaffDirectoryAdapter);*//*
                           *//* } else {
                                Toast.makeText(StaffListActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                            }*//*
                        }
                    } else if (response_code.equalsIgnoreCase("500")) {
                        AppUtils.showDialogAlertDismiss((Activity) mContext, "Alert", getString(R.string.common_error), R.drawable.exclamationicon, R.drawable.round);

                    } else if (response_code.equalsIgnoreCase("400")) {
                        AppUtils.getToken(mContext, new AppUtils.GetTokenSuccess() {
                            @Override
                            public void tokenrenewed() {
                            }
                        });
                        callStaffListAPI(URL_GETSTAFFLDEPT_LIST);

                    } else if (response_code.equalsIgnoreCase("401")) {
                        AppUtils.getToken(mContext, new AppUtils.GetTokenSuccess() {
                            @Override
                            public void tokenrenewed() {
                            }
                        });
                        callStaffListAPI(URL_GETSTAFFLDEPT_LIST);

                    } else if (response_code.equalsIgnoreCase("402")) {
                        AppUtils.getToken(mContext, new AppUtils.GetTokenSuccess() {
                            @Override
                            public void tokenrenewed() {
                            }
                        });
                        callStaffListAPI(URL_GETSTAFFLDEPT_LIST);

                    } else {
                        *//*CustomDialog dialog = new CustomDialog(mContext, getResources().getString(R.string.common_error)
                                , getResources().getString(R.string.ok));
                        dialog.show();*//*
                        AppUtils.showDialogAlertDismiss((Activity) mContext, "Alert", getString(R.string.common_error), R.drawable.exclamationicon, R.drawable.round);

                    }
                } catch (Exception ex) {
                    System.out.println("The Exception in edit profile is" + ex.toString());
                }

            }

            @Override
            public void responseFailure(String failureResponse) {
               *//* CustomDialog dialog = new CustomDialog(mContext, getResources().getString(R.string.common_error)
                        , getResources().getString(R.string.ok));
                dialog.show();*//*
                AppUtils.showDialogAlertDismiss((Activity) mContext, "Alert", getString(R.string.common_error), R.drawable.exclamationicon, R.drawable.round);

            }
        });*/


    }

    /*  private StaffModel addStaffDeptDetails(JSONObject obj,String dep) {
          StaffModel model = new StaffModel();
          try {
              model.setStaffId(obj.optString("id"));
              model.setStaffName(obj.optString("name"));
              model.setStaffDepartment(dep);
              model.setStaffPhoneNo(obj.optString("phone"));
              model.setStaffAbout(obj.getString("about"));
              model.setStaffEmail(obj.optString("email"));
              model.setStaffContactNo(obj.optString("contact"));
          } catch (Exception ex) {
              System.out.println("Exception is" + ex);
          }

          return model;
      }
  */
    private StaffModel addStaffDeptDetails(JSONObject obj) {
        StaffModel model = new StaffModel();
        try {
            model.setStaffId(obj.optString("id"));
            model.setStaffName(obj.optString("name"));
            model.setStaffPhoneNo(obj.optString("phone"));
            //model.setStaffAbout(obj.getString("about"));
            model.setStaffEmail(obj.optString("email"));
            model.setRole(obj.optString("role"));
            model.setStaffContactNo(obj.optString("contact"));
            model.setStaffImage(obj.optString("staff_photo"));
        } catch (Exception ex) {
            System.out.println("Exception is" + ex);
        }

        return model;
    }
}
