package nti.newhorizons.newhorizons.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import nti.newhorizons.newhorizons.R;

public class CategoryAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.web_development, R.drawable.android,
            R.drawable.database, R.drawable.csharp,
            R.drawable.english, R.drawable.business,
            R.drawable.web_development, R.drawable.android,
            R.drawable.csharp, R.drawable.business,
            R.drawable.english, R.drawable.microsoft,
            R.drawable.microsoft, R.drawable.microsoft,
            R.drawable.microsoft,R.drawable.microsoft
    };

    // Constructor
    public CategoryAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(280, 220));
        return imageView;
    }
}
