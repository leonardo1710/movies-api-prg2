package at.ac.fhcampuswien.moviesapi.models;

import com.google.gson.annotations.SerializedName;

public enum Genre {
    @SerializedName("Action")
    ACTION("Action"),
    @SerializedName("Adventure")
    ADVENTURE("Adventure"),
    @SerializedName("Animation")
    ANIMATION("Animation"),
    @SerializedName("Biography")
    BIOGRAPHY("Biography"),
    @SerializedName("Comedy")
    COMEDY("Comedy"),
    @SerializedName("Crime")
    CRIME("Crime"),
    @SerializedName("Drama")
    DRAMA("Drama"),
    @SerializedName("Documentary")
    DOCUMENTARY("Documentary"),
    @SerializedName("Family")
    FAMILY("Family"),
    @SerializedName("Fantasy")
    FANTASY("Fantasy"),
    @SerializedName("History")
    HISTORY("History"),
    @SerializedName("Horror")
    HORROR("Horror"),
    @SerializedName("Musical")
    MUSICAL("Musical"),
    @SerializedName("Mystery")
    MYSTERY("Mystery"),
    @SerializedName("Romance")
    ROMANCE("Romance"),
    @SerializedName("Sci-Fi")
    SCIENCE_FICTION("Science Fiction"),
    @SerializedName("Sport")
    SPORT("Sport"),
    @SerializedName("Thriller")
    THRILLER("Thriller"),
    @SerializedName("War")
    WAR("War"),
    @SerializedName("Western")
    WESTERN("Western");

    public final String label;

    private Genre(String label) {
        this.label = label;
    }

}
