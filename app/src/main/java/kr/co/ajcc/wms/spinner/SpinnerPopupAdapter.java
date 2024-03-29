package kr.co.ajcc.wms.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import kr.co.ajcc.wms.R;

public class SpinnerPopupAdapter extends BaseAdapter {
    Context mContext;
    List<String> mData;
    Spinner mSpinner;
    LayoutInflater inflater;

    public SpinnerPopupAdapter(Context context, List<String> data, Spinner spinner){
        mContext = context;
        mData = data;
        mSpinner = spinner;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null) {
            view = inflater.inflate(R.layout.view_popup_spinner, parent, false);
        }

        if(mData != null){
            String text = mData.get(position);
            TextView tv_title = view.findViewById(R.id.tv_title);
            tv_title.setText(text);
        }

        return view;
    }

    //스피너 눌렀을때 리스트 레이아웃
    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        if(view == null){
            view = inflater.inflate(R.layout.cell_spinner, parent, false);
        }

        //데이터세팅
        String text = mData.get(position);
        TextView tv_title = view.findViewById(R.id.tv_title);
        tv_title.setText(text);

        return view;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
