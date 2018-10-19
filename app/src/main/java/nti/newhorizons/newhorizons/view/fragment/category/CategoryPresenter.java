package nti.newhorizons.newhorizons.view.fragment.category;

import nti.newhorizons.newhorizons.adapter.CategoryAdapter;
import nti.newhorizons.newhorizons.adapter.VendorsAdapter;
import nti.newhorizons.newhorizons.view.fragment.vendors.VendorsFragment;



public class CategoryPresenter {
    CategoryFragment view;

    public CategoryPresenter(CategoryFragment view) {
        this.view = view;
    }


    public void setCategoryAdapter() {
        view.gridView.setAdapter(new CategoryAdapter(view.getActivity()));


    }
}