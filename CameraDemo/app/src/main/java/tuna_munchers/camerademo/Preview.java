package tuna_munchers.camerademo;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.content.Context;

abstract class Preview extends ViewGroup implements SurfaceHolder.Callback{
    SurfaceView mSurfaceView;
    SurfaceHolder mHolder;

    Preview(Context context) {
        super(context);

        mSurfaceView = new SurfaceView(context);
        addView(mSurfaceView);

        // Install a SurfaceHolder.Callback so we get notified when the underlying surface is created and destroyed.
        mHolder = mSurfaceView.getHolder();
        mHolder.addCallback(this);
        //apparently this is all outdated as fck, finding a new way to do this
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
}
