package com.example.abdullah.livewallpapers.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdullah.livewallpapers.Interface.ItemClickListener;
import com.example.abdullah.livewallpapers.Model.CategoryItem;
import com.example.abdullah.livewallpapers.R;
import com.example.abdullah.livewallpapers.Viewholder.CategoryViewholder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private static final String STR_CATEGORY_BACKGROUND = "CategoryBackground";
    DatabaseReference categoryBackground;
    FirebaseDatabase database;

    FirebaseRecyclerOptions<CategoryItem> options;
    FirebaseRecyclerAdapter<CategoryItem,CategoryViewholder> adapter;

    RecyclerView recyclerView;

    private static CategoryFragment INSTANCE = null;

    public CategoryFragment() {

        database = FirebaseDatabase.getInstance();
        categoryBackground = database.getReference().child(STR_CATEGORY_BACKGROUND);

        options = new FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(categoryBackground,CategoryItem.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<CategoryItem, CategoryViewholder>(options) {



            @Override
            protected void onBindViewHolder(@NonNull final CategoryViewholder holder, int position, @NonNull final CategoryItem model) {



                 Picasso.with(getActivity())
                        .load(model.getImageLink())
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(holder.backgroud_image , new Callback(){
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {

                                Picasso.with(getActivity())
                                        .load(model.getImageLink())
                                        .error(R.drawable.ic_terrain_black_24dp)
                                        .into(holder.backgroud_image, new Callback() {
                                            @Override
                                            public void onSuccess() {

                                            }

                                            @Override
                                            public void onError() {

                                                Log.i("category_error","error comes");
                                            }
                                        });
                            }
                        });

                holder.category_name.setText(model.getName());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int postion) {

                        
                    }
                });
            }

            @NonNull
            @Override
            public CategoryViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.layout_category_item,viewGroup,false);

                return new CategoryViewholder(itemView);
            }
        };
    }

    private void setCategory() {
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter!=null)
        adapter.startListening();
    }

    @Override
    public void onStop() {

        super.onStop();
        if (adapter!=null)
            adapter.stopListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter!=null)
            adapter.startListening();
    }

    public static CategoryFragment getInstance() {

        if (INSTANCE == null)
            INSTANCE = new CategoryFragment();
        return INSTANCE;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.category_recyclerview);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        setCategory();

        return view;
    }

}
