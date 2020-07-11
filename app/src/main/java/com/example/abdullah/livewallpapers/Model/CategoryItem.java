package com.example.abdullah.livewallpapers.Model;

public class CategoryItem {
    private String Name;
    private String ImageLink;

    public CategoryItem() {
    }

    public CategoryItem(String name, String imageLink) {
        Name = name;
        ImageLink = imageLink;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }
}
