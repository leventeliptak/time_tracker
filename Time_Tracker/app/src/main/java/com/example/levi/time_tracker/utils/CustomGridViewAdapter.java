package com.example.levi.time_tracker.utils;

    import java.util.ArrayList;
    import java.util.List;

    import android.app.Activity;
    import android.content.Context;
    import android.graphics.Color;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.ImageView;
    import android.widget.TextView;

    import com.example.levi.time_tracker.R;
    import com.example.levi.time_tracker.model.Process;
    import android.graphics.Color;

/**
 * Created by Levi on 2017.05.04..
 */

public class CustomGridViewAdapter extends ArrayAdapter<Process> {
    Context context;
    int layoutResourceId;
    ArrayList<Process> data = new ArrayList<Process>();

    public CustomGridViewAdapter(Context context, int layoutResourceId,
                                 List<Process> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = new ArrayList<Process>(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TextView  text;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            text = (TextView) row.findViewById(R.id.grid_item);
          //  color = row.findViewById(R.id.grid_item).getBackground();
         //   row.setTag(text);
        } else {
            text = (TextView) row.getTag();
        }

        Process item = data.get(position);
        text.setText(item.getName());
        text.setBackgroundResource(item.getColor());
        return row;
    }


}
