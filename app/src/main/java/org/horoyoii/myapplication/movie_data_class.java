package org.horoyoii.myapplication;

import android.os.Parcel;
import android.os.Parcelable;


// 시ㅣ시ㅣ이이발
public class movie_data_class implements Parcelable {

    String movieTitle;
    int movieGrade;
    String movieGenre;
    int movieRuntime;
    int movieLike;
    int movieDislike;
    float movieRating;
    int moiveTotalAudience;
    float movieBook;
    String movieSynopsis;
    String movieCaptin;
    String movieActor1;
    String movieActor2;
    int movieImage;

    // 한줄평??

    //==================================================================================
    // getter and setter
    //==================================================================================

    public int getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(int movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getMovieGrade() {
        return movieGrade;
    }

    public void setMovieGrade(int movieGrade) {
        this.movieGrade = movieGrade;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(int movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    public int getMovieLike() {
        return movieLike;
    }

    public void setMovieLike(int movieLike) {
        this.movieLike = movieLike;
    }

    public int getMovieDislike() {
        return movieDislike;
    }

    public void setMovieDislike(int movieDislike) {
        this.movieDislike = movieDislike;
    }

    public float getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(float movieRating) {
        this.movieRating = movieRating;
    }

    public int getMoiveTotalAudience() {
        return moiveTotalAudience;
    }

    public void setMoiveTotalAudience(int moiveTotalAudience) {
        this.moiveTotalAudience = moiveTotalAudience;
    }

    public float getMovieBook() {
        return movieBook;
    }

    public void setMovieBook(float movieBook) {
        this.movieBook = movieBook;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    public String getMovieCaptin() {
        return movieCaptin;
    }

    public void setMovieCaptin(String movieCaptin) {
        this.movieCaptin = movieCaptin;
    }

    public String getMovieActor1() {
        return movieActor1;
    }

    public void setMovieActor1(String movieActor1) {
        this.movieActor1 = movieActor1;
    }

    public String getMovieActor2() {
        return movieActor2;
    }

    public void setMovieActor2(String movieActor2) {
        this.movieActor2 = movieActor2;
    }


    //==================================================================================
    // 생성자

    public movie_data_class(String movieTitle, int movieGrade, String movieGenre, int movieRuntime, int movieLike, int movieDislike, float movieRating, int moiveTotalAudience, float movieBook, String movieSynopsis, String movieCaptin, String movieActor1, String movieActor2, int movieImage) {
        this.movieTitle = movieTitle;
        this.movieGrade = movieGrade;
        this.movieGenre = movieGenre;
        this.movieRuntime = movieRuntime;
        this.movieLike = movieLike;
        this.movieDislike = movieDislike;
        this.movieRating = movieRating;
        this.moiveTotalAudience = moiveTotalAudience;
        this.movieBook = movieBook;
        this.movieSynopsis = movieSynopsis;
        this.movieCaptin = movieCaptin;
        this.movieActor1 = movieActor1;
        this.movieActor2 = movieActor2;
        this.movieImage = movieImage;
    }

    public movie_data_class(Parcel src){
        this.movieTitle = src.readString();
        this.movieGrade = src.readInt();
        this.movieGenre = src.readString();
        this.movieRuntime = src.readInt();
        this.movieLike = src.readInt();
        this.movieDislike = src.readInt();
        this.movieRating = src.readFloat();
        this.moiveTotalAudience = src.readInt();
        this.movieBook = src.readInt();
        this.movieSynopsis = src.readString();
        this.movieCaptin = src.readString();
        this.movieActor1 = src.readString();
        this.movieActor2 = src.readString();
        this.movieImage = src.readInt();
    }


    //반드시 구현해야하는 변수
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        public movie_data_class createFromParcel(Parcel in){
            return new movie_data_class(in);
        }

        //배열 객체 만들어 주기
        public movie_data_class[] newArray(int size) {
            return  new movie_data_class[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movieTitle);
        parcel.writeInt(movieGrade);
        parcel.writeString(movieGenre);
        parcel.writeInt(movieRuntime);
        parcel.writeInt(movieLike);
        parcel.writeInt(movieDislike);
        parcel.writeFloat(movieRating);
        parcel.writeInt(moiveTotalAudience);
        parcel.writeFloat(movieBook);
        parcel.writeString(movieSynopsis);
        parcel.writeString(movieCaptin);
        parcel.writeString(movieActor1);
        parcel.writeString(movieActor2);
        parcel.writeInt(movieImage);

    }
}
