package com.example.seminar7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        WebView webView=findViewById(R.id.webView);
//        webView.loadUrl("https://csie.ase.ro");

        //folosim Executor Service
        //cu un Executor ne ducem pe firul secundar, iar cu un Handler ne intoarcem pe firul principal
        //Looper - este o clasa care imi va gestiona callback-urile
        ExecutorService es= Executors.newSingleThreadExecutor(); //un nou thread
        Handler handler=new Handler(Looper.myLooper());
        es.execute(new Runnable() { //clasa anonima
            @Override
            public void run() {
                List<String> listaElemente=new ArrayList<>();
                //tot ce este aici va rula pe threadul secundar
                try {

                    URL url=new URL("https://www.bnr.ro/nbrfxrates.xml");
                    HttpsURLConnection connection= (HttpsURLConnection) url.openConnection();
                    InputStream is=connection.getInputStream();

                    DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder=builderFactory.newDocumentBuilder();
                    Document document=builder.parse(is);

                    NodeList noduri=document.getElementsByTagName("Rate");

                    for(int i=0;i< noduri.getLength();i++){
                        Node nod= noduri.item(i);
                        if(nod.getNodeType() == Node.ELEMENT_NODE){
                            Element el=(Element) nod;

                            StringBuilder stringBuilder=new StringBuilder(el.getAttribute("currency"))
                                    .append(": ")
                                    .append(el.getTextContent());
                            if(el.hasAttribute("multiplier")){
                                String multiplier=el.getAttribute("multiplier");
                                stringBuilder.append(" (multiplier =")
                                        .append(multiplier)
                                        .append(")");
                            }
                            listaElemente.add(stringBuilder.toString());
                        }
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() { //post se va face cand se termina run-ul mare
                    @Override
                    public void run() {
                        //aici ne intoarcem la firul principal
                        //folosit pt a interactiona cu layout-ul principal
                        ListView listView=findViewById(R.id.listView);
                        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(),
                                android.R.layout.simple_list_item_1,listaElemente);
                        listView.setAdapter(arrayAdapter);

                    }
                });

            }
        });

    }
}
