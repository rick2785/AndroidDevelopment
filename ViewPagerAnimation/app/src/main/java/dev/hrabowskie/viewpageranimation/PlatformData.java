package dev.hrabowskie.viewpageranimation;

/**
 * Created by rickeyhrabowskie on 3/29/17.
 */

public class PlatformData {
    public int imageId;
    public String name;

    public PlatformData() {

    }

    public PlatformData(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
