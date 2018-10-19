package nti.newhorizons.newhorizons.view.fragment.ProfilePersonal;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import nti.newhorizons.newhorizons.R;

public class ProfileFragmentPresenter {

    private SharedPreferences shared;

    public void SaveToShare(String path, Context hold){
        shared = hold.getSharedPreferences("newHorizons", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("path",path);
        editor.commit();
        Toast.makeText(hold,path,Toast.LENGTH_SHORT).show();
    }
    public String GetFromShare(Context context){
        String outpath;
        shared=context.getSharedPreferences("newHorizons", Context.MODE_PRIVATE);
        outpath= shared.getString("path","");
        return outpath;
    }

//    private void loadimage(Context context, View view) {
//        String path;
//        path=GetFromShare(context);
//        if (path.equals(null)||path.equals("")) {
//        }else {
//
//
//            Uri returnUri = Uri.parse((path));
//            Bitmap bitmapImage = null;
//
//            try {
//                bitmapImage = MediaStore.Images.Media.getBitmap(context.getContentResolver(), returnUri);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            (CircleImageView) view.findViewById(R.id.profile_image).setImageBitmap(bitmapImage);
//        }
//    }

}
