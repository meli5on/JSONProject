package ua.com.meli5on.jsonproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test1Activity extends Activity {
    TextView textView, textView2, textView3, textView4;

    String[] q1;
    JSONObject test = new JSONObject();
    JSONArray question1 = new JSONArray();

    private String readFile(String filename){
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput(filename)));
            String line = reader.readLine();
            while (line != null){
                builder.append(line);
            }
            reader.close();
            return builder.toString();
        }catch (Exception e){}
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        String[] text = readFile("test.txt");
        q1 = text;


        for (int i = 0; i < q1.length; i++){
            question1.put(q1[i]);
        }
        try {
            test.put("question", question1);
        } catch (JSONException e) {
            e.printStackTrace();
        }



        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        try{
            JSONArray testJsonArray = test.getJSONArray("question");
            textView.setText(testJsonArray.getString(0));
            textView2.setText(testJsonArray.getString(1));
            textView3.setText(testJsonArray.getString(2));
            textView4.setText(testJsonArray.getString(3));


        }catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
