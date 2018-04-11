package com.example.pielikes.appurfuone;

import android.support.v4.app.Fragment;
import android.os.Bundle;

public class CatFragment extends Fragment {
    public static CatFragment newInstance(int someInt, String someString) {
        CatFragment catFragment = new CatFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        args.putString("SomeString", someString);
        catFragment.setArguments(args);
        return catFragment;
    }
}
