package com.kazimasum.retro4demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    EditText nametext, emailtext, passwordtext,std_id;
    TextView tv;
    Button btn;
    Spinner ct_spin;
    ArrayList<String> arrServiceName =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        nametext=findViewById(R.id.nametext);
        std_id=findViewById(R.id.std_id);
        emailtext=findViewById(R.id.emailtext);
        passwordtext=findViewById(R.id.passwordtext);
        ct_spin = findViewById(R.id.ct_spin);


        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);

        fetchJson();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processdata(
                        (String) ct_spin.getItemAtPosition(0),
//                        nametext.getText().toString(),
                        std_id.getText().toString(),
                        emailtext.getText().toString(),
                        passwordtext.getText().toString());

                Log.e("mydata001","ct_spin "+ct_spin.getItemIdAtPosition(0) );

                Log.e("mydata001","std_id "+std_id.getText() );
                Log.e("mydata001","Title "+emailtext.getText() );
                Log.e("mydata001","Description "+passwordtext.getText() );
            }
        });
    }

    public  void processdata(String student_id ,String service_id,
                             String title, String description)
    {
        Call<responsemodel> call= apiController.getInstance()
                .getapi()
                .getregister("SFSNE",student_id,service_id,
                        title,description,"New");

        Log.e("mydata001","APICalling004" );

        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                Log.e("mydata001","APICalling005" );

                Log.d("mydata001",response.toString());

                responsemodel obj=response.body();

                Log.e("mydata001","APICalling006" );

                tv.setText(obj.getMessage());
                std_id.setText("");
//                ct_spin.getSelectedItemId();
//                nametext.setText("");
                emailtext.setText("");
                passwordtext.setText("");

                Toast.makeText(getApplicationContext(),response.body().getMessage(), Toast.LENGTH_LONG).show();

                Log.e("mydata001","APICalling007" );

            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {
                tv.setText("something went wrong");
//                nametext.setText("");
                ct_spin.getSelectedItemId();
                std_id.setText("");
                emailtext.setText("");
                passwordtext.setText("");

                Log.e("mydata001","APICalling008" );
            }
        });
    }


    //Spinner
    private void fetchJson(){
        Call<SpinnerServierResponseModel> call= apiController.getInstance()
                .getapi()
                .getAllLogs("SFSNE");
        call.enqueue(new Callback<SpinnerServierResponseModel>() {
            @Override
            public void onResponse(Call<SpinnerServierResponseModel> call, Response<SpinnerServierResponseModel> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    SpinnerServierResponseModel model = response.body();
                    arrServiceName.clear();

                    for (int i = 0; i < model.getService_type().size(); i++) {
                        arrServiceName.add(model.getService_type().get(i).getService_name());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, arrServiceName);
                    ct_spin.setAdapter(adapter);

                    Log.e("mydata001","APICalling009");


                }
            }

            @Override
            public void onFailure(Call<SpinnerServierResponseModel> call, Throwable t) {
                Log.e("mydata001","APICalling010");

            }
        });

//        ct_spin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            private String selectedServiceId;
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                SpinnerServierResponseModel.Service_type clickedItem = (SpinnerServierResponseModel.Service_type)
//                        adapterView.getItemAtPosition(i);
//
//                selectedServiceId = clickedItem.getService_id();
//                ct_spin.getItemIdAtPosition(0);
//            }
//        });






    }
}


