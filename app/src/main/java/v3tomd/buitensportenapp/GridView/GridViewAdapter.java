package v3tomd.buitensportenapp.GridView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import v3tomd.buitensportenapp.Controllers.ItemObjects;
import v3tomd.buitensportenapp.R;


public class GridViewAdapter extends RecyclerView.Adapter<GridViewHolder> {

    private List<ItemObjects> itemList;
    private Context context;

    public GridViewAdapter(Context context, List<ItemObjects> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, null);
        GridViewHolder gvl = new GridViewHolder(layoutView);
        return gvl;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}



