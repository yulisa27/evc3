package pe.idat.yulizaev3;

import android.content.res.Resources;
import  android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class Animal {
    private static final String TAG = Animal.class.getSimpleName();

    public final String nombreAnimal;
    public final String razaAnimal;
    public final Uri dynamicUrl;
    public final String url;

    public Animal(String nombreAnimal, String dynamicUrl, String url, String razaAnimal) {
        this.nombreAnimal = nombreAnimal;
        this.razaAnimal = razaAnimal;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
    }

    public static List<Animal> initProductEntryList (Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.animales);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0 , pointer);
            }
        } catch (IOException exception){
            Log.e(TAG, "Error JSON", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Error input stream", exception);
            }
        }

        String jsonProductsString = writer.toString();
        Gson gson = new Gson();
        Type productListType = new TypeToken<ArrayList<Animal>>(){
        }.getType();

        return gson.fromJson(jsonProductsString, productListType);
    }

}
