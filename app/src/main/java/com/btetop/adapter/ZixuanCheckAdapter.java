package com.btetop.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.btetop.R;
import com.btetop.bean.AirBoardBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZixuanCheckAdapter extends BaseAdapter {
    private List<AirBoardBean> mdata;
    private final LayoutInflater inflater;



    public ZixuanCheckAdapter(List<AirBoardBean> mdata, Activity context) {
        this.mdata = mdata;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return mdata == null ? 0 : mdata.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.adapter_zixuan, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        AirBoardBean itemBean = mdata.get(position);
        viewHolder.base.setText(itemBean.getBaseAsset());
        viewHolder.quote.setText("/"+itemBean.getQuoteAsset());
        viewHolder.exchage.setText(itemBean.getExchange());
        viewHolder.imCheck.setSelected(itemBean.isCheckFlag());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.base_tv)
        TextView base;
        @BindView(R.id.quote_tv)
        TextView quote;
        @BindView(R.id.exchange_tv)
        TextView exchage;
        @BindView(R.id.image_container_ll)
        LinearLayout llDelete;
        @BindView(R.id.image_check)
        ImageView imCheck;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
