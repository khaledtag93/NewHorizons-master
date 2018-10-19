package nti.newhorizons.newhorizons.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import nti.newhorizons.newhorizons.R;


/**
 * Created by hady on 23/11/2016.
 */

public class TitleChildViewHolder extends ChildViewHolder {
    public TextView option1,option2,option3;
    public ImageView optionimg;
    public TitleChildViewHolder(View itemView) {
        super(itemView);
        option1 = (TextView)itemView.findViewById(R.id.option1);
        option2 = (TextView)itemView.findViewById(R.id.option2);
        option3 = (TextView) itemView.findViewById(R.id.option3);
        optionimg= (ImageView) itemView.findViewById(R.id.optionimg);
    }
}
