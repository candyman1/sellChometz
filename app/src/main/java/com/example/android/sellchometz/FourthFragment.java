package com.example.android.sellchometz;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Home on 5/21/2017.
 */

public class FourthFragment extends Fragment {
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
myView=inflater.inflate(R.layout.fourth_layout,container,false);
        return myView;
    }
}
