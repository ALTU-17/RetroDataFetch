package com.kazimasum.retro4demo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiController
{
   private static final String url="https://sfs.evolvu.in/test/msfs_test/index.php/TicketApi/";
   private static apiController clientobject;
   private static Retrofit retrofit;

     apiController()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized apiController getInstance()
     {
          if(clientobject==null)
              clientobject=new apiController();
          return clientobject;
     }

     apiset getapi()
     {
         return retrofit.create(apiset.class);
     }
}
