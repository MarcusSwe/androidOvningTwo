package com.example.ovningtwo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModelString extends ViewModel {
    private final MutableLiveData<String> selectedItem = new MutableLiveData<String>();
    public void selectItem(String text) {
        if(!text.equals("dummy")){
        selectedItem.setValue("Logged in as: "+text);
        } else selectedItem.setValue("Username: Not Logged in!");
    }
    public LiveData<String> getSelectedItem() {
        return selectedItem;
    }
}