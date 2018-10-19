package nti.newhorizons.newhorizons.view.fragment.vendors;

import nti.newhorizons.newhorizons.adapter.VendorsAdapter;
import nti.newhorizons.newhorizons.view.fragment.home.HomeFragment;

public class VendorsPresenter {
    private VendorsFragment view;

    public VendorsPresenter(VendorsFragment view) {
        this.view = view;
    }


    public void setVendorsAdapter() {
        view.gridView.setAdapter(new VendorsAdapter(view.getActivity()));


    }
}