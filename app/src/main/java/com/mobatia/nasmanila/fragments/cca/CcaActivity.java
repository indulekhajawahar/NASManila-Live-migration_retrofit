package com.mobatia.nasmanila.fragments.cca;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mobatia.nasmanila.R;
import com.mobatia.nasmanila.activities.cca.CCA_Activity;
import com.mobatia.nasmanila.activities.home.HomeListAppCompatActivity;
import com.mobatia.nasmanila.activities.pdf.PDFViewActivity;
import com.mobatia.nasmanila.activities.web_view.LoadUrlWebViewActivity;
import com.mobatia.nasmanila.constants.CacheDIRConstants;
import com.mobatia.nasmanila.constants.IntentPassValueConstants;
import com.mobatia.nasmanila.constants.JSONConstants;
import com.mobatia.nasmanila.constants.NaisClassNameConstants;
import com.mobatia.nasmanila.constants.NaisTabConstants;
import com.mobatia.nasmanila.constants.StatusConstants;
import com.mobatia.nasmanila.constants.URLConstants;
import com.mobatia.nasmanila.fragments.category1.model.CcaResponseModel;
import com.mobatia.nasmanila.fragments.cca.adapter.CCARecyclerAdapter;
import com.mobatia.nasmanila.fragments.cca.model.CcaSubmitResponseModel;
import com.mobatia.nasmanila.fragments.secondary.model.SecondaryModel;
import com.mobatia.nasmanila.manager.AppUtils;
import com.mobatia.nasmanila.manager.HeaderManager;
import com.mobatia.nasmanila.manager.PreferenceManager;
import com.mobatia.nasmanila.recyclerviewmanager.ItemOffsetDecoration;
import com.mobatia.nasmanila.recyclerviewmanager.RecyclerItemListener;
import com.mobatia.nasmanila.retrofit.APIClient;
import com.mobatia.nasmanila.retrofit.APIInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by krishnaraj on 08/11/18.
 */

public class CcaActivity extends Activity implements AdapterView.OnItemClickListener,
        NaisTabConstants,CacheDIRConstants, URLConstants,
        IntentPassValueConstants,NaisClassNameConstants,JSONConstants,StatusConstants {
    private Context mContext;
    RelativeLayout relativeHeader;

    HeaderManager headermanager;
    ImageView back;
    ImageView home;
    private String mTitle;
    private String mTabId;
    private String description="";
    private RelativeLayout relMain;
    TextView descriptionTV;
    TextView descriptionTitle;
    RelativeLayout mtitleRel;
    RelativeLayout CCAFRegisterRel;
    private ArrayList<SecondaryModel> mListViewArray;
    ImageView bannerImagePager;
    ArrayList<String> bannerUrlImageArray;
    private RecyclerView mListView;
    String contactEmail="";
    EditText text_dialog;
    EditText text_content;
    ImageView sendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ccas_list);

        mContext = this;
        initialiseUI();
        //System.out.println("value is");
    }
    private void initialiseUI() {
        relativeHeader = (RelativeLayout) findViewById(R.id.relativeHeader);
        headermanager = new HeaderManager(CcaActivity.this, "Enrichment Lessons");
        headermanager.getHeader(relativeHeader, 0);
        back = headermanager.getLeftButton();
        home = headermanager.getLogoButton();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(mContext, HomeListAppCompatActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });
        headermanager.setButtonLeftSelector(R.drawable.back,
                R.drawable.back);

        back.setOnClickListener(v -> finish());
//		mListView = (ListView) mRootView.findViewById(R.id.mListView);
        bannerImagePager= (ImageView)findViewById(R.id.bannerImagePager);
        mListView = (RecyclerView)findViewById(R.id.mListView);
        descriptionTV= (TextView) findViewById(R.id.descriptionTV);
        descriptionTitle= (TextView)findViewById(R.id.descriptionTitle);
        sendEmail= (ImageView)findViewById(R.id.sendEmail);
        mtitleRel = (RelativeLayout)findViewById(R.id.title);
        CCAFRegisterRel = (RelativeLayout)findViewById(R.id.CCAFRegisterRel);
        relMain = (RelativeLayout)findViewById(R.id.relMain);
        relMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        CCAFRegisterRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PreferenceManager.getUserId(mContext).equalsIgnoreCase("")) {
                    AppUtils.showDialogAlertDismiss((Activity) mContext, "Alert","This feature is available only for registered users. Login/register to see contents.", R.drawable.exclamationicon, R.drawable.round);
                }
                else
                {
                    Intent intent = new Intent(mContext, CCA_Activity.class);
                    intent.putExtra("tab_type", "Enrichment Lessons");
                    mContext.startActivity(intent);
                }
				//AppUtils.showDialogAlertDismiss((Activity) mContext, "Alert", getString(R.string.module_under_construction), R.drawable.exclamationicon, R.drawable.round);

            }
        });
        //////////////////////////////
		//mListView.setOnItemClickListener(this);
        if (AppUtils.checkInternet(mContext)) {

            getList();
        }
        else
        {
            AppUtils.showDialogAlertDismiss((Activity) mContext, "Network Error", getString(R.string.no_internet), R.drawable.nonetworkicon, R.drawable.roundred);

       }
        /////////////////////////
        mListView.setHasFixedSize(true);
