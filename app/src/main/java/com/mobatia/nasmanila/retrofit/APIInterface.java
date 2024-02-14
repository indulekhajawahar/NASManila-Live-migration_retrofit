package com.mobatia.nasmanila.retrofit;

import com.google.gson.JsonObject;
import com.mobatia.nasmanila.activities.home.BannerResponseModel;
import com.mobatia.nasmanila.activities.staff_directory.model.StaffCategoriListResponseModel;
import com.mobatia.nasmanila.activities.staff_directory.model.StaffCategoriResponseModel;
import com.mobatia.nasmanila.activities.terms_of_service.model.TermsofServiceResponseModel;
import com.mobatia.nasmanila.fragments.about_us.model.AboutUsResponseModel;
import com.mobatia.nasmanila.fragments.absence.model.LeaveRequestResponseModel;
import com.mobatia.nasmanila.fragments.calendar.model.CalendarResponseModel;
import com.mobatia.nasmanila.fragments.category1.model.CcaResponseModel;
import com.mobatia.nasmanila.fragments.category1.model.EnrichmentLessonResponseModel;
import com.mobatia.nasmanila.fragments.cca.model.CcaDetailsResponseModel;
import com.mobatia.nasmanila.fragments.cca.model.CcaReviewResponseModel;
import com.mobatia.nasmanila.fragments.cca.model.CcaSubmitResponseModel;
import com.mobatia.nasmanila.fragments.contact_us.model.ContactResponseModel;
import com.mobatia.nasmanila.fragments.nas_today.model.NAsTodayResponseModel;
import com.mobatia.nasmanila.fragments.notifications_new.model.NotificationResponseModel;
import com.mobatia.nasmanila.fragments.parent_essentials.model.ParentResponseModel;
import com.mobatia.nasmanila.fragments.parents_evening.model.StudentResponseModel;
import com.mobatia.nasmanila.fragments.social_media.model.SocialMediaResponseModel;
import com.mobatia.nasmanila.fragments.social_media.model.StaffResponseModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {


    @POST("Api-V1/home_banner_images")
    @Headers("Content-Type: application/json")
    Call<BannerResponseModel> bannerresponse(
            @Header("Authorization") String token,
            @Body JsonObject json

    );

    @POST("Api-V1/calender")
    @Headers("Content-Type: application/json")
    Call<CalendarResponseModel> calendar(
            @Header("Authorization") String token

    );

    @POST("Api-V1/notifications")
    @Headers("Content-Type: application/json")
    Call<NotificationResponseModel> notifications(
            @Header("Authorization") String token,
            @Body JsonObject json

    );
    @POST("Api-V1/contact_us")
    @Headers("Content-Type: application/json")
    Call<ContactResponseModel> contact_us(
            @Header("Authorization") String token

    );

    @POST("Api-V1/about_us")
    @Headers("Content-Type: application/json")
    Call<AboutUsResponseModel> about_us(
            @Header("Authorization") String token

    );

    @POST("Api-V1/parents_essentials")
    @Headers("Content-Type: application/json")
    Call<ParentResponseModel> parents_essentials(
            @Header("Authorization") String token

    );
    @POST("Api-V1/social_media")
    @Headers("Content-Type: application/json")
    Call<SocialMediaResponseModel> social_media(
            @Header("Authorization") String token

    );

    @POST("Api-V1/studentlist")
    @Headers("Content-Type: application/json")
    Call<StudentResponseModel> studentlist(
            @Header("Authorization") String token,
            @Body JsonObject json

    );

    @POST("Api-V1/stafflist")
    @Headers("Content-Type: application/json")
    Call<StaffResponseModel> stafflist(
            @Header("Authorization") String token,
            @Body JsonObject json

    );
    @POST("Api-V1/getstaffcategorylist")
    @Headers("Content-Type: application/json")
    Call<StaffCategoriResponseModel> getstaffcategorylist(
            @Header("Authorization") String token

    );

    @POST("Api-V1/getstaffdeptlist")
    @Headers("Content-Type: application/json")
    Call<StaffCategoriListResponseModel> getstaffdeptlist(
            @Header("Authorization") String token,
            @Body JsonObject json

    );
    @POST("Api-V1/enrichment_lessons")
    @Headers("Content-Type: application/json")
    Call<EnrichmentLessonResponseModel> enrichment_lessons(
            @Header("Authorization") String token

    );

    @POST("Api-V1/cca")
    @Headers("Content-Type: application/json")
    Call<CcaResponseModel> cca(
            @Header("Authorization") String token

    );
    @POST("Api-V1/cca_details")
    @Headers("Content-Type: application/json")
    Call<CcaDetailsResponseModel> cca_details(
            @Header("Authorization") String token,
            @Body JsonObject json

    );

    @POST("Api-V1/cca_reviews")
    @Headers("Content-Type: application/json")
    Call<CcaReviewResponseModel> cca_reviews(
            @Header("Authorization") String token,
            @Body JsonObject json

    );
    @POST("Api-V1/cca_submit")
    @Headers("Content-Type: application/json")
    Call<CcaSubmitResponseModel> cca_submit(
            @Header("Authorization") String token,
            @Body JsonObject json

    );

    @POST("Api-V1/requestLeave")
    @Headers("Content-Type: application/json")
    Call<CcaSubmitResponseModel> requestLeave(
            @Header("Authorization") String token,
            @Body JsonObject json

    );

    @POST("Api-V1/leaveRequests")
    @Headers("Content-Type: application/json")
    Call<LeaveRequestResponseModel> leaveRequests(
            @Header("Authorization") String token,
            @Body JsonObject json

    );

    @POST("Api-V1/nastoday")
    @Headers("Content-Type: application/json")
    Call<NAsTodayResponseModel> nastoday(
            @Header("Authorization") String token

    );

    @POST("Api-V1/terms_of_service")
    @Headers("Content-Type: application/json")
    Call<TermsofServiceResponseModel> terms_of_service(
            @Header("Authorization") String token

    );

    @POST("Api-V1/changepassword")
    @Headers("Content-Type: application/json")
    Call<CcaSubmitResponseModel> changepassword(
            @Header("Authorization") String token,
             @Body JsonObject json

    );
    @POST("Api-V1/logout")
    @Headers("Content-Type: application/json")
    Call<CcaSubmitResponseModel> logout(
            @Header("Authorization") String token,
            @Body JsonObject json

    );


    @POST("Api-V1/pta_meeting")
    @Headers("Content-Type: application/json")
    Call<CcaSubmitResponseModel> pta_meeting(
            @Header("Authorization") String token,
            @Body JsonObject json

    );
    @POST("Api-V1/sendemail")
    @Headers("Content-Type: application/json")
    Call<CcaSubmitResponseModel> sendemail(
            @Header("Authorization") String token,
            @Body JsonObject json

    );
    @POST("Api-V1/clear_badge")
    @Headers("Content-Type: application/json")
    Call<CcaSubmitResponseModel> clear_badge(
            @Header("Authorization") String token

    );

    @POST("Api-V1/deviceregistration")
    @Headers("Content-Type: application/json")
    Call<CcaSubmitResponseModel> deviceregistration(
            @Header("Authorization") String token,
            @Body JsonObject json

    );
//    @POST("Api-V1/term_calender")
//    @Headers("Content-Type: application/json")
//    Call<TermCalendarResponseModel> postTermCalendar(
//            @Header("Authorization") String token
//    );
//
//    @POST("Api-V1/calender")
//    @Headers("Content-Type: application/json")
//    Call<CalendarResponseModel> postCalendar(
//            @Header("Authorization") String token
//    );
//
//    /***********************************Notification**************************/
//    @POST("Api-V1/notifications_V1")
//    @Headers("Content-Type: application/json")
//    Call<NotifiationResponseModel> getNotifiation(
//            @Header("Authorization") String token,
//            @Body JsonObject json
//    );
//
//    @POST("Api-V1/notification_message")
//    @Headers("Content-Type: application/json")
//    Call<NotifiationDetailsResponseModel> notification_message(
//            @Header("Authorization") String token,
//            @Body JsonObject json
//    );
}