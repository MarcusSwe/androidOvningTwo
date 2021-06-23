package com.example.ovningtwo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModelString extends ViewModel {
    private final MutableLiveData<String> selectedItem = new MutableLiveData<String>();
    public void selectItem(String text) {
        selectedItem.setValue("Logged in as: "+text);
    }
    public LiveData<String> getSelectedItem() {
        return selectedItem;
    }
}