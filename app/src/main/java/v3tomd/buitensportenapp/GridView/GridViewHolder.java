package v3tomd.buitensportenapp.GridView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import v3tomd.buitensportenapp.R;

public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvCountryName;
    public ImageView ivCountryPhoto;
    public List<ItemObject> MyPaginas;
    public Context MyContext;

    public GridViewHolder(Context Context, View itemView, List<ItemObject> lstPaginas) {
        super(itemView);
        itemView.setOnClickListener(this);
        MyContext = Context;
        tvCountryName = (TextView) itemView.findViewById(R.id.country_name);
        ivCountryPhoto = (ImageView) itemView.findViewById(R.id.country_photo);

        MyPaginas = lstPaginas;
    }

    @Override
    public void onClick(View view) {

        ItemObject Pagina = MyPaginas.get(getPosition());

        Intent intent = new Intent(MyContext, Pagina.getMyClass());
        MyContext.startActivity(intent);
//        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();

    }
}
