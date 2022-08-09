package com.lunna.insight.Models.DTO.Common;


public class Image {
    private int imageNo;
    private String imageUrl;
    private String thumbImageUrl;
    private String deleteUrl;

    public Image() {

    }

    public Image(int imageNo) {
        this.imageNo = imageNo;
    }

    public Image(String imageUrl, String thumbImageUrl, String deleteUrl) {
        this.imageUrl = imageUrl;
        this.thumbImageUrl = thumbImageUrl;
        this.deleteUrl = deleteUrl;
    }

    public Image(int imageNo, String imageUrl, String thumbImageUrl, String deleteUrl) {
        this.imageNo = imageNo;
        this.imageUrl = imageUrl;
        this.thumbImageUrl = thumbImageUrl;
        this.deleteUrl = deleteUrl;
    }

    public int getImageNo() {
        return imageNo;
    }

    public void setImageNo(int imageNo) {
        this.imageNo = imageNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbImageUrl() {
        return thumbImageUrl;
    }

    public void setThumbImageUrl(String thumbImageUrl) {
        this.thumbImageUrl = thumbImageUrl;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Image) {
            Image that = (Image) obj;
            return (this.imageNo == that.imageNo);
        }
        return false;
    }
}
