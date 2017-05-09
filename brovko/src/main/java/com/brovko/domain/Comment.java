package com.brovko.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "br_comments")
public class Comment implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "br_comment_author")
    private String author;
    @Column(name = "br_comment_title")
    private String title;
    @Column(name = "br_comment_pluses")
    private String pluses;
    @Column(name = "br_comment_minuses")
    private String minuses;
    @Column(name = "br_comment_text")
    private String text;
    @Column(name = "br_comment_date")
    private LocalDateTime dateTime;
    @Column(name = "br_comment_mark")
    private CommentMark mark;

    public Comment() {
    }

    public Comment(String author, String title, String pluses, String minuses, String text, CommentMark mark) {
        this.author = author;
        this.title = title;
        this.pluses = pluses;
        this.minuses = minuses;
        this.text = text;
        this.mark = mark;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPluses() {
        return pluses;
    }

    public void setPluses(String pluses) {
        this.pluses = pluses;
    }

    public String getMinuses() {
        return minuses;
    }

    public void setMinuses(String minuses) {
        this.minuses = minuses;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public CommentMark getMark() {
        return mark;
    }

    public void setMark(CommentMark mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (author != null ? !author.equals(comment.author) : comment.author != null) return false;
        if (title != null ? !title.equals(comment.title) : comment.title != null) return false;
        if (pluses != null ? !pluses.equals(comment.pluses) : comment.pluses != null) return false;
        if (minuses != null ? !minuses.equals(comment.minuses) : comment.minuses != null) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        if (dateTime != null ? !dateTime.equals(comment.dateTime) : comment.dateTime != null) return false;
        return mark == comment.mark;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (pluses != null ? pluses.hashCode() : 0);
        result = 31 * result + (minuses != null ? minuses.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pluses='" + pluses + '\'' +
                ", minuses='" + minuses + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                ", mark=" + mark +
                '}';
    }
}
