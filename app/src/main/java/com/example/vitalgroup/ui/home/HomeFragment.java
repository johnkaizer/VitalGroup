package com.example.vitalgroup.ui.home;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.vitalgroup.ProductAdapter;
import com.example.vitalgroup.ProductModel;
import com.example.vitalgroup.R;
import com.example.vitalgroup.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView productsRec;
    ArrayList<ProductModel> productModels;
    ProductAdapter productAdapter;
    private FragmentHomeBinding binding;
    CardView cardLoc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        /////////////////Programs////////////////////////////

        productsRec =root.findViewById(R.id.products);
        productModels =new ArrayList<>();

        productModels.add(new ProductModel(R.drawable.charmg2,"Example 1","Tsh 200"));
        productModels.add(new ProductModel(R.drawable.lockgel,"Example 2","Tsh 200"));
        productModels.add(new ProductModel(R.drawable.masque,"Example 3","Tsh 200"));
        productModels.add(new ProductModel(R.drawable.conditioner,"Example 4","Tsh 200"));
        productModels.add(new ProductModel(R.drawable.creme,"Example 1","Tsh 200"));
        productModels.add(new ProductModel(R.drawable.oil2,"Example 2","Tsh 200"));
        productModels.add(new ProductModel(R.drawable.olive,"Example 3","Tsh 200"));
        productModels.add(new ProductModel(R.drawable.logo,"Example 4","Tsh 200"));


        productAdapter = new ProductAdapter(getActivity(), productModels, this);
        productsRec.setAdapter(productAdapter);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getContext(), 2,GridLayoutManager.VERTICAL,false);
        productsRec.setLayoutManager(gridLayoutManager);
        productsRec.setHasFixedSize(true);
        productsRec.setNestedScrollingEnabled(false);

        ImageSlider imageSlider = root.findViewById(R.id.imageviewSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.officiallogo, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.pic1, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.vital1, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.olive, ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);

        ///// Location
        cardLoc = root.findViewById(R.id.cardView2);
        cardLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomDialog();
            }
        });

        return root;
    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomesheetlayout);

        ImageView cancelButton = dialog.findViewById(R.id.imageView4);


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}