//        mNewsLetterListView.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.list_divider)));
        GridLayoutManager recyclerViewLayout= new GridLayoutManager(mContext, 4);
        int spacing = 5; // 50px
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(mContext,spacing);
        mListView.addItemDecoration(itemDecoration);
        mListView.setLayoutManager(recyclerViewLayout);

        mListView.addOnItemTouchListener(new RecyclerItemListener(mContext, mListView,
                new RecyclerItemListener.RecyclerTouchListener() {
                    public void onClickItem(View v, int position) {
                        if (mListViewArray.get(position).getmFile().endsWith(".pdf")) {
                            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mListViewArray.get(position).getmFile())));
                            }else{
                                Intent intent = new Intent(mContext, PDFViewActivity.class);
                                intent.putExtra("pdf_url", mListViewArray.get(position).getmFile());
                                startActivity(intent);
                            }
//                            Intent intent = new Intent(mContext, PDFViewActivity.class);
//                            intent.putExtra("pdf_url", mListViewArray.get(position).getmFile());
//                            startActivity(intent);
                        }
                        else
                        {
                            Intent intent = new Intent(mContext, LoadUrlWebViewActivity.class);
                            intent.putExtra("url",mListViewArray.get(position).getmFile());
                            intent.putExtra("tab_type","Enrichment Lessons");
                            mContext.startActivity(intent);
                        }

                    }

                    public void onLongClickItem(View v, int position) {
                        System.out.println("On Long Click Item interface");
                    }
                }));
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PreferenceManager.getUserId(mContext).equalsIgnoreCase("")) {

                    final Dialog dialog = new Dialog(mContext);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.alert_send_email_dialog);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    Button dialogCancelButton = (Button) dialog.findViewById(R.id.cancelButton);
                    Button submitButton = (Button) dialog.findViewById(R.id.submitButton);
                    text_dialog = (EditText) dialog.findViewById(R.id.text_dialog);
                    text_content = (EditText) dialog.findViewById(R.id.text_content);

                    text_dialog.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            if (hasFocus) {
                                text_dialog.setHint("");
                                text_dialog.setGravity(Gravity.LEFT| Gravity.CENTER_VERTICAL);
                                text_dialog.setPadding(5, 5, 0, 0);
                            } else {
                                text_dialog.setHint("Enter your subject here...");

                                text_dialog.setGravity(Gravity.CENTER);

                            }
                        }
                    });
                    text_content.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            if (hasFocus) {
                                text_content.setGravity(Gravity.LEFT);
                            } else {
                                text_content.setGravity(Gravity.CENTER);

                            }
                        }
                    });
                    dialogCancelButton.setOnClickListener(new View.OnClickListener() {

                        @Override

                        public void onClick(View v) {

                            dialog.dismiss();

                        }

                    });

                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            System.out.println("submit btn clicked");
