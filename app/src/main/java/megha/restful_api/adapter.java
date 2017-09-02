package megha.restful_api;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import static megha.restful_api.R.layout.datalist;
import static megha.restful_api.R.layout.support_simple_spinner_dropdown_item;

/**
 * Created by Megha Chauhan on 02-Sep-17.
 */

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {
    List<data> dataList;

    public adapter(List<data> dataList) {
        this.dataList = dataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView t1, t2, t3, t4;

        public MyViewHolder(View view) {
            super(view);
            t1 = (TextView) view.findViewById(R.id.t1);
            t2 = (TextView) view.findViewById(R.id.t2);
            t3 = (TextView) view.findViewById(R.id.t3);
            t4 = (TextView) view.findViewById(R.id.t4);
        }

    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(datalist, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int pos) {
        data d = dataList.get(pos);
        holder.t1.setText("UserId: "+""+d.getUid());
        holder.t2.setText("ID: "+ ""+d.getId());
        holder.t3.setText("Body: "+ ""+d.getBody());
        holder.t4.setText("Title"+""+d.getTitle());
    }

}
