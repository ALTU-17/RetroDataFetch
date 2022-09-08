package com.kazimasum.retro4demo;

import android.widget.EditText;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiset
{

    @FormUrlEncoded
    @POST("get_service_types")
    Call<SpinnerServierResponseModel> getAllLogs(
            @Field("short_name") String short_name
    );

    @FormUrlEncoded
    @POST("GET_TICKET_LIST")
    Call<AllDataShowResponseModel> getTicketList(
            @Field("short_name") String short_name,
            @Field("reg_id") String reg_id
    );

    @FormUrlEncoded
   @POST("raise_ticket")
    Call<responsemodel> getregister(
            @Field("short_name") String short_name,
            @Field("student_id") String student_id,
            @Field("service_id") String service_id,
            @Field("title") String title,
            @Field("description") String description,
            @Field("status") String status
    );

}
