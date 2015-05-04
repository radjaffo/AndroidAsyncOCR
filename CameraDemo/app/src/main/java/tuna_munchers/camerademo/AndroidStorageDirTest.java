package tuna_munchers.camerademo;

import java.io.File;

//class def/prototype, abstracted it because android studio told me I had to...
abstract class AndroidStorageDirTest {
    public abstract File getAlbumStorageDir(String albumName);
}