//						sendEmailToStaff(URL_SEND_EMAIL_TO_STAFF);
                            if (text_dialog.getText().toString().equals("")) {
                                AppUtils.showDialogAlertDismiss((Activity) mContext, mContext.getString(R.string.alert_heading), "Please enter subject", R.drawable.exclamationicon, R.drawable.round);

                            } else if (text_content.getText().toString().equals("")) {
                                AppUtils.showDialogAlertDismiss((Activity) mContext, mContext.getString(R.string.alert_heading), "Please enter content", R.drawable.exclamationicon, R.drawable.round);

                            } else {
                                if (AppUtils.isNetworkConnected(mContext)) {
                                    sendEmailToStaff(URL_SEND_EMAIL_TO_STAFF,dialog);

                                } else {
                                    AppUtils.showDialogAlertDismiss((Activity) mContext, "Network Error", mContext.getString(R.string.no_internet), R.drawable.nonetworkicon, R.drawable.roundred);

                                }
                            }
                        }
                    });


                    dialog.show();
                }else {
                    AppUtils.showDialogAlertDismiss((Activity) mContext, mContext.getString(R.string.alert_heading), "This feature is available only for registered users. Login/register to see contents.", R.drawable.exclamationicon, R.drawable.round);

                }

            }
        });
        PreferenceManager.setStudIdForCCA(mContext, "");
        PreferenceManager.setCCAStudentIdPosition(mContext, "0");
        PreferenceManager.setStudNameForCCA(mContext, "");
        PreferenceManager.setStudClassForCCA(mContext, "");
        PreferenceManager.setCCATitle(mContext, "");
        PreferenceManager.setCCAItemId(mContext, "");
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget
     * .AdapterView, android.view.View, int, long)
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        if (mListViewArray.get(position).getmFile().endsWith(".pdf")) {
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mListViewArray.get(position).getmFile())));
            }else{
                Intent intent = new Intent(mContext, PDFViewActivity.class);
                intent.putExtra("pdf_url", mListViewArray.get(position).getmFile());
                startActivity(intent);
            }
//            Intent intent = new Intent(mContext, PDFViewActivity.class);
//            intent.putExtra("pdf_url", mListViewArray.get(position).getmFile());
//            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(mContext, LoadUrlWebViewActivity.class);
            intent.putExtra("url",mListViewArray.get(position).getmFile());
            intent.putExtra("tab_type",mListViewArray.get(position).getmName());
            mContext.startActivity(intent);
        }

    }
