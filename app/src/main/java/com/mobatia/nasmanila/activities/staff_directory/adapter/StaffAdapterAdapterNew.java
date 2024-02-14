package com.mobatia.nasmanila.activities.staff_directory.adapter;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobatia.nasmanila.R;
import com.mobatia.nasmanila.activities.staff_directory.model.StaffModel;
import com.mobatia.nasmanila.retrofit.Categori;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by gayatri on 22/3/17.
 */
public class StaffAdapterAdapterNew extends  RecyclerView.Adapter<StaffAdapterAdapterNew.MyViewHolder> {
    ArrayList<Categori> mStaffModels;
   // ArrayList<String> deptArrayList;
    Context mContext;
  //  HashMap<String, ArrayList<StaffModel>> hashmap;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout deptLayout;
        View separator;
        TextView deptName;
       RecyclerView mStaffDeptListView;

        public MyViewHolder(View view) {
            super(view);

           deptLayout= (LinearLayout) view.findViewById(R.id.deptLayout);
            mStaffDeptListView= (RecyclerView) view.findViewById(R.id.mStaffDepListView);
            deptName= (TextView) view.findViewById(R.id.departmentName);
            separator=view.findViewById(R.id.separator);
            //mStaffDeptListView = (RecyclerView) view.findViewById(R.id.mStaffListView);
            mStaffDeptListView.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(mContext);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            mStaffDeptListView.setLayoutManager(llm);


        }
    }
    public StaffAdapterAdapterNew(Context mContext, ArrayList<Categori> mStaffList) {
        this.mContext = mContext;
        this.mStaffModels = mStaffList;

    }
    public StaffAdapterAdapterNew(Context mContext,ArrayList<String> deptArrayList,HashMap<String, ArrayList<StaffModel>> hashmap) {
        this.mContext = mContext;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customadapter_staffdept_listitem, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

       // System.out.println("Adapter---" + position + "--" + hashmap.get(deptArrayList.get(position)).size());
       if(mStaffModels.get(position).getStaffList().size()>0) {
           holder.deptName.setText(mStaffModels.get(position).getDepartmentName());
       }/*else if(hashmap.get(deptArrayList.get(position)).size()>0&&deptArrayList.size()==1){
           holder.deptLayout.setVisibility(View.GONE);
           //Toast.makeText(mContext)
           //AppUtils.showDialogAlertFinish();
           AppUtils.showDialogAlertFinish((Activity) mContext, mContext.getString(R.string.alert_heading), mContext.getString(R.string.no_details_available), R.drawable.exclamationicon, R.drawable.round);

       }*/else{
           holder.deptLayout.setVisibility(View.GONE);

       }

            holder.separator.setVisibility(View.GONE);
CustomStaffDeptRecyclerAdapter customStaffDeptRecyclerAdapter=new CustomStaffDeptRecyclerAdapter(mContext,mStaffModels.get(position).getStaffList(),"list");
holder.mStaffDeptListView.setAdapter(customStaffDeptRecyclerAdapter);

    }


    @Override
    public int getItemCount() {
      //  System.out.println("Adapter---size" + deptArrayList.size());

        return mStaffModels.size();
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
