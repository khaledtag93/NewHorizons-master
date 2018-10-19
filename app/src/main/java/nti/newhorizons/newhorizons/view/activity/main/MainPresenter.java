package nti.newhorizons.newhorizons.view.activity.main;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.data.entities.Client;

public class MainPresenter {
    MainActivity view;


    public MainPresenter(MainActivity view) {
        this.view = view;
    }

    public void removeOneOfNavigationBottom() {
       if(view.getIntent().hasExtra("Client"))
       {
           view.bottomNavigationView.getMenu().removeItem(R.id.navigation_signIn);
       }
       else
       {
           view.bottomNavigationView.getMenu().removeItem(R.id.navigation_profile);

       }
    }
}
