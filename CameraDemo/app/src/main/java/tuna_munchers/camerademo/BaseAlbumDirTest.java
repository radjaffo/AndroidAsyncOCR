package tuna_munchers.camerademo;

import java.io.File;

import android.os.Environment;

//This is where the directory magic happens, gets us into the album for our app and lets us save to it
public final class BaseAlbumDirTest extends AndroidStorageDirTest{
    private static final String CAMERA_DIR = "/dicm/";

    @Override
    public File getAlbumStorageDir(String albumName){
        return new File(
                Environment.getExternalStorageDirectory()
                + CAMERA_DIR
                + albumName
        );
    }
}
