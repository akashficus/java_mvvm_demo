package com.rf.javamvvmdemo.ui.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class BaseViewModelFactory<T extends ViewModel> implements ViewModelProvider.Factory {

    private final Creator<T> creator;

    public BaseViewModelFactory(Creator<T> creator) {
        this.creator = creator;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(Class<T> modelClass) {
        try {
            return (T) creator.create();
        } catch (Exception e) {
            throw new RuntimeException("Error creating ViewModel", e);
        }
    }

    public interface Creator<T> {
        T create();
    }
}