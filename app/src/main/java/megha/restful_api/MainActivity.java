package megha.restful_api;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private adapter adapter;
    private List<data> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AndroidNetworking.get("https://jsonplaceholder.typicode.com/posts")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int i;
                        JSONObject object;
                        for (i = 0; i < response.length(); i++) {
                            try {
                                object = response.getJSONObject(i);
                            data data1=new data(object.getString("title"),object.getString("body"),object.getInt("uid"),object.getInt("id"));
                                dataList.add(data1);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter = new adapter(dataList);
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }
}
