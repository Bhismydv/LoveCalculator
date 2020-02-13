package com.example.dell.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoveCalculator extends AppCompatActivity {
    EditText editText1,editText2;
    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_calculator);
        Intent intent=getIntent();

        editText1=findViewById(R.id.et1);
        editText2=findViewById(R.id.et2);
        textView=findViewById(R.id.text);
        button=findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              String  st1 = editText1.getText().toString().toLowerCase();
                String st2 = editText2.getText().toString().toLowerCase();

                String calculation=calculate(st1,st2);

                textView.setText((calculation));

            }

            String countChars(String str1, String str2) {
                String combinedString = str1 + "loves" + str2;
                String strAllChar = "";
                String strCount = "";
                for(char c1:combinedString.toCharArray()){
                    if(strAllChar.indexOf(c1)<0){
                        int count=0;
                        for(char c2:combinedString.toCharArray()){
                            if(c1==c2){
                                count=count+1;
                            }
                        }
                        strAllChar=strAllChar+c1;
                        strCount=strCount+String.valueOf(count);
                    }
                }


                return strCount;
            }
            /*shorten the number using the love algorithm*/
            String shortenNumber(String str){
                String shortString="";
                if(str.length()>=2){
                    int int1=Integer.parseInt(String.valueOf(str.toCharArray()[0]));
                    int int2=Integer.parseInt(String.valueOf(str.toCharArray()[str.length()-1]));
                    shortString=String.valueOf(int1+int2)+shortenNumber(str.substring(1,str.length()-1));
                }
                else {
                    return  str;
                }
                return shortString;

            }

            /*Making Algorithm Work*/

            String calculate(String str1,String str2){
                String shortString=countChars(str1,str2);
                String output=shortString;
                do {
                    output=output+"\n";
                    shortString=shortenNumber(shortString);
                    if(shortString.length()==2){
                        output=output+"\n";
                    }
                    output=output+shortString;
                }while (shortString.length()>2);{
                    output=output+"%";

                }
                    return output;

            }


        });

    }
}
