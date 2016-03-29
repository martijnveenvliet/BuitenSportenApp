package v3tomd.buitensportenapp.GridView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import v3tomd.buitensportenapp.R;


public class GridViewAdapter extends RecyclerView.Adapter<GridViewHolder> {

    private List<ItemObject> itemList;
    private Context context;

    public GridViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, null);
        GridViewHolder gvl = new GridViewHolder(context, layoutView, itemList);
        return gvl;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        holder.tvCountryName.setText(itemList.get(position).getName());
        holder.ivCountryPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}



