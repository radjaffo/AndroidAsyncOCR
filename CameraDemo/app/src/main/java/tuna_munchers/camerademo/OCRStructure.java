package tuna_munchers.camerademo;

/**
 * Created by radjaffo on 4/21/15.
 */
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;

public class OCRStructure {
    private Bitmap bitmap;
    private String text;
    private Paint paint;

    private List<Rect> regionBoundingBoxes;
    private List<Rect> textlineBoundingBoxes;
    private List<Rect> wordBoundingBoxes;
    private List<Rect> stripBoundingBoxes;
    private List<Rect> characterBoundingBoxes;

    public OCRStructure(Bitmap bitmap, String text,
                        List<Rect> regionBoundingBoxes,
                        List<Rect> textlineBoundingBoxes,
                        List<Rect> wordBoundingBoxes,
                        List<Rect> stripBoundingBoxes,
                        List<Rect> characterBoundingBoxes){
        this.bitmap = bitmap;
        this.text = text;
        this.paint = new Paint();
        this.regionBoundingBoxes = regionBoundingBoxes;
        this.textlineBoundingBoxes = textlineBoundingBoxes;
        this.wordBoundingBoxes = wordBoundingBoxes;
        this.stripBoundingBoxes = stripBoundingBoxes;
        this.characterBoundingBoxes = characterBoundingBoxes;
    }

    public OCRStructure() {
        this.paint = new Paint();
    }

    public Bitmap getBitmap(){
        return getAnnotatedBitmap();
    }

    private Bitmap getAnnotatedBitmap() {
        Canvas canvas = new Canvas(bitmap);

        // Draw bounding boxes around each word
        for (int i = 0; i < wordBoundingBoxes.size(); i++) {
            paint.setAlpha(0xFF);
            paint.setColor(0xFF00CCFF);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth(2);
            Rect r = wordBoundingBoxes.get(i);
            canvas.drawRect(r, paint);
        }
        return bitmap;
    }

    public Point getBitmapDimensions() {
        return new Point(bitmap.getWidth(), bitmap.getHeight());
    }

    public List<Rect> getRegionBoundingBoxes() {
        return regionBoundingBoxes;
    }

    public List<Rect> getTextlineBoundingBoxes() {
        return textlineBoundingBoxes;
    }

    public List<Rect> getWordBoundingBoxes() {
        return wordBoundingBoxes;
    }

    public List<Rect> getStripBoundingBoxes() {
        return stripBoundingBoxes;
    }

    public List<Rect> getCharacterBoundingBoxes() {
        return characterBoundingBoxes;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRegionBoundingBoxes(List<Rect> regionBoundingBoxes) {
        this.regionBoundingBoxes = regionBoundingBoxes;
    }

    public void setTextlineBoundingBoxes(List<Rect> textlineBoundingBoxes) {
        this.textlineBoundingBoxes = textlineBoundingBoxes;
    }

    public void setWordBoundingBoxes(List<Rect> wordBoundingBoxes) {
        this.wordBoundingBoxes = wordBoundingBoxes;
    }

    public void setStripBoundingBoxes(List<Rect> stripBoundingBoxes) {
        this.stripBoundingBoxes = stripBoundingBoxes;
    }

    public void setCharacterBoundingBoxes(List<Rect> characterBoundingBoxes) {
        this.characterBoundingBoxes = characterBoundingBoxes;
    }


}

