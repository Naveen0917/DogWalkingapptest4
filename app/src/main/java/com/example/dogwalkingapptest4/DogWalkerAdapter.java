package com.example.dogwalkingapptest4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DogWalkerAdapter extends ArrayAdapter<DogWalker> {
    public DogWalkerAdapter(Context context, List<DogWalker> dogWalkers) {
        super(context, 0, dogWalkers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dog_walker_item, parent, false);
        }

        DogWalker dogWalker = getItem(position);

        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvDescription = convertView.findViewById(R.id.tvDescription);
        TextView tvPayRate = convertView.findViewById(R.id.tvPayRate); // Add this line
        ImageView imgProfile = convertView.findViewById(R.id.imgProfile);

        tvName.setText(dogWalker.getName());
        tvDescription.setText(dogWalker.getDescription());
        tvPayRate.setText("Pay: $" + dogWalker.getPayRate() + "/hr"); // Set the pay rate text
        imgProfile.setImageResource(dogWalker.getImageResourceId());

        return convertView;
    }
}
