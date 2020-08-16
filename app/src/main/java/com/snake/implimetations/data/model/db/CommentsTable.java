package com.snake.implimetations.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "CommentsTable", indices = {@Index(value = {"Comment"},
        unique = true)})
public class CommentsTable {
    @Expose
    @PrimaryKey(autoGenerate = true)
    public int id;

    @Expose
    @SerializedName("comment")
    @ColumnInfo(name = "Comment")
    public String comment;

    @Expose
    @SerializedName("image")
    @ColumnInfo(name = "Image")
    public String Image;

    public CommentsTable() {
    }

    public CommentsTable(String comment, String image) {
        this.comment = comment;
        this.Image = image;
    }
}
