package nd.com.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView tv_show_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_show_data = (TextView) findViewById(R.id.tv_show_data);
        tv_show_data.setText(createJSONOject());
        tv_show_data.append(createJSONArray());
        tv_show_data.append(parseJSONObject(createJSONOject()));
        tv_show_data.append(parseJSONArray(createJSONArray()));

    }

    public String createJSONOject() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", "william");
            jsonObject.put("age", "22");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public String createJSONArray() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("william");
        jsonArray.put("jackson");
        JSONObject jsonObject1 = new JSONObject();
        try {
            jsonObject1.put("name", "William");
            jsonObject1.put("age", "22");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject2 = new JSONObject();
        try {
            jsonObject2.put("name", "Jackson");
            jsonObject2.put("age", "23");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(jsonObject1);
        jsonArray.put(jsonObject2);
        return jsonArray.toString();
    }

    public String parseJSONObject(String json) {
        String ret = "";
        try {
            JSONObject jsonObject = new JSONObject(json);
            String name = jsonObject.getString("name");
            if (TextUtils.isEmpty(name)) {
                ret += name + "\n";
            }
            String age = jsonObject.getString("age");
            if (TextUtils.isEmpty(age)) {
                ret += age;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public String parseJSONObject(JSONObject json) {
        String ret = "";
        try {
            String name = json.getString("name");
            if (TextUtils.isEmpty(name)) {
                ret += name + "\n";
            }
            String age = json.getString("age");
            if (TextUtils.isEmpty(age)) {
                ret += age;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public String parseJSONArray(String jsonArray) {
        String ret = "";
        try {
            JSONArray jsonArray1 = new JSONArray(jsonArray);
            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObject = jsonArray1.getJSONObject(i);
                ret += parseJSONObject(jsonObject) + "\n";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }
}