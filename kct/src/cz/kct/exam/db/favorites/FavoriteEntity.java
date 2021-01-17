package cz.kct.exam.db.favorites;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.model.FavoriteRestEntity;

@XmlRootElement(name = "data")
public class FavoriteEntity {

    private String favoriteId = "";
    private String name = "";
    private String origin = "";
    private String description = "";
    private int imageWidth = 0;
    private int imageHeight = 0;
    private String imageUrl = "";

    /**
     * Default konstruktor
     */
    public FavoriteEntity() {
        super();
    }

    /**
     * Konstructor pro prevod REST Entity na DB entitu
     * 
     * @param ent DB Entita
     */
    public FavoriteEntity(FavoriteRestEntity ent) {
        super();
        this.favoriteId = ent.getId();
        this.name = ent.getName();
        this.origin = ent.getOrigin();
        this.description = ent.getDescription();
        this.imageWidth = ent.getWidth();
        this.imageHeight = ent.getHeight();
        this.imageUrl = ent.getUrl();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((favoriteId == null) ? 0 : favoriteId.hashCode());
        result = prime * result + imageHeight;
        result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
        result = prime * result + imageWidth;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FavoriteEntity other = (FavoriteEntity) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (favoriteId == null) {
            if (other.favoriteId != null)
                return false;
        } else if (!favoriteId.equals(other.favoriteId))
            return false;
        if (imageHeight != other.imageHeight)
            return false;
        if (imageUrl == null) {
            if (other.imageUrl != null)
                return false;
        } else if (!imageUrl.equals(other.imageUrl))
            return false;
        if (imageWidth != other.imageWidth)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (origin == null) {
            if (other.origin != null)
                return false;
        } else if (!origin.equals(other.origin))
            return false;
        return true;
    }

    /**
     * @return the favoriteId
     */
    public String getFavoriteId() {
        return favoriteId;
    }

    /**
     * @param favoriteId the favoriteId to set
     */
    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the imageWidth
     */
    public int getImageWidth() {
        return imageWidth;
    }

    /**
     * @param imageWidth the imageWidth to set
     */
    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    /**
     * @return the imageHeight
     */
    public int getImageHeight() {
        return imageHeight;
    }

    /**
     * @param imageHeight the imageHeight to set
     */
    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    /**
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "FavoriteEntity [favoriteId=" + favoriteId + ", name=" + name + ", origin=" + origin + ", description="
                + description + ", imageWidth=" + imageWidth + ", imageHeight=" + imageHeight + ", imageUrl=" + imageUrl
                + "]";
    }
}
