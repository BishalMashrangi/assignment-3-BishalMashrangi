package adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.e.softwaricaassignment.Description;
import com.e.softwaricaassignment.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Items;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {
Context mContext;
List<Items> itemsList;

public ItemsAdapter(Context mContext, List<Items>itemsList){
    this.mContext=mContext;
    this.itemsList=itemsList;

}

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items,viewGroup,false);
       return new ItemsViewHolder(view);
        
    }


    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {
      final Items items = itemsList.get(i);
      Resources res = mContext.getResources();
      final int resourceId = res.getIdentifier(
              items.getItemImage(), "drawable", mContext.getPackageName());

       itemsViewHolder.imgItems.setImageResource(resourceId);
       itemsViewHolder.tvItemName.setText(items.getItemName());
       itemsViewHolder.tvItemPrice.setText(items.getItemPrice());



        itemsViewHolder.imgItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Description.class);

                intent.putExtra("image", resourceId);
                intent.putExtra("name", items.getItemName());
                intent.putExtra("price", items.getItemPrice());
                intent.putExtra("description", items.getItemDescription());

                mContext.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgItems;
        TextView tvItemName, tvItemPrice ;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItems = itemView.findViewById(R.id.imgItem);
            tvItemName = itemView.findViewById(R.id.tvName);
            tvItemPrice= itemView.findViewById(R.id.tvPrice);


        }
    }
}

