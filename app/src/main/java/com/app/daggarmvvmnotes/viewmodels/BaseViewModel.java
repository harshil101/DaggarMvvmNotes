package com.app.daggarmvvmnotes.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.os.Handler;

/**
 * Base class for all ViewModels. Biggest reason for this class is that all viewModels need a
 * reference
 * to the UI Thread.
 */
abstract class BaseViewModel extends ViewModel{
    protected Handler mUiThreadHandler;

    public void onCreate(Handler handler) {
        mUiThreadHandler = handler;
    }

    public void onDestroy() {
        mUiThreadHandler = null;
    }
}
