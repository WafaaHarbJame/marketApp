package com.h2oapp.h2o.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.h2oapp.h2o.MainActivity;
import com.h2oapp.h2o.R;

import static android.support.v4.content.ContextCompat.getSystemService;


public class HomeFragment extends Fragment {
    private WebView webView;
    String website = "http://h2o.aquaista.com/";
    private View root_view;
    ProgressDialog pd;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment


        pd = new ProgressDialog(getContext());


        root_view = inflater.inflate(R.layout.fragment_home, container, false);


        ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            webView=root_view.findViewById(R.id.webview1);
            WebSettings webSettings=webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new MyWebViewClient());
            webView.loadUrl(website);

        } else {
            Toast.makeText(getActivity(), R.string.no_internet, Toast.LENGTH_SHORT).show();

        }




        return root_view;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

           if (!pd.isShowing()) {
                pd.show();
            }
            else
            {
                pd.dismiss();

            }

            return true;
        }



        @Override
        public void onPageFinished(WebView view, String url) {
            System.out.println("on finish");

                pd.dismiss();
            super.onPageFinished(view, url);





        }



        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            pd.setMessage("Please wait Loading...");
            pd.show();
            super.onPageStarted(view, url, favicon);

        }
    }
}