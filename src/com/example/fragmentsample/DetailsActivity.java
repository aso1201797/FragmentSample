package com.example.fragmentsample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // レイアウトの生成
        FrameLayout layout=new FrameLayout(this);
        layout.setId(R.id.details);
        setContentView(layout);

        //インテントからのパラメータ取得
        String cont="";
        Bundle extras=getIntent().getExtras();
    	cont=extras.getString("contents");
		// リフレクションを使ってインスタンスを生成するにはClass#newInstance()を使う。
        DetailsFragment fragment=DetailsFragment.newInstance(cont);

        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.details,fragment);
        //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        ft.commit();


    }
    public static class DetailsFragment extends Fragment {
        //インスタンス生成時に呼ばれる
        public static DetailsFragment newInstance(String cont) {
            DetailsFragment fragment=new DetailsFragment();
            Bundle bundle=new Bundle();
            bundle.putString("contents",cont);
            fragment.setArguments(bundle);
            return fragment;
        }

        //フラグメントのビュー生成時に呼ばれる
        @Override
        public View onCreateView(LayoutInflater inflater,
            ViewGroup container,Bundle bundle) {
            if (container==null) return null;
            TextView textView=new TextView(getActivity());
            textView.setTextSize(20);
            textView.setText(getArguments().getString("contents"));
            return textView;
        }
    }
}
