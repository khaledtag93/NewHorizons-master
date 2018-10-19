package nti.newhorizons.newhorizons.view.fragment.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.net.URI;

import de.hdodenhof.circleimageview.CircleImageView;
import nti.newhorizons.newhorizons.R;

public class ProfilePresenter {
    Context context;

    public ProfilePresenter(Context context) {
        this.context = context;
    }public ProfilePresenter( ) {

    }

    public Intent getImage(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        return intent;
    }

    private void saveProfilePhoto(URI uri, View view) {
        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences("profile_image",0);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("image",uri.toString());
        editor.commit();
    }
    public void setProfilePhoto(View view){

        CircleImageView ivphoto=view.findViewById(R.id.profile_image);
        ivphoto.buildDrawingCache();
        Bitmap bitmap = ivphoto.getDrawingCache();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
        byte[] image=stream.toByteArray();

        String img_str = Base64.encodeToString(image, 0);

         String base=img_str;
        byte[] imageAsBytes = Base64.decode(base.getBytes(), Base64.DEFAULT);
        ivphoto.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes,0, imageAsBytes.length)
        );
    }

}
