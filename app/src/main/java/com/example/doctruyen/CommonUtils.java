package com.example.doctruyen;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CommonUtils {
    private static CommonUtils instance;
    private CommonUtils() {
        //for singleton
    }

    public static CommonUtils getInstance(){
        if(instance==null){
            instance = new CommonUtils();
        }
        return instance;
    }

    public String getTextAs(String path){
        try{
            InputStream in = App.getInstance().getAssets().open(path);
            BufferedReader br=new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            StringBuilder text = new StringBuilder();
            String line=br.readLine();
            while(line!=null){
                text.append(line).append("\n");
                line=br.readLine();
            }
            br.close();
            in.close();
            return text.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}