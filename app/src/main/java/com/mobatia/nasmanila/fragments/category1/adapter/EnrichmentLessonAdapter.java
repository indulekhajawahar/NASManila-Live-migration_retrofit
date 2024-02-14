package com.mobatia.nasmanila.fragments.category1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobatia.nasmanila.R;
import com.mobatia.nasmanila.fragments.category1.model.EnrichmentEssentialsModel;
import com.mobatia.nasmanila.fragments.parent_essentials.adapter.ParentEssentialsListAdapter;
import com.mobatia.nasmanila.fragments.parent_essentials.model.ParentEssentialsModel;

import java.util.ArrayList;

public class EnrichmentLessonAdapter extends RecyclerView.Adapter<EnrichmentLessonAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<EnrichmentEssentialsModel> mnNewsLetterModelArrayList;
    String dept;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTitleTxt;


        public MyViewHolder(View view) {
            super(view);

            mTitleTxt = (TextView) view.findViewById(R.id.listTxtTitle);


        }
    }


    public EnrichmentLessonAdapter(Context mContext, ArrayList<EnrichmentEssentialsModel> mnNewsLetterModelArrayList) {
        this.mContext = mContext;
        this.mnNewsLetterModelArrayList = mnNewsLetterModelArrayList;

    }

    @Override
    public EnrichmentLessonAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_aboutus_list_adapter, parent, false);

        return new EnrichmentLessonAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTitleTxt.setText(mnNewsLetterModelArrayList.get(position).getName());
    }




    @Override
    public int getItemCount() {
        return mnNewsLetterModelArrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