/////////////////////////////////////////////////
    public void getList() {

        mListViewArray = new ArrayList<>();

        APIInterface service = APIClient.getRetrofitInstance().create(APIInterface.class);

        Call<CcaResponseModel> call = service.cca("Bearer "+PreferenceManager.getAccessToken(mContext));
        call.enqueue(new Callback<CcaResponseModel>()
        {
            @Override
            public void onResponse(Call<CcaResponseModel> call, Response<CcaResponseModel> response) {
                if (response.isSuccessful()) {
                    CcaResponseModel apiResponse = response.body();
                    String responsCode = apiResponse.getResponsecode();
                    if (responsCode.equals(RESPONSE_SUCCESS)) {
                        String statusCode = apiResponse.getResponse().getStatuscode();

                        if (statusCode.equals(STATUS_SUCCESS)) {
                            String bannerImage=apiResponse.getResponse().getBanner_image();
                            description = apiResponse.getResponse().getDescription();
                            contactEmail = apiResponse.getResponse().getContact_email();
                            if (!bannerImage.equalsIgnoreCase("")) {
                                Glide.with(mContext).load(AppUtils.replace(bannerImage)).centerCrop().into(bannerImagePager);

//											bannerUrlImageArray = new ArrayList<>();
//											bannerUrlImageArray.add(bannerImage);
//											bannerImagePager.setAdapter(new ImagePagerDrawableAdapter(bannerUrlImageArray, getActivity()));
                            }
                            else
                            {
                                bannerImagePager.setBackgroundResource(R.drawable.default_bannerr);
//											bannerImagePager.setBackgroundResource(R.drawable.ccas_banner);

                            }

                            if (description.equalsIgnoreCase("")&&contactEmail.equalsIgnoreCase(""))
                            {
                                mtitleRel.setVisibility(View.GONE);
                            }
                            else
                            {
                                mtitleRel.setVisibility(View.VISIBLE);
                            }
                            if (description.equalsIgnoreCase(""))
                            {
                                descriptionTV.setVisibility(View.GONE);
                                descriptionTitle.setVisibility(View.GONE);
                            }else
                            {
                                descriptionTV.setText(description);
                                descriptionTitle.setVisibility(View.GONE);
//											descriptionTitle.setVisibility(View.VISIBLE);
                                descriptionTV.setVisibility(View.VISIBLE);
                                mtitleRel.setVisibility(View.VISIBLE);
                            }
                            if (contactEmail.equalsIgnoreCase(""))
                            {
                                sendEmail.setVisibility(View.GONE);
                            }else
                            {
                                mtitleRel.setVisibility(View.VISIBLE);
                                sendEmail.setVisibility(View.VISIBLE);
                            }
                            CCAFRegisterRel.setVisibility(View.VISIBLE);
                            //JSONArray dataArray = respObject.getJSONArray(JTAG_RESPONSE_DATA_ARRAY);
                            if (apiResponse.getResponse().getData().size() > 0) {
                                for (int i = 0; i <apiResponse.getResponse().getData().size(); i++) {
                                    //JSONObject dataObject = dataArray.getJSONObject(i);
                                    SecondaryModel item = apiResponse.getResponse().getData().get(i);
                                    Gson gson = new Gson();
                                    String eventJson = gson.toJson(item);
                                    try {
                                        JSONObject jsonObject = new JSONObject(eventJson);

                                        mListViewArray.add(getSearchValues(jsonObject));

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                }

//											mListView.setAdapter(new CustomSecondaryAdapter(getActivity(), mListViewArray));
                                mListView.setAdapter(new CCARecyclerAdapter(mContext, mListViewArray));

                            } else {
                                //CustomStatusDialog();
                                //Toast.makeText(mContext,"Failure",Toast.LENGTH_SHORT).show();
                                AppUtils.showDialogAlertDismiss((Activity)mContext,"Alert",getString(R.string.nodatafound),R.drawable.exclamationicon,R.drawable.round);

                            }
                        }
                    }

                }
                //Log.e("response", String.valueOf(apiResponse));
            }
            @Override
            public void onFailure(Call<CcaResponseModel> call, Throwable t) {
                //progressDialogP.hide();
                Log.e("toadst", String.valueOf(t));
                //Toast.makeText(mContext, "Successfully sent email to staff"+t, Toast.LENGTH_SHORT);

            }});


      /*  try {
            mListViewArray = new ArrayList<>();
            final VolleyWrapper manager = new VolleyWrapper(URL_CCAS_LIST);
            String[] name = new String[]{JTAG_ACCESSTOKEN};
            String[] value = new String[]{PreferenceManager.getAccessToken(mContext)};


            manager.getResponsePOST(mContext, 11, name, value, new VolleyWrapper.ResponseListener() {

                @Override
                public void responseSuccess(String successResponse) {
                    System.out.println("The response is" + successResponse);
                    String responsCode = "";
                    if (successResponse != null) {
                        try {
                            JSONObject rootObject = new JSONObject(successResponse);
                            if (rootObject.optString(JTAG_RESPONSE) != null) {
                                responsCode = rootObject.optString(JTAG_RESPONSECODE);
                                if (responsCode.equals(RESPONSE_SUCCESS)) {
                                    JSONObject respObject = rootObject.getJSONObject(JTAG_RESPONSE);
                                    String statusCode = respObject.optString(JTAG_STATUSCODE);
                                    if (statusCode.equals(STATUS_SUCCESS)) {
                                        String bannerImage=respObject.optString(JTAG_BANNER_IMAGE);
                                        description = respObject.optString(JTAG_DESCRIPTION);
                                        contactEmail = respObject.optString(JTAG_CONTACT_EMAIL);
                                        if (!bannerImage.equalsIgnoreCase("")) {
                                            Glide.with(mContext).load(AppUtils.replace(bannerImage)).centerCrop().into(bannerImagePager);

//											bannerUrlImageArray = new ArrayList<>();
//											bannerUrlImageArray.add(bannerImage);
//											bannerImagePager.setAdapter(new ImagePagerDrawableAdapter(bannerUrlImageArray, getActivity()));
                                        }
                                        else
                                        {
                                            bannerImagePager.setBackgroundResource(R.drawable.default_bannerr);
//											bannerImagePager.setBackgroundResource(R.drawable.ccas_banner);

                                        }
                                        if (description.equalsIgnoreCase("")&&contactEmail.equalsIgnoreCase(""))
                                        {
                                            mtitleRel.setVisibility(View.GONE);
                                        }
                                        else
                                        {
                                            mtitleRel.setVisibility(View.VISIBLE);
                                        }
                                        if (description.equalsIgnoreCase(""))
                                        {
                                            descriptionTV.setVisibility(View.GONE);
                                            descriptionTitle.setVisibility(View.GONE);
                                        }else
                                        {
                                            descriptionTV.setText(description);
                                            descriptionTitle.setVisibility(View.GONE);
//											descriptionTitle.setVisibility(View.VISIBLE);
                                            descriptionTV.setVisibility(View.VISIBLE);
                                            mtitleRel.setVisibility(View.VISIBLE);
                                        }
                                        if (contactEmail.equalsIgnoreCase(""))
                                        {
                                            sendEmail.setVisibility(View.GONE);
                                        }else
                                        {
                                            mtitleRel.setVisibility(View.VISIBLE);
                                            sendEmail.setVisibility(View.VISIBLE);
                                        }
                                        CCAFRegisterRel.setVisibility(View.VISIBLE);
                                        JSONArray dataArray = respObject.getJSONArray(JTAG_RESPONSE_DATA_ARRAY);
                                        if (dataArray.length() > 0) {
                                            for (int i = 0; i <dataArray.length(); i++) {
                                                JSONObject dataObject = dataArray.getJSONObject(i);
                                                mListViewArray.add(getSearchValues(dataObject));

                                            }

//											mListView.setAdapter(new CustomSecondaryAdapter(getActivity(), mListViewArray));
                                            mListView.setAdapter(new CCARecyclerAdapter(mContext, mListViewArray));

                                        } else {
                                            //CustomStatusDialog();
                                            //Toast.makeText(mContext,"Failure",Toast.LENGTH_SHORT).show();
                                            AppUtils.showDialogAlertDismiss((Activity)mContext,"Alert",getString(R.string.nodatafound),R.drawable.exclamationicon,R.drawable.round);

                                        }
                                    } else {
//										CustomStatusDialog(RESPONSE_FAILURE);
                                        //Toast.makeText(mContext,"Failure",Toast.LENGTH_SHORT).show();
                                        AppUtils.showDialogAlertDismiss((Activity)mContext,"Alert",getString(R.string.common_error),R.drawable.exclamationicon,R.drawable.round);

                                    }
                                }
                                else if (responsCode.equalsIgnoreCase(RESPONSE_ACCESSTOKEN_MISSING) ||
                                        responsCode.equalsIgnoreCase(RESPONSE_ACCESSTOKEN_EXPIRED) ||
                                        responsCode.equalsIgnoreCase(RESPONSE_INVALID_TOKEN)) {
                                    AppUtils.postInitParam(mContext, new AppUtils.GetAccessTokenInterface() {
                                        @Override
                                        public void getAccessToken() {
                                        }
                                    });
                                    getList();

                                }else if (responsCode.equals(RESPONSE_ERROR)) {
//								CustomStatusDialog(RESPONSE_FAILURE);
                                    //Toast.makeText(mContext,"Failure", Toast.LENGTH_SHORT).show();
                                    AppUtils.showDialogAlertDismiss((Activity)mContext,"Alert",getString(R.string.common_error),R.drawable.exclamationicon,R.drawable.round);

                                }
                            } else {
//								CustomStatusDialog(RESPONSE_FAILURE);
                                //Toast.makeText(mContext,"Failure", Toast.LENGTH_SHORT).show();
                                AppUtils.showDialogAlertDismiss((Activity)mContext,"Alert",getString(R.string.common_error),R.drawable.exclamationicon,R.drawable.round);

                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }

                @Override
                public void responseFailure(String failureResponse) {
                    AppUtils.showDialogAlertDismiss((Activity)mContext,"Alert",getString(R.string.common_error),R.drawable.exclamationicon,R.drawable.round);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }

    ////////////////////////////////////////
    private SecondaryModel getSearchValues(JSONObject Object)
            throws JSONException {
        SecondaryModel mSecondaryModel = new SecondaryModel();
        mSecondaryModel.setmId(Object.getString(JTAG_ID));
        mSecondaryModel.setmFile(Object.getString(JTAG_TAB_FILE));
        mSecondaryModel.setmName(Object.getString(JTAG_TAB_NAME));
        return mSecondaryModel;
    }
    private void sendEmailToStaff(String URL, Dialog dialog) {


        APIInterface service = APIClient.getRetrofitInstance().create(APIInterface.class);
        JsonObject paramObject = new JsonObject();
        paramObject.addProperty("email", contactEmail);
        paramObject.addProperty("users_id", PreferenceManager.getUserId(mContext));
        paramObject.addProperty("title", text_dialog.getText().toString());
        paramObject.addProperty("message", text_content.getText().toString());

        Call<CcaSubmitResponseModel> call = service.sendemail("Bearer "+PreferenceManager.getAccessToken(mContext),paramObject);
        call.enqueue(new Callback<CcaSubmitResponseModel>()
        {
            @Override
            public void onResponse(Call<CcaSubmitResponseModel> call, Response<CcaSubmitResponseModel> response) {
                if (response.isSuccessful()) {
                    CcaSubmitResponseModel apiResponse = response.body();
                    String responsCode = apiResponse.getResponsecode();
                    if (responsCode.equals("200")) {
                        String statusCode = apiResponse.getResponse().getStatuscode();

                        if (statusCode.equals("303")) {
                            dialog.dismiss();
                            Toast toast = Toast.makeText(mContext, "Successfully sent email to staff", Toast.LENGTH_SHORT);
                            toast.show();

                        }
                        else{
                            Toast toast = Toast.makeText(mContext,"Email not sent", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                    else {

                        AppUtils.showDialogAlertDismiss((Activity) mContext, "Alert", mContext.getString(R.string.common_error), R.drawable.exclamationicon, R.drawable.round);

                    }

                }
                //Log.e("response", String.valueOf(apiResponse));
            }
            @Override
            public void onFailure(Call<CcaSubmitResponseModel> call, Throwable t) {
                AppUtils.showDialogAlertDismiss((Activity) mContext, "Alert", mContext.getString(R.string.common_error), R.drawable.exclamationicon, R.drawable.round);


            }});





       /* VolleyWrapper volleyWrapper=new VolleyWrapper(URL);
        String[] name={"access_token","email","users_id","title","message"};
        String[] value={PreferenceManager.getAccessToken(mContext),contactEmail,PreferenceManager.getUserId(mContext),text_dialog.getText().toString(),text_content.getText().toString()};//contactEmail

        //String[] value={PreferenceManager.getAccessToken(mContext),mStaffList.get(pos).getStaffEmail(),JTAG_USERS_ID_VALUE,text_dialog.getText().toString(),text_content.getText().toString()};
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
                            Toast toast = Toast.makeText(mContext, "Successfully sent email to staff", Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            Toast toast = Toast.makeText(mContext, "Email not sent", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    } else if (response_code.equalsIgnoreCase("500")) {
                    } else if (response_code.equalsIgnoreCase("400")) {
                        AppUtils.getToken(mContext, new AppUtils.GetTokenSuccess() {
                            @Override
                            public void tokenrenewed() {
                            }
                        });
                        sendEmailToStaff(URL_SEND_EMAIL_TO_STAFF);

                    } else if (response_code.equalsIgnoreCase("401")) {
                        AppUtils.getToken(mContext, new AppUtils.GetTokenSuccess() {
                            @Override
                            public void tokenrenewed() {
                            }
                        });
                        sendEmailToStaff(URL_SEND_EMAIL_TO_STAFF);

                    } else if (response_code.equalsIgnoreCase("402")) {
                        AppUtils.getToken(mContext, new AppUtils.GetTokenSuccess() {
                            @Override
                            public void tokenrenewed() {
                            }
                        });
                        sendEmailToStaff(URL_SEND_EMAIL_TO_STAFF);

                    } else {
						*//*CustomDialog dialog = new CustomDialog(mContext, getResources().getString(R.string.common_error)
								, getResources().getString(R.string.ok));
						dialog.show();*//*
                        AppUtils.showDialogAlertDismiss((Activity) mContext, "Alert", mContext.getString(R.string.common_error), R.drawable.exclamationicon, R.drawable.round);

                    }
                } catch (Exception ex) {
                    System.out.println("The Exception in edit profile is" + ex.toString());
                }

            }

            @Override
            public void responseFailure(String failureResponse) {
				*//*CustomDialog dialog = new CustomDialog(mContext, getResources().getString(R.string.common_error)
						, getResources().getString(R.string.ok));
				dialog.show();*//*
                AppUtils.showDialogAlertDismiss((Activity) mContext, "Alert", mContext.getString(R.string.common_error), R.drawable.exclamationicon, R.drawable.round);

            }
        });*/


    }

    @Override
    public void onResume() {
        super.onResume();
        PreferenceManager.setStudIdForCCA(mContext, "");
        PreferenceManager.setCCAStudentIdPosition(mContext, "0");
        PreferenceManager.setStudNameForCCA(mContext, "");
        PreferenceManager.setStudClassForCCA(mContext, "");
        PreferenceManager.setCCATitle(mContext, "");
        PreferenceManager.setCCAItemId(mContext, "");
    }
}